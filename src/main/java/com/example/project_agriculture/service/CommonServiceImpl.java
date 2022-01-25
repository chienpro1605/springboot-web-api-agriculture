package com.example.project_agriculture.service;

import com.example.project_agriculture.constant.ErrorCode;
import com.example.project_agriculture.entity.AbstractEntity;
import com.example.project_agriculture.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class CommonServiceImpl<E extends AbstractEntity, R extends JpaRepository<E, String>> implements CommonService<E> {
    @Autowired
    protected R repository;

    @Override
    public E addEntity(E entity) {
        return repository.save(entity);
    }

    @Override
    public E updateEntity(E entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteEntityById(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<E> getEntities() {
        return repository.findAll();
    }

    @Override
    public E findEntityById(String id) {
        Optional<E> entityOptional = repository.findById(id);
        if (!entityOptional.isPresent()) {
            throw new ApplicationException(ErrorCode.ID_NOT_EXISTS.getValue());
        }
        return entityOptional.get();
    }

    @Override
    public List<E> saveAll(List<E> entities) {
        return repository.saveAll(entities);
    }
}
