package encryption;

public interface EncryptionInterface {
    byte[] encrypt(byte[] value,byte[] key,byte[] salt) throws Exception;
    byte[] decrypt(byte[] value,byte[] key,byte[] salt) throws Exception;

}
