package dev.dubsky.rapidrequest.request;

import dev.dubsky.rapidrequest.response.RapidResponse;
import dev.dubsky.rapidrequest.util.ContentType;
import dev.dubsky.rapidrequest.util.HttpMethod;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Base class for all requests
 */
public class Request {

    protected HttpMethod method;
    protected String url;
    protected String body;

    protected ContentType contentType;
    protected List<Map.Entry<String, String>> headers = new ArrayList<>();
    protected ContentType returnType;

    /**
     * Set the method of the request
     *
     * @param method the method to use
     * @return the request
     */
    public Request setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    /**
     * Set the URL of the request
     *
     * @param url the URL to use
     * @return the request
     */
    public Request setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Set the expected return type of the request
     *
     * @param returnType the expected return type
     * @return the request
     */
    public Request expect(ContentType returnType) {
        this.returnType = returnType;
        return this;
    }

    /**
     * Set the content type of the request
     *
     * @param contentType the content type to use
     * @return the request
     */
    public Request setContentType(ContentType contentType) {
        this.contentType = contentType;
        return this;
    }

    /**
     * Add a header to the request
     *
     * @param key   the key of the header
     * @param value the value of the header
     * @return the request
     */
    public Request addHeader(String key, String value) {
        headers.add(new AbstractMap.SimpleEntry<>(key, value));
        return this;
    }

    /**
     * Set the body of the request
     *
     * @param body the body to use
     * @return the request
     */
    public Request setBody(String body) {
        this.body = body;
        return this;
    }

    /**
     * Send the request
     *
     * @return the response
     */
    public RapidResponse call() {
        return null;
    }

    @Override
    public String toString() {
        return "Request{" +
                "method=" + method +
                ", url='" + url + '\'' +
                ", body='" + body + '\'' +
                ", contentType=" + contentType +
                ", headers=" + headers +
                ", returnType=" + returnType +
                '}';
    }
}
