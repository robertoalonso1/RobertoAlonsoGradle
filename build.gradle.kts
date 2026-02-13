plugins {
    id("java")
    id("application")
}

group = "com.robertoalonso.tema4gradle"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation(platform("dev.langchain4j:langchain4j-bom:1.10.0"))
    implementation("dev.langchain4j:langchain4j-open-ai")

}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("com.robertoalonso.tema4gradle.Main")
}

val isWindows = System.getProperty("os.name").lowercase().contains("windows")

val ollamaVersion by tasks.registering(Exec::class) {
    if (isWindows) {
        commandLine("powershell", "-NoProfile", "-Command", "ollama --version")
    } else {
        commandLine("sh", "-c", "ollama --version")
    }
}

val ollamaPs by tasks.registering(Exec::class) {
    if (isWindows) {
        commandLine("powershell", "-NoProfile", "-Command", "ollama ps")
    } else {
        commandLine("sh", "-c", "ollama ps")
    }
    standardOutput = System.out
    errorOutput = System.err
}

val llmInfo by tasks.registering {
    dependsOn(ollamaVersion, ollamaPs)
    doLast {
        println("Demo finalizada")
    }
}