package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Boleto;

public interface BoletoRepository extends CrudRepository<Boleto, String> {
}
