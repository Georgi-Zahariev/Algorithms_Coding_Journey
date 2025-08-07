public class SumofTwoIntegers {
    public int getSum(int a, int b) {
        int result = 0;
        int carry  = 0;

        for(int i = 0; i < 32; i++){
            int abit = (a >>> i) & 1;
            int bbit = (b >>> i) & 1;

            int sum = abit ^ bbit ^ carry;
            carry = (abit & bbit) | (abit & carry) | (bbit & carry);

            result |= (sum << i);
        }
        return result;
    }
}
