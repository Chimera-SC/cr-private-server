package royaleserver.crypto;

import royaleserver.network.protocol.MessageHeader;

public class ServerCrypto {
    private final CryptoRC4 crypto = new CryptoRC4();

    public void decryptPacket(MessageHeader header) {
        header.decrypted = crypto.decryptPacket(header.payload, header.id);
    }

    public void encryptPacket(MessageHeader header) {
        header.payload = crypto.encryptPacket(header.decrypted, header.id);
    }
}