package org.example;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class WebApplicationServer {

    private static final Logger log = LoggerFactory.getLogger(WebApplicationServer.class);

    public static void main(String[] args) throws Exception {
        String webappDirLocation = "webapps/";  // ~/mvx-practice/webapps <- directory 생성 root directory
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        tomcat.getConnector(); // 기본 커넥터 생성(리스너 강제 생성)

        tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        log.info("configuring app with basedir: {}", new File("./" + webappDirLocation). getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}