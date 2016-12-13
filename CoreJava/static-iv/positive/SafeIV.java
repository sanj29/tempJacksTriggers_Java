public class SafeIV {
    public static void encrypt(String message) throws Exception {

        byte[] iv = new byte[16] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        new SecureRandom().nextBytes(iv);

        //IV
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
    }

}