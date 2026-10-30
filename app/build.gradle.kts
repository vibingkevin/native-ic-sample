plugins { kotlin("multiplatform") }

kotlin {
    iosSimulatorArm64()
    iosArm64()
    compilerOptions {
        freeCompilerArgs.add("-XXLanguage:-IrIntraModuleInlinerBeforeKlibSerialization")
    }
    sourceSets {
        commonMain.dependencies { implementation(project(":lib")) }
        commonTest.dependencies { implementation(kotlin("test")) }
    }
}
