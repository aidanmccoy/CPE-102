import java.lang.Object;
import java.lang.Math;
public class SUnit{

	private static int testCount;
	private static int testFailCount;

	public static void assertEquals(double expect, double actual, double epsilon){
		if(Math.abs(actual - expect) > epsilon ){
			Throwable throwable = new Throwable("Error: Expected " + expect +" +/-" + epsilon+ ", found " + actual);
			throwable.printStackTrace();
			testFailCount = testFailCount + 1;
		}
		testCount = testCount +1;
	}

	public static void assertEquals(long expect, long actual){
		if(expect != actual){
			Throwable throwable = new Throwable("Error: Expected " + expect + ", found " + actual);
			throwable.printStackTrace();
			testFailCount = testFailCount + 1;
		}
		testCount = testCount +1;
	}

	public static void assertEqualsObject(Object expect, java.lang.Object actual){
		if(expect.equals(actual) == false){
			Throwable throwable = new Throwable("Error: Expected object equality, found inequality");
			throwable.printStackTrace();
			testFailCount = testFailCount + 1;
		}
		testCount = testCount +1;
	}

	public static void assertEqualsReference(Object expect, java.lang.Object actual){
		if(expect != actual){
			Throwable throwable = new Throwable("Error: Expected reference equality, found inequality");
			throwable.printStackTrace();
			testFailCount = testFailCount + 1;
		}
		testCount = testCount +1;

	}

	public static void assertFalse(boolean actual){
		if(actual == true){
			Throwable throwable = new Throwable("Error: Expected false, found true");
			throwable.printStackTrace();
			testFailCount = testFailCount + 1;
		}
		testCount = testCount +1;
	}

	public static void assertNotNull(Object actual){
		if(actual == null){
			Throwable throwable = new Throwable("Error: Expected non-null, found null");
			throwable.printStackTrace();
			testFailCount = testFailCount + 1;
		}
		testCount = testCount +1;
	}

	public static void assertNull(Object actual){
		if (actual != null){
			Throwable throwable = new Throwable("Error: Expected null, found non-null");
			throwable.printStackTrace();
			testFailCount = testFailCount + 1;
		}
		testCount = testCount +1;
	}

	public static void assertTrue(boolean actual){
		if( actual == false){
			Throwable throwable = new Throwable("Error: Expected true, found false");
			throwable.printStackTrace();
			testFailCount = testFailCount + 1;
		}
		testCount = testCount +1;
	}

	public static void fail(){
		Throwable throwable = new Throwable("Error: Explicit failure");
		throwable.printStackTrace();
		testCount = testCount +1;
		testFailCount = testFailCount + 1;
	}

	public static int testsFailed(){
		return testFailCount;
	}

	public static int testsRun(){
		return testCount;
	}
}