class Solution {
    public boolean isPalindrome(String s) {
        
        String str = s.toLowerCase();
        int i1 = 0;
        int i2 = str.length() - 1;

        while(i1 < i2){
            while(i1 < i2 && !Character.isLetterOrDigit(str.charAt(i1)))
                i1++;
            while(i1 < i2 && !Character.isLetterOrDigit(str.charAt(i2)))
                i2--;

            if(str.charAt(i1) != str.charAt(i2))
                return false;
            i1++;
            i2--;
        }
        return true;
    }
}