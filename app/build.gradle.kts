plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.healthycareai"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.healthycareai"
        minSdk = 30
        targetSdk = 35
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
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation ("androidx.coordinatorlayout:coordinatorlayout:1.2.0")
    implementation ("com.github.ismaeldivita:chip-navigation-bar:1.4.0")
    implementation ("androidx.core:core-ktx:1.15.0")
    implementation ("com.google.android.material:material:1.9.0")
    implementation("com.github.bumptech.glide:glide:4.15.1")
    implementation ("androidx.viewpager2:viewpager2:1.0.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.14.2")
    implementation("com.google.code.gson:gson:2.9.1")
    implementation("androidx.recyclerview:recyclerview:1.3.1")
    implementation ("com.airbnb.android:lottie:3.4.0")
    implementation ("com.intuit.sdp:sdp-android:1.1.0")
    implementation ("com.intuit.ssp:ssp-android:1.1.1")


}