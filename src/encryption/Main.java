package encryption;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)throws Exception{

        System.out.println("Aes");

        String word = "hello";
        String key = "asdfertjjhyrohgy";   //128-192-256 bit
        String initvector = "initvectorIntVec";  //16 byte
        System.out.println(word);
        byte[] aes1 = Aes.getInstance().encrypt(word.getBytes(),key.getBytes(),initvector.getBytes());
        System.out.println(Arrays.toString(aes1));
        byte[] res1 = Aes.getInstance().decrypt(aes1,key.getBytes(),initvector.getBytes());
        System.out.println(new String(res1));
        System.out.println();


        System.out.println("Aes without salt");
        byte[] aes2 = Aes.getInstance().encrypt(word.getBytes(),key.getBytes());
        //System.out.println(Arrays.toString(aes2));
        System.out.println(new String(aes2));
        byte[] res2 = Aes.getInstance().decrypt(aes2,key.getBytes());
        System.out.println(new String(res2));
        System.out.println();

        System.out.println("Blowfish");
        String initvector2 = "blvector";  //8byte
        String val = "hello blowfish";
        System.out.println(val);
        String ekey = "secretkeyy";
        byte[] bl = Blowfish.getInstance().encrypt(val.getBytes(),ekey.getBytes(),initvector2.getBytes());
        System.out.println(new String(bl));
        byte[] blres = Blowfish.getInstance().decrypt(bl,ekey.getBytes(),initvector2.getBytes());
        System.out.println(new String(blres));
        System.out.println();

        System.out.println("Blowfish without salt");
        byte[] c = Blowfish.getInstance().encrypt(val.getBytes(),ekey.getBytes());
        //System.out.println(Arrays.toString(a));
        System.out.println(new String(c));
        byte[] d= Blowfish.getInstance().decrypt(c,ekey.getBytes());
        System.out.println(new String(d));
        System.out.println();


    }
}


