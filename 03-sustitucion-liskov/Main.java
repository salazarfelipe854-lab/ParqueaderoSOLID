public class Main {
    public static void main(String[] args) {
        GestorParqueadero gestor = new GestorParqueadero();

        Vehiculo mensualista = new VehiculoMensualista("ABC123"); // Paso 2
        mensualista.asignarCasillero(7);

        gestor.agregar(mensualista);
        gestor.agregar(new VehiculoPorMinutos("XYZ789", 185)); // Paso 2
        gestor.agregar(new Bicicleta("BICI-01"));
        gestor.agregar(new VehiculoPorDia("DEF456", 3)); // Paso 2: nuevo tipo, GestorParqueadero intacto
        gestor.agregar(new Casillero(7));

        gestor.cerrarMes();
    }
}
