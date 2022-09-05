package ru.safin.skladchina.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.safin.skladchina.entities.AbstractEntity;
import ru.safin.skladchina.exceptions.BusinessException;
import ru.safin.skladchina.repositories.CommonRepository;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public abstract class AbstractService<T extends AbstractEntity, R extends CommonRepository<T>> implements CommonService<T> {
  protected final R repository;


  public T get(String id) {
    log.info("Get entity with id={}", id);
    return repository.findById(id)
            .orElseThrow(() ->
                    BusinessException.create(String.format("not found entity with id %s", id))
            );
  }

  public T update(T object) {
    log.info("Update entity {}", object);
    return repository.save(object);
  }

  public T create(T object) {
    log.info("Create entity {}", object);

    String id = object.getId();
    if (repository.existsById(id)) {
      throw BusinessException.create(String.format("Entity with id=%s already exist", id));
    }

    return repository.save(object);
  }

  public void delete(String id) {
    var object = get(id);
    log.info("Delete entity {}", object);

    repository.delete(object);
  }

  public List<T> getAll() {
    log.info("Get all entities");
    return repository.findAll();
  }

}
