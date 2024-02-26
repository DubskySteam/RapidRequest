package response;

import request.Request;

import java.util.Objects;

/**
 * @author DubskySteam
 */
public class RapidResponse {

    int statusCode;
    String response;
    Request request;

    public RapidResponse() {}

    public RapidResponse(int statusCode, String response, Request request){
        this.statusCode = statusCode;
        this.response = response;
        this.request = request;
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

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "RapidResponse{" +
                "statusCode=" + statusCode +
                ", response='" + response + '\'' +
                ", request=" + request +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        RapidResponse that = (RapidResponse) obj;
        return statusCode == that.statusCode && Objects.equals(response, that.response) && Objects.equals(request, that.request);
    }
}
