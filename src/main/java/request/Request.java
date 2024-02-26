package request;

import response.RapidResponse;
import util.ContentType;
import util.HttpMethod;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Request {

    protected HttpMethod method;
    protected String url;
    protected String body;

    protected ContentType contentType;
    protected List<Map.Entry<String, String>> headers = new ArrayList<>();
    protected ContentType returnType;

    public Request setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public Request setUrl(String url) {
        this.url = url;
        return this;
    }

    public Request expect(ContentType returnType) {
        this.returnType = returnType;
        return this;
    }

    public Request setContentType(ContentType contentType) {
        this.contentType = contentType;
        return this;
    }

    public Request addHeader(String key, String value) {
        headers.add(new AbstractMap.SimpleEntry<>(key, value));
        return this;
    }

    public Request setBody(String body) {
        this.body = body;
        return this;
    }

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
