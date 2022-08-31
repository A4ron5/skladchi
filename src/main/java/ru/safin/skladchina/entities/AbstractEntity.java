package ru.safin.skladchina.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@EqualsAndHashCode(exclude = "id")
public abstract class AbstractEntity {
    @Id
    @Getter
    public String id;
}
