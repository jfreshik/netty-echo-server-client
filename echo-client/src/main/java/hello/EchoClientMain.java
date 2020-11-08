package hello;

public class EchoClientMain {

    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println("Usage: " + EchoClientMain.class.getSimpleName() + " <host> <port> <echo-message>");
            return ;
        }

        String host = args[0];
        int port = Integer.parseInt(args[1]);
        String msg = args[2];
        new EchoClient(host, port, msg).start();
    }

}
