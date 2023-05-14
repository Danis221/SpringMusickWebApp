plugins {
    java
    id("org.springframework.boot") version "2.7.11-SNAPSHOT"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    id("jacoco")
}

apply(plugin = "io.spring.dependency-management")

group = "ru.itis"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

tasks.jar {
    enabled = false
    manifest {
        attributes["Main-Class"] = "ru.itis.mv.MusicKitWevAppSpringApplication"
    }
}
configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    //spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-mail")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("org.springframework.security:spring-security-oauth2-resource-server:5.8.3")

    implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity5:3.0.4.RELEASE")
    implementation("org.thymeleaf:thymeleaf-spring5:3.0.15.RELEASE")

    // lombok
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.projectlombok:lombok")

    //db
    implementation("org.postgresql:postgresql:42.5.3")

//webjars
    implementation("org.webjars:jquery:3.6.0")
    implementation("org.webjars:bootstrap:4.6.0")
    implementation("org.webjars:webjars-locator-core:0.46")
    implementation("org.webjars:stomp-websocket:2.3.4")
    implementation("org.webjars:sockjs-client:1.5.1")

    //test
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testImplementation("org.mockito:mockito-junit-jupiter:5.2.0")

    //mail
    implementation("javax.mail:javax.mail-api:1.6.2")

    //swagger
    implementation("org.springdoc:springdoc-openapi-ui:1.6.15")

    implementation("org.springframework.boot:spring-boot-starter-websocket")

    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    implementation("io.jsonwebtoken:jjwt-impl:0.11.5")
    implementation("io.jsonwebtoken:jjwt-jackson:0.11.5")
}


tasks.withType<Test> {
    useJUnitPlatform()
}
