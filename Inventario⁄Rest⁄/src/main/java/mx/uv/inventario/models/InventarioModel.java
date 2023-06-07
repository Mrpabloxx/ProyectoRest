package mx.uv.inventario.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventario")
public class InventarioModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Integer id;
    private String nombre;
    private String cantidad;
    private Integer total;
    private String  folio;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFolio() {
        return nombre;
    }
    public void setFolio(String folio) {
        this.folio = folio;
    }
    public String getCantidad() {
        return cantidad;
    }
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }

}
