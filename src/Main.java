public class Main {
    public static void main(String[] args) {

        //3
        TCPClient client = new TCPClient("10.22.26.17", 9007);
        System.out.println(client.getMessage());
        client.sendMessage("Hello there");
        System.out.println(client.getMessage());
        client.close();

        //1
        TCPClient client2 = new TCPClient("10.22.26.17", 9005);
        System.out.println(client2.getMessage());

        //2
        TCPMessage client3 = new TCPMessage("10.22.26.17", 9006);
        System.out.println(client3.getMessage());

        client3.close();


    }
}

