buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Build.androidBuildTools)
        classpath(Build.hiltAndroidGradlePlugin)
        classpath(Build.kotlinGradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.

tasks.register("clean",Delete::class) {
    delete(rootProject.buildDir)
}
