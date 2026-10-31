// Paso 5 (DIP): abstraccion de la que depende el gestor
public interface RepositorioCobros {
    void guardar(String descripcion, double valor);
}
