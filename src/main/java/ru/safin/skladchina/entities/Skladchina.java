package ru.safin.skladchina.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import ru.safin.skladchina.entities.enums.SkladchinaStatus;


@Document("Skladchinas")
public class Skladchina extends AbstractEntity{

    String name;
    Integer participantsCount;
    SkladchinaStatus status;
    boolean archived;
}
