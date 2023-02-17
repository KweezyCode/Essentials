plugins {
    java
    id("io.freefair.lombok") version "6.6.2"
}


repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}

allprojects {
    apply(plugin = "java")
    apply(plugin = "io.freefair.lombok")
    dependencies {
        compileOnly(fileTree(mapOf("dir" to "../lib", "include" to listOf("*.jar"))))
        //annotationProcessor(files("../lib/lombok-0.10.8.jar"))
    }
}




tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}