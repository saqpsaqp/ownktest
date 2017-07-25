package com.ownk.project.controllers;

import com.ownk.project.mappers.ProductoMapper;
import com.ownk.project.models.Producto;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/producto",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductoController {
    
    private ProductoMapper productoMapper;

    public ProductoController(ProductoMapper productoMapper) {
        this.productoMapper = productoMapper;
    }
        
    @GetMapping("/")
    public List<Producto> getProducto(){
        return productoMapper.getAll();
    }
    
    @GetMapping("/{id}")    
    public Producto getProductoById(@PathVariable("id") int id){
        return productoMapper.getById(id);
    }
    
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public List<Producto> add(@RequestBody Producto producto){
        productoMapper.insert(producto);
        return productoMapper.getAll();
    }      
}