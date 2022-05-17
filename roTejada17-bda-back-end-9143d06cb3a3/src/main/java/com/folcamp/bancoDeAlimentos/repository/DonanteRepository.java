package com.folcamp.bancoDeAlimentos.repository;

import com.folcamp.bancoDeAlimentos.entity.Donante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonanteRepository extends JpaRepository<Donante, Long> {
}
