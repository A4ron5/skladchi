package ru.safin.skladchina.services;

import ru.safin.skladchina.entities.AbstractEntity;

import java.util.List;

public interface CommonService<T extends AbstractEntity> {

  T get(String id);

  T update(T object);

  T create(T object);

  void delete(String id);

  List<T> getAll();
}
