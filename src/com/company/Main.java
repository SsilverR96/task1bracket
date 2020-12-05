package com.company;
import java.util.Scanner;

/*
C[n] - Regular Bracket sequence made from N opening brackets and N closing brackets.
C[n] = X, X - An arbitrary regular bracket sequence.
Let is X = (A)B, where A and B - Regular Bracket sequences.
The length of the sequence A is C[k] and B = C[n-1-k]
C[n] = C[k]C[n-k-1]
*/

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        try
        {
            System.out.print("Input count of open(close) brackets: ");
            while (!in.hasNextInt())
            {
                System.out.println("That not a number!");
                in.next();
            }
            int countBrackets = in.nextInt();
            if (countBrackets <= 0)
                throw new Exception("Number must be a non-negative");
            System.out.print("Number of correct expressions: " + Brackets(countBrackets));
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    static long Brackets(int countBrackets)
    {
        /*
        Returns the number of regular bracket sequences (Catalan numbers)
         */
        long[] C = new long [countBrackets + 1];
        C[0] = 1;
        for (int i = 1; i <= countBrackets; i++)
        {
            C[i] = 0;
            for (int j = 0; j < i; j++)
                C[i] += C[j] * C[i-1-j];
        }
        return C[countBrackets];
    }
}
