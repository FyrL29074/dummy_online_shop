object Deps {
    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.Retrofit.retrofit_version}"
        const val retrofit_gson =
            "com.squareup.retrofit2:converter-gson:${Versions.Retrofit.retrofit_version}"

        const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.Retrofit.okHttp_version}"
        const val logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.Retrofit.okHttp_version}"

    }

    object AndroidX {
        const val app_compat =
            "androidx.appcompat:appcompat:${Versions.AndroidX.app_compat_version}"
        const val core_ktx = "androidx.core:core-ktx:${Versions.AndroidX.android_core_version}"
        const val recycler_view =
            "androidx.recyclerview:recyclerview:${Versions.AndroidX.recycler_view_version}"
        const val constraint_layout =
            "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constraint_layout_version}"
        const val paging_runtime =
            "androidx.paging:paging-runtime:${Versions.AndroidX.paging_version}"
    }

    object Lifecycle {
        const val lifecycle_viewmodel_ktx =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Lifecycle.lifecycle_version}"
        const val lifecycle_runtime_ktx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Lifecycle.lifecycle_version}"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${Versions.Glide.glide_version}"
    }

    object Koin {
        const val koin_android = "io.insert-koin:koin-android:${Versions.Koin.koin_android_version}"
    }

    object NavComponent {
        val nav_fragment_ktx = "androidx.navigation:navigation-fragment-ktx:${Versions.NavComponent.nav_version}"
        val nav_ui_ktx = "androidx.navigation:navigation-ui-ktx:${Versions.NavComponent.nav_version}"
    }
}