public class Casillero implements ServicioParqueadero {
    private int numero;

    public Casillero(int numero) {
        this.numero = numero;
    }

    public String descripcion() {
        return "CASILLERO " + numero;
    }

    public double calcularCobro() {
        return 15000;
    }

    public void asignarCasillero(int n) {
        // metodo vacio forzado por la interfaz
    }
}
