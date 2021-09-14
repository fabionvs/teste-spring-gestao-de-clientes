package com.teste.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.entity.Clientes;
import com.teste.entity.Email;
import com.teste.entity.Telefone;

public interface EmailRepository extends JpaRepository<Email, Long> {
  List<Email> findById(int id);

}