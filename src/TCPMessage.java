import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
public class TCPMessage {

    private Socket socket;

    public TCPMessage(String host, int port) {
        try {
            this.socket = new Socket(host, port);
        } catch (IOException e) {
            System.out.printf("Error during the connection - %s\n", e.getMessage());
        }
    }

    public String getMessage() {
        byte[] buffer = new byte[1];
        StringBuilder sb = new StringBuilder();
        try {
            InputStream stream = this.socket.getInputStream();
            while (stream.read(buffer) != -1) {
                String c = new String(buffer);
                sb.append(c);

            }
        } catch (IOException e) {
            System.out.printf("Error during the receiving the message - %s\n", e.getMessage());
        }
        String[] arr = sb.toString().split("\r\n");
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < arr.length-1; i++)
            sb2.append(arr[i]).append("\r\n");


        return sb2.toString();
    }

    public void close() {
        try{
            this.socket.close();
        }catch (IOException e) {
            System.out.printf("Error during closing the socket - %s\n", e.getMessage());
        }
    }

}
