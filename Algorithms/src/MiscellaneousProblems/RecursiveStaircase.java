package MiscellaneousProblems;

public class RecursiveStaircase {

	public static void main(String[] args) {
		int steps = 3;
		//You are allowed to skip either of these steps at a time
		int[] skipFactor = {1,2};
		int[] result = new int[steps+1];
		System.out.println(countWays(steps, skipFactor, result));
	}
	public static int countWays(int n, int[] m, int[] result)
	{
		if(n == 0){
			result[n] = 1;
			return result[n];
		}
		if(result[n] > 0)
			return result[n];
		for(int i=0; i<m.length; i++)
		{
			if(n-m[i] >= 0)
				result[n] += countWays(n-m[i],m,result);
		}
		return result[n];
	}
}
