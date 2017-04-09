package ec.facturar;

public class CertAlias {
    private String alias;
    private String nombre;

    public CertAlias(String alias, String nombre) {
        this.alias = alias;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String getAlias() {
        return alias;
    }

    public String getNombre() {
        return nombre;
    }
}
