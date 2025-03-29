description = "Common Smithy models for Consent Management Framework projects"

plugins {
  `java-library`
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
}
