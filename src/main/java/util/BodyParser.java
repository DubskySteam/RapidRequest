package util;

import java.net.http.HttpRequest;

public class BodyParser {

    public static HttpRequest.BodyPublisher parseBody(String body) {
        if (body == null) {
            return HttpRequest.BodyPublishers.noBody();
        }
        return HttpRequest.BodyPublishers.ofString(body);
    }

}
