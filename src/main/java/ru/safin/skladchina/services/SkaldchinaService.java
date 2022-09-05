package ru.safin.skladchina.services;

import ru.safin.skladchina.entities.Skladchina;
import ru.safin.skladchina.entities.User;

import java.util.List;

public interface SkaldchinaService {
    void addParticipant(User user, String skladchinaId);
}
