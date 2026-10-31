// Paso 2 (OCP): Vehiculo es abstracta, sin switch sobre tipo
public abstract class Vehiculo implements Cobrable, ConCasillero { // Paso 4
    protected String placa;
    protected int casillero;

    public Vehiculo(String placa) { // Paso 2
        this.placa = placa;
    }

    public String descripcion() {
        return getClass().getSimpleName() + " " + placa + (casillero > 0 ? " (casillero " + casillero + ")" : ""); // Paso 2
    }

    public abstract double calcularCobro(); // Paso 2: cada modelo de cobro es una subclase

    public void asignarCasillero(int numero) {
        this.casillero = numero;
    }
}
