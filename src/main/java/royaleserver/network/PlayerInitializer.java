package royaleserver.network;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import royaleserver.crypto.ServerCrypto;

public class PlayerInitializer extends ChannelInitializer<SocketChannel> {
	private final NetworkServer server;

	public PlayerInitializer(NetworkServer server) {
		this.server = server;
	}

	@Override
	public void initChannel(SocketChannel channel) throws Exception {
		ServerCrypto serverCrypto = new ServerCrypto();

		ChannelPipeline pipeline = channel.pipeline();
		pipeline.addLast(new PacketDecoder(serverCrypto));
		pipeline.addLast(new PacketEncoder(serverCrypto));
		pipeline.addLast(new PlayerHandler(server));
	}
}