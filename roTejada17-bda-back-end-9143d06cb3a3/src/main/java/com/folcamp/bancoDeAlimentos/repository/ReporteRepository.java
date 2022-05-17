package com.folcamp.bancoDeAlimentos.repository;

import com.folcamp.bancoDeAlimentos.entity.DetalleRte;
import com.folcamp.bancoDeAlimentos.entity.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReporteRepository extends JpaRepository<Reporte, Integer> {
    Optional<Reporte> findById(Integer id);

    Optional<DetalleRte> findDetallesById(Integer id);
}
