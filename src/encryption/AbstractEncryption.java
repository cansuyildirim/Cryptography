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

    protected byte[] encrypt(Constant.EncryptionTypes type, Constant.Modes mode, Constant.Padding padding, byte[] value, byte[] key, byte[] salt) throws EncryptionException {

        try {

            IvParameterSpec iv = new IvParameterSpec(salt);
            SecretKeySpec seckey = new SecretKeySpec(key, type.getType());

            Cipher cipher = Cipher.getInstance(type.getType() + "/" + mode.getMode() + "/" + padding.getPadding());
            cipher.init(Cipher.ENCRYPT_MODE, seckey, iv);

            byte[] enc = cipher.doFinal(value);

            return enc;

            //return Base64.getEncoder().encode(enc);


        }
        catch(Exception exception) {
            throw new EncryptionException("Encryption failed",new Exception());
        }

    }

    protected byte[] decrypt(Constant.EncryptionTypes type, Constant.Modes mode, Constant.Padding padding, byte[] value, byte[] key, byte[] salt) throws EncryptionException {
        
        try {

            //byte[] decval = Base64.getDecoder().decode(value);

            IvParameterSpec iv = new IvParameterSpec(salt);
            SecretKeySpec seckey = new SecretKeySpec(key, type.getType());

            Cipher cipher = Cipher.getInstance(type.getType() + "/" + mode.getMode() + "/" + padding.getPadding());
            cipher.init(Cipher.DECRYPT_MODE, seckey, iv);

            return cipher.doFinal(value);

            //return cipher.doFinal(decval);
        }
        catch (Exception exception){
            throw new EncryptionException("Decryption failed",new Exception());
        }
    }

}
