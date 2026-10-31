// Paso 2 (OCP)
public class VehiculoPorMinutos extends Vehiculo {
    private int minutos;

    public VehiculoPorMinutos(String placa, int minutos) {
        super(placa);
        this.minutos = minutos;
    }

    public double calcularCobro() {
        return minutos * 100.0;
    }

    public int calcularPuntos() {
        return minutos / 60;
    }
}
