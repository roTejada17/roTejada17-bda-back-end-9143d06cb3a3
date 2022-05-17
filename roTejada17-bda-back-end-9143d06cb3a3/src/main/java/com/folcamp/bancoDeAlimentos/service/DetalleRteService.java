package com.folcamp.bancoDeAlimentos.service;

import com.folcamp.bancoDeAlimentos.dto.DetalleRteDto;
import com.folcamp.bancoDeAlimentos.dto.Mensaje;
import com.folcamp.bancoDeAlimentos.entity.DetalleRte;
import com.folcamp.bancoDeAlimentos.entity.Reporte;
import com.folcamp.bancoDeAlimentos.entity.Stock;
import com.folcamp.bancoDeAlimentos.mappers.DetalleRteMapper;
import com.folcamp.bancoDeAlimentos.repository.DetalleRteRepository;
import com.folcamp.bancoDeAlimentos.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class DetalleRteService {

    @Autowired
    DetalleRteRepository detalleRteRepository;

    @Autowired
    DetalleRteMapper detalleRteMapper;

    @Autowired
    StockRepository stockRepository;

    //@Autowired
    //DetalleRte detalleRte;


    public List<DetalleRte> getAll() {
        return detalleRteRepository.findAll();
    }

    public Optional<DetalleRte> getById(Integer id) {
        return detalleRteRepository.findById(id);
    }

    public boolean existsById(Integer id) {
        return detalleRteRepository.existsById(id);
    }

    public void save(DetalleRte detalleRte) {
        detalleRteRepository.save(detalleRte);
        boolean encontrado = false;
        if (stockRepository.existsByProducto(detalleRte.getProducto())) {
            List<Stock> stocks = stockRepository.findByProducto(detalleRte.getProducto());

            for (Stock st :
                    stocks) {
                if (!encontrado && YearMonth.from(LocalDate.parse(detalleRte.getFechaDeVencimiento()))
                        .equals(st.getFechaDeVencimiento())) {
                    st.setTotalKilos(st.getTotalKilos() + detalleRte.getTotalKilos());
                    encontrado = true;
                    stockRepository.save(st);
                }
            }
        }
        if (!encontrado)
            stockRepository.save(new Stock(
                    null, detalleRte.getProducto(),
                    detalleRte.getFechaDeVencimiento(),
                    detalleRte.getTotalKilos()
            ));
    }

    public void delete(DetalleRte detalleRte) {
        boolean encontrado = false;
        if (stockRepository.existsByProducto(detalleRte.getProducto())) {
            List<Stock> stocks = stockRepository.findByProducto(detalleRte.getProducto());

            for (Stock st :
                    stocks) {
                if (!encontrado && YearMonth.from(LocalDate.parse(detalleRte.getFechaDeVencimiento()))
                        .equals(st.getFechaDeVencimiento())) {
                    st.setTotalKilos(st.getTotalKilos() - detalleRte.getTotalKilos());
                    encontrado = true;
                    stockRepository.save(st);
                }
            }
        }
        detalleRteRepository.delete(detalleRte);
    }


    public List<DetalleRteDto> listByReporteId(Reporte reporte){
        return detalleRteRepository.findByReporte(reporte)
                .stream()
                .map(detalleRteMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public ResponseEntity update(DetalleRte nuevo, Integer id) {
        if (!detalleRteRepository.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        nuevo.setId(id);
        return ResponseEntity.ok(detalleRteRepository.save(nuevo));
    }
}
