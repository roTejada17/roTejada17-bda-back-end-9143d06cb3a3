package com.folcamp.bancoDeAlimentos.repository;


import com.folcamp.bancoDeAlimentos.entity.Complementario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComplementarioRepository extends JpaRepository<Complementario,Integer> {
Optional<Complementario> findById(Integer id);



}
