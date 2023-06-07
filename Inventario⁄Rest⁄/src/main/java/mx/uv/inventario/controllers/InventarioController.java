package mx.uv.inventario.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.uv.inventario.models.InventarioModel;
import mx.uv.inventario.services.InventarioService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/inventario")
public class InventarioController {
    
    @Autowired
    InventarioService invetarioServicio;

    @GetMapping()
    public ArrayList<InventarioModel> obtenerInventario(){
        return invetarioServicio.obtenerInventario();
    }

    @PostMapping()
    public InventarioModel guardarInventario(@RequestBody InventarioModel inventario){
        return this.invetarioServicio.guardarInventario(inventario);
    }

    @PutMapping("update")
    public InventarioModel modificarInventario(@RequestBody InventarioModel request){
        return this.invetarioServicio.modificarInventario(request);
    }

    @GetMapping(path = "/{id}")
    public Optional<InventarioModel> obtenerInventarioPorId(@PathVariable("id") Integer id){
        return this.invetarioServicio.obtenerPorId(id);
    }

    @GetMapping("/querynombre")
    public ArrayList<InventarioModel> obtenerInventarioPorNombre(@RequestParam("nombre") String nombre){
        return this.invetarioServicio.obtenerPorNombre(nombre);
    }

    @GetMapping("/queryfolio")
    public ArrayList<InventarioModel> obtenerInventarioPorFolio(@RequestParam("folio") String folio){
        return this.invetarioServicio.obtenerPorFolio(folio);
    }

    @GetMapping("/querytotal")
    public ArrayList<InventarioModel> obtenerInventarioPorTotal(@RequestParam("total") String total){
        return this.invetarioServicio.obtenerPorTotal(total);
    }

    @GetMapping("/querycantidad")
    public ArrayList<InventarioModel> obtenerInventarioPorCantidad(@RequestParam("cantidad") Integer cantidad){
        return this.invetarioServicio.obtenerPorCantidad(cantidad);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Integer id){
        boolean ok = this.invetarioServicio.eliminarInventario(id);
        if(ok){
            return "Se elimino del inventa con id " + id;
        } else {
            return "No se pudo eliminar del producto con id " + id;
        }
    }
}
