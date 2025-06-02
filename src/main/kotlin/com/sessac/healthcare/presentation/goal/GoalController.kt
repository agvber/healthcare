package com.sessac.healthcare.presentation.goal

import com.sessac.healthcare.data.model.HistoryDataModel
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.domain.usecase.GetLoggedInUserUseCase
import com.sessac.healthcare.domain.usecase.GetUserHistoriesUseCase
import com.sessac.healthcare.domain.usecase.UpdateUserProfileUseCase
import com.sessac.healthcare.presentation.common.ViewController
import com.sessac.healthcare.presentation.goal.constants.GoalControllerConstants.INSERT_GOAL_NUMBER
import com.sessac.healthcare.presentation.goal.constants.GoalControllerConstants.BACK_NUMBER
import com.sessac.healthcare.presentation.goal.constants.GoalControllerConstants.DAILY_GOAL_DISTANCE_NUMBER
import com.sessac.healthcare.presentation.goal.constants.GoalControllerConstants.TOTAL_GOAL_DISTANCE_NUMBER
import com.sessac.healthcare.presentation.goal.constants.GoalControllerConstants.WEEKLY_GOAL_DISTANCE_NUMBER

class GoalController : ViewController {
    private lateinit var goalView: GoalView
    private lateinit var goalMapper: GoalMapper
    private lateinit var presentationModel: GoalPresentationModel

    private val getLoggedInUserUseCase = GetLoggedInUserUseCase()
    private val updateUserProfileUseCase = UpdateUserProfileUseCase()
    private val getUserHistoriesUseCase = GetUserHistoriesUseCase()

    private val user: UserDataModel = getLoggedInUserUseCase()
    private val userRecords: List<HistoryDataModel> = getUserHistoriesUseCase(user.userId)

    override fun run() {
        goalMapper = GoalMapper()
        presentationModel = goalMapper.dataModelToPresentation(user, userRecords)
        goalView = GoalView
        showGoalScreen()
        handleUserInput()
    }

    private fun showGoalScreen() {
        goalView.printGoalDefaultMessage(user)
        goalView.printUserTree(presentationModel.tree)
        goalView.printGoal(user)
        goalView.printRemainingBMIDistance(presentationModel.remainingBMIDistance)
    }

    private fun handleUserInput() {
        when (goalView.askWantToInsertGoal()) {
            INSERT_GOAL_NUMBER -> handleGoalInsertion()
            BACK_NUMBER -> return // 이전 화면으로 이동
            else -> goalView.printInvalidInputMessage()

        }
    }

    private fun handleGoalInsertion() {
        when (goalView.askGoalDistance()) {
            TOTAL_GOAL_DISTANCE_NUMBER -> insertTotalGoalDistance()
            WEEKLY_GOAL_DISTANCE_NUMBER -> insertWeeklyGoalDistance()
            DAILY_GOAL_DISTANCE_NUMBER -> insertDailyGoalDistance()
            else -> goalView.printInvalidInputMessage()
        }
    }

    private fun insertTotalGoalDistance() {
        val goalInput = goalView.inputTotalGoalDistance()
        val updatedUser = user.copy(goalDistance = goalInput.toLong())
        updateUserProfileUseCase(updatedUser)
        goalView.printUpdateGoal()
        goalView.printGoal(updatedUser)
    }

    private fun insertWeeklyGoalDistance() {
        val goalInput = goalView.inputWeeklyGoalDistance()
        val updatedUser = user.copy(weeklyGoalDistance = goalInput.toLong())
        updateUserProfileUseCase(updatedUser)
        goalView.printUpdateGoal()
        goalView.printGoal(updatedUser)
    }

    private fun insertDailyGoalDistance() {
        val goalInput = goalView.inputDailyGoalDistance()
        val updatedUser = user.copy(dailyGoalDistance = goalInput.toLong())
        updateUserProfileUseCase(updatedUser)
        goalView.printUpdateGoal()
        goalView.printGoal(updatedUser)
    }

}