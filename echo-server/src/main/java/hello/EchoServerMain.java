package hello;

public class EchoServerMain {

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: " + EchoServerMain.class.getSimpleName() + " <port>");
            return ;
        }

        int port = Integer.parseInt(args[0]);
        new EchoServer(port).start();
    }
}
