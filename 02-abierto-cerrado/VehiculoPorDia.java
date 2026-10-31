// Paso 2 (OCP): nuevo modelo de cobro agregado SIN modificar Gestor, Vehiculo ni otras subclases
public class VehiculoPorDia extends Vehiculo {
    private int dias;

    public VehiculoPorDia(String placa, int dias) {
        super(placa);
        this.dias = dias;
    }

    public double calcularCobro() {
        return dias * 15000.0;
    }

    public int calcularPuntos() {
        return dias * 5;
    }
}
