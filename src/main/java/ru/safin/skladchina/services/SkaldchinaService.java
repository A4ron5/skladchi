package ru.safin.skladchina.services;

import ru.safin.skladchina.entities.Skladchina;
import ru.safin.skladchina.entities.User;

public interface SkaldchinaService {
    Skladchina create(User user, String name, Integer participantsCount);

    Skladchina get(String skladchinaId);

    boolean addParticipant(User user, String skladchinaId);

    Skladchina update(Skladchina skladchina);
}
