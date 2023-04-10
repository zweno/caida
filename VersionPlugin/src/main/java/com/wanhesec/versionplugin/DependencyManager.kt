package com.wanhesec.versionplugin

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/15
 *     desc  : 如果数量少的话，放在一个类里面就可以，如果数量多的话，可以拆分为多个类
 * </pre>
 */

object Versions {
    val retrofit = "2.9.0"
    val appcompat = "1.1.0"
    val coreKtx = "1.3.0"
    val constraintlayout = "1.1.3"
    val paging = "3.0.0-alpha01"
    val timber = "4.7.1"
    val kotlin = "1.3.72"
    val koin = "2.1.5"
    val work = "2.2.0"
    val room = "2.3.0-alpha01"
    val cardview = "1.0.0"
    val recyclerview = "1.0.0"
    val fragment = "1.2.1"
    val anko = "0.10.8"

    val junit = "4.12"
    val junitExt = "1.1.1"
    val espressoCore = "3.2.0"
    val jDatabinding = "1.0.1"


    val liveData_ktx = "2.2.0"
    val viewModel_ktx = "2.2.0"
    val extensions_ktx = "2.2.0"
    val okhttpLog ="3.12.1"

}

object AndroidX {
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"

    val liveData_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.liveData_ktx}"
    val viewModel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel_ktx}"
    val extensions_ktx = "androidx.lifecycle:lifecycle-extensions:${Versions.extensions_ktx}"

    val pagingRuntime = "androidx.paging:paging-runtime:${Versions.paging}"

    val workRuntime = "androidx.work:work-runtime:${Versions.work}"
    val workTesting = "androidx.work:work-testing:${Versions.work}"
    val cardview = "androidx.cardview:cardview:${Versions.cardview}"
    val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
}

object Room {
    val runtime = "androidx.room:room-runtime:${Versions.room}"
    val compiler = "androidx.room:room-compiler:${Versions.room}"
    val ktx = "androidx.room:room-ktx:${Versions.room}"
    val rxjava2 = "androidx.room:room-rxjava2:${Versions.room}"
    val testing = "androidx.room:room-testing:${Versions.room}"
}

object Fragment {
    val runtime = "androidx.fragment:fragment:${Versions.fragment}"
    val runtimeKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    val testing = "androidx.fragment:fragment-testing:${Versions.fragment}"
}

object Kt {
    val stdlibJdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val stdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    val test = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.5"
    val coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.0"
}

object Koin {
    val core = "org.koin:koin-core:${Versions.koin}"
    val androidCore = "org.koin:koin-android:${Versions.koin}"
    val viewmodel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    val androidScope = "org.koin:koin-android-scope:$${Versions.koin}"

}

object Anko {
    val common = "org.jetbrains.anko:anko-common:${Versions.anko}"
    val sqlite = "org.jetbrains.anko:anko-sqlite:${Versions.anko}"
    val coroutines = "org.jetbrains.anko:anko-coroutines:${Versions.anko}"
    val design = "org.jetbrains.anko:anko-design:${Versions.anko}" // For SnackBars
}

object Retrofit {
    val runtime = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val mock = "com.squareup.retrofit2:retrofit-mock:${Versions.retrofit}"
}

object Okhttp{
    val okhttpLog = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLog}"
}

object Depend {
    val cc = "com.billy.android:cc:2.1.5"

    val junit = "junit:junit:${Versions.junit}"
    val androidTestJunit = "androidx.test.ext:junit:${Versions.junitExt}"
    val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    val jDatabinding = "com.hi-dhl:jdatabinding:${Versions.jDatabinding}"
    val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}

