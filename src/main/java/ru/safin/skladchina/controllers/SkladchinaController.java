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
import ru.safin.skladchina.validators.UserValidator;

@RestController
@RequestMapping("/api/skladchina")
@Validated
public class SkladchinaController {

    PermissionValidator permissionValidator;
    UserValidator userValidator;
    SkaldchinaService skaldchinaService;

    @PostMapping
    public ResponseEntity<Skladchina> createSkladchina(@RequestBody String skaldchinaName, String userId) {
        User user = userValidator.getUserIfExist(userId);
        permissionValidator.canUserCreateSkladchina(user);

        Skladchina skladchina = skaldchinaService.create(skaldchinaName, user);

        return ResponseEntity.ok(skladchina);
    }

    @PostMapping
    public ResponseEntity<Void> appParticipantToSkladchina(String skladchinaId, String userId) {
        User user = userValidator.getUserIfExist(userId);


        return ResponseEntity.ok().build();
    }

}
