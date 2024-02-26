package response;

import request.ReturnType;

import java.time.LocalDateTime;
import java.util.Objects;

public class RapidResponse {

    int statusCode;
    String response;
    ReturnType returnType;

    public RapidResponse() {}

    public RapidResponse(int statusCode, String response, ReturnType returnType) {
        this.statusCode = statusCode;
        this.response = response;
        this.returnType = returnType;
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

    public ReturnType getReturnType() {
        return returnType;
    }

    public void setReturnType(ReturnType returnType) {
        this.returnType = returnType;
    }

    @Override
    public String toString() {
        return "RapidResponse{" +
                "statusCode=" + statusCode +
                ", response='" + response + '\'' +
                ", returnType=" + returnType +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        RapidResponse that = (RapidResponse) obj;
        return statusCode == that.statusCode && Objects.equals(response, that.response) && returnType == that.returnType;
    }
}
