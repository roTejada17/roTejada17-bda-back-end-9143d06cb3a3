package com.folcamp.bancoDeAlimentos.repository;

import com.folcamp.bancoDeAlimentos.entity.DetalleRte;
import com.folcamp.bancoDeAlimentos.entity.Producto;
import com.folcamp.bancoDeAlimentos.entity.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetalleRteRepository extends JpaRepository<DetalleRte, Integer> {
    Optional<DetalleRte> findById(Integer id);

    List<DetalleRte> findByReporte(Reporte reporte);

    boolean deleteById(Producto producto);
}
