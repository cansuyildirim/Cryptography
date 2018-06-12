package encryption;

public class Constant {


    public enum EncryptionTypes{

        AES("AES"),
        Blowfish("Blowfish");

        private String type;

        EncryptionTypes(final String type){
            this.type = type;
        }
        public String getType(){
            return type;
        }
    }
    public enum Modes{

        ECB("ECB"),       //simple,same plaintext blocks -> same ciphertext blocks
        CBC("CBC"),       //most common, secure
        OFB("OFB"),       //creates a pseudo random stream which is independent from plaintext, no paralellization,
                          //transmission errors only effect the wrong bits, makes blockcipher into streamcipher

        CFB("CFB"),       //creates a pseudo random stream which depends on the plaintext, dec paral/enc not paral
                          // transmission errors completely destroy the following block but only effect the wrong bits
                          //makes blockcipher into streamcipher

        CTR("CTR");       //creates a pseudo random stream which is independent from plaintext, paralellization
                          //transmission errors only effect the wrong bits,makes blockcipher into streamcipher

        private String mode;

        Modes(final String mode){
            this.mode = mode;
        }
        public String getMode(){
            return mode;
        }
    }
    public enum Padding{

        PKCS5Padding("PKCS5Padding"),   //use with ECB and CBC mode, it makes the length of data proper
        NoPadding("NoPadding");

        private String padding;

        Padding(final String padding){
            this.padding = padding;
        }
        public String getPadding(){
            return padding;
        }
    }



}
