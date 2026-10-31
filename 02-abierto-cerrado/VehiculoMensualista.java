// Paso 2 (OCP)
public class VehiculoMensualista extends Vehiculo {
    public VehiculoMensualista(String placa) {
        super(placa);
    }

    public double calcularCobro() {
        return 120000;
    }

    public int calcularPuntos() {
        return 50;
    }
}
