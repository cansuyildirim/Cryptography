package encryption;



public class Aes extends AbstractEncryption implements EncryptionInterface {

    private static Aes aesEncrp;


    public static  Aes getInstance(){

        if(aesEncrp==null)
            aesEncrp = new Aes();

        return aesEncrp;
    }

    private Aes(){

    }


    /**
     *
     * @param value
     * @param key must be 128/192/256 bit
     * @param salt must be 16 bytes
     * @return
     * @throws EncryptionException
     */

    public byte[] encrypt(byte[] value, byte[] key, byte[] salt) throws EncryptionException {

        if((key.length == 16 || key.length == 24 || key.length ==32)
                && salt.length == 16)
            return super.encrypt(Constant.EncryptionTypes.AES, Constant.Modes.CBC, Constant.Padding.PKCS5Padding, value, key, salt);

        else
            throw new EncryptionException("Key/Salt size is invalid for Aes Encryption");

    }

   public byte[] decrypt(byte[] value,byte[] key,byte[] salt) throws EncryptionException {

       if((key.length == 16 || key.length == 24 || key.length ==32)
               && salt.length == 16)
           return super.decrypt(Constant.EncryptionTypes.AES, Constant.Modes.CBC, Constant.Padding.PKCS5Padding, value, key, salt);

       else
           throw new EncryptionException("Key/Salt size is invalid for Aes Decryption!");
    }


    public byte[] encrypt(byte[] value,byte[] key) throws Exception{

        if(key.length == 16 || key.length == 24 || key.length ==32)
            return super.encrypt(Constant.EncryptionTypes.AES, Constant.Modes.ECB, Constant.Padding.PKCS5Padding, value, key);

        else
            throw new EncryptionException("Key/Salt size is invalid for Aes Encryption");

    }

    public byte[] decrypt(byte[] value,byte[] key) throws Exception{

        if(key.length == 16 || key.length == 24 || key.length ==32)

            return super.decrypt(Constant.EncryptionTypes.AES, Constant.Modes.ECB, Constant.Padding.PKCS5Padding, value, key);

        else
            throw new EncryptionException("Key/Salt size is invalid for Aes Decryption!");




    }



}
