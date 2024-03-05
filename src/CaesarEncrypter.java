package src;

public class CaesarEncrypter implements LeetEncrypter {
    private final byte[] offset;
    private int offsetIndex;
    
    public CaesarEncrypter(byte[] offset) {
        this.offset = offset;
        this.offsetIndex = 0;
    }

    private int updateOffestIndex() {
        if (++offsetIndex >= offset.length)
            offsetIndex = 0;
        
        return offsetIndex;
    }

    @Override
    public byte encrypt(int index, byte[] data) {
        return (byte)(data[index] + offset[updateOffestIndex()]);
    }

    @Override
    public byte decrypt(int index, byte[] data) {
        return (byte)(data[index] - offset[updateOffestIndex()]);
    }

    @Override
    public byte[] encrypt(byte[] data) {
        final byte[] encrypted = new byte[data.length];

        offsetIndex = 0;

        for (int i = 0; i < data.length; i++)
            encrypted[i] = encrypt(i, data);
        
        return encrypted;
    }

    @Override
    public byte[] decrypt(byte[] data) {
        final byte[] decrypted = new byte[data.length];

        offsetIndex = 0;

        for (int i = 0; i < data.length; i++)
            decrypted[i] = decrypt(i, data);
        
        return decrypted;
    }
}
