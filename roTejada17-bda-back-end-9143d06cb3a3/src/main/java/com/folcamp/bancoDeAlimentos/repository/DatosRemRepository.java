package com.folcamp.bancoDeAlimentos.repository;

import com.folcamp.bancoDeAlimentos.entity.DatosRem;
import com.folcamp.bancoDeAlimentos.entity.Remito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DatosRemRepository extends JpaRepository<DatosRem, Integer> {
    @Override
    Optional<DatosRem> findById(Integer id);

    List<DatosRem> findByRemito(Remito remito);
}
