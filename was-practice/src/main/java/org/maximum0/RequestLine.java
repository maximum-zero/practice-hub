package org.maximum0;

import java.util.Objects;

public class RequestLine {
    private final String method;
    private final String path;
    private QueryStrings queryString;

    public RequestLine(String method, String path, String queryString) {
        this.method = method;
        this.path = path;
        this.queryString = new QueryStrings(queryString);
    }

    public RequestLine(String requestLine) {
        String[] tokens = requestLine.split(" ");
        this.method = tokens[0];

        String[] urlTokens = tokens[1].split("\\?");
        this.path = urlTokens[0];

        if (urlTokens.length == 2) {
            this.queryString = new QueryStrings(urlTokens[1]);
        }
    }

    public boolean isGetRequest() {
        return "GET".equals(method);
    }

    public boolean matchPath(String requestPath) {
        return path.equals(requestPath);
    }

    public QueryStrings getQueryString() {
        return queryString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(path, that.path) && Objects.equals(queryString, that.queryString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, path, queryString);
    }
}
