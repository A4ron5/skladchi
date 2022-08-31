package ru.safin.skladchina.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.safin.skladchina.entities.Skladchina;
import ru.safin.skladchina.entities.User;
import ru.safin.skladchina.services.SkaldchinaService;
import ru.safin.skladchina.validators.PermissionValidator;

@RestController
@RequestMapping("/api/skladchina")
@Validated
public class SkladchinaController {

    PermissionValidator permissionValidator;
    SkaldchinaService skaldchinaService;

    @PostMapping
    public ResponseEntity<Skladchina> createSkladchina(
            @RequestBody String name,
            @RequestBody Integer participantsCount,
            @RequestBody User user
    ) {
        permissionValidator.canUserCreateSkladchina(user);

        var skladchina = skaldchinaService.create(
                user,
                name,
                participantsCount
        );

        return ResponseEntity.ok(skladchina);
    }

}
