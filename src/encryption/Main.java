package encryption;

public class Main {
    public static void main(String[] args)throws Exception{

        System.out.println("Aes");
        String word = "hell reer o";
        String key = "asdfertjjhyrohgy";   //128-192-256 bit
        String initvector = "iiiiiiinişştor";  //16 byte
        System.out.println(word);
        String res = Aes.getInstance().encrypt(word,key,initvector);
        System.out.println(res);
        String last = Aes.getInstance().decrypt(res,key,initvector);
        System.out.println(last);
        System.out.println();

        System.out.println("Blowfish");
        String initvector2 = "yyyujyyf";  //8byte
        String val = "hello";
        System.out.println(val);
        String ekey = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaabb";
        String bl = Blowfish.getInstance().encrypt(val,ekey,initvector2);
        System.out.println(bl);

        String blres = Blowfish.getInstance().decrypt(bl,ekey,initvector2);
        System.out.println(blres);

    }
}


