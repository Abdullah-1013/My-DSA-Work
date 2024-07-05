import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        int n,i,item,c=0,beg,mid;
        int a[];
        Scanner s1=new Scanner(System.in);
        System.out.println("How many elements you want to enter: ");
        n=s1.nextInt();
        a=new int[n];
        System.out.println("Enter the elements: ");
        for(i=0;i<n;i++)
            a[i]=s1.nextInt();
        System.out.println("Enter item to be searched: ");
        item=s1.nextInt();
        beg=0; int end=n-1;
        while(beg<=end){
            mid=beg+end/2;
            if(item==a[mid]){
                c++;
                break;
            } else if (item>a[mid]) {
                beg=mid+1;
            } else if (item<a[mid]) {
                end=mid-1;
            }
        }
        if(c>0){
            System.out.println("Item has been found");
        }
        else
            System.out.println("Item has not been found");
    }
}
