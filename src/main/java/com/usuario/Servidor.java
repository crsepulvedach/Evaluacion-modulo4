package com.usuario;

import static spark.Spark.*;

public class Servidor {

    public static void main(String[] args) {
        Usuario usuario = new Usuario("Ana", 60.0);

        get("/usuario", (req, res) -> {
            return "<html><body>" +
                    "<h1 id='nombre'>" + usuario.getNombre() + "</h1>" +
                    "<p id='peso'>" + usuario.getPeso() + "</p>" +
                   "</body></html>";
        });
    }
}
