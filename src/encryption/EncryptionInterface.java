package encryption;

public interface EncryptionInterface {
    String encrypt(String value,String key,String salt) throws Exception;
    String decrypt(String value,String key,String salt) throws Exception;

}
