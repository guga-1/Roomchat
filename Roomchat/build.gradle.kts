plugins {
    java
}

group = "com.mziuri"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")
    implementation("org.apache.tomcat.embed:tomcat-embed-core:10.0.20")
    implementation("org.apache.tomcat.embed:tomcat-embed-jasper:10.0.20")
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation("org.hibernate.orm:hibernate-core:6.4.2.Final")
    implementation("com.mysql:mysql-connector-j:8.3.0")
    compileOnly("jakarta.websocket:jakarta.websocket-api:2.1.1")
    implementation("org.apache.tomcat.embed:tomcat-embed-websocket:10.0.20")
    implementation("com.fasterxml.jackson.core:jackson-core:2.17.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.0")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(group = "org.json", name = "json", version = "20090211")
}

tasks.test {
    useJUnitPlatform()
}
