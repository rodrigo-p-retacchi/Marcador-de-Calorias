package com.rodrigopr.core.data.preferences

import android.content.SharedPreferences
import com.rodrigopr.core.domain.model.ActivityLevel
import com.rodrigopr.core.domain.model.Gender
import com.rodrigopr.core.domain.model.GoalType
import com.rodrigopr.core.domain.model.UserInfo
import com.rodrigopr.core.domain.preferences.Preferences

class DefaultPreferences(
    private val sharePreferences: SharedPreferences
) : Preferences {
    override fun saveGender(gender: Gender) {
        sharePreferences.edit()
            .putString(Preferences.KEY_GENDER,gender.name)
            .apply()
    }

    override fun saveAge(age: Int) {
        sharePreferences.edit()
            .putInt(Preferences.KEY_AGE,age)
            .apply()
    }

    override fun saveWeight(weight: Float) {
        sharePreferences.edit()
            .putFloat(Preferences.KEY_WEIGHT,weight)
            .apply()
    }

    override fun saveHeight(height: Int) {
        sharePreferences.edit()
            .putInt(Preferences.KEY_HEIGHT,height)
            .apply()
    }

    override fun saveActivityLevel(activityLevel: ActivityLevel) {
        sharePreferences.edit()
            .putString(Preferences.KEY_ACTIVITY_LEVEL,activityLevel.name)
            .apply()
    }

    override fun saveGoalType(goalType: GoalType) {
        sharePreferences.edit()
            .putString(Preferences.KEY_GOAL_TYPE,goalType.name)
            .apply()
    }

    override fun saveCarbRatio(ratio: Float) {
        sharePreferences.edit()
            .putFloat(Preferences.KEY_CARB_RATIO,ratio)
            .apply()
    }

    override fun saveProteinRatio(ratio: Float) {
        sharePreferences.edit()
            .putFloat(Preferences.KEY_PROTEIN_RATIO,ratio)
            .apply()
    }

    override fun saveFatRatio(ratio: Float) {
        sharePreferences.edit()
            .putFloat(Preferences.KEY_FAT_RATIO,ratio)
            .apply()
    }

    override fun loadUserInfo(): UserInfo {
        val age = sharePreferences.getInt(Preferences.KEY_AGE, -1)
        val height = sharePreferences.getInt(Preferences.KEY_HEIGHT, -1)
        val weight = sharePreferences.getFloat(Preferences.KEY_WEIGHT, -1f)
        val genderString = sharePreferences.getString(Preferences.KEY_GENDER, null)
        val activityLevelString = sharePreferences.getString(Preferences.KEY_ACTIVITY_LEVEL, null)
        val goalType = sharePreferences.getString(Preferences.KEY_GOAL_TYPE, null)
        val carbRatio = sharePreferences.getFloat(Preferences.KEY_CARB_RATIO, -1f)
        val proteinRatio = sharePreferences.getFloat(Preferences.KEY_PROTEIN_RATIO, -1f)
        val fatRatio = sharePreferences.getFloat(Preferences.KEY_FAT_RATIO, -1f)


        return UserInfo(
            gender = Gender.fromString(genderString ?: "male"),
            age = age,
            weight = weight,
            height = height,
            activityLevel = ActivityLevel.fromString(activityLevelString ?: "medium"),
            goalType = GoalType.fromString(goalType ?: "keep_weight"),
            carbRatio = carbRatio,
            proteinRatio = proteinRatio,
            fatRatio = fatRatio
        )
    }

    override fun saveShouldShowOnboarding(shouldldShow: Boolean) {
        sharePreferences.edit()
            .putBoolean(Preferences.KEY_SHOULD_SHOW_ONBOARDING,shouldldShow)
    }

    override fun loadShouldShowOnboarding(): Boolean {
        return sharePreferences.getBoolean(
            Preferences.KEY_SHOULD_SHOW_ONBOARDING,
            true
        )
    }
}