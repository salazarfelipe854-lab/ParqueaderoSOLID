import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorParqueadero {
    private List<ServicioParqueadero> servicios = new ArrayList<>();
    private RepositorioMySQL repo = new RepositorioMySQL(); // viola DIP

    public void agregar(ServicioParqueadero s) {
        servicios.add(s);
    }

    // Viola SRP: calcula, guarda, exporta CSV y envia SMS
    public void cerrarMes() {
        double total = 0;
        StringBuilder csv = new StringBuilder("descripcion,cobro,puntos\n");
        for (ServicioParqueadero s : servicios) {
            double cobro = s.calcularCobro();
            int puntos;
            try {
                puntos = s.calcularPuntos();
            } catch (UnsupportedOperationException e) {
                puntos = 0; // el cliente debe protegerse de la violacion de LSP
            }
            total += cobro;
            repo.guardar(s.descripcion(), cobro);
            csv.append(s.descripcion()).append(",").append((long) cobro).append(",").append(puntos).append("\n");
        }
        try (FileWriter w = new FileWriter("cierre.csv")) {
            w.write(csv.toString());
        } catch (IOException e) {
            System.out.println("Error escribiendo CSV: " + e.getMessage());
        }
        System.out.println("[SMS] a 3001234567: Cierre de mes. Total a recaudar: $" + (long) total);
    }
}
