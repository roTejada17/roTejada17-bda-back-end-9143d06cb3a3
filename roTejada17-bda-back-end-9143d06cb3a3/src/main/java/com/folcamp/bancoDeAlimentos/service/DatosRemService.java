package com.folcamp.bancoDeAlimentos.service;

import com.folcamp.bancoDeAlimentos.dto.DatosRemDto;
import com.folcamp.bancoDeAlimentos.dto.Mensaje;
import com.folcamp.bancoDeAlimentos.entity.*;
import com.folcamp.bancoDeAlimentos.mappers.DatosRemMapper;
import com.folcamp.bancoDeAlimentos.repository.DatosRemRepository;
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
public class DatosRemService {

    @Autowired
    DatosRemRepository datosRemRepository;

    @Autowired
    DatosRemMapper datosRemMapper;

    @Autowired
    StockRepository stockRepository;
    
    //@Autowired
    //DatosRem datosRem;

    public List<DatosRem> getAll() {
        return datosRemRepository.findAll();
    }

    public Optional<DatosRem> getById(Integer id) {
        return datosRemRepository.findById(id);
    }

    public boolean existsById(Integer id) {
        return datosRemRepository.existsById(id);
    }

    public void save(DatosRem datosRem) {
        datosRemRepository.save(datosRem);
        boolean encontrado = false;
        if (stockRepository.existsByProducto(datosRem.getProducto())) {
            List<Stock> stocks = stockRepository.findByProducto(datosRem.getProducto());

            for (Stock st :
                    stocks) {
                if (!encontrado && YearMonth.from(LocalDate.parse(datosRem.getFechaDeVencimiento()))
                        .equals(st.getFechaDeVencimiento())) {
                    st.setTotalKilos(st.getTotalKilos() - datosRem.getKilosDonados());
                    encontrado = true;
                    stockRepository.save(st);
                }
            }
        }
    }

    public void delete(DatosRem datosRem) {
        boolean encontrado = false;
        if (stockRepository.existsByProducto(datosRem.getProducto())) {
            List<Stock> stocks = stockRepository.findByProducto(datosRem.getProducto());

            for (Stock st :
                    stocks) {
                if (!encontrado && YearMonth.from(LocalDate.parse(datosRem.getFechaDeVencimiento()))
                        .equals(st.getFechaDeVencimiento())) {
                    st.setTotalKilos(st.getTotalKilos() + datosRem.getKilosDonados());
                    encontrado = true;
                    stockRepository.save(st);
                }
            }
        }
        datosRemRepository.delete(datosRem);
    }

    public List<DatosRemDto> listByRemitoId(Remito remito){
        return datosRemRepository.findByRemito(remito)
                .stream()
                .map(datosRemMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public ResponseEntity update(DatosRem nuevo, Integer id) {
        if (!datosRemRepository.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        nuevo.setId(id);
        return ResponseEntity.ok(datosRemRepository.save(nuevo));
    }
}
