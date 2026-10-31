public class Casillero implements Cobrable { // Paso 4
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
}
