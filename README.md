# ParqueaderoSOLID

Taller 9 de Programacion 1 (Universidad Libre, docente Andres Castano): refactorizacion paso a paso aplicando los principios SOLID a un sistema de cobro mensual de parqueadero (mensualistas, vehiculos por minutos, bicicletas y casilleros para cascos).

Cada carpeta es una version ejecutable e independiente:

```
cd <carpeta>
javac *.java && java Main
```

| Carpeta | Principio | Problema en la version anterior | Que cambio |
|---|---|---|---|
| `00-inicio` | Ninguno (violaciones a proposito) | `GestorParqueadero` calcula, guarda, exporta CSV y envia SMS; `switch` sobre `tipo`; `Bicicleta` lanza excepcion; `Casillero` con metodos vacios; `new RepositorioMySQL()` dentro del gestor | Punto de partida |
| `01-responsabilidad-unica` | **S** - Single Responsibility | El gestor tenia varias razones para cambiar | Se extraen `ExportadorCSV` y `NotificadorSMS`; el gestor conserva el calculo y coordina en `cerrarMes` |
| `02-abierto-cerrado` | **O** - Open/Closed | Agregar un modelo de cobro obligaba a editar el `switch` de `Vehiculo` | `Vehiculo` pasa a abstracta; `VehiculoMensualista`, `VehiculoPorMinutos` y `Bicicleta` son subclases; se agrega `VehiculoPorDia` sin tocar ninguna clase existente |
| `03-sustitucion-liskov` | **L** - Liskov Substitution | `Bicicleta` prometia `calcularPuntos()` y lanzaba excepcion; el cliente necesitaba `try/catch` | Nueva interfaz `AcumulaPuntos` solo para quien acumula puntos; `Bicicleta` ya no la implementa; el gestor usa `instanceof` sin `try/catch` |
| `04-segregacion-interfaces` | **I** - Interface Segregation | `ServicioParqueadero` obligaba a `Casillero` a implementar metodos vacios | Se elimina `ServicioParqueadero` y se divide en `Cobrable`, `ConCasillero` y `AcumulaPuntos`; `Casillero` solo implementa `Cobrable` |
| `05-inversion-dependencias` | **D** - Dependency Inversion | `GestorParqueadero` creaba con `new` un `RepositorioMySQL` | Interfaz `RepositorioCobros` recibida por constructor; `RepositorioMySQL` (simulado) y `RepositorioMemoria` la implementan; `Main` prueba con memoria sin base de datos |

Las lineas modificadas en cada carpeta llevan un comentario que empieza con `// Paso`.
