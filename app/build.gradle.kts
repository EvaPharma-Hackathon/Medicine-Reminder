plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.plugin.parcelize")
    id("org.jetbrains.kotlin.android") version "1.9.0"
    id("org.jetbrains.kotlin.kapt")
    id("com.google.dagger.hilt.android") version "2.48"
    id("androidx.navigation.safeargs.kotlin") version "2.6.0"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.0"
    // Add the Google services Gradle plugin
    id("com.google.gms.google-services")
}

apply(from = "$rootDir/base.gradle")

android {
    namespace = "com.evapharma.medicinereminder"
    compileSdk = 34

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        applicationId = "com.evapharma.medicinereminder"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            buildConfigField("String", "BASE_URL", "\"http://ec2-54-171-240-65.eu-west-1.compute.amazonaws.com\"")
        }
        release {
            isMinifyEnabled = true // Enables code shrinking
            isShrinkResources = true
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
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.messaging.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")
    implementation("com.github.GrenderG:Toasty:1.5.0")

    implementation("com.github.bumptech.glide:glide:4.12.0")
    kapt("com.github.bumptech.glide:compiler:4.12.0")

    implementation("com.github.permissions-dispatcher:permissionsdispatcher:4.8.0")
    kapt("com.github.permissions-dispatcher:permissionsdispatcher-processor:4.8.0")

    implementation("com.google.code.gson:gson:2.8.9")

    // Chuck
//    implementation("com.github.chuckerteam.chucker:library:3.5.2")

    implementation("androidx.security:security-crypto:1.1.0-alpha03")
    implementation("androidx.preference:preference-ktx:1.2.0")


    implementation("androidx.navigation:navigation-fragment-ktx:2.7.1")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.1")


    // Import the Firebase BoM
    implementation(platform(libs.firebase.bom)) // Make sure to use the latest version
    implementation(libs.firebase.messaging)

    // When using the BoM, you don't specify versions in Firebase library dependencies

    // Add the dependency for the Firebase SDK for Google Analytics
    implementation(libs.firebase.analytics)
}
