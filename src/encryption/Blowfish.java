package encryption;


public class Blowfish extends AbstractEncryption implements EncryptionInterface {

    private static Blowfish blowfish;

    public static  Blowfish getInstance(){

        if(blowfish==null)
            blowfish = new Blowfish();

        return blowfish;
    }

    private Blowfish(){

    }

    /**
     *
     * @param value
     * @param key 8 to 448 bits
     * @param salt must be 8 bytes
     * @return
     * @throws EncryptionException
     */
    public String encrypt(String value,String key,String salt) throws EncryptionException{

        if(salt.getBytes().length == 8 && key.getBytes().length <= 56)

            return super.encrypt(Constant.EncryptionTypes.Blowfish, Constant.Modes.CBC, Constant.Padding.PKCS5Padding, value, key, salt);

        else
            throw new EncryptionException("Key/Salt size is invalid for Blowfish Encryption");


    }

    public String decrypt(String value,String key,String salt)throws EncryptionException{

        if(salt.getBytes().length == 8 && key.getBytes().length <= 56)

            return super.decrypt(Constant.EncryptionTypes.Blowfish, Constant.Modes.CBC, Constant.Padding.PKCS5Padding, value, key, salt);

        else
            throw new EncryptionException("Key/Salt size is invalid for Blowfish Decryption");

    }
}
