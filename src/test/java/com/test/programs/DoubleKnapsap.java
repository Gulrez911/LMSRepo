package com.test.programs;

public class DoubleKnapsap {
	static int maxN = 31; 
    static int maxW = 31; 
  
    // 3D array to store 
    // states of DP 
    static int dp [][][] = new int[maxN][maxW][maxW]; 
      
    // w1_r represents remaining capacity of 1st knapsack 
    // w2_r represents remaining capacity of 2nd knapsack 
    // i represents index of the array arr we are working on 
    static int maxWeight(int arr [] , int n, int w1_r, int w2_r, int i) 
    { 
        // Base case 
        if (i == n) 
            return 0; 
        if (dp[i][w1_r][w2_r] != -1) 
            return dp[i][w1_r][w2_r]; 
      
        // Variables to store the result of three 
        // parts of recurrence relation 
        int fill_w1 = 0, fill_w2 = 0, fill_none = 0; 
      
        if (w1_r >= arr[i]) 
            fill_w1 = arr[i] +  
            maxWeight(arr, n, w1_r - arr[i], w2_r, i + 1); 
      
        if (w2_r >= arr[i]) 
            fill_w2 = arr[i] +  
            maxWeight(arr, n, w1_r, w2_r - arr[i], i + 1); 
      
        fill_none = maxWeight(arr, n, w1_r, w2_r, i + 1); 
      
        // Store the state in the 3D array 
        dp[i][w1_r][w2_r] = Math.max(fill_none, Math.max(fill_w1, fill_w2)); 
      
        return dp[i][w1_r][w2_r]; 
    } 
      
    // Driver code 
    public static void main (String[] args)  
    { 
      
        // Input array 
        int arr[] = { 100, 200, 300, 400, 500, -567845 }; 
      
        // Intializing the array with -1 
                 for (int i = 0; i < maxN ; i++) 
            for (int j = 0; j < maxW ; j++) 
                for (int k = 0; k < maxW ; k++) 
                        dp[i][j][k] = -1; 
          
        // Number of elements in the array 
        int n = arr.length; 
      
        // Capacity of knapsacks 
        int w1 = 10, w2 = 3; 
      
        // Function to be called 
        System.out.println(maxWeight(arr, n, w1, w2, 0)); 
    } 
}
