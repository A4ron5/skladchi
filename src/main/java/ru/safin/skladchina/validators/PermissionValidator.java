package ru.safin.skladchina.validators;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.safin.skladchina.configurations.SkladchinaProperties;
import ru.safin.skladchina.entities.User;
import ru.safin.skladchina.entities.enums.Role;
import ru.safin.skladchina.exceptions.BusinessException;

import java.util.List;

@Component
@Slf4j
public class PermissionValidator {

    SkladchinaProperties skladchinaProperties;

    public void canUserCreateSkladchina(User user) {
        if (
                skladchinaProperties.getNotAllowedRolesToCreate()
                        .stream().anyMatch(role -> role.equals(user.getRole()))
        )
        {
            throw new BusinessException("Not allowed role to create skladchina");
        }

    }
}
