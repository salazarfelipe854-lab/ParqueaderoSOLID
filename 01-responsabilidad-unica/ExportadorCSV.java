import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

// Paso 1 (SRP): clase nueva, unica responsabilidad = exportar a CSV
public class ExportadorCSV {
    public void exportar(String archivo, List<String[]> filas) {
        try (FileWriter w = new FileWriter(archivo)) {
            for (String[] fila : filas) {
                w.write(String.join(",", fila) + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error escribiendo CSV: " + e.getMessage());
        }
    }
}
