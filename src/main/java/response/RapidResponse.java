package response;

import java.util.Objects;

public class RapidResponse {

    int statusCode;
    String response;

    public RapidResponse() {}

    public RapidResponse(int statusCode, String response) {
        this.statusCode = statusCode;
        this.response = response;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "RapidResponse{" +
                "statusCode=" + statusCode +
                ", response='" + response + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!RapidResponse.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final RapidResponse other = (RapidResponse) obj;
        if (this.statusCode != other.statusCode) {
            return false;
        }
        return Objects.equals(this.response, other.response);
    }
}
