package hello;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class EchoClient {

    private final String host;
    private final int port;
    private final String message;

    public EchoClient(String host, int port, String msg) {
        this.host = host;
        this.port = port;
        this.message = msg;
    }

    public void start() throws Exception {
        EventLoopGroup echoClientEventGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(echoClientEventGroup)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host, port))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new EchoClientHandler(message));
                        }
                    });
            final ChannelFuture future = bootstrap.connect().sync();
            future.channel().closeFuture().sync();
        } finally {
            echoClientEventGroup.shutdownGracefully().sync();
        }
    }
}
