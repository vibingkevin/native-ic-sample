plugins { kotlin("multiplatform") }

kotlin {
    linuxX64()
    iosSimulatorArm64()
    iosArm64()
    compilerOptions {
        freeCompilerArgs.add("-XXLanguage:-IrIntraModuleInlinerBeforeKlibSerialization")
        optIn.add("kotlin.native.SymbolNameIsInternal")
    }
}
