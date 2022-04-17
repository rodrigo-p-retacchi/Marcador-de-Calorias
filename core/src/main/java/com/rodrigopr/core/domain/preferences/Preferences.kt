package com.rodrigopr.core.domain.preferences

import com.rodrigopr.core.domain.model.ActivityLevel
import com.rodrigopr.core.domain.model.Gender
import com.rodrigopr.core.domain.model.GoalType
import com.rodrigopr.core.domain.model.UserInfo

interface Preferences {

    fun saveGender(gender: Gender)
    fun saveAge(age: Int)
    fun saveWeight(weight: Float)
    fun saveHeight(height: Int)
    fun saveActivityLevel(activityLevel: ActivityLevel)
    fun saveGoalType(goalType: GoalType)
    fun saveCarbRatio(ratio: Float)
    fun saveProteinRatio(ratio: Float)
    fun saveFatRatio(ratio: Float)

    fun loadUserInfo(): UserInfo

    fun saveShouldShowOnboarding(shouldShow: Boolean)
    fun loadShouldShowOnboarding(): Boolean

    companion object{
        const val KEY_GENDER = "gender"
        const val KEY_AGE = "age"
        const val KEY_WEIGHT = "weight"
        const val KEY_HEIGHT = "height"
        const val KEY_ACTIVITY_LEVEL = "activity_leve"
        const val KEY_GOAL_TYPE = "goal_type"
        const val KEY_CARB_RATIO = "carb_ratio"
        const val KEY_PROTEIN_RATIO = "protein_ratio"
        const val KEY_FAT_RATIO = "fan_ratio"
        const val KEY_SHOULD_SHOW_ONBOARDING = "should_show_onboarding"
    }
}