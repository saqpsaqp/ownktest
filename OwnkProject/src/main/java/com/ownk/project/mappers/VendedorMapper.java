package com.ownk.project.mappers;

import com.ownk.project.models.Producto;
import com.ownk.project.models.Vendedor;
import java.util.List;
import javax.websocket.server.PathParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

@Mapper
public interface VendedorMapper {

    @Select("SELECT * FROM Vendedor")
    public List<Vendedor> getAll();

    @Select("SELECT * FROM Vendedor WHERE idVend=#{id}")
    @Results(value = {
        @Result(property = "idVend", column = "idVend"),
        @Result(property = "nombres", column = "nombres"),
        @Result(property = "apellidos", column = "apellidos"),
        @Result(property = "cedula", column = "cedula"),
        @Result(property = "productos", javaType = List.class, 
                column = "idVend", many = @Many(select = "getProductos"))
    })
    public Vendedor getById(@PathParam("id") final Integer id);

    @Select("SELECT idProd, codigo, descripcion FROM Producto WHERE idVend = #{id}")
    @Results(value = {
        @Result(property = "idProd", column = "idProd"),
        @Result(property = "codigo", column = "codigo"),
        @Result(property = "descripcion", column = "descripcion")
    })
    public List<Producto> getProductos(Integer id);

    @Insert("insert into Vendedor(nombres,apellidos,cedula) values (#{nombres},#{apellidos},#{cedula})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "idVend",
            before = false, resultType = Integer.class)
    public void insert(Vendedor vendedor);

    @Delete("delete from Vendedor where idVend=#{id}")
    public void delete(int id);

}
