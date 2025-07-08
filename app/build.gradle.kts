plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.parcelize)
}

// Arquivo para deixar as configs que são comuns a outros modulos.
apply(from = "$rootDir/plugins/android-commons.gradle")
apply(from = "$rootDir/plugins/core-dependencies.gradle")

//lib de core (implementacao da ui interna)


android {
    namespace = "com.example.animes"

    defaultConfig {
        applicationId = "com.example.animes"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.androidx.navigation.compose)
    // Material Icons - extensão
    implementation(libs.androidx.material.icons.extended)

    //SERIALIZATION
    implementation(libs.jetbrains.kotlinx.serialization.json)

    // DataStore
    implementation(libs.androidx.datastore.preferences)

    // Koin
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.koin.androidx.compose)
    implementation(libs.koin.compose.viewmodel)
    implementation(libs.koin.compose.viewmodel.navigation)
    // Gson
    //RETROFIT
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    //GLIDE - URL DE IMAGEM COM CACHE
    implementation(libs.glide)

    //COIL  - ASYNCIMAGE
    implementation(libs.coil)

    // FIREBASE
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.auth)

    implementation(libs.androidx.material3.android)
}