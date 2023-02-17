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

dependencies {
    compileOnly(project(":Essentials"))
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}