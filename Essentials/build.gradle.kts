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
    compileOnly(project(":EssentialsGroupManager"))
}


tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}