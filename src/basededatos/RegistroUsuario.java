package basededatos;

import java.io.Serializable;

public class RegistroUsuario implements Serializable {

    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private String correo;
    private int edad;

    public RegistroUsuario(int id, String nombre, String apellido, String dni, String correo, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.edad = edad;
    } 

    public String getNombre() {
        return this.nombre;
    }
    
}
