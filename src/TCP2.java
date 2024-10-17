import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
public class TCP2 {

    private Socket socket;

    public TCP2(String host, int port) {
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
                if(c.equals("\n"))
                    break;
            }
        } catch (IOException e) {
            System.out.printf("Error during the receiving the message - %s\n", e.getMessage());
        }
        return sb.toString();
    }

}
