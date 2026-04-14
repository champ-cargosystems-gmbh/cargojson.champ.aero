plugins {
    java
    `maven-publish`
}

group = "aero.champ"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
}

dependencies {
    val jacksonVersion = "2.18.2"
    implementation("com.fasterxml.jackson.core:jackson-core:$jacksonVersion")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("com.fasterxml.jackson.core:jackson-annotations:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")
    
    implementation("io.swagger.core.v3:swagger-annotations:2.2.28")
    implementation("jakarta.validation:jakarta.validation-api:3.1.1")
    implementation("jakarta.ws.rs:jakarta.ws.rs-api:4.0.0")
    implementation("jakarta.servlet:jakarta.servlet-api:6.1.0")
    
    implementation("com.google.guava:guava:33.3.1-jre")

    testImplementation("junit:junit:4.13.2")
    testImplementation("com.fasterxml.jackson.module:jackson-module-jsonSchema:$jacksonVersion")
    testImplementation("javax.validation:validation-api:2.0.1.Final")
}

tasks.test {
    // JUnit 4 support is built-in, but let's be explicit if needed.
    // However, Gradle 9 might prefer test suites.
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}
