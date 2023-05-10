package ResultadoAngel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResultadoAngel {

    private final String nombreTabla;
    private RegistroUsuario[] aRegistroUsuario;

    public TablaUsuario(String nombreTabla) throws IOException, ClassNotFoundException {
        RegistroUsuario[] aRegistroUsuario;
        Path path = Paths.get(nombreTabla);
        if (!(new File(nombreTabla).exists()) || Files.size(path) == 0) {
            aRegistroUsuario = new RegistroUsuario[0];
        } else {
            ObjectInputStream descriptorLectura = new ObjectInputStream(new FileInputStream(nombreTabla));
            aRegistroUsuario = (RegistroUsuario[]) descriptorLectura.readObject();
            descriptorLectura.close();
        }
        this.nombreTabla = nombreTabla;
        this.aRegistroUsuario = aRegistroUsuario;
    }

    //Pasa a memoria lo que hay en el fichero
    public void insertarUsuario(RegistroUsuario registroUsuario) throws FileNotFoundException, IOException, ClassNotFoundException {
        RegistroUsuario[] aRegistroUsurario = {registroUsuario};
        insertarUsuario(aRegistroUsurario);
    }

    //Instancia la tabla si solo hay un elemento, por eso devuelve un objeto de tipo TablaUsuario
    public static TablaUsuario insertarUsuario(String nombreTabla, RegistroUsuario registroUsuario) throws FileNotFoundException, IOException, ClassNotFoundException {
        TablaUsuario tablaUsuario = new TablaUsuario(nombreTabla);
        tablaUsuario.insertarUsuario(registroUsuario);
        return tablaUsuario;
    }

    //Instancia la tabla si hay varios elementos, por eso devuelve un objeto de tipo TablaUsuario
    public static TablaUsuario insertarUsuario(String nombreTabla, RegistroUsuario[] aRegistroUsuario) throws FileNotFoundException, IOException, ClassNotFoundException {
        TablaUsuario tablaUsuario = new TablaUsuario(nombreTabla);
        tablaUsuario.insertarUsuario(aRegistroUsuario);
        return tablaUsuario;
    }

    //Copia el registro del constructor y el registro nuevo en un registro final
    public void insertarUsuario(RegistroUsuario[] aRegistroUsuario) throws FileNotFoundException, IOException, ClassNotFoundException {
        RegistroUsuario[] aRegistroUsuarioFinal = new RegistroUsuario[this.aRegistroUsuario.length + aRegistroUsuario.length];
        int indice = 0;
        for (int i = 0; i < this.aRegistroUsuario.length; i++) {
            aRegistroUsuarioFinal[indice] = this.aRegistroUsuario[i];
            indice++;
        }
        for (int i = 0; i < aRegistroUsuario.length; i++) {
            aRegistroUsuarioFinal[indice] = aRegistroUsuario[i];
            indice++;
        }
        FileOutputStream fos = new FileOutputStream(nombreTabla, false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(aRegistroUsuarioFinal);
        oos.close();
        this.aRegistroUsuario = aRegistroUsuarioFinal;
    }

}
