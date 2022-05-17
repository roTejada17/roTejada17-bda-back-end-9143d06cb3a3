package com.folcamp.bancoDeAlimentos.repository;

import com.folcamp.bancoDeAlimentos.entity.Organizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizacionRepository extends JpaRepository<Organizacion, Integer> {
    Optional<Organizacion> findByName(String name);
    boolean existsByName(String name);


    Optional<Organizacion> findById(Integer id);

}
