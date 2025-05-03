package org.maximum0;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestLineTest {

    @Test
    void createTest() {
        RequestLine requestLine = new RequestLine("GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1");
        assertThat(requestLine).isNotNull();
    }
}
