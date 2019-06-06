package MiscellaneousProblems;

/*Problem Statement: Find the minimum number of coins required from the given denominations to the get
 * to get the given total amount. We will use the dynamic programming to get to the solution*/

public class ChangingCoins {

	public static void main(String[] args) {
		int[] denominations = {1,5,6,8};
		int totalAmount = 11;
		int minCoins = getMinimumCoins(denominations, totalAmount);
		System.out.println("Minimum number of coins required are : " + minCoins);
	}
	
	private static int getMinimumCoins(int[] coins, int total) {
		int[][] coinMatrix = new int[coins.length+1][total+1];
		for(int i=1; i<= total; i++)
			coinMatrix[1][i]= i;
		for(int i=2; i<= coins.length; i++) {
			for(int j=1; j<=total; j++) {
				if(j >= coins[i-1])
					coinMatrix[i][j] = coinMatrix[i-1][j] < coinMatrix[i][j-(coins[i-1]-1)] ? 
						coinMatrix[i-1][j]: coinMatrix[i][j-(coins[i-1]-1)];
				else
					coinMatrix[i][j] = coinMatrix[i-1][j];
			}
		}
		
		return coinMatrix[coinMatrix.length][coinMatrix[0].length];
	}

}
