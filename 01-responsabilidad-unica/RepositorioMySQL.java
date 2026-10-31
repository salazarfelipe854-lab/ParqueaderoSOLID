// Simulado: imprime el INSERT en lugar de conectarse a una base real.
public class RepositorioMySQL {
    public void guardar(String descripcion, double valor) {
        System.out.println("[MySQL] INSERT INTO cobros VALUES ('" + descripcion + "', " + (long) valor + ")");
    }
}
