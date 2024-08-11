package com.example.tdd

object PasswordStrengthMeter {

    fun meter(s:String?): PasswordStrength {

        if(s.isNullOrEmpty()) return PasswordStrength.INVALID
        var metCounts = 0
        if(s.length >= 8) metCounts++
        if(meetsContainingNumberCriteria(s)) metCounts++
        if(meetsContainingUppercaseCriteria(s)) metCounts++

        if(metCounts <= 1) return  PasswordStrength.WEAK
        if(metCounts == 2) return  PasswordStrength.NORMAL

        return PasswordStrength.STRONG
    }

    private fun meetsContainingUppercaseCriteria(s: String): Boolean {
        for (ch: Char in s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true
            }
        }
        return false
    }

    private fun meetsContainingNumberCriteria(s: String): Boolean {
        for (ch: Char in s) {
            if (ch in '0'..'9') {
                return true
            }
        }
        return false
    }

}
