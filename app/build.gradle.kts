plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.devst0rm.importantpoints"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.devst0rm.importantpoints"
        minSdk = 21
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation("com.intuit.sdp:sdp-android:1.1.1")





    //Retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit:retrofit:1.9.0")
    implementation("com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0")

    //LiveData
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")

    //RxJava
    implementation("io.reactivex.rxjava2:rxandroid:2.0.2")
    implementation("androidx.room:room-rxjava2:2.6.1")

    //Glide
    implementation("com.github.bumptech.glide:glide:4.12.0")
    implementation("jp.wasabeef:glide-transformations:4.3.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")


}