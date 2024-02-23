package request;

import response.RapidResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author Dubsky
 * @since 1.0
 */
public class RapidRequest {

    private HttpMethod method;
    private String url;
    private ReturnType returnType;

    public RapidRequest() {

    }

    public RapidRequest setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public RapidRequest setUrl(String url) {
        this.url = url;
        return this;
    }

    public RapidRequest setReturnType(ReturnType returnType) {
        this.returnType = returnType;
        return this;
    }

    public RapidResponse call() {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .method(method.name(), HttpRequest.BodyPublishers.noBody())
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new RapidResponse(response.statusCode(), response.body());
        } catch (Exception e) {
            e.printStackTrace();
            return new RapidResponse();
        }
    }

}