package ru.terra.terramarket.server;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import org.apache.log4j.BasicConfigurator;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.servlet.WebappContext;
import ru.terra.server.config.Config;
import ru.terra.server.constants.ConfigConstants;
import ru.terra.server.timers.TimersManager;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

public class Main {

    protected static HttpServer startServer() throws IOException {
        String url = "http://" + Config.getConfig().getValue(ConfigConstants.SERVER_ADDR, ConfigConstants.SERVER_ADDR_DEFAULT);
        URI uri = UriBuilder.fromUri(url).port(18080).build();
        System.out.println("Starting terra market server...");
        WebappContext context = new WebappContext("context");
        HttpServer webserver = GrizzlyServerFactory.createHttpServer(uri);
        context.deploy(webserver);
        return webserver;
    }

    public static void main(String[] args) throws IOException {
        BasicConfigurator.configure();
        TimersManager.getInstance().start();
        HttpServer httpServer = startServer();

        System.out.println("Starting...");
        System.in.read();
        httpServer.stop();
    }
}
