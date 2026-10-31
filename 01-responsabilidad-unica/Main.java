public class Main {
    public static void main(String[] args) {
        GestorParqueadero gestor = new GestorParqueadero();

        Vehiculo mensualista = new Vehiculo("MENSUALISTA", "ABC123", 0);
        mensualista.asignarCasillero(7);

        gestor.agregar(mensualista);
        gestor.agregar(new Vehiculo("MINUTOS", "XYZ789", 185));
        gestor.agregar(new Bicicleta("BICI-01"));
        gestor.agregar(new Casillero(7));

        gestor.cerrarMes();
    }
}
