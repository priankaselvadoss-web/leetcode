class Palindrome {
    public boolean isPalindrome(int x) {
        int original = x;
        int reversed = 0;

        if (x<0){
            return false;
        }
    while (x !=0) {
        int digit = x%10;
        if (reversed > Integer.MAX_VALUE/10 || (reversed == Integer.MAX_VALUE/10 && digit>7)){
            return false;
        }
        reversed = reversed*10+digit;
        x=x/10;
    }
    return original == reversed;
}
}