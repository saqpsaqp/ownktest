package com.ownk.practical.backend.controller;

import com.ownk.practical.backend.mapper.VendedorMapper;
import com.ownk.practical.backend.model.Vendedor;
import java.awt.PageAttributes;
import java.util.Collection;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendedorController {
    
    private VendedorMapper vendedorMapper;

    public VendedorController(VendedorMapper vendedorMapper) {
        this.vendedorMapper = vendedorMapper;
    }
        
    @RequestMapping(value = "/api/vendedor/all",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vendedor> getVendedor(){
        return vendedorMapper.getAll();
    }
    
}
