package com.entel.infra.adapter.output.console;

// Consola
import com.entel.app.usecase.LoginUseCaseImpl;
import com.entel.domain.repository.UsuarioRepository;
import com.entel.domain.service.LoginService;
import com.entel.infra.adapter.input.UsuarioRepositoryImpl;

import java.util.Scanner;

public class LoginConsole {

    public static void main(String[] args) {
        // Crear dependencias
        UsuarioRepository usuarioRepository = new UsuarioRepositoryImpl() {
        };
        LoginService loginService = new LoginService(usuarioRepository);
        LoginUseCaseImpl loginUseCaseImpl = new LoginUseCaseImpl(loginService);

        // Leer entradas de usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");

        String password = scanner.nextLine();

        // Ejecutar login
        boolean loginExitoso = loginUseCaseImpl.ejecutar(username, password);

        // Resultado
        if (loginExitoso) {
            System.out.println("Login exitoso");
        } else {
            System.out.println("Credenciales incorrectas");
        }
    }
}
