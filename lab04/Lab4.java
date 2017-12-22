import java.util.*;

class Lab4
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

    	Boolean stop = false;

    	ArrayList<Integer> intList = new ArrayList<Integer>();
		ArrayList<Double> doubleList = new ArrayList<Double>();
		ArrayList<String> stringList = new ArrayList<String>();

		
		while(stop == false){
			System.out.print("Enter an int, double:, any random text, or type 'quit' to end:");


			if( scanner.hasNextInt()){
				int nums = scanner.nextInt();
				scanner.nextLine();
				intList.add(nums);
			}
			else if (scanner.hasNextDouble()){
				double nums = scanner.nextDouble();
				scanner.nextLine();
				doubleList.add(nums);
			}
			else if(scanner.hasNext()) {
				String nums = scanner.nextLine();
				if (nums.equals("quit")){
					stop = true;
				}
				else{stringList.add(nums);}
				}
			
			
		}
		System.out.println("Integers: ");
		for(int i = 0; i < intList.size();i++){
			System.out.println("     Integer[" + i + "] is "+ intList.get(i));
		}
		System.out.println("Doubles: ");
		for(int i = 0;i < doubleList.size();i++){
			System.out.println("     Double["+i+"[ is "+ doubleList.get(i));
		}
		System.out.println("Other:");
		for(int i = 0;i < stringList.size();i++){
			System.out.println("     Other["+ i +"] is "+ stringList.get(i));
		}
	}
}