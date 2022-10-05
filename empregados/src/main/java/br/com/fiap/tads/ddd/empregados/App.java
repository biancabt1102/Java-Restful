package br.com.fiap.tads.ddd.empregados;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

@SuppressWarnings("deprecation")
public class App {

	public static final String BASE_URI = "http://localhost:8080/";

	public static HttpServer startServer() {
		final ResourceConfig rc = new ResourceConfig().packages("br.com.fiap.tads.ddd.empregados.controller");
		return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
	}

	public static void main(String[] args) throws IOException {
		final HttpServer server = startServer();
		System.out.println(String.format("Jersey app iniciado e os endiponts estão disponíveis em"
				+ " %s%nHit Control-C para parar o servidor...", BASE_URI));
		System.in.read();
		server.stop();
	}

}
