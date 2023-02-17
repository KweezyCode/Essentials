plugins {
    java
}

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}


sourceSets {
    main {
        java {
            srcDir("src")
        }
        resources {
            srcDir("src")
            exclude("**.java")
        }
    }
}



tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}