package dev.dubsky.rapidrequest.response;

import dev.dubsky.rapidrequest.request.Request;

import java.util.Objects;

/**
 * Represents a response from a request.
 */
public class RapidResponse {

    private int statusCode;
    private String response;
    private Request request;
    private volatile boolean completed = false;

    public RapidResponse() {
    }

    public RapidResponse(int statusCode, String response, Request request) {
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

    /**
     * Method to complete the response
     *
     * @param statusCode the status code of the response
     * @param response   the response body
     */
    public synchronized void complete(int statusCode, String response) {
        this.statusCode = statusCode;
        this.response = response;
        this.completed = true;
        this.notifyAll();
    }

    /**
     * Method to check if the response is completed
     *
     * @return true if the response is completed, false otherwise
     */
    public synchronized boolean isCompleted() {
        return completed;
    }

    /**
     * Method to wait for the response to be completed
     *
     * @throws InterruptedException if the thread is interrupted while waiting
     */
    public synchronized void waitForCompletion() throws InterruptedException {
        while (!completed) {
            this.wait();
        }
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
