package com.folcamp.bancoDeAlimentos.repository;

import com.folcamp.bancoDeAlimentos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    Optional<Producto> findByName(String name);
    boolean existsByName(String name);


    Optional<Producto> findById(int id);
}
