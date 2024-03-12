plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.fyrl29074.productslist"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(Deps.AndroidX.core_ktx)
    implementation(Deps.AndroidX.app_compat)
    implementation(Deps.AndroidX.recycler_view)
    implementation(Deps.AndroidX.constraint_layout)
    implementation(Deps.Lifecycle.lifecycle_runtime_ktx)
    implementation(Deps.Lifecycle.lifecycle_viewmodel_ktx)
    implementation(Deps.Glide.glide)
    implementation(Deps.Koin.koin_android)

    implementation(project(ProjectDeps.network))
}