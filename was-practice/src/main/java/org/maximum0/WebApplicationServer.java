package org.maximum0;

import org.maximum0.calculator.Calculator;
import org.maximum0.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebApplicationServer {
    private final int port;
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    private static final Logger log = LoggerFactory.getLogger(WebApplicationServer.class);

    public WebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            log.info("[WebApplicationServer] started {} port.", port);

            Socket clientSocket;
            log.info("[WebApplicationServer] waiting for client.");

            while ((clientSocket = serverSocket.accept()) != null) {
                log.info("[WebApplicationServer] client connected.");

                executorService.execute(new ClientRequestHandler(clientSocket));
            }
        }
    }
}
