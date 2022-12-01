package com.example.superkassa_task.service;

import com.example.superkassa_task.entity.CurrentIncrementator;
import com.example.superkassa_task.entity.Current;
import com.example.superkassa_task.entity.Entity;
import com.example.superkassa_task.exception.EntityNotFoundException;
import com.example.superkassa_task.repository.EntityRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class EntityService {

    EntityRepository entityRepository;

    @Autowired
    public EntityService(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    public Entity findEntity(int id) {
        return entityRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public Current add(@Valid CurrentIncrementator currentIncrementator) {
        Entity entity = entityRepository.findById(currentIncrementator.getId()).orElseThrow(EntityNotFoundException::new);
        Current current = new Current(entity.getObj().getCurrent() + currentIncrementator.getAdd());
        entity.setObj(current);
        return entityRepository.save(entity).getObj();
    }
}
