package com.ownk.practical.backend.mapper;

import com.ownk.practical.backend.model.Vendedor;
import java.util.List;
import javax.websocket.server.PathParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

@Mapper
public interface VendedorMapper {

    @Select("select * from Vendedor")
    public List<Vendedor> getAll();
    
    @Select("select * from Vendedor where idVend=#{id}")
    public List<Vendedor> getById(@PathParam("id") final Integer id);

    @Insert("insert into Vendedor(nombres,apellidos,cedula) values (#{nombres},#{apellidos},#{cedula})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "idVend",
            before = false, resultType = Integer.class)
    public void insert(Vendedor vendedor);
  
}
