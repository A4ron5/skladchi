package ru.safin.skladchina.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.safin.skladchina.configurations.SkladchinaProperties;
import ru.safin.skladchina.entities.Skladchina;
import ru.safin.skladchina.entities.User;
import ru.safin.skladchina.exceptions.BusinessException;
import ru.safin.skladchina.repositories.SkladchinaRepository;
import ru.safin.skladchina.repositories.UserRepository;
import ru.safin.skladchina.services.AbstractService;
import ru.safin.skladchina.services.SkaldchinaService;

import java.util.Optional;

@Service
@Slf4j
public class SkladchinaServiceImpl
        extends AbstractService<Skladchina, SkladchinaRepository> implements SkaldchinaService {

    SkladchinaProperties skladchinaProperties;
    UserRepository userRepository;

    public SkladchinaServiceImpl(
            SkladchinaRepository repository,
            SkladchinaProperties skladchinaProperties,
            UserRepository userRepository
            ) {
        super(repository);
        this.skladchinaProperties = skladchinaProperties;
        this.userRepository = userRepository;
    }

    @Override
    public void addParticipant(User user, String skladchinaId) {
        Skladchina skladchina = this.get(skladchinaId);
        log.info("add participant {} to skladchina {}", user, skladchina);

        int participantCount = skladchina.getParticipantsCount();

        if (participantCount >= skladchinaProperties.getMaxParticipants()) {
            throw BusinessException.create("Max participants count reached");
        }

        skladchina.addParticipant(user);
        skladchina.setParticipantsCount(participantCount + 1);

        this.update(skladchina);
    }

    @Override
    public Skladchina create(Skladchina skladchina, String userId) {

        User user = userRepository.findById(userId).orElseThrow(() ->
                BusinessException.create(
                        String.format("No user with id=%s found to create skladchina", userId)
                )
        );


        skladchina.setCreator(user);

        return super.create(skladchina);
    }


}
