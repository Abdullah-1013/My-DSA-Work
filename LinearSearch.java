import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        int n,i,item,c=0;
        int a[];
        Scanner s1=new Scanner(System.in);
        System.out.println("How many values you want to enter: ");
        n=s1.nextInt();
        a=new int[n];
        System.out.println("Enter the elements: ");
        for (i=0;i<n;i++)
            a[i]=s1.nextInt();
        System.out.println("Enter the value to find: ");
        item=s1.nextInt();
        for(i=0;i<a.length;i++){
            if (a[i]==item){
                c++;
            }

        }
            if(c>0){
                System.out.println("Item exists");
            }
        else
                System.out.println("Item not exists");
    }
}