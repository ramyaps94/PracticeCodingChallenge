import java.util.Scanner;

public class JumpClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] a) {
        int count = 0;
        for(int i = 0; i < a.length-2; ){
            int j = i+1;
            int k = i+2;
            if(a[i] == 0 && a[j] == 0 && a[k] == 0){
                count++;
                i = k;
            }
            else if(a[i] == 0 && a[j] == 0 && a[k] == 1){
                count++;
                i = j;
            }
            else if(a[i] == 0 && a[j] == 1 && a[k] == 0){
                count++;
                i = k;

            }
            if(k == a.length-1) return count;

        }
        if(a.length%2==0) count++;
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        System.out.println(result);


        scanner.close();
    }
}
