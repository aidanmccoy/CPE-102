public class CircleTest{
	public static void main(String[] args) {
		try{
			Circle c1 = new Circle(-2);
			System.out.println(c1);
		}
		catch (NegativeRadiusException e){
			System.out.println(e.getMessage() + ": " + e.getRadius());
		}
		catch (ZeroRadiusException e){
			System.out.println(e.getMessage());
		}

		//catch (CircleException e){
		//	System.out.println(e.getMessage());
		//}

	}
}