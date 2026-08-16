class Solution {
    public int reverse(int x) {
        int rev  = 0;
        int n = 0;
        while(x != 0){
            n = x % 10;
            if(rev >= (Integer.MAX_VALUE / 10) && n > 7 || rev <= (Integer.MIN_VALUE / 10) && n < -8)
                return 0;
            
            rev= rev * 10 + n;
            x /= 10;
        }
        return rev;
    }
}