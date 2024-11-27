package com.entel.app.usecase;

import com.entel.domain.service.LoginService;

// Aplicación
public class LoginUseCase implements com.entel.app.port.input.LoginUseCase {

    private final LoginService loginService;

    public LoginUseCase(LoginService loginService) {
        this.loginService = loginService;
    }

    public boolean ejecutar(String username, String password) {
        return loginService.login(username, password);
    }
}
