package ru.safin.skladchina.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.safin.skladchina.configurations.SkladchinaProperties;
import ru.safin.skladchina.entities.Skladchina;
import ru.safin.skladchina.entities.User;
import ru.safin.skladchina.entities.enums.SkladchinaStatus;
import ru.safin.skladchina.exceptions.BusinessException;
import ru.safin.skladchina.repositories.SkladchinaRepository;
import ru.safin.skladchina.repositories.UserRepository;
import ru.safin.skladchina.services.AbstractService;
import ru.safin.skladchina.services.SkaldchinaService;

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
    public void addParticipant(String userId, String skladchinaId) {
        Skladchina skladchina = this.get(skladchinaId);

        int participantCount = skladchina.getParticipantsCount();

        if (participantCount >= skladchinaProperties.getMaxParticipants()) {
            throw BusinessException.create("Max participants count reached");
        }

        User user = userRepository.findById(userId).orElseThrow(() ->
                BusinessException.create(
                        String.format("No user with id=%s found to add participant to skladchina", userId)
                )
        );

        log.info("add participant {} to skladchina {}", user, skladchina);

        skladchina.addParticipant(user);
        skladchina.setParticipantsCount(participantCount + 1);

        this.update(skladchina);
    }

    @Override
    public Skladchina create(String skladchinaName, User user) {
        return super.create(
                Skladchina.builder()
                        .creatorId(user.getId())
                        .name(skladchinaName)
                        .status(SkladchinaStatus.CREATED)
                        .build()
        );
    }


}
