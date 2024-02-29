import dev.dubsky.rapidrequest.request.AsyncRequest;
import dev.dubsky.rapidrequest.response.RapidResponse;
import dev.dubsky.rapidrequest.util.HttpMethod;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AsyncRequestTest {

    @Test
    public void testAsyncRequest() {
        // Set up the request
        RapidResponse response = new AsyncRequest()
                .setUrl("https://type.fit/api/quotes")
                .setMethod(HttpMethod.GET)
                .call();

        // Check that the response is not null
        assertNotNull(response);

        //Wait for the response to complete
        try {
            response.waitForCompletion(); // Blocks until the response is complete
            assert(response.isCompleted());
            assert(response.getStatusCode() == 200);
            assert(response.getResponse() != null);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
