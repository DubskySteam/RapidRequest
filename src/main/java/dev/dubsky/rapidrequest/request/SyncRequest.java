package dev.dubsky.rapidrequest.request;

import dev.dubsky.rapidrequest.util.TypeParser;
import dev.dubsky.rapidrequest.response.RapidResponse;
import dev.dubsky.rapidrequest.util.BodyParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.logging.Logger;

public final class SyncRequest extends Request {

    /**
     * Send the request and return the response
     *
     * @return the response
     */
    @Override
    public RapidResponse call() {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .method(method.name(), BodyParser.parseBody(body))
                    .header("Accept", TypeParser.parseType(returnType));

            for (Map.Entry<String, String> header : headers) {
                requestBuilder.header(header.getKey(), header.getValue());
            }

            HttpRequest request = requestBuilder.build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                return new RapidResponse(response.statusCode(), response.body(), this);
            } catch (Exception e) {
                Logger.getGlobal().severe("Error occurred while sending request: " + e.getMessage());
                return new RapidResponse();
            }
        }
    }

}
