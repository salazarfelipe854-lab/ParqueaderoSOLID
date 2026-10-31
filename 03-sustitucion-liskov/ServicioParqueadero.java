public interface ServicioParqueadero {
    String descripcion();
    double calcularCobro();
    // Paso 3: calcularPuntos() salio de este contrato (ahora vive en AcumulaPuntos)
    void asignarCasillero(int numero);
}
