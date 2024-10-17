import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    private Socket socket;

    public TCPClient(String host, int port) {
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

    //flush() sends the written msg. Without flushing it doesn't work.
    public void sendMessage(String message) {
        byte[] buffer = message.getBytes();
        try{
            OutputStream stream = this.socket.getOutputStream();
            stream.write(buffer);
            stream.flush();
        } catch (IOException e) {
            System.out.printf("Error during the sending the message - %s\n", e.getMessage());
        }
    }

    public void close() {
        try{
            this.socket.close();
        }catch (IOException e) {
            System.out.printf("Error during closing the socket - %s\n", e.getMessage());
        }
    }
}
