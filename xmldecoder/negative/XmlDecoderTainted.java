class XmlDecoderTainted
{
    public static void main(String args[], Request request)
    {
	XMLDecoder d = new XMLDecoder(request.getParameter("UserInput"));
	Object result = d.readObject();
	d.close();
    }
}
