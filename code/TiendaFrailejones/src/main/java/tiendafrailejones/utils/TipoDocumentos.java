package tiendafrailejones.utils;

public enum TipoDocumentos {
    CEDULA_CIUDADANIA("CÉDULA", "CC"),
    CEDULA_DE_EXTRANJERIA("CÉDULA DE EXTRANJERÍA", "CE"), 
    PASAPORTE("PASAPORTE", "PAS");
    
    private final String nombreDocumento;
    private final String acronimoDocumento;

    private TipoDocumentos(String nombreDocumento, String acronimoDocumento) {
        this.nombreDocumento = nombreDocumento;
        this.acronimoDocumento = acronimoDocumento;
    }

    public static String getById(String nombreDoc){
        for (TipoDocumentos tipoDocumento : values()) {
            if (tipoDocumento.nombreDocumento.equalsIgnoreCase(nombreDoc)) {
                return tipoDocumento.getAcronimoDocumento();
            }
        }
        throw new IllegalArgumentException("No existe documento: " + nombreDoc);
    }

    public String getAcronimoDocumento() {
        return acronimoDocumento;
    }
    

    
    
}
