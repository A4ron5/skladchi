package ru.safin.skladchina.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.safin.skladchina.entities.Skladchina;
import ru.safin.skladchina.entities.User;
import ru.safin.skladchina.services.SkaldchinaService;
import ru.safin.skladchina.validators.PermissionValidator;

@Service
public class SkladchinaServiceImpl implements SkaldchinaService {

    @Override
    public Skladchina create(User user, String name, Integer participantsCount) {

    }
}
