import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        int n,i,j,loc,a[],ptr,temp;
        Scanner s1=new Scanner(System.in);
        System.out.println("How many elements you want to enter: ");
        n=s1.nextInt();
        a=new int[n];
        System.out.println("Enter the elements: ");
        for (i=0;i<n;i++)
        {
            a[i]=s1.nextInt();
        }
        for (i=0;i<n-1;i++)
        {
            loc=i;
            for (j=i+1;j<n;j++)
            {
                if (a[j] < a[loc])
                {
                    loc = j;
                }
            }
                temp=a[i];
                a[i]=a[loc];
                a[loc]=temp;
            }
        for(i=0;i<n;i++){
            System.out.println(a[i]);
        }
        }

    }

