package com.geous.cursouml.service;

import com.geous.cursouml.domain.Categoria;
import com.geous.cursouml.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria BuscarCategoriaPorId(Integer id){
        return categoriaRepository.findById(id).orElse(null);
    }
}
