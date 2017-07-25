package com.ownk.project.controllers;

import com.ownk.project.mappers.VendedorMapper;
import com.ownk.project.models.Vendedor;
import java.awt.PageAttributes;
import java.util.Collection;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/vendedor",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
public class VendedorController {
    
    private VendedorMapper vendedorMapper;

    public VendedorController(VendedorMapper vendedorMapper) {
        this.vendedorMapper = vendedorMapper;
    }
        
    @GetMapping("/")
    public List<Vendedor> getVendedor(){
        return vendedorMapper.getAll();
    }
    
    @GetMapping("/{id}")    
    public Vendedor getVendedorById(@PathVariable("id") int id){
        return vendedorMapper.getById(id);
    }
    
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public List<Vendedor> addPost(@RequestBody Vendedor vendedor){
        vendedorMapper.insert(vendedor);
        return vendedorMapper.getAll();
    }
}