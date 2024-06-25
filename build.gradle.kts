plugins {
	java
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm")
}

group = "me.dio"
version = "0.0.1-SNAPSHOT"

java {
}

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "2023.0.1"

/* Spring initializer
 https://start.spring.io/#!type=gradle-project-kotlin&language
 =java&platformVersion=3.2.4&packaging=jar&jvmVersion
 =21&groupId=me.dio&artifactId=santander-dev-week.2024&
 name=santander-dev-week.2024&description=API%20Rest%20
 sobre%20Champions%20do%20lol&packageName=me.dio.sdw24&
 dependencies=web,data-jdbc,cloud-feign,h2
*/

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
	// OpenAPI (Swagger) https://springdoc.org/#getting-started
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")

	runtimeOnly("com.h2database:h2")

	testImplementation("org.springframework.boot:spring-boot-starter-test")

	implementation(kotlin("stdlib-jdk8"))
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
kotlin {
	jvmToolchain(21)
}