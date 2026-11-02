plugins { kotlin("multiplatform") }

kotlin {
    linuxX64 { binaries.executable { entryPoint = "demo.main" } }
    iosSimulatorArm64 { binaries.framework { baseName = "NativeIcSample" } }
    iosArm64 { binaries.framework { baseName = "NativeIcSample" } }
    sourceSets {
        commonMain.dependencies { implementation(project(":lib")) }
        commonTest.dependencies { implementation(kotlin("test")) }
    }
}
