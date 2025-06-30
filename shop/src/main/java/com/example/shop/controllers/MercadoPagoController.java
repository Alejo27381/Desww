package com.example.shop.controllers;

import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.resources.preference.Preference;
import com.mercadopago.MercadoPagoConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/mercadopago")
public class MercadoPagoController {

    @Value("${mercadopago.access.token}")
    private String accessToken;

    @PostMapping("/crear-preferencia")
    public Map<String, String> crearPreferencia(@RequestBody List<PreferenceItemRequest> items) throws Exception {
        MercadoPagoConfig.setAccessToken(accessToken);

        PreferenceClient client = new PreferenceClient();
        PreferenceRequest request = PreferenceRequest.builder().items(items).build();
        Preference preference = client.create(request);

        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("init_point", preference.getInitPoint());
        return respuesta;
    }
}
