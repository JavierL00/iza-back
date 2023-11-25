package com.izanagi.back.controller;

import com.izanagi.back.dto.InputLoginClientDTO;
import com.izanagi.back.dto.InputRegisterClientDTO;
import com.izanagi.back.model.Clients;
import com.izanagi.back.service.IClientsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientsController {
    private final IClientsService service;

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody InputRegisterClientDTO input
    ) {
        try {
            Clients client = new Clients();
            client.setUsername(input.getUsername());
            client.setEmail(input.getEmail());
            client.setPassword(input.getPassword());
            service.save(client);
            return ResponseEntity.ok("Cliente creado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear cliente. Error: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody InputLoginClientDTO input
    ) {
        try {
            Clients client = service.findByUsername(input.getUsername());
            if (client.getPassword().equals(input.getPassword())) {
                return ResponseEntity.ok("Login exitoso");
            } else {
                return ResponseEntity.badRequest().body("Contraseña incorrecta");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al hacer login. Error: " + e.getMessage());
        }
    }
}
