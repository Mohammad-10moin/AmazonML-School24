import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GCD_SUM {
    public static int largest(int[] a, int s, int e) {
        int mI=0;
        for (int i = s; i <= e; i++) {
            if(a[i] > a[mI]) {
                mI = i;
            }
        }
        return mI;
    }
    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            a[i]=gcd(a[i],a[largest(a,0,i)]);
        }
        System.out.println(Arrays.toString(a));
        ArrayList<Integer> b= new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if(a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
        int sum = 0;
        for (int i = 0; i < n/2; i++) {
            b.add(gcd(a[i],a[n-i-1]));
            sum +=gcd(a[i],a[n-i-1]) ;
        }
        System.out.println(b);
        System.out.println(sum);
    }
}
