package com.usuario;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Servidor {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/usuario", new UsuarioHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Servidor escuchando en puerto 8080");
    }

    static class UsuarioHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            Usuario usuario = new Usuario("Ana", 60.0);
            String response = usuario.mostrarInformacion();
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
