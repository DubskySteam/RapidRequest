# RapidRequest
RapidRequest is a simple and easy to use HTTP request library for Java.
It is designed to make HTTP requests with minimal code and maximum flexibility.

## 🌟 Features
- [X] Synchronous Requests
- [X] Response Object

## 🚀 Upcoming Features
- [ ] Asynchronous Requests
- [ ] Advanced Logging
- [ ] Exception Handling
- [ ] Request/Response Encryption
- [ ] File Uploads
- [ ] File Downloads
- [ ] Threading?

## 🛠️ Quick Start Guide

### Step 1: Add the dependency
Add the following dependency to your `pom.xml` file:
```xml
<dependency>
    <groupId>dev.dubsky</groupId>
    <artifactId>rapidrequest</artifactId>
    <version>1.1</version>
</dependency>
```
or if you are using Gradle, add the following to your `build.gradle` file:
```gradle
implementation 'dev.dubsky:rapidrequest:1.0'
```

### Step 2: Make a request

Blocking (synchronous) request:
```java
RapidResponse req = new RapidRequest()
        .setUrl("https://type.fit/api/quotes") // Request URL
        .setMethod(HttpMethod.GET) // Request method
        .expect(ContentType.JSON) // Expected response content type
        .addHeader("Header", "Header-Value") // Add request headers
        .addHeader("Another-Header", "Another-Value") // Add request headers
        .call(); // Send the request
```

Asynchronous request:
```java
RapidResponse req = new RapidRequest()
        .setUrl("https://type.fit/api/quotes") // Request URL
        .setMethod(HttpMethod.GET) // Request method
        .expect(ContentType.JSON) // Expected response content type
        .addHeader("Header", "Header-Value") // Add request headers
        .addHeader("Another-Header", "Another-Value") // Add request headers
        .callAsync(response -> {
            // Handle the response
        });
```

### Step 3: Example Response Object
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

## 📌 Version & Downloads

Will be available as soon as the first release is made.