public class InlineIV {
    public static void encryptIvNotInitialize2(String message) throws Exception {

        //IV
        IvParameterSpec ivSpec = new IvParameterSpec(new byte[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16});  //Oups. Static

    }
}