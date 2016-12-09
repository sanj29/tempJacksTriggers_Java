import java.lang.*;

class ExceptionPrintStackTraceNegative
{
    public static void main(String args[])
    {
	try {
	    Exception foo = new Exception("foo");
	    throw foo;
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
