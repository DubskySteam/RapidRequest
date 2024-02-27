package util;

import java.net.http.HttpRequest;

public class BodyParser {

    /**
     * This method is used to parse the body of the request.
     * It is used to convert the body to a HttpRequest.BodyPublisher.
     * This is used in the Request class to set the body of the request.
     *
     * @param body The body of the request.
     * @return The body of the request as a HttpRequest.BodyPublisher.
     */
    public static HttpRequest.BodyPublisher parseBody(String body) {
        if (body == null) {
            return HttpRequest.BodyPublishers.noBody();
        }
        return HttpRequest.BodyPublishers.ofString(body);
    }

}
