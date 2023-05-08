package basededatos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    
    //Comentario para cargar segundo commit
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, ClassNotFoundException {
        
        RegistroUsuario user1 = new RegistroUsuario(1, "John", "Doe", "12345A", "johnnymelabo@gmail.com", 15);
        RegistroUsuario user2 = new RegistroUsuario(2, "Susana", "Horia", "45321B", "Susanahoria@gmail.com", 21);
        RegistroUsuario user3 = new RegistroUsuario(3, "Aquiles", "Canto", "5458985C", "aquiles1234@gmail.com", 25);
        RegistroUsuario user4 = new RegistroUsuario(4, "Aitor", "Menta", "665452Z", "aitormentafuerte@gmail.com", 27);
        RegistroUsuario user5 = new RegistroUsuario(5, "Oscar", "Nivoro", "112542Z", "oscarnivoro@gmail.com", 54);

        /*TablaUsuario.insertarUsuario(user1, "users.dat");
            RegistroUsuario[] aRegistroUsuario = {user2, user3, user4, user5};
            TablaUsuario.insertarUsuario(aRegistroUsuario, "tablausuarios.dat");*/
        RegistroUsuario[] aUsuarios = TablaUsuario.leerRegistroUsuario("tablausuarios.dat");
        System.out.println(Arrays.toString(aUsuarios));
        //RegistroUsuario[] arrayEncontrados = TablaUsuario.busquedaUsuario("tablausuarios.dat", "Aitor");
        //System.out.println(Arrays.toString(arrayEncontrados));
    }
}
