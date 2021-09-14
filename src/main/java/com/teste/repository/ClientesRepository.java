package com.teste.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.entity.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {
  List<Clientes> findById(int id);

}