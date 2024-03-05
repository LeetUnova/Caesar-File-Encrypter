package src;

public interface LeetEncrypter {
    public byte encrypt(int index, byte[] data);
    public byte decrypt(int index, byte[] data);

    public byte[] encrypt(byte[] data);
    public byte[] decrypt(byte[] data);
}
