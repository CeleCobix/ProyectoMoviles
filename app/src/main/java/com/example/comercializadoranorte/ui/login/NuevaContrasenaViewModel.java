package com.example.comercializadoranorte.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NuevaContrasenaViewModel extends ViewModel {

    private final MutableLiveData<String> mensaje = new MutableLiveData<>();

    public LiveData<String> getMensaje() {
        return mensaje;
    }

    public void cambiarContrasena(String nueva, String confirmacion) {
        if (nueva.isEmpty() || confirmacion.isEmpty()) {
            mensaje.setValue("Completa todos los campos");
            return;
        }
        if (!nueva.equals(confirmacion)) {
            mensaje.setValue("Las contraseñas no coinciden");
            return;
        }
        if (nueva.length() < 6) {
            mensaje.setValue("La contraseña debe tener al menos 6 caracteres");
            return;
        }
        mensaje.setValue("Contraseña actualizada correctamente");
    }
}