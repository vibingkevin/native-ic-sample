plugins { kotlin("multiplatform") }

kotlin {
    linuxX64()
    iosSimulatorArm64()
    iosArm64()
    compilerOptions {
        optIn.add("kotlin.native.SymbolNameIsInternal")
    }
}
