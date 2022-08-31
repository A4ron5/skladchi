package ru.safin.skladchina.services;

import ru.safin.skladchina.entities.Skladchina;
import ru.safin.skladchina.entities.User;

public interface SkaldchinaService {
    public Skladchina create(User user, String name, Integer participantsCount);
}
