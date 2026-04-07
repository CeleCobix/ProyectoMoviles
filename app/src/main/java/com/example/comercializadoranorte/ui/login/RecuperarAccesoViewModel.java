package com.example.comercializadoranorte.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecuperarAccesoViewModel extends ViewModel {

    private final MutableLiveData<String> mensaje = new MutableLiveData<>();

    public LiveData<String> getMensaje() {
        return mensaje;
    }

    public void recuperarAcceso(String correo) {
        if (correo.isEmpty()) {
            mensaje.setValue("Ingresa tu correo electrónico");
            return;
        }
        // Aquí se conecta con el servicio de recuperación
        mensaje.setValue("Se enviaron instrucciones a: " + correo);
    }
}