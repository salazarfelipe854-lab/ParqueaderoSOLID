import java.util.ArrayList;
import java.util.List;

public class GestorParqueadero {
    private List<Cobrable> servicios = new ArrayList<>(); // Paso 4
    private RepositorioCobros repo; // Paso 5: depende de la abstraccion
    private ExportadorCSV exportador = new ExportadorCSV(); // Paso 1: responsabilidad extraida
    private NotificadorSMS notificador = new NotificadorSMS(); // Paso 1: responsabilidad extraida

    public GestorParqueadero(RepositorioCobros repo) { // Paso 5: inyeccion por constructor
        this.repo = repo;
    }

    public void agregar(Cobrable s) { // Paso 4
        servicios.add(s);
    }

    // Paso 1: el gestor solo calcula y coordina
    public void cerrarMes() {
        double total = 0;
        List<String[]> filas = new ArrayList<>(); // Paso 1
        filas.add(new String[] {"descripcion", "cobro", "puntos"}); // Paso 1
        for (Cobrable s : servicios) { // Paso 4
            double cobro = s.calcularCobro();
            int puntos = 0;
            if (s instanceof AcumulaPuntos) { // Paso 3: sin try/catch, el tipo garantiza el contrato
                puntos = ((AcumulaPuntos) s).calcularPuntos(); // Paso 3
            }
            total += cobro;
            repo.guardar(s.descripcion(), cobro);
            filas.add(new String[] {s.descripcion(), String.valueOf((long) cobro), String.valueOf(puntos)}); // Paso 1
        }
        exportador.exportar("cierre.csv", filas); // Paso 1
        notificador.enviar("3001234567", "Cierre de mes. Total a recaudar: $" + (long) total); // Paso 1
    }
}
