package com.example.tdd

object PasswordStrengthMeter {

    fun meter(s:String?): PasswordStrength {

        if(s.isNullOrEmpty()) return PasswordStrength.INVALID

        val lengthEnough: Boolean = s.length >= 8
        if(!lengthEnough) return PasswordStrength.NORMAL

        if (s.length < 8) {
          return PasswordStrength.NORMAL
        }

        val containsNum = meetsContainingNumberCriteria(s)
        val containsUpp = meetsContainingUppercaseCriteria(s)

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
