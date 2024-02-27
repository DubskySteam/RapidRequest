import org.junit.jupiter.api.Test;
import request.Request;
import request.SyncRequest;
import response.RapidResponse;
import util.ContentType;
import util.HttpMethod;

import static org.junit.jupiter.api.Assertions.*;

public class SyncRequestTest {

    @Test
    public void testSyncRequest() {

        // Set up the request
        Request rreq = new SyncRequest()
                .setUrl("https://type.fit/api/quotes")
                .expect(ContentType.JSON)
                .setMethod(HttpMethod.GET)
                .setContentType(ContentType.JSON)
                .addHeader("User-Agent", "Java 21 HttpClient");

        // Call the API
        RapidResponse response = rreq.call();

        // Check for a 200 status code
        assertEquals(200, response.getStatusCode());

        // Check that the body is not null or empty
        assertNotNull(response.getResponse());
        assertFalse(response.getResponse().isEmpty());

        // Optional: Output the response for manual verification
        System.out.println(response.getResponse());
    }
}
