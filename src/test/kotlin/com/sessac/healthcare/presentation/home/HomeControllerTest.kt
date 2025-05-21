package com.sessac.healthcare.presentation.home

import com.sessac.healthcare.data.model.HistoryDataModel
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.presentation.home.ui.HomeView
import org.junit.jupiter.api.Test
import java.time.LocalDateTime


class HomeControllerTest {

    private lateinit var user: UserDataModel
    private lateinit var histories: List<HistoryDataModel>
    private lateinit var controller: HomeController
    private lateinit var view: HomeView

    @Test
    fun `홈`(){
        user = UserDataModel(1, "테스트 유저", 170, 65, 100000)

        histories = listOf(
            HistoryDataModel(1, 1, LocalDateTime.now().minusDays(1), LocalDateTime.now(), "힘들다", 3000),
            HistoryDataModel(2, 1, LocalDateTime.now().minusDays(2), LocalDateTime.now(), "파이팅", 5000)
        )

        view = HomeView()

        controller = HomeController(user, histories)

        controller.startHome()
    }
}