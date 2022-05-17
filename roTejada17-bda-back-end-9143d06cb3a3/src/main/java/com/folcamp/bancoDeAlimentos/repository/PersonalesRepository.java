package com.folcamp.bancoDeAlimentos.repository;

import com.folcamp.bancoDeAlimentos.entity.Personales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonalesRepository extends JpaRepository<Personales, Integer> {

    boolean existsByName(String name);
    Optional<Personales> findById(Integer id);

}
