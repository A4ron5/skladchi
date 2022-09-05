package ru.safin.skladchina.services;

import ru.safin.skladchina.entities.Skladchina;
import ru.safin.skladchina.entities.User;

public interface SkaldchinaService extends CommonService<Skladchina> {
    void addParticipant(User user, String skladchinaId);

    Skladchina create(Skladchina skladchina, String userId);
}
