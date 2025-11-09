plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.microsoft.playwright:playwright:1.40.0")
    testImplementation("org.testng:testng:7.8.0")
    testImplementation("org.slf4j:slf4j-simple:2.0.9")
}

tasks.test {
    useTestNG() {
        useDefaultListeners = true
    }
    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = true
        showExceptions = true
        showCauses = true
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
    // ADD THIS LINE to force output display
    testLogging.showStandardStreams = true
    // ADD THIS to prevent caching and always run tests
    outputs.upToDateWhen { false }
}

// Task to install Playwright browsers
tasks.register<JavaExec>("installPlaywright") {
    description = "Install Playwright browsers"
    classpath = sourceSets["test"].runtimeClasspath
    mainClass.set("com.microsoft.playwright.CLI")
    args("install")
}

tasks.register<JavaExec>("recordTest") {
    description = "Record user behavior and generate tests"
    group = "playwright"
    classpath = sourceSets["test"].runtimeClasspath
    mainClass.set("com.microsoft.playwright.CLI")
    args("codegen", "https://dev.app.nude.web.ghfls.ru/dating")
}

// Make test depend on browser installation
tasks.test {
    dependsOn(tasks.named("installPlaywright"))
}