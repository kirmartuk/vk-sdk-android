buildscript {
    repositories {
        mavenCentral()
        google()
        jcenter()
    }

    dependencies {
        classpath(kotlin("gradle-plugin", Config.Versions.Kotlin.kotlin))
        classpath("com.android.tools.build:gradle:${Config.Versions.Plugin.androidGradle}")
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:${Config.Versions.Plugin.dokka}")
        classpath("com.vanniktech:gradle-maven-publish-plugin:${Config.Versions.Plugin.publish}")
        classpath("com.github.dcendents:android-maven-gradle-plugin:2.1")
    }
}

allprojects {
    tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class).all {
        JavaVersion.VERSION_1_8.toString().also {
            kotlinOptions.jvmTarget = it
            if (plugins.hasPlugin("org.jetbrains.kotlin.jvm")) {
                sourceCompatibility = it
                targetCompatibility = it
            }
        }
    }

    repositories {
        mavenCentral()
        google()
        jcenter()
        maven(url = "https://jitpack.io")
    }

    group = project.property("GROUP").toString()
    version = project.property("VERSION_NAME").toString()
}

apply(from = "tasks.gradle.kts")