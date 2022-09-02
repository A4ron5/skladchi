package ru.safin.skladchina.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.safin.skladchina.configurations.SkladchinaProperties;
import ru.safin.skladchina.entities.Skladchina;
import ru.safin.skladchina.entities.User;
import ru.safin.skladchina.exceptions.BusinessException;
import ru.safin.skladchina.repositories.SkladchinaRepository;
import ru.safin.skladchina.services.SkaldchinaService;
import ru.safin.skladchina.validators.PermissionValidator;

@Service
public class SkladchinaServiceImpl implements SkaldchinaService {

    SkladchinaProperties skladchinaProperties;
    SkladchinaRepository skladchinaRepository;

    @Override
    public Skladchina create(User user, String name, Integer participantsCount) {
        return null;
    }

    @Override
    public Skladchina get(String skladchinaId) {
        return skladchinaRepository.findById(skladchinaId).orElseThrow(() ->
                new BusinessException("Not found skladchina with id "));
    }

    @Override
    public Skladchina update(Skladchina skladchina) {
        return skladchinaRepository.save(skladchina);
    }

    @Override
    public boolean addParticipant(User user, String skladchinaId) {
        Skladchina skladchina = this.get(skladchinaId);

        if (skladchina.getParticipantsCount() >= skladchinaProperties.getMaxParticipants()) {
            throw new BusinessException("Max participants count reached");
        }

        skladchina.addParticipant(user);

        this.update(skladchina);

        return true;
    }


}
