package com.example.comercializadoranorte.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    private final MutableLiveData<Boolean> loginExitoso = new MutableLiveData<>();

    public LiveData<Boolean> getLoginExitoso() {
        return loginExitoso;
    }

    public void login(String usuario, String contrasena) {
        if (usuario.isEmpty() || contrasena.isEmpty()) {
            loginExitoso.setValue(false);
            return;
        }

        boolean valido = usuario.equals("admin") && contrasena.equals("admin");
        loginExitoso.setValue(valido);
    }
}