package com.sessac.healthcare.domain.entites

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ReportEntityUnitTest {

    private lateinit var reportEntity: ReportEntity

    @BeforeEach
    fun init() {
        reportEntity = ReportEntity()
    }

    @Test
    fun `탄소 저감량 검사합니다`() {
        val carbonReduction = reportEntity.calculateCarbonReduction(1000)
        Assertions.assertEquals(0.21, carbonReduction)
    }

    @Test
    fun `bmi 계산을 검사합니다`() {
        val bmi = reportEntity.calculateBMI(80f, 180f)
        Assertions.assertEquals(24.689999f, bmi)
    }
}