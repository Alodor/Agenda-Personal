package Controllers;

public class cContacto {
    
    private int id_contacto;
    private String nombre;
    private String apellido;
    private String alias;
    private String telefono1;
    private String telefono2;
    private String email1;
    private String email2;
    private String grupo;

    public cContacto() {
    }

    public cContacto(int id_contacto, String nombre, String apellido, String alias, String telefono1, String telefono2, String email1, String email2, String grupo) {
        this.id_contacto = id_contacto;
        this.nombre = nombre;
        this.apellido = apellido;
        this.alias = alias;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.email1 = email1;
        this.email2 = email2;
        this.grupo = grupo;
    }

    public int getId_contacto() {
        return id_contacto;
    }

    public void setId_contacto(int id_contacto) {
        this.id_contacto = id_contacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
}