package ru.safin.skladchina.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;
import ru.safin.skladchina.entities.enums.Role;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Data
@Validated
@ConfigurationProperties(prefix = "skladchina")
public class SkladchinaProperties {

    @NotNull
    @NotEmpty
    private int maxParticipants;

    @NotNull
    private List<Role> notAllowedRolesToCreate;

}
