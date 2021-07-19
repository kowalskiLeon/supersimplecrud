/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author guilherme.moura
 */

@Service
public class PessoaService {
    
    private final PessoaRepository repositorio;

    @Autowired
    public PessoaService(PessoaRepository repositorio) {
        this.repositorio = repositorio;
    }
    
    
    public List<Pessoa> pegarTudo(){
        return repositorio.findAll();
    }
    
    public Pessoa salvar(Pessoa p){
        return repositorio.save(p);
    }
    
    
    
}
