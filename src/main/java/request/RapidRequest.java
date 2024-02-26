package request;

import response.RapidResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * @author Dubsky
 * @since 1.0
 */
public class RapidRequest {

    private HttpMethod method;
    private String url;
    private String body;
    private ArrayList<String> headers;
    private ReturnType returnType;

    public RapidRequest() {

    }

    /**
     * @param method      HTTP method to use
     */
    public RapidRequest setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public RapidRequest setUrl(String url) {
        this.url = url;
        return this;
    }

    public RapidRequest expect(ReturnType returnType) {
        this.returnType = returnType;
        return this;
    }

    public String getBody() {
        return body;
    }

    public RapidRequest setBody(String body) {
        this.body = body;
        return this;
    }

    public RapidResponse call() {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .method(method.name(), HttpRequest.BodyPublishers.ofString(body))
                    .header("Accept", "application/" + returnType.name().toLowerCase())
                    .build();
            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                return new RapidResponse(response.statusCode(), response.body(), returnType);
            } catch (Exception e) {
                Logger.getGlobal().severe("Error occurred while sending (s)request: " + e.getMessage());
                return new RapidResponse();
            }
        }
    }

}