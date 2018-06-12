package encryption;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class AbstractEncryption {

    public static final int AES_VECTOR_LENGTH = 16;
    public static final String CHAR_SET_NAME = "UTF-8";

    public AbstractEncryption(){}

    public byte[] getRandomInıtVector(){

        byte[] initvec = new byte[AES_VECTOR_LENGTH];
        SecureRandom random = new SecureRandom();
        random.nextBytes(initvec);
        return initvec;

    }

    protected String encrypt(Constant.EncryptionTypes type, Constant.Modes mode, Constant.Padding padding, String value, String key, String salt) throws EncryptionException {
        try {

            IvParameterSpec iv = new IvParameterSpec(salt.getBytes(CHAR_SET_NAME));
            SecretKeySpec seckey = new SecretKeySpec(key.getBytes(CHAR_SET_NAME), type.getType());

            Cipher cipher = Cipher.getInstance(type.getType() + "/" + mode.getMode() + "/" + padding.getPadding());
            cipher.init(Cipher.ENCRYPT_MODE, seckey, iv);

            byte[] enc = cipher.doFinal(value.getBytes());
            String encrypted = Base64.getEncoder().encodeToString(enc);

            return encrypted;
        }
        catch(Exception exception) {
            throw new EncryptionException("Encryption failed",new Exception());
        }



    }

    protected String decrypt(Constant.EncryptionTypes type, Constant.Modes mode, Constant.Padding padding, String value, String key, String salt) throws EncryptionException {
        try {

            byte[] decval = Base64.getDecoder().decode(value.getBytes(CHAR_SET_NAME));

            IvParameterSpec iv = new IvParameterSpec(salt.getBytes(CHAR_SET_NAME));
            SecretKeySpec seckey = new SecretKeySpec(key.getBytes(CHAR_SET_NAME), type.getType());

            Cipher cipher = Cipher.getInstance(type.getType() + "/" + mode.getMode() + "/" + padding.getPadding());
            cipher.init(Cipher.DECRYPT_MODE, seckey, iv);

            byte[] dec = cipher.doFinal(decval);
            String decrypted = new String(dec, CHAR_SET_NAME);

            return decrypted;
        }
        catch (Exception exception){
            throw new EncryptionException("Decryption failed",new Exception());
        }


    }

}
