public class ZeroIV {
    public static void encryptIvNotInitialize3(String message) throws Exception {

        //IV
        IvParameterSpec ivSpec = new IvParameterSpec(new byte[16]);  //Oups. All 0s
    }

}