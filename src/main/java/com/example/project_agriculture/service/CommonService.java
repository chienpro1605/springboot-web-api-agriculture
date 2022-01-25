package com.example.project_agriculture.service;

import com.example.project_agriculture.entity.AbstractEntity;

import java.util.List;

public interface CommonService<E extends AbstractEntity> {
    E addEntity(E entity);
    E updateEntity(E entity);
    void deleteEntityById(String id);
    List<E> getEntities();
    E findEntityById(String id);
    List<E> saveAll(List<E> entities);
}
