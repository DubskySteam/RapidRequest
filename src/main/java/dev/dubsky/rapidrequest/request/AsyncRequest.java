package dev.dubsky.rapidrequest.request;

import dev.dubsky.rapidrequest.logging.RapidLogger;
import dev.dubsky.rapidrequest.response.RapidResponse;
import dev.dubsky.rapidrequest.util.BodyParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public final class AsyncRequest extends Request {

    @Override
    public RapidResponse call() {
        RapidResponse response = new RapidResponse();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .method(method.name(), BodyParser.parseBody(body))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(httpResponse -> {
                    RapidLogger.getInstance().log("Request completed with status code " + httpResponse.statusCode());
                    response.complete(httpResponse.statusCode(), httpResponse.body());
                })
                .exceptionally(e -> {
                    RapidLogger.getInstance().log("Error occurred while sending request", e);
                    response.complete(500, "Internal Server Error");
                    return null;
                });

        return response;
    }
}
