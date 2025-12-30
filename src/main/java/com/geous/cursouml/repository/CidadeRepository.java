package com.geous.cursouml.repository;

import com.geous.cursouml.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository  extends JpaRepository<Cidade, Integer> {
}
