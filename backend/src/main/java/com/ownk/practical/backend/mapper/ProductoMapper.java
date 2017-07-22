package com.ownk.practical.backend.mapper;

import com.ownk.practical.backend.model.Producto;
import java.util.List;
import javax.websocket.server.PathParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

@Mapper
public interface ProductoMapper {

    @Select("select * from Producto")
    public List<Producto> getAll();
    
    @Select("select * from Producto where idProd=#{id}")
    public List<Producto> getById(@PathParam("id") final Integer id);

    @Insert("insert into Producto(codigo,descripcion,imagen) values (#{codigo},#{descripcion},#{imagen})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "idProd",
            before = false, resultType = Integer.class)
    public void insert(Producto producto);
  
}
