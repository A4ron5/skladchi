package ru.safin.skladchina.services;

import ru.safin.skladchina.entities.Skladchina;
import ru.safin.skladchina.entities.User;

import java.util.List;

public interface SkaldchinaService {
    Skladchina create(User user, String name, Integer participantsCount);

    Skladchina get(String skladchinaId);

    List<Skladchina> getAll();

    boolean addParticipant(User user, String skladchinaId);

    Skladchina update(Skladchina skladchina);
}
