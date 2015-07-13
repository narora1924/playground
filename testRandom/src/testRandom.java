import java.util.Random;


public class testRandom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random rand = new Random();
		int randomNum = 0;
		
		for (int j=0; j<=10; j++)
		{
		  randomNum = rand.nextInt(2);
	 	  System.out.println(randomNum);
		}
	}

}
