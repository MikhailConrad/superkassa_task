package com.example.superkassa_task.repository;

import com.example.superkassa_task.entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntityRepository extends JpaRepository<Entity, Integer> {

    Optional<Entity> findById(int id);

    Entity save(Entity entity);

}
