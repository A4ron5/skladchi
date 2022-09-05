package ru.safin.skladchina.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.safin.skladchina.entities.enums.SkladchinaStatus;

import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
@Document("Skladchinas")
public class Skladchina extends AbstractEntity {

    String name;
    SkladchinaStatus status;
    Integer participantsCount;
    List<User> participants;
    boolean archived;
    User creator;

    public void addParticipant(User participant) {
        participants.add(participant);
    }

    void archive() {
        archived = true;
    }

}
