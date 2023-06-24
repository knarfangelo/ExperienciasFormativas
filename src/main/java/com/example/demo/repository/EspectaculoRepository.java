package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Espectaculo;

public interface EspectaculoRepository extends CrudRepository<Espectaculo, String> {
}
