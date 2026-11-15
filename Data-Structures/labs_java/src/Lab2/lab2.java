package Lab2;

import java.util.Arrays;

public class lab2 implements Ilab2 {

    @Override
    public int[] minMax(int[] arr){
        int n= arr.length;
        int min=arr[0];
        int max=arr[0];
        for(int i=1;i<n;i++){
            if(min>arr[i])
                min=arr[i];
            else if (max<arr[i])
                max=arr[i];
        }
        int result[]={min,max};
        return result;
    }
    @Override
    public int[] countEvenOdd(int[] arr){
        int n= arr.length;
        int even=0;
        int odd=0;
        for(int i=0;i<n;i++) {
            if ((arr[i] & 1) == 1) odd++;
            else even++;
        }
        int result[]={even,odd};
        return result;
    }
    @Override
    public int median(int[] arr){
        int n= arr.length;
        if(n==0) return 0;
        int[] arr2 = arr.clone();
        Arrays.sort(arr2);
        if ((n&1)==1) return arr2[n/2];
        else return (arr2[n/2 -1]+arr2[n/2])/2 ;
    }

    @Override
    public boolean isPalindrome(int[] arr) {
        int n=arr.length;
        for(int i=0; i<n/2;i++){
            if(arr[i] != arr[n-i-1])
                return false;
        }
        return true;
    }
    @Override
    public void pascalRow(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                arr[j] = (j==0)||(j==i) ?1:arr[j-1]+arr[j];
                System.out.print(arr[j]);
            }
            System.out.println();
        }
    }
}
