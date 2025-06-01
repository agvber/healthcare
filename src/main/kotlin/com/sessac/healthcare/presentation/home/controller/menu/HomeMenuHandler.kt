package com.sessac.healthcare.presentation.home.controller.menu

import com.sessac.healthcare.presentation.goal.GoalController
import com.sessac.healthcare.presentation.home.ui.HomeStringResource
import com.sessac.healthcare.presentation.record.RecordController
import com.sessac.healthcare.presentation.report.ReportController
import com.sessac.healthcare.presentation.userprofile.controller.UserProfileController
import kotlin.system.exitProcess

class HomeMenuHandler : HomeMenuListener {
    override fun onSelectRecord() {
        RecordController().run()
    }

    override fun onSelectGoal() {
        GoalController().run()
    }

    override fun onSelectUserInfo() {
        UserProfileController().run()
    }

    override fun onSelectReport() {
        ReportController().run()
    }

    override fun onExit() {
        exitProcess(0)
    }

    override fun onInvalidInput() {
        println(HomeStringResource.INCORRECT_INPUT)
    }
}