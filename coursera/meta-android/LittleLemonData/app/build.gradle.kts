plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    alias(libs.plugins.kotlin.serialization)

    id("com.google.devtools.ksp")

//    id("org.jetbrains.kotlin.plugin.serialization")
//    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "dev.sn.littlelemondata"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "dev.sn.littlelemondata"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
//    kotlin {
//        compilerOptions {
//            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
//        }
//    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    val ktor_version = "2.1.3"
    implementation("io.ktor:ktor-client-core:${ktor_version}")
    implementation("io.ktor:ktor-client-android:${ktor_version}")
    implementation("io.ktor:ktor-client-content-negotiation:${ktor_version}")
    implementation("io.ktor:ktor-serialization-kotlinx-json:${ktor_version}")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

    val room_version = "2.8.4"
    implementation("androidx.room:room-runtime:${room_version}")
    ksp("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:${room_version}")

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.10.0")

//    implementation(libs.ktor.client.android)
//    implementation("io.ktor:ktor-client-core:2.3.6")
//
//    implementation(libs.ktor.client.content.negotiation)
//    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.6")
//
//    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

//    implementation(libs.ktor.serialization.kotlinx.json)
//    implementation(libs.kotlinx.serialization.json)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}