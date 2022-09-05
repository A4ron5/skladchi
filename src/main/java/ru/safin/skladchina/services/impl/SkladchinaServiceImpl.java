package ru.safin.skladchina.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.safin.skladchina.configurations.SkladchinaProperties;
import ru.safin.skladchina.entities.Skladchina;
import ru.safin.skladchina.entities.User;
import ru.safin.skladchina.exceptions.BusinessException;
import ru.safin.skladchina.repositories.SkladchinaRepository;
import ru.safin.skladchina.services.AbstractService;
import ru.safin.skladchina.services.SkaldchinaService;

@Service
@Slf4j
public class SkladchinaServiceImpl
        extends AbstractService<Skladchina, SkladchinaRepository> implements SkaldchinaService {

    SkladchinaProperties skladchinaProperties;

    public SkladchinaServiceImpl(SkladchinaRepository repository) {
        super(repository);
    }

    @Override
    public void addParticipant(User user, String skladchinaId) {
        Skladchina skladchina = this.get(skladchinaId);
        log.info("add participant {} to skladchina {}", user, skladchina);

        if (skladchina.getParticipantsCount() >= skladchinaProperties.getMaxParticipants()) {
            throw BusinessException.create("Max participants count reached");
        }

        skladchina.addParticipant(user);

        this.update(skladchina);
    }


}
