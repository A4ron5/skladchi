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

import java.util.List;

@Service
@Slf4j
public class SkladchinaServiceImpl implements SkaldchinaService {

    SkladchinaProperties skladchinaProperties;
    SkladchinaRepository skladchinaRepository;

    @Override
    public Skladchina create(User user, String name, Integer participantsCount) {
        return null;
    }

    @Override
    public Skladchina get(String skladchinaId) {
        log.info("Get skladchina with id {}", skladchinaId);
        return skladchinaRepository.findById(skladchinaId).orElseThrow(() ->
                new BusinessException("Not found skladchina with id "));
    }

    @Override
    public List<Skladchina> getAll() {
        log.info("Get all skladchina");
        return skladchinaRepository.findAll();
    }

    @Override
    public Skladchina update(Skladchina skladchina) {
        log.info("Update skladchina {}", skladchina);
        return skladchinaRepository.save(skladchina);
    }

    @Override
    public boolean addParticipant(User user, String skladchinaId) {
        Skladchina skladchina = this.get(skladchinaId);
        log.info("add participant {} to skladchina {}", user, skladchina);

        if (skladchina.getParticipantsCount() >= skladchinaProperties.getMaxParticipants()) {
            throw new BusinessException("Max participants count reached");
        }

        skladchina.addParticipant(user);

        this.update(skladchina);

        return true;
    }


}
