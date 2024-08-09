package com.example.tdd

object PasswordStrengthMeter {

    fun meter(s:String?): PasswordStrength {

        if(s.isNullOrEmpty()) return PasswordStrength.INVALID

        val lengthEnough: Boolean = s.length >= 8

        val containsNum = meetsContainingNumberCriteria(s)
        val containsUpp = meetsContainingUppercaseCriteria(s)

        if(!lengthEnough && !containsNum && !containsUpp) return PasswordStrength.WEAK
        if(!lengthEnough && containsNum && !containsUpp) return PasswordStrength.WEAK
        if(!lengthEnough && !containsNum && containsUpp) return PasswordStrength.WEAK

        if(!lengthEnough) return PasswordStrength.NORMAL
        if(!containsNum) return PasswordStrength.NORMAL
        if(!containsUpp) return PasswordStrength.NORMAL

        return PasswordStrength.STRONG
    }

    private fun meetsContainingUppercaseCriteria(s: String?): Boolean {
        if (s != null) {
            for (ch: Char in s.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    return true
                }
            }
        }
        return false
    }

    private fun meetsContainingNumberCriteria(s: String?): Boolean {
        if (s != null) {
            for (ch: Char in s) {
                if (ch in '0'..'9') {
                    return true
                }
            }
        }
        return false
    }

}
