package com.entel.app.usecase;

import com.entel.app.port.input.LoginUseCase;
import com.entel.domain.service.LoginService;

// Aplicación
public class LoginUseCaseImpl implements LoginUseCase {

    private final LoginService loginService;

    public LoginUseCaseImpl(LoginService loginService) {
        this.loginService = loginService;
    }

    public boolean ejecutar(String username, String password) {
        return loginService.login(username, password);
    }
}
