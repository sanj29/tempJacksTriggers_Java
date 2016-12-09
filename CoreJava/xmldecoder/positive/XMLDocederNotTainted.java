class XMLDecoderNotTainted
{
    public static void main(String args[], Request request)
    {
	XMLDecoder d = new XMLDecoder("I am static");
	Object result = d.readObject();
	d.close();
    }
}
