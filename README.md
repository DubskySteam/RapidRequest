# RapidRequest
RapidRequest is a simple and easy to use HTTP request library for Java.
It is designed to make HTTP requests with minimal code and maximum flexibility.

## 🌟 Features
- [ ] Request Builder
- [ ] Response Handler
- [ ] Advanced Logging
- [ ] Exception Handling

## 🚀 Upcoming Features
- [ ] Asynchronous Requests
- [ ] Request/Response Encryption

## 🛠️ Quick Start Guide
```java
RapidResponse req = new RapidRequest()
    .setMethod(HttpMethod.GET)
    .setUrl("https://type.fit/api/quotes")
    .setReturnType(ReturnType.JSON)
    .call();

System.out.println(req);
```

## 📌 Version & Downloads

Will be available as soon as the first release is made.