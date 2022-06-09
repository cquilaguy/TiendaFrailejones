package tiendafrailejones.modelo;

import java.math.BigDecimal;

public class Cliente extends Persona {

    private BigDecimal deuda;
    private String metodoPago;
    private String direccion;
    private String permitirDeuda;

    public BigDecimal getDeuda() {
        return deuda;
    }

    public void setDeuda(BigDecimal deuda) {
        this.deuda = deuda;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPermitirDeuda() {
        return permitirDeuda;
    }

    public void setPermitirDeuda(String permitirDeuda) {
        this.permitirDeuda = permitirDeuda;
    }

}
