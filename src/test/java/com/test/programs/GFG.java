package com.test.programs;

public class GFG {
	// Function that returns true if white wins  
	static boolean whiteWins(int rowW, int colW,  
	                        int rowB, int colB)  
	{  
	    int white = 0, black = 0;  
	    boolean flag=true; 
	  
	    while (flag) 
	    {  
	  
	        // If white can move  
	        if (rowW != 8)  
	        {  
	  
	            // If white pawn can kill black pawn  
	            // White wins  
	            if (rowB == rowW + 1
	                && (colB == colW - 1 || colB == colW + 1))  
	                return true;  
	  
	            // Make the move forward  
	            else
	                rowW++;  
	        }  
	  
	        // White has no moves  
	        // White loses  
	        else
	            return false;  
	  
	        // If black can move  
	        if (rowB != 1) 
	        {  
	  
	            // If black pawn can kill white pawn  
	            // White loses  
	            if (rowB == rowW + 1
	                && (colB == colW - 1 || colB == colW + 1))  
	                return false;  
	  
	            // Make the move forward  
	            else
	                rowB--;  
	        }  
	  
	        // Black has no moves  
	        // White wins  
	        else
	            return true;  
	    }  
	  
	    // If white has got more moves  
	    if (white > black)  
	        return true;  
	  
	    return false;  
	}  
	  
	// Driver code  
	public static void main(String args[]) 
	{  
	    int rowW = 1, colW = 1, rowB = 1, colB = 1;  
	    if (whiteWins(rowW, colW, rowB, colB))  
	        System.out.println("White");  
	    else
	        System.out.println("Black");  
	}  
}
