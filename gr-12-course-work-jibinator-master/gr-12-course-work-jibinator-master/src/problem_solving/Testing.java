package problem_solving;

public class Testing
{
	public static void main(String[] args) 
	{

	}
	public static void insertElements( int value, int position)
	{
		int originalArray[]= {1,2,3,4,5,6,7,8,9};
		value =5;
		position=2;
		int[] newArray = new int[originalArray.length + 1];

		for (int i = 0; i < position; i++) {
			newArray[i] = originalArray[i];
		}

		newArray[position] = value;

		for (int i = 0; i < newArray.length; i++) {
			if (originalArray[i]==position) {
				newArray[position]=value;
				i=i+1;
			}
			else {
				newArray[i] = originalArray[i];
			}
		}


		for (int i = 0; i < newArray.length; i++) {
			System.out.println(newArray[i]);
		}

	}

}
