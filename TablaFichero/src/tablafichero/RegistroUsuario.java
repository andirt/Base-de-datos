package tablafichero;

import java.io.Serializable;

public class RegistroUsuario implements Serializable {
    private int id;
    private String nombre;
    private String primerApellido;
    private String dni;
    private String telefono;
    private String email;
    private int edad;

    public RegistroUsuario(int id, String nombre, String primerApellido, String dni, String telefono, String email, int edad) {
        this.id=id;
        this.nombre=nombre;
        this.primerApellido=primerApellido;
        this.dni=dni;
        this.telefono=telefono;
        this.email=email;
        this.edad=edad;
    }
    
    public String devolverNombre() {
        return this.nombre;
    }
}