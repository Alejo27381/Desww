package com.example.shop.controllers;

import com.example.shop.entities.Usuario;
import com.example.shop.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class PagesController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/")
    public String index(Model model, Principal principal) {
        if (principal != null) {
            String email = principal.getName();
            Usuario usuario = usuarioRepository.findByEmail(email).orElse(null);
            if (usuario != null) {
                model.addAttribute("nombreUsuario", usuario.getNombre());
            }
        }
        return "index";
    }

    @GetMapping("/nosotros")
    public String nosotros(Model model, Principal principal) {
        if (principal != null) {
            String email = principal.getName();
            Usuario usuario = usuarioRepository.findByEmail(email).orElse(null);
            if (usuario != null) {
                model.addAttribute("nombreUsuario", usuario.getNombre());
            }
        }
        return "nosotros";
    }

}
