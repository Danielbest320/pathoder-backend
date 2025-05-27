package co.edu.uco.pathorder.crosscutting.utilitarios;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UtilSeguridad {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String encriptar(String contrasena) {
        return encoder.encode(contrasena);
    }

    public static boolean verificar(String contrasenaPlano, String contrasenaEncriptada) {
        return encoder.matches(contrasenaPlano, contrasenaEncriptada);
    }
}

