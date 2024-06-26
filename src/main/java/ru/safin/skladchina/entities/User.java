package ru.safin.skladchina.entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.safin.skladchina.entities.enums.Role;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Document("Users")
public class User extends AbstractEntity {

    String name;
    String secretWord;
    Role role;
    public List<Skladchina> skladchinas;


}
