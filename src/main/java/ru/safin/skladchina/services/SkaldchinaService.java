package ru.safin.skladchina.services;

import ru.safin.skladchina.entities.Skladchina;
import ru.safin.skladchina.entities.User;

public interface SkaldchinaService extends CommonService<Skladchina> {
    void addParticipant(String userId, String skladchinaId);

    Skladchina create(String skladchinaName, User user);
}
