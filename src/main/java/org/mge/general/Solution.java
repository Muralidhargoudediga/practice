package org.mge.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solve(ArrayList<String> A) {
        long res = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<A.size();i++) {
            String s = A.get(i);
            int c = 0;
            int l = s.length();
            while(true) {
                c++;
                int j = c % l;
                if(j != 0){
                    s = s.substring(j, l) + s.substring(0, j);
                }
                if(s.equals(A.get(i))) {
                    fact(c, map);
                    break;
                }
            }
        }
        
        for(int i : map.keySet()) {
            long p = pow(i, map.get(i));
            res = (res * p) % 1000000007;
        }
        return (int)res;
    }
    
    long pow(long a, long p){
        
        long ans = 1;
        while(p>0){
            if(p%2L == 1L){
                ans = (ans * a)%1000000007;
            }
            a = (a*a)%1000000007;
            p /= 2;
        }
        
        return ans%1000000007;
    }
    
    void fact(int n, Map<Integer, Integer> map) {
        int p = 0;
        while(n%2==0) {
            p++;
            n=n/2;
        }
        if((!map.containsKey(2) && p > 0) || (map.containsKey(2) && map.get(2) < p)){
            map.put(2, p);
        }
        for(int i = 3; i<=Math.sqrt(n); i+=2) {
            p = 0;
            while(n%i==0) {
                p++;
                n=n/i;
            }
            if((!map.containsKey(i) && p > 0) || (map.containsKey(i) && map.get(i) < p)){
                map.put(i, p);
            }
        }
        if(n>2){
            map.put(n, 1);
        }
    }
}
