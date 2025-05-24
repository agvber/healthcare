package com.sessac.healthcare.data.model.fake

import com.sessac.healthcare.data.model.HistoryDataModel
import java.time.LocalDateTime

class DummyHistoryModels() : DummyModel<List<HistoryDataModel>>() {
    override fun build(): List<HistoryDataModel> {
        return listOf(
            HistoryDataModel(
                1,
                "hong123",
                LocalDateTime.now().minusDays(1),
                LocalDateTime.now().minusDays(1).plusHours(1),
                2000,
                "공원에서 가볍게 산책"
            ),
            HistoryDataModel(
                2,
                "102",
                LocalDateTime.now().minusDays(2),
                LocalDateTime.now().minusDays(2).plusMinutes(45),
                5000,
                "조깅 후 스트레칭"
            ),
            HistoryDataModel(
                3,
                "103",
                LocalDateTime.now().minusDays(3),
                LocalDateTime.now().minusDays(3).plusHours(2),
                3000,
                "동네 한 바퀴 돌며 운동"
            ),
            HistoryDataModel(
                4,
                "104",
                LocalDateTime.now().minusDays(4),
                LocalDateTime.now().minusDays(4).plusMinutes(30),
                1000,
                "계단 오르기"
            ),
            HistoryDataModel(
                5,
                "105",
                LocalDateTime.now().minusDays(5),
                LocalDateTime.now().minusDays(5).plusHours(1),
                4000,
                "러닝 머신에서 달리기"
            ),
            HistoryDataModel(
                6,
                "106",
                LocalDateTime.now().minusDays(6),
                LocalDateTime.now().minusDays(6).plusMinutes(40),
                6000,
                "강변에서 가벼운 조깅"
            ),
            HistoryDataModel(
                7,
                "107",
                LocalDateTime.now().minusDays(7),
                LocalDateTime.now().minusDays(7).plusMinutes(25),
                3000,
                "빠른 걸음으로 출퇴근"
            ),
            HistoryDataModel(
                8,
                "108",
                LocalDateTime.now().minusDays(8),
                LocalDateTime.now().minusDays(8).plusHours(1),
                7000,
                "헬스장에서 트레드밀 러닝"
            ),
            HistoryDataModel(
                9,
                "109",
                LocalDateTime.now().minusDays(9),
                LocalDateTime.now().minusDays(9).plusMinutes(50),
                2000,
                "산책하며 음악 감상"
            ),
            HistoryDataModel(
                10,
                "110",
                LocalDateTime.now().minusDays(10),
                LocalDateTime.now().minusDays(10).plusMinutes(35),
                4000,
                "쇼핑하며 걸음 수 채우기"
            ),
            HistoryDataModel(
                11,
                "111",
                LocalDateTime.now().minusDays(11),
                LocalDateTime.now().minusDays(11).plusMinutes(45),
                8000,
                "체력 단련을 위한 조깅"
            ),
            HistoryDataModel(
                12,
                "112",
                LocalDateTime.now().minusDays(12),
                LocalDateTime.now().minusDays(12).plusHours(1),
                6000,
                "야외 러닝"
            ),
            HistoryDataModel(
                13,
                "113",
                LocalDateTime.now().minusDays(13),
                LocalDateTime.now().minusDays(13).plusMinutes(30),
                1500,
                "운동 후 스트레칭"
            ),
            HistoryDataModel(
                14,
                "114",
                LocalDateTime.now().minusDays(14),
                LocalDateTime.now().minusDays(14).plusMinutes(20),
                2000,
                "출근길 걷기"
            ),
            HistoryDataModel(
                15,
                "115",
                LocalDateTime.now().minusDays(15),
                LocalDateTime.now().minusDays(15).plusMinutes(50),
                3000,
                "점심시간 산책"
            )
        )
    }
}