package encryption;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)throws Exception{

        System.out.println("Aes");

        String word = "hellfjko";
        String key = "asdfertjjhyrohgy";   //128-192-256 bit
        String initvector = "iiiiiiinişştor";  //16 byte
        System.out.println(word);
        byte[] res = Aes.getInstance().encrypt(word.getBytes(),key.getBytes(),initvector.getBytes());
        System.out.println(Arrays.toString(res));
        byte[] last = Aes.getInstance().decrypt(res,key.getBytes(),initvector.getBytes());
        System.out.println(new String(last));
        System.out.println();

        System.out.println("Blowfish");
        String initvector2 = "yyyujyyf";  //8byte
        String val = "hello";
        System.out.println(val);

        String ekey = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaadgvgsd";

        byte[] bl = Blowfish.getInstance().encrypt(val.getBytes(),ekey.getBytes(),initvector2.getBytes());
        System.out.println(new String(bl));

        byte[] blres = Blowfish.getInstance().decrypt(bl,ekey.getBytes(),initvector2.getBytes());
        System.out.println(new String(blres));

    }
}


