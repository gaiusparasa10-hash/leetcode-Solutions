class Solution {
    public boolean isPalindrome(int x) {
        int rev = 0;
        int n;
        int t = x;
        while(x > 0){
            n = x % 10;
            rev = rev * 10 + n;
            x = x / 10;
        }
        if(rev == t)
            return true;
        return false;
    }
}