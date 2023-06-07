package mx.uv.inventario.services;

import java.util.ArrayList;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import mx.uv.inventario.models.InventarioModel;
import mx.uv.inventario.repositories.InventarioRepository;

@Service
public class InventarioService {

    @Autowired
    InventarioRepository inventarioRepository;

    public ArrayList<InventarioModel> obtenerInventario() {
        return (ArrayList<InventarioModel>) inventarioRepository.findAll();
    }

    public InventarioModel guardarInventario(InventarioModel inventario) {
        return inventarioRepository.save(inventario);
    }



    
    public InventarioModel modificarInventario(InventarioModel inventario) {
        // fetch the existing product by id
        InventarioModel existingInventario = inventarioRepository.findById(inventario.getId()).orElse(null);
        
        if (existingInventario != null) {
            // update the existing product with the new values
            existingInventario.setNombre(inventario.getNombre());
            existingInventario.setNombre(inventario.getFolio());
            existingInventario.setTotal(inventario.getTotal());
            existingInventario.setCantidad(inventario.getCantidad());
            
            // save the updated product to the database
            return inventarioRepository.save(existingInventario);
        }
        
        return null;
    }

    public Optional<InventarioModel> obtenerPorId(Integer id) {
        return inventarioRepository.findById(id);
    }

    public ArrayList<InventarioModel> obtenerPorNombre(String nombre) {
        return inventarioRepository.findByNombre(nombre);
    }

    public ArrayList<InventarioModel> obtenerPorFolio(String folio) {
        return inventarioRepository.findByFolio(folio);
    }

    public ArrayList<InventarioModel> obtenerPorTotal(String total) {
        return inventarioRepository.findByTotal(total);
    }

    public ArrayList<InventarioModel> obtenerPorCantidad(Integer cantidad) {
        return inventarioRepository.findByCantidad(cantidad);
    }

    public boolean eliminarInventario(Integer id) {
        try {
            inventarioRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }



}
