import java.util.HashMap;

public class TopKFrequentElems {

    public static void main(String[] args) {

    }

    public int[] topKFrequentElements(int[] nums, int k){

        HashMap<Integer, Integer> myMap = new HashMap<>();


        for(int n : nums){
            // add each number to Map
            // check if number exists as key
            // if exists increment
            // else add with 1

            myMap.put(n, myMap.getOrDefault(n, 0) + 1);
        }



        for(int n: nums){
            myMap.put(n, myMap.getOrDefault(n, 0) +1);
        }



        // now sort Map By values



        for(int i = 0; i < nums.length; i++){
            // if contains key get the value and increment it by 1

                myMap.put(nums[i], myMap.getOrDefault(nums[i], 0)+1);
                //myMap.getOrDefault(nums[i], 0)

        }
        //
        return null;
    }
}
