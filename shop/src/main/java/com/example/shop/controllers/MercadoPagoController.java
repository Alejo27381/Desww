package com.example.shop.controllers;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.resources.preference.Preference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/mercadopago")
@CrossOrigin(origins = "*") // Permitir acceso desde frontend en otro origen
public class MercadoPagoController {
    // Puedes inyectar el access token directamente o usar application.properties más adelante
    private static final String ACCESS_TOKEN = "TEST-2498672285912965-062919-fe8c47b42828b6650d29bb5afc875201-2522374027";

    @PostMapping("/crear-preferencia")
    public Preference crearPreferencia(@RequestBody List<PreferenceItemRequest> items) throws Exception {
        // Configurar el access token
        MercadoPagoConfig.setAccessToken(ACCESS_TOKEN);

        // Crear la preferencia
        PreferenceClient client = new PreferenceClient();
        PreferenceRequest request = PreferenceRequest.builder().items(items).build();
        Preference preference = client.create(request);

        return preference;
    }
}
