public class Bicicleta extends Vehiculo {
    public Bicicleta(String placa) {
        super(placa); // Paso 2
    }

    public double calcularCobro() { // Paso 2
        return 20000;
    }

    @Override
    public int calcularPuntos() {
        throw new UnsupportedOperationException("Las bicicletas no acumulan puntos"); // se corrige en el paso 3
    }
}
