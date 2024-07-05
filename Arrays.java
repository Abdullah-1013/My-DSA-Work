import java.util.Scanner;

public class Arrays {
    public static void main(String args[]) {
        int n,i;
        Scanner s1=new Scanner(System.in);
        System.out.println("Enter the numbers of elements of the array: ");
        n=s1.nextInt();
        int a[]=new int[n];
        System.out.println("Enter the values: ");
        for (i=0;i<n;i++){
            a[i]=s1.nextInt();
        }
        System.out.println("Elements are as follows: ");



    }
}

