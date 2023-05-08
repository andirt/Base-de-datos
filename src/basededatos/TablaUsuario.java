package basededatos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TablaUsuario implements Serializable {

    public static void insertarUsuario(RegistroUsuario usuario, String nombreFichero) throws FileNotFoundException, IOException {
        ObjectOutputStream flujoEscrituraBin;
        flujoEscrituraBin = new ObjectOutputStream(new FileOutputStream(nombreFichero, true));
        flujoEscrituraBin.writeObject(usuario);
        flujoEscrituraBin.close();
    }

    public static void insertarUsuario(RegistroUsuario[] aUsuario, String nombreFichero) throws FileNotFoundException, IOException {
        for (int i = 0; i < aUsuario.length; i++) {
            insertarUsuario(aUsuario[i], nombreFichero);
        }

    }

    public static RegistroUsuario[] leerRegistroUsuario(String nombreFichero) throws FileNotFoundException, IOException, ClassNotFoundException {
        int contadorobjetos = 0;
        ObjectInputStream flujoLecturaBin;
        RegistroUsuario usuario;
        flujoLecturaBin = new ObjectInputStream(new FileInputStream(nombreFichero));
        do {
            usuario = (RegistroUsuario) flujoLecturaBin.readObject();
                contadorobjetos++;
        } while (usuario != null);
        flujoLecturaBin.close();
        
        RegistroUsuario[] aUsuarios = new RegistroUsuario[contadorobjetos];
        flujoLecturaBin = new ObjectInputStream(new FileInputStream(nombreFichero));
        for (int i = 0; i < contadorobjetos; i++) {
            aUsuarios[i] = (RegistroUsuario) flujoLecturaBin.readObject();
        }
        flujoLecturaBin.close();
        return aUsuarios;
    }

    public static RegistroUsuario[] busquedaUsuario(String nombreFichero, String nombreUsuario) throws IOException, FileNotFoundException, ClassNotFoundException {
        RegistroUsuario[] aUsuarios = leerRegistroUsuario(nombreFichero);
        int contador = 0;
        if (aUsuarios.length == 0) {
            return aUsuarios;
        }

        for (int i = 0; i < aUsuarios.length; i++) {
            if (nombreUsuario == aUsuarios[i].getNombre()) {
                contador++;
            }
        }

        RegistroUsuario[] usuariosEncontrados = new RegistroUsuario[contador];
        int aux = 0;
        for (int i = 0; i < aUsuarios.length; i++) {
            if (nombreUsuario == aUsuarios[i].getNombre()) {
                usuariosEncontrados[aux] = aUsuarios[i];
                aux++;
            }
        }
        return usuariosEncontrados;
    }
}
