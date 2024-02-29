# RapidRequest
RapidRequest is a simple and easy to use HTTP request library for Java.
It is designed to make HTTP requests with minimal code and maximum flexibility.

![Maven Central Version](https://img.shields.io/maven-central/v/dev.dubsky/RapidRequest)
![GitHub](https://img.shields.io/github/license/dubskysteam/RapidRequest)

## 🌟 Features
- [X] Synchronous Requests
- [X] Response Object

## 🚀 Upcoming Features
- [ ] Asynchronous Requests
- [ ] Advanced Logging
- [ ] Exception Handling
- [ ] File Handling
- [ ] Threading?

## 🛠️ Quick Start Guide

View the Maven Repository [here](https://central.sonatype.com/artifact/dev.dubsky/RapidRequest)

### Step 1: Add the dependency

Add the following dependency to your `pom.xml` file:
```xml
<dependency>
    <groupId>dev.dubsky</groupId>
    <artifactId>rapidrequest</artifactId>
    <version>1.2</version>
</dependency>
```
or if you are using Gradle, add the following to your `build.gradle` file:
```gradle
implementation 'dev.dubsky:rapidrequest:1.2'
```

### Step 2: Make a request

**Blocking (synchronous) request:**
```java
RapidResponse response = new SyncRequest()
        .setUrl("https://type.fit/api/quotes")
        .setMethod(HttpMethod.GET)
        .expect(ContentType.JSON)  // Optional
        .addHeader("Header", "Header-Value")  // Optional
        .addHeader("Another-Header", "Another-Value")  // Optional
        .call();
```

**Asynchronous request**:
```java
RapidResponse response = new AsyncRequest()
        .setUrl("https://type.fit/api/quotes")
        .setMethod(HttpMethod.GET)
        .expect(ContentType.JSON) // Optional
        .addHeader("Header", "Header-Value") // Optional
        .addHeader("Another-Header", "Another-Value") // Optional
        .call();
```

**Asynchronous request with blocking**:
```java
AsyncRequest response = new AsyncRequest()
        .setUrl("https://type.fit/api/quotes")
        .setMethod(HttpMethod.GET)
        .expect(ContentType.JSON) // Optional
        .addHeader("Header", "Header-Value") // Optional
        .addHeader("Another-Header", "Another-Value") // Optional
        .call();

response.waitForCompletion(); // Blocks until the request is complete
```

### Step 3: Result is given in a Response Object
```java
RapidResponse{
    statusCode=200, 
    response='[
        {
            "text": "Genius is one percent inspiration and ninety-nine percent perspiration.",
            "author": "Thomas Edison, type.fit"
        },
        ...
    ]',
    request=Request{
            method=GET,
            url='https://type.fit/api/quotes',
            body='null',
            contentType=JSON,
            headers=[User-Agent=Java 21 HttpClient],
            returnType=JSON
    }
}
```

## 📌 Version History

**v1.1 - 2024-02-27**
**v1.2 - 2024-02-29**

__Latest__:

![Maven Central Version](https://img.shields.io/maven-central/v/dev.dubsky/RapidRequest)