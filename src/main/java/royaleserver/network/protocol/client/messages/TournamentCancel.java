package royaleserver.network.protocol.client.messages;

import royaleserver.network.protocol.client.ClientMessage;
import royaleserver.network.protocol.client.ClientMessageHandler;
import royaleserver.network.protocol.Messages;
import royaleserver.utils.DataStream;

public final class TournamentCancel extends ClientMessage {
	public static final short ID = Messages.TOURNAMENT_CANCEL;

	public TournamentCancel() {
		super(ID);
	}

	@Override
	public ClientMessage create() {
		return new TournamentCancel();
	}

	@Override
	public boolean handle(ClientMessageHandler handler) throws Throwable {
		return handler.handleTournamentCancel(this);
	}

	@Override
	public void decode(DataStream stream) {
	}
}
