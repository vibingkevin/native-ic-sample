plugins { kotlin("multiplatform") }

kotlin {
    iosSimulatorArm64()
    iosArm64()
    compilerOptions {
        freeCompilerArgs.add("-XXLanguage:-IrIntraModuleInlinerBeforeKlibSerialization")
        optIn.add("kotlin.native.SymbolNameIsInternal")
    }
}
