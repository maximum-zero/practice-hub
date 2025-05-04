package org.maximum0;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class WebApplicationServer {
    private static final Logger log = LoggerFactory.getLogger(WebApplicationServer.class);

    public static void main(String[] args) throws LifecycleException, IOException {
        String webappDirLocation = "servlet-practice/webapp";
        String fullPath = new File(webappDirLocation).getCanonicalPath();

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        tomcat.addWebapp("", fullPath);
        log.info("configuring app with basedir: {}", fullPath);

        tomcat.start();
        tomcat.getServer().await();
    }
}
