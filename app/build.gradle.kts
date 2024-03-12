plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.fyrl29074.dummy_online_shop"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.fyrl29074.dummy_online_shop"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Deps.AndroidX.core_ktx)
    implementation(Deps.AndroidX.app_compat)

    implementation(Deps.Koin.koin_android)

    implementation(project(ProjectDeps.network))
    implementation(project(ProjectDeps.navigation))
    implementation(project(ProjectDeps.Features.productsList))
}