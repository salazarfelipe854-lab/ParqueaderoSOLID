import java.util.ArrayList;
import java.util.List;

public class GestorParqueadero {
    private List<ServicioParqueadero> servicios = new ArrayList<>();
    private RepositorioMySQL repo = new RepositorioMySQL(); // viola DIP (se corrige en el paso 5)
    private ExportadorCSV exportador = new ExportadorCSV(); // Paso 1: responsabilidad extraida
    private NotificadorSMS notificador = new NotificadorSMS(); // Paso 1: responsabilidad extraida

    public void agregar(ServicioParqueadero s) {
        servicios.add(s);
    }

    // Paso 1: el gestor solo calcula y coordina
    public void cerrarMes() {
        double total = 0;
        List<String[]> filas = new ArrayList<>(); // Paso 1
        filas.add(new String[] {"descripcion", "cobro", "puntos"}); // Paso 1
        for (ServicioParqueadero s : servicios) {
            double cobro = s.calcularCobro();
            int puntos;
            try {
                puntos = s.calcularPuntos();
            } catch (UnsupportedOperationException e) {
                puntos = 0;
            }
            total += cobro;
            repo.guardar(s.descripcion(), cobro);
            filas.add(new String[] {s.descripcion(), String.valueOf((long) cobro), String.valueOf(puntos)}); // Paso 1
        }
        exportador.exportar("cierre.csv", filas); // Paso 1
        notificador.enviar("3001234567", "Cierre de mes. Total a recaudar: $" + (long) total); // Paso 1
    }
}
