package mx.uv.inventario.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.uv.inventario.models.InventarioModel;

@Repository
public interface InventarioRepository extends CrudRepository<InventarioModel, Integer> {


    public abstract ArrayList <InventarioModel> findByNombre(String nombre);
    
    public abstract ArrayList <InventarioModel> findByFolio(String folio);

    public abstract ArrayList <InventarioModel> findByCantidad(Integer cantidad);

    public abstract ArrayList<InventarioModel> findByTotal(String total);
}
