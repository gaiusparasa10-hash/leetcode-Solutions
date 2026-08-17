class Solution {
    public int addDigits(int num) {
        int sum = 0;
        int x = 0;
        while(num > 0){
            x = num % 10;
            sum += x;
            num /= 10;
        }
        if(sum > 9)
           return addDigits(sum);
        return sum;
    }
}