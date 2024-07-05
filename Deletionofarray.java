import java.util.Scanner;
public class Deletionofarray {
    public static void main(String args[]) {
        int n,i,m;
        Scanner s1=new Scanner(System.in);
        System.out.println("Enter the numbers of elements of the array: ");
        n=s1.nextInt();
        int a[]=new int[n];
        int b[]=new int[n-1];
        System.out.println("Enter the values: ");
        for (i=0;i<n;i++){
            a[i]=s1.nextInt();
        }
        System.out.println("Elements are as follows: ");
        for(i=0;i<n;i++){
            System.out.println(a[i]);
        }
        System.out.println("Enter the index number to be deleted: ");
        m=s1.nextInt();
        for(i=0;i<a.length;i++){
            if (i<m)
            {
                b[i] = a[i];
            }
            else
            {
                b[i-1]=a[i];
            }

        }
        System.out.println("The new array after deleting the required index are as follows: ");
        for(i=0;i<n-1;i++)
        {
            System.out.println(b[i]);
        }
    }
}
