package request;

import response.RapidResponse;
import util.TypeParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

/**
 * Represents an asynchronous request.
 *
 * @deprecated Will be available in a future release.
 */
public final class AsyncRequest extends Request {

    /**
     * Sends an asynchronous request to the specified URL.
     *
     * @return a RapidResponse object containing the response from the server.
     */
    @Override
    public RapidResponse call() {
        CompletableFuture<RapidResponse> futureResponse;
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .method(method.name(), HttpRequest.BodyPublishers.ofString(body))
                    .header("Accept", TypeParser.parseType(returnType))
                    .build();

            futureResponse = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(response -> new RapidResponse(response.statusCode(), response.body(), this))
                    .exceptionally(e -> {
                        Logger.getGlobal().severe("Error occurred while sending asynchronous request: " + e.getMessage());
                        return new RapidResponse();
                    });
        }
        return futureResponse.join();
    }

}
