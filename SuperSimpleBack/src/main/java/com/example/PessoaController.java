/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author guilherme.moura
 */

@RestController
@RequestMapping("/pessoa")
@CrossOrigin(origins = "http://localhost:3000")
public class PessoaController {
    
    private final PessoaService service;
    
    @Autowired
    public PessoaController(PessoaService service){
            this.service = service;
    }
    
    @RequestMapping(value = "/listarTodos", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity list(Model model, @RequestHeader HttpHeaders httpHeaders) {
        List<Pessoa> listaObjetos = (List<Pessoa>) service.pegarTudo();
        return new ResponseEntity(listaObjetos.toArray(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/salvar", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity save(@RequestBody Pessoa pessoa) {
        Pessoa p = service.salvar(pessoa);
        return new ResponseEntity(p, HttpStatus.OK);
    }
    
    
}
