package com.ownk.practical.backend.controller;

import com.ownk.practical.backend.mapper.ProductoMapper;
import com.ownk.practical.backend.model.Producto;
import java.awt.PageAttributes;
import java.util.Collection;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/producto/",
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
    public List<Producto> getProductoById(@PathVariable("id") int id){
        return productoMapper.getById(id);
    }
    
    /*@GetMapping("/add/{codigo}/{descripcion}/{imagen}")
    public List<Producto> add(  @PathVariable("codigo") String codigo,
                                @PathVariable("descripcion") String descripcion,
                                @PathVariable("imagen") String imagen){
        Producto producto = new Producto();
        producto.setCodigo(codigo);
        producto.setDescripcion(descripcion);
        producto.setImagen(imagen);
        productoMapper.insert(producto);
        return productoMapper.getAll();
    }*/
    @RequestMapping(value = "/add/",method = RequestMethod.POST)
    public List<Producto> add(@RequestBody Producto producto){
        productoMapper.insert(producto);
        return productoMapper.getAll();
    }    
    
    
}
