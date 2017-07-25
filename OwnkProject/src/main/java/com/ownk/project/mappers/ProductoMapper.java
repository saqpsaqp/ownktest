package com.ownk.project.mappers;


import com.ownk.project.models.Producto;
import com.ownk.project.models.Vendedor;
import java.util.List;
import javax.websocket.server.PathParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

@Mapper
public interface ProductoMapper {

    @Select("SELECT * FROM Producto")
    public List<Producto> getAll();
    
    @Select("SELECT idProd,codigo,descripcion,idVend FROM Producto where idProd=#{id}")
    @Results(value = {
        @Result(property = "idProd", column = "idProd"),
        @Result(property = "codigo", column = "codigo"),
        @Result(property = "descripcion", column = "descripcion"),
        @Result(property = "vendedor", column = "idVend", one=@One(select = "getVendedor"))
    })
    public Producto getById(@PathParam("id") final Integer id);
    
    @Select("SELECT idVend, nombres, apellidos, cedula FROM Vendedor WHERE idVend = #{id}")
    @Results(value = {
        @Result(property = "idVend", column = "idVend"),
        @Result(property = "nombres", column = "nombres"),
        @Result(property = "apellidos", column = "apellidos"),
        @Result(property = "cedula", column = "cedula")
    })
    public Vendedor getVendedor(Integer id);

    @Insert("insert into Producto(codigo,descripcion,idVend) values (#{codigo},#{descripcion},#{idVend})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "idProd",
            before = false, resultType = Integer.class)
    public void insert(Producto producto);
  
}
