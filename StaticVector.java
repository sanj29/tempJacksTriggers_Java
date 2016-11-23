public class StaticIV {
    public static void encryptIvNotInitialize1(String message) throws Exception {

        byte[] iv = new byte[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}; //Oups. Static

        //IV
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
    }
}