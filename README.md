<div align="center">
  <br />
    <a href="https://bloggios.com" target="_blank">
      <img src="./.github/assets/bloggios-header.png" alt="Project Banner">
    </a>
  <br />

<h2 align="center">Elasticsearch Configuration Jar</h2>

  <div>
    <img src="https://img.shields.io/badge/-java-4258ff?style=for-the-badge&logoColor=white&logo=openjdk&color=FF7800" alt="Java 17" />
    <img src="https://img.shields.io/badge/-Spring_Boot-black?style=for-the-badge&logoColor=white&logo=springboot&color=6DB33F" alt="Spring Boot" />
    <img src="https://img.shields.io/badge/-Elasticsearch-black?style=for-the-badge&logoColor=white&logo=elasticsearch&color=005571" alt="Spring Security" />
  </div>
</div>

## 📋 <a name="table">Table of Contents</a>

1. 🤖 [Introduction](#introduction)
2. ⚙️ [Tech Stack](#tech-stack)
3. 🔋 [Documentation](#documentation)
4. 🤸 [Quick Start](#quick-start)
5. 🕸️ [Contributing](#contributing)
6. 🔗 [Links](#links)
7. 🙏 [Support](#support)
8. ✨ [Contributors](#contributors)

## <a name="introduction">🤖 Introduction</a>

The **Elasticsearch Configuration JAR** is a critical component within **Bloggios Microservices** architecture. Built
using **Java 17** and **Spring Boot**, and leveraging the **Spring Boot Parent**, this JAR dependency provides advanced
capabilities such as **searching**, **sorting**, **filtering**, **fuzzy searching**, and more, utilizing the *
*Elasticsearch engine**. It serves as a centralized library for other microservices, ensuring a consistent and efficient
approach to handling Elasticsearch operations.

## Key Features

1. **Advanced Search Capabilities:**
    - Implements powerful search functionalities including full-text search, multi-field search, and more, leveraging
      the robust capabilities of the Elasticsearch engine.

2. **Sorting and Filtering:**
    - Provides comprehensive sorting and filtering options, enabling precise data retrieval and organization based on
      various criteria and fields.

3. **Fuzzy Searching:**
    - Supports fuzzy searching to handle typographical errors and approximate matches, enhancing user experience by
      delivering relevant results even with imperfect input.

4. **Centralized Configuration:**
    - Acts as a centralized configuration library for all microservices within the Bloggios architecture, ensuring
      consistency and reducing redundancy in Elasticsearch operations.

5. **High Performance:**
    - Optimized for high performance, ensuring fast and efficient data retrieval, which is critical for applications
      requiring real-time search capabilities.

## Benefits

- **Consistent Implementation Across Microservices:**
    - By serving as a centralized configuration library, the Elasticsearch Configuration JAR ensures that all
      microservices within the Bloggios architecture implement Elasticsearch functionalities in a consistent and
      standardized manner.

- **Time and Effort Savings:**
    - Developers save considerable time and effort as they do not need to repeatedly configure Elasticsearch for each
      microservice. This centralized approach reduces redundancy and streamlines the development process.

Join our newly active Discord community for support, bug reporting, and feature requests. Here, we strive to address
every issue, and developers and testers can collaborate and assist each other effectively.

<a href="https://discord.gg/sEerF8HuKC" target="_blank">
<img src="https://img.shields.io/badge/-Join_our_Community-4258ff?style=for-the-badge&logoColor=white&logo=discord&color=5865F2" alt="Discord" />
</a>

## <a name="tech-stack">⚙️ Tech Stack</a>

- Java 17
- Spring Boot
- Elasticsearch
- Elastic High Level Client

## <a name="documentation">🔋 API Documentation</a>

To help you get started with our API and understand all its features and endpoints, we have created detailed
documentation available on Postman. This documentation includes comprehensive information about each endpoint,
including:

- **Endpoint URLs**: Specific paths to access various functionalities.
- **HTTP Methods**: The method type (GET, POST, PUT, DELETE, etc.) for each endpoint.
- **Parameters**: Required and optional parameters, including headers, query parameters, and body content.
- **Request Examples**: Sample requests to demonstrate proper usage.
- **Response Formats**: Expected response structure, including status codes and data formats.
- **Error Handling**: Common error responses and troubleshooting tips.

To access the documentation:

1. **Visit our Postman Documentation Page
   **: [Visit Documentation](https://www.postman.com/rohit-zip/workspace/bloggios/collection/34920421-dbc22257-2de7-4888-a0b1-69d0234bb3b4?action=share&source=copy-link&creator=34920421)
2. **Explore the Collection**: Navigate through the collection to find detailed descriptions and examples for each
   endpoint.
3. **Run Requests Directly in Postman**: Use the "Run in Postman" button to directly import the collection into your
   Postman workspace for testing and exploration.

By leveraging the Postman documentation, you can quickly integrate our API into your application and take full advantage
of its capabilities.

For any further assistance, feel free to contact our support team or refer to the additional resources section in the
documentation.

## <a name="quick-start">🤸 Quick Start</a>

Follow these steps to set up the project locally on your machine.

**Prerequisites**

Make sure you have the following installed on your machine:

- Git
- Java 17
- Intellij Idea or any other IDE supports Spring Boot

**Cloning the Repository**

```bash
git clone <repository-url>
```

**Opening the Project**

Open the project in any of your favourite IDE
We recommended Intellij Idea

Make sure you have Java 17 Installed in your system
Please execute the below command to check installed version of Java in your system

```bash
java --version
```

Replace the placeholder values with your actual credentials

**Running or Compiling the Project**

This is the configuration file repository only so there is no need to run this Repository

One can create a Jar of this application and use it in the other Microservices of Bloggios
to Create a Jar please run the below command on root directory

```bash
mvn clean install
```

If Maven is not installed in your system then run

```bash
./mvnw clean install
```

## <a name="contributing">🧑‍💻Contributing</a>

Any kind of positive contribution is welcome! Please help us to grow by contributing to the project.

If you wish to contribute, you can,

- Star Repositories Bloggios
- Suggest a Feature
- Test the application, and help it improve.
- Improve the app, fix bugs, etc.
- Improve documentation.
- Create content about Bloggios and share it with the world.

> Please read [`CONTRIBUTING`](CONTRIBUTING.md) for details on our [`CODE OF CONDUCT`](CODE_OF_CONDUCT.md), and the
> process for submitting pull requests to us.

🆕 New to Open Source? 💡 Follow this [guide](https://opensource.guide/how-to-contribute/) to jumpstart your Open Source
journey 🚀.

## <a name="links">🔗 Links</a>

- **Devsanbox API's URL** - https://api.bloggios.in (Bloggios Devsandbox API)
- **Devsandbox Environment** - https://dev.bloggios.in (Bloggios Devsandbox) (*Not Deployed yet*)
- **Production Environment** - Not Deployed yet

**Repositories**

- **Auth Provider Application** - [Visit Github](https://github.com/Bloggios/auth-provider-application)
- **User Provider Application** - [Visit Github](https://github.com/Bloggios/user-provider-application)
- **Bloggios Mail Service** - [Visit Github](https://github.com/Bloggios/bloggios-mail-service)
- **Authentication Configuration Jar** - [Visit Github](https://github.com/Bloggios/authentication-configuration-jar)
- **Bloggios Web UI** - [Visit Github](https://github.com/Bloggios/bloggios-web-ui)

## <a name="support">🙏Support</a>

We all need support and motivation. `Bloggios` is not an exception. Please give this project repositories a ⭐️ to
encourage and show that you liked it. Don't forget to leave a star ⭐️ before you move away.

If you found the app helpful, consider supporting us with a coffee.

## <a name="contributors">✨Contributors</a>

Thanks goes to these wonderful people ([emoji key](https://allcontributors.org/docs/en/emoji-key)):

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tbody>
    <tr>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/rohit-zip"><img src="https://avatars.githubusercontent.com/u/75197401?v=4" width="100px;" alt="Rohit Parihar"/><br /><sub><b>Rohit Parihar</b></sub></a><br /><a href="https://github.com/rohit-zip" title="Code">💻</a></td>
    </tr>
  </tbody>
</table>