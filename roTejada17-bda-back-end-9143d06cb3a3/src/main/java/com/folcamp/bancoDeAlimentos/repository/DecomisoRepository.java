package com.folcamp.bancoDeAlimentos.repository;

import com.folcamp.bancoDeAlimentos.entity.Decomiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DecomisoRepository extends JpaRepository<Decomiso, Integer> {
    @Override
    Optional<Decomiso> findById(Integer integer);
}
