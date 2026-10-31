// Paso 1 (SRP): clase nueva, unica responsabilidad = enviar SMS (simulado)
public class NotificadorSMS {
    public void enviar(String telefono, String mensaje) {
        System.out.println("[SMS] a " + telefono + ": " + mensaje);
    }
}
