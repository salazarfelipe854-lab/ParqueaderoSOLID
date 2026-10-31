public class Vehiculo implements ServicioParqueadero {
    protected String tipo;
    protected String placa;
    protected int minutos;
    protected int casillero;

    public Vehiculo(String tipo, String placa, int minutos) {
        this.tipo = tipo;
        this.placa = placa;
        this.minutos = minutos;
    }

    public String descripcion() {
        return tipo + " " + placa + (casillero > 0 ? " (casillero " + casillero + ")" : "");
    }

    public double calcularCobro() {
        switch (tipo) {
            case "MENSUALISTA": return 120000;
            case "MINUTOS": return minutos * 100.0;
            case "BICICLETA": return 20000;
            default: throw new IllegalArgumentException("Tipo desconocido: " + tipo);
        }
    }

    public int calcularPuntos() {
        switch (tipo) {
            case "MENSUALISTA": return 50;
            case "MINUTOS": return minutos / 60;
            default: return 0;
        }
    }

    public void asignarCasillero(int numero) {
        this.casillero = numero;
    }
}
