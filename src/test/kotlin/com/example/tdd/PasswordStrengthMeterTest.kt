package com.example.tdd

import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * 암호검사기
 */
class PasswordStrengthMeterTest {

    /**
     * 검사할 규칙
     * 1. 길이가 8글자 이상
     * 2. 0부터 9 사이의 숫자를 포함
     * 3. 대문자 포함
     *
     * 세 규칙을 모두 충족하면 강함
     * 2개의 규칙을 충족하면 보통
     * 1개 이하의 규칙을 충족하면 약함
     *
     * @DisplayName : 테스트 메서드를 원하는 이름으로 표시 가능
     */

    // 데이터 선언?

    // 암호 검사 함수 () {
    // }


    @Test
    fun `모든 규칙을 충족하는 경우`() {
        // Given
        val password = "ab12!@AB"

        // when & then
        assertStrength(password, PasswordStrength.STRONG)

        assertStrength("abc1!Add", PasswordStrength.STRONG)
    }

    @Test
    @DisplayName("길이만 8글자 미만이고 나머지 조건은 충족하는 경우")
    fun meetOtherCriteria_except_for_Length_Then_Normal() {
        assertStrength("ab12!@A", PasswordStrength.NORMAL)
        assertStrength("Ab12!c", PasswordStrength.NORMAL)
    }

    @Test
    @DisplayName("숫자를 포함하지 않고 나머지 조건은 충족하는 경우")
    fun meetsOtherCriteria_except_for_number_Then_Normal() {
        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL)
    }

    @Test
    @DisplayName("값이 없는 경우 - null")
    fun nullInput_Then_Invalid() {
        assertStrength(null, PasswordStrength.INVALID)
    }

    @Test
    @DisplayName("값이 없는 경우 - 공백")
    fun emptyInput_Then_Invalid() {
        assertStrength("", PasswordStrength.INVALID)
    }

    @Test
    @DisplayName("대문자를 포함하지 않고 나머지 조건을 충족하는 경우")
    fun meetsOtherCriteria_except_for_Uppercase_Then_Normal() {
        assertStrength("ab12!@df", PasswordStrength.NORMAL)
    }

    @Test
    @DisplayName("길이가 8글자 이상인 조건만 충족하는 경우")
    fun meetsOnlyLengthCriteria_Then_Weak() {
        assertStrength("abdefghi", PasswordStrength.WEAK)
    }

    @Test
    @DisplayName("숫자 포함 조건만 충족하는 경우")
    fun meetsOnlyNumCriteria_Then_Week() {
        assertStrength("12345", PasswordStrength.WEAK)
    }

    @Test
    @DisplayName("대문자 포함 조건만 충족하는 경우")
    fun meetsOnlyUpperCriteria_Then_Weak() {
        assertStrength("ABZEF", PasswordStrength.WEAK)
    }

    @Test
    @DisplayName("아무 조건도 충족하지 않은 경우")
    fun meetsNoCriteria_Then_Weak() {
        assertStrength("abc", PasswordStrength.WEAK)
    }

    private fun assertStrength(password: String?, strength: PasswordStrength) {
        assertEquals(strength, PasswordStrengthMeter.meter(password))
    }
}