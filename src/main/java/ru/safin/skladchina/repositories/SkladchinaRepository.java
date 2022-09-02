package ru.safin.skladchina.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.safin.skladchina.entities.Skladchina;

@Repository
public interface SkladchinaRepository extends MongoRepository<Skladchina, String> {
}
