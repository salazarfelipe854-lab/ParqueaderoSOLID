public class Bicicleta extends Vehiculo {
    public Bicicleta(String placa) {
        super(placa);
    }

    public double calcularCobro() {
        return 20000;
    }

    // Paso 3: ya no implementa AcumulaPuntos, no promete lo que no cumple ni lanza excepcion
}
