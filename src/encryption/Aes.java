package encryption;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;


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
     * @param salt must be 16 byte
     * @return
     * @throws EncryptionException
     */
    public String encrypt(String value, String key, String salt) throws EncryptionException {

        if((key.getBytes().length == 16 || key.getBytes().length == 24 || key.getBytes().length ==32)
                && salt.getBytes().length == 16)

            return super.encrypt(Constant.EncryptionTypes.AES, Constant.Modes.CBC, Constant.Padding.PKCS5Padding, value, key, salt);

        else
            throw new EncryptionException("Key/Salt size is invalid for Aes Encryption");



    }

   public String decrypt(String value,String key,String salt) throws EncryptionException {

       if((key.getBytes().length == 16 || key.getBytes().length == 24 || key.getBytes().length ==32)
               && salt.getBytes().length == 16)

           return super.decrypt(Constant.EncryptionTypes.AES, Constant.Modes.CBC, Constant.Padding.PKCS5Padding, value, key, salt);

       else
           throw new EncryptionException("Key/Salt size is invalid for Aes Decryption!");



    }


}
