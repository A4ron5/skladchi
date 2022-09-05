package ru.safin.skladchina.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.safin.skladchina.entities.AbstractEntity;

@NoRepositoryBean
public interface CommonRepository<T extends AbstractEntity> extends MongoRepository<T, String> {
}
