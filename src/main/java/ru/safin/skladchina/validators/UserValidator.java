package ru.safin.skladchina.validators;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.safin.skladchina.entities.User;
import ru.safin.skladchina.exceptions.BusinessException;
import ru.safin.skladchina.repositories.UserRepository;

@Component
@Slf4j
public class UserValidator {

  UserRepository userRepository;

  public User getUserIfExist(String userId) {
    return userRepository.findById(userId).orElseThrow(() ->
      BusinessException.create(
        String.format("No user with id=%s found to add participant to skladchina", userId)
      )
    );
  }
}
