import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPCliente {
    public static void main(String[] args) throws Exception {
        String servidor = "localhost";  // Dirección del servidor
        int puertoServidor = 9876;

        DatagramSocket socket = new DatagramSocket();
        String mensaje = "Hola, servidor!";
        byte[] datosEnvio = mensaje.getBytes();

        InetAddress direccionServidor = InetAddress.getByName(servidor);

        DatagramPacket paqueteEnvio = new DatagramPacket(datosEnvio, datosEnvio.length, direccionServidor, puertoServidor);
        socket.send(paqueteEnvio);
        System.out.println("Mensaje enviado al servidor: " + mensaje);

        // Recibir respuesta del servidor
        byte[] buffer = new byte[1024];
        DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
        socket.receive(paqueteRecibido);

        String respuesta = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());
        System.out.println("Respuesta del servidor: " + respuesta);

        socket.close();
    }
}
