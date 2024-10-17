public class Main {
    public static void main(String[] args) {
        TCPClient client = new TCPClient("10.22.26.17", 9007);
        System.out.println(client.getMessage());
        client.sendMessage("Hello there");
        System.out.println(client.getMessage());
        client.close();

    }
}

