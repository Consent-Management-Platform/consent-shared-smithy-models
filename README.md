# consent-shared-smithy-models

This package defines common Smithy models used across Consent Framework services such as the Consent Management API, Consent History Ingestor, and Consent History API.

## Usage

To import this package's Smithy models in another Gradle project, merge the following code into your Gradle project's build.gradle.kts file:

```kotlin
repositories {
  repositories {
    maven {
      url = uri("https://maven.pkg.github.com/Consent-Management-Platform/consent-shared-smithy-models")
      credentials {
        username = project.findProperty("gpr.usr") as String? ?: System.getenv("GITHUB_USERNAME")
        password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
      }
    }
  }
}

dependencies {
  // Shared Consent Framework Smithy models
  implementation("com.consentframework:consent-shared-smithy-models:0.0.1")
}
```

### Usage in Smithy packages

After updating the project's build.gradle.kts file to import the package, you can directly import the types into your Smithy files.

Eg. To reference the Consent data model in a Smithy operation or structure, add `use com.consentframework.shared.models.consent#Consent` to the Smithy file's imports.

Eg. To reference the InternalServiceException exception type in a Smithy operation, add `use com.consentframework.shared.models.exceptions#InternalServiceException` to the Smithy file's imports.

## Technologies
[Smithy](https://smithy.io) is used to produce protocol and technology agnostic API models that can be used to automatically generate:
* API specifications for various types of platforms
* API clients for various programming languages

[GitHub Packages](https://github.com/features/packages) are used to release artifacts to a GitHub's version of Maven, so that the API models can be imported into other packages.

[Gradle](https://docs.gradle.org) is used to build the project and manage package dependencies.

## License
The code in this project is released under the [GPL-3.0 License](LICENSE).
