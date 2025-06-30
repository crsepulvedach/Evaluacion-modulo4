package com.usuario;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UsuarioTest {

    @Test
    public void testActualizarPeso() {
        Usuario usuario = new Usuario("Juan", 70.0);
        usuario.actualizarPeso(75.0); // Se debería modificar la lógica.
        assertEquals(75.0, usuario.getPeso(), "El peso no se actualiza correctamente");
    }
}