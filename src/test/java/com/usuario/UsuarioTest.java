package com.usuario;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UsuarioTest {

    @Test
    public void testActualizarPeso() {
        Usuario usuario = new Usuario("Juan", 70.0);
        usuario.actualizarPeso(75.0); // Se debería modificar la lógica.
        assertEquals(75.0, usuario.getPeso(), "El peso no se actualiza correctamente");
    }

    @Test
    public void testMostrarInformacion() {
        Usuario usuario = new Usuario("Ana", 60.0);
        usuario.mostrarInformacion(); // Puede ser que solo imprima a consola, se puede usar para comprobar manualmente.
    }
}