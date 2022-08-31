package ru.safin.skladchina.validators;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.safin.skladchina.entities.User;
import ru.safin.skladchina.entities.enums.Role;
import ru.safin.skladchina.exceptions.BusinessException;

@Component
@Slf4j
public class PermissionValidator {

    private final Role notAllowedRole = Role.NEWBIE;

    public boolean canUserCreateSkladchina(User user) {
        if (user.getRole().equals(notAllowedRole)) {
            throw new BusinessException();
        }

        return true;
    }
}
