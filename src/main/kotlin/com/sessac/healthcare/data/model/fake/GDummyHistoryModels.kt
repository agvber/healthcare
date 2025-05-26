package com.sessac.healthcare.data.model.fake

import com.sessac.healthcare.data.model.GHistoryDataModel
import java.time.LocalDateTime

class DummyHistoryModels() : DummyModel<List<GHistoryDataModel>>() {
    override fun build(): List<GHistoryDataModel> {
        return listOf(
            GHistoryDataModel(
                1,
                1.toString(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                2000,
                "공원에서 가볍게 산책"
            ),
            GHistoryDataModel(
                2,
                1.toString(),
                LocalDateTime.now().minusDays(2),
                LocalDateTime.now().minusDays(2).plusMinutes(45),
                5000,
                "조깅 후 스트레칭"
            ),
            GHistoryDataModel(
                3,
                1.toString(),
                LocalDateTime.now().minusDays(3),
                LocalDateTime.now().minusDays(3).plusHours(2),
                3000,
                "동네 한 바퀴 돌며 운동"
            ),
            GHistoryDataModel(
                4,
                1.toString(),
                LocalDateTime.now().minusDays(4),
                LocalDateTime.now().minusDays(4).plusMinutes(30),
                1000,
                "계단 오르기"
            ),
            GHistoryDataModel(
                5,
                1.toString(),
                LocalDateTime.now().minusDays(5),
                LocalDateTime.now().minusDays(5).plusHours(1),
                4000,
                "러닝 머신에서 달리기"
            ),
            GHistoryDataModel(
                6,
                11.toString(),
                LocalDateTime.now().minusDays(6),
                LocalDateTime.now().minusDays(6).plusMinutes(40),
                6000,
                "강변에서 가벼운 조깅"
            ),
            GHistoryDataModel(
                7,
                11.toString(),
                LocalDateTime.now().minusDays(6),
                LocalDateTime.now().minusDays(6).plusMinutes(25),
                3000,
                "빠른 걸음으로 출퇴근"
            ),
            GHistoryDataModel(
                8,
                108.toString(),
                LocalDateTime.now().minusDays(8),
                LocalDateTime.now().minusDays(8).plusHours(1),
                7000,
                "헬스장에서 트레드밀 러닝"
            ),
            GHistoryDataModel(
                9,
                109.toString(),
                LocalDateTime.now().minusDays(9),
                LocalDateTime.now().minusDays(9).plusMinutes(50),
                2000,
                "산책하며 음악 감상"
            ),
            GHistoryDataModel(
                10,
                110.toString(),
                LocalDateTime.now().minusDays(10),
                LocalDateTime.now().minusDays(10).plusMinutes(35),
                4000,
                "쇼핑하며 걸음 수 채우기"
            )
        )
    }
}