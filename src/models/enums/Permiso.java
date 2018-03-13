package models.enums;


public enum Permiso {

    CAJERO("cajero"),
    ADMINISTRADOR("administrador");
    
    private String descripcion;

    private Permiso(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    private Permiso() {
    }

    
    
}
