package tablafichero;

import java.io.FileNotFoundException;
import java.io.IOException;
// https://www.geeksforgeeks.org/how-to-fix-java-io-streamcorruptedexception-invalid-type-code-in-java/

public class Main {
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        RegistroUsuario user1=new RegistroUsuario(1, "N1", "R1", "12345671", "6543211", "aR1@mail.es", 21);
        RegistroUsuario user2=new RegistroUsuario(2, "N2", "R2", "12345672", "6543212", "aR2@mail.es", 22);
        RegistroUsuario user3=new RegistroUsuario(3, "N3", "R3", "12345673", "6543213", "aR3@mail.es", 23);
        RegistroUsuario user4=new RegistroUsuario(4, "N4", "R4", "12345674", "6543214", "aR4@mail.es", 24);
        RegistroUsuario user5=new RegistroUsuario(5, "N5", "R5", "12345675", "6543215", "aR5@mail.es", 25);
        RegistroUsuario user6=new RegistroUsuario(7, "N6", "R6", "12345676", "6543216", "aR6@mail.es", 26);
        
        //TablaUsuario tablaUsuario = TablaUsuario.insertarUsuario("tabla.dat", user1);
        
        //RegistroUsuario[] aRegistroUsuario = {user2, user3, user4, user5, user6};
        //TablaUsuario tablaUsuario=TablaUsuario.insertarUsuario("tabla.dat", aRegistroUsuario);
        
        TablaUsuario tablausuario = new TablaUsuario("tabla.dat");
        System.out.println(tablausuario);
    }    
}
