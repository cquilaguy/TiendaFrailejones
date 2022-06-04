package tiendafrailejones.modelo;

import java.math.BigDecimal;


public class Deuda {
    private Integer id;
    private Integer idCliente;
    private BigDecimal todalDeuda;
    private String fecha;
    private String descripcion;
    private BigDecimal abonoDeuda;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public BigDecimal getTodalDeuda() {
        return todalDeuda;
    }

    public void setTodalDeuda(BigDecimal todalDeuda) {
        this.todalDeuda = todalDeuda;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getAbonoDeuda() {
        return abonoDeuda;
    }

    public void setAbonoDeuda(BigDecimal abonoDeuda) {
        this.abonoDeuda = abonoDeuda;
    }
    
    
}
