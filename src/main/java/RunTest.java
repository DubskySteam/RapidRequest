import request.HttpMethod;
import request.RapidRequest;
import request.ReturnType;
import response.RapidResponse;

public class RunTest {

    public static void main(String[] args) {
        RapidResponse req = new RapidRequest()
                .setMethod(HttpMethod.GET)
                .setUrl("https://type.fit/api/quotes")
                .setReturnType(ReturnType.JSON)
                .call();

        System.out.println(req);
    }

}
