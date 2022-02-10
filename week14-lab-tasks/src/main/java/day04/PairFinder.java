package day04;

import java.util.Arrays;

public class PairFinder {
    public int findPairs(int[] arr){
        Arrays.sort(arr);
        int c=0;
        int amount=1;
        for(int i =0;i<arr.length-1;++i){
            while(i!=arr.length-1&&arr[i]==arr[i+1]){
                amount++;
                if(arr[i]==arr[i+1]) {i++;}
            }
            c+=amount/2;
            amount=1;
        }
        return c;
    }
}
