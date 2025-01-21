import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        int puerto = 9876;  // Puerto de escucha del servidor
        DatagramSocket socket = new DatagramSocket(puerto);
        System.out.println("Servidor UDP esperando en el puerto " + puerto);

        byte[] buffer = new byte[1024];

        while (true) {
            DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
            socket.receive(paqueteRecibido);

            String mensaje = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());
            System.out.println("Mensaje recibido: " + mensaje);

            // Enviar respuesta al cliente
            String respuesta = "Mensaje recibido correctamente";
            byte[] datosRespuesta = respuesta.getBytes();
            DatagramPacket paqueteRespuesta = new DatagramPacket(
                    datosRespuesta,
                    datosRespuesta.length,
                    paqueteRecibido.getAddress(),
                    paqueteRecibido.getPort()
            );

            socket.send(paqueteRespuesta);
        }
    }
}