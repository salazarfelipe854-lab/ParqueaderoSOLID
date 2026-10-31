public interface ServicioParqueadero {
    String descripcion();
    double calcularCobro();
    int calcularPuntos();
    void asignarCasillero(int numero);
}
