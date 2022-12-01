package com.example.superkassa_task.controller;

import com.example.superkassa_task.entity.CurrentIncrementator;
import com.example.superkassa_task.entity.Current;
import com.example.superkassa_task.entity.Entity;
import com.example.superkassa_task.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/example")
public class EntityController {

    private final EntityService entityService;

    @Autowired
    public EntityController(EntityService entityService) {
        this.entityService = entityService;
    }

    @GetMapping("/{id}")
    public Entity findEntity(@PathVariable int id) {
        return entityService.findEntity(id);
    }

    @PostMapping("/modify")
    public Current add(@RequestBody CurrentIncrementator currentIncrementator) {
        return entityService.add(currentIncrementator);
    }
}
