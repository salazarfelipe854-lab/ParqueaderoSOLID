import java.util.ArrayList;
import java.util.List;

// Paso 5 (DIP): implementacion en memoria para probar sin base de datos
public class RepositorioMemoria implements RepositorioCobros {
    private List<String> registros = new ArrayList<>();

    public void guardar(String descripcion, double valor) {
        registros.add(descripcion + " -> " + (long) valor);
    }

    public List<String> listar() {
        return registros;
    }
}
