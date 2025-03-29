description = "Common Smithy models for Consent Management Framework projects"

plugins {
  `java-library`
  `maven-publish`
  id("software.amazon.smithy.gradle.smithy-jar")
}

repositories {
  mavenLocal()
  mavenCentral()
}

smithy {
  // Use the `package` projection from smithy-build.json
  sourceProjection.set("package")
  // Set tags so other smithy packages can include this in their built packages
  tags.addAll("common")
}

dependencies {
  val smithyVersion: String by project

  smithyCli("software.amazon.smithy:smithy-cli:$smithyVersion")
  implementation("software.amazon.smithy:smithy-linters:$smithyVersion")
  implementation("software.amazon.smithy:smithy-model:$smithyVersion")
}

// Publish jar to GitHub Packages so can import into other repositories
publishing {
  repositories {
    maven {
      name = "GitHubPackages"
      url = uri("https://maven.pkg.github.com/Consent-Management-Platform/consent-shared-smithy-models")
      credentials {
        username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_USERNAME")
        password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
      }
    }
  }

  publications {
    register<MavenPublication>("gpr") {
      groupId = "com.consentframework"
      artifactId = "consent-shared-smithy-models"
      version = "0.0.1"

      from(components["java"])
    }
  }
}

tasks.clean {
  delete("$rootDir/bin")
  delete("$rootDir/build")
}
