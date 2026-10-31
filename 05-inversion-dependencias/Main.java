public class Main {
    public static void main(String[] args) {
        RepositorioMemoria repo = new RepositorioMemoria(); // Paso 5: sin base de datos
        // En produccion: new GestorParqueadero(new RepositorioMySQL()) // Paso 5
        GestorParqueadero gestor = new GestorParqueadero(repo); // Paso 5

        Vehiculo mensualista = new VehiculoMensualista("ABC123");
        mensualista.asignarCasillero(7);

        gestor.agregar(mensualista);
        gestor.agregar(new VehiculoPorMinutos("XYZ789", 185));
        gestor.agregar(new Bicicleta("BICI-01"));
        gestor.agregar(new VehiculoPorDia("DEF456", 3));
        gestor.agregar(new Casillero(7));

        gestor.cerrarMes();

        // Paso 5: prueba sin base de datos
        System.out.println("Registros en memoria: " + repo.listar());
        System.out.println(repo.listar().size() == 5 ? "PRUEBA OK" : "PRUEBA FALLO");
    }
}
