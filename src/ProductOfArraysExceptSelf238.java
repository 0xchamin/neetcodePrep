public class ProductOfArraysExceptSelf238 {
    public static void main(String[] args) {

    }

    public int[] productOfArraysExceptSelfHaha(int[] nums){

        int totalProduct = 1;
        int totalProductWOZero = 1;
        int numZeros = 0;
        int[] ans = new int[nums.length];

        for(int num: nums){
            totalProduct *= num;
            if(num == 0)
            {
                numZeros++;

            }else{
                totalProductWOZero *= num;
            }

        }



        for (int i = 0; i < nums.length; i++){
            if(nums[i] == 0) {
                if (numZeros > 1) {
                    ans[i] = 0;
                } else if (nums[i] == 0) {
                    ans[i] = totalProductWOZero;
                } else {
                    ans[i] = totalProduct / nums[i];
                }
            }
        }

        return nums;
    }
}
