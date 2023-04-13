import java.util.*;
import java.util.Map.Entry;

public class NeetCode {
    public static void main(String[] args) {

    }

    public boolean containsDuplicate2(int[] nums){

        HashMap<Integer,Integer> myMap = new HashMap<>();
        HashSet<Integer> mySet = new HashSet<>();

        for(int i : nums){
            myMap.put(i, myMap.getOrDefault(i, 0) + 1);
            if(myMap.get(i) > 1) return true;

            if(!mySet.contains(i)){
                mySet.add(i);
            }else return true;
        }

        return false;
    }

    public boolean containsDuplicate(int[] nums){
        HashMap<Integer,Integer> countVals = new HashMap<>();

        for(int num : nums){
            if(countVals.containsKey(num)){
                return false;
            }
            countVals.put(num, countVals.getOrDefault(num, 0) + 1);
        }

        Set<Integer> mySet = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(mySet.contains(nums[i])){
                return false;
            }
            mySet.add(nums[i]);
        }

        return false;
    }

    public boolean isAnagram(String s, String t){

        int[] alphabet = new int[26];

        for(int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a'] ++;

        for(int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a'] --;

        for(int i : alphabet) if (i != 0) return false;

        return true;
    }

    public boolean isAnagram2(String s, String t){

        if(s.length() != t.length()) return false;

        int[] bucket = new int[26];

        for(int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i) - 'a'] ++;
            bucket[t.charAt(i) - 'a'] --;
        }

        for(int i : bucket) if(i != 0) return false;





        return true;
    }


    public int[] twoSum2(int[] nums, int target){
        int[] indexes = new int[2];

        //key - nums[i], value =i
        HashMap<Integer, Integer> myMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            if(myMap.containsKey(target - nums[i])){
                // return i and value of corresponding key
                indexes[0] = i;
                indexes[1] = myMap.get(target - nums[i]);
                break;
            }
            //if not add it to map
            myMap.put(nums[i], i);
        }

        return indexes;
    }

    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> twoSum = new HashMap<>();
        int[] resArray = new int[2];

        for(int i = 0; i < nums.length; i++){

            twoSum.put(nums[i], i);

             int temp = target - nums[i];
             if(twoSum.containsKey(target - nums[i])){
                 resArray[0] = i;
                 resArray[1] = twoSum.get(target - nums[i]);
                  return  resArray;
             }

        }

        return resArray;
    }

    public boolean isPalindrome(String s){

        String newS = "";

//        for(char c: s){
//            if(c != " " || c != )
//            newS += c;
//        }
        if (newS == "") return true;



        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs){

        if(strs.length == 0 || strs == null) return new ArrayList<>();

        HashMap<String, List<String>> myMap = new HashMap<>();

        for(String s: strs){
            int[] charArray = new int[26];
            for(int i = 0; i < s.length(); i++){
                charArray[s.charAt(i) - 'a'] ++;
            }

            String keyStr = new String(Arrays.toString(charArray));

            if(!myMap.containsKey(keyStr)) myMap.put(keyStr, new ArrayList<>());

            myMap.get(keyStr).add(s);
        }

        return new ArrayList<>(myMap.values());
    }

    public int[] topKFrequentElement(int[] nums, int k){
        int[] arr = new int[k];

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0 ) + 1);
        }

        //create bucketSort
        List<Integer>[] buckets = new List[nums.length + 1]; // +1 because aray index 0

        for(int key: map.keySet()){
            int frequency = map.get(key);
            if(buckets[frequency] == null) {
                // initialze the value to a new empty array list
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        // now we have to return the top k values
        // for that we have to build an array
        int[] topKValues = new int[k];
        int index = 0;

        //we want to loop from last to first
        for(int i = buckets.length - 1; i >= 0; i --){
            if(buckets[i] == null){
                continue; // we don't have elements in the last slots
                // so we continue decrement
            }
            // if values exists, emit the values
            for(int j = 0 ; j < buckets[i].size(); j++){
                topKValues[index] = buckets[i].get(j);
                index++;
            }
        }

        return topKValues;
    }

    public List<Integer> topKFrequent(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        //PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b ) -> b.getValue);

        return  null;
    }


    public int[] productExceptSelf(int[] nums){
        int[] res = new int[nums.length];

        res[0] = 1;

        int left = 1, right = 1;

        for(int i = 0; i < nums.length; i++){
            res[i] = left;
            left *= nums[i];
        }

        for (int j = nums.length - 1; j >= 0; j--){
            res[j] = right;
            right *= nums[j];
        }

        return res;
    }

    /** encode decode problem**/
    public String encode(List<String> strs){

        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();


    }

    public List<String> decode(String str){
        ArrayList<String> decodeList = new ArrayList<>();
        //int i = 0;

        for(int i = 0; i < str.length(); i++){
            int j = i;
            while (str.charAt(i) != '#') j++;

            //create the substring and get the length of each word
            int lengthOfWord = Integer.valueOf(str.substring(i, j));

            //skip all digits
            i = lengthOfWord + 1 + j; // dont understand why j is here.

            decodeList.add(str.substring(j + 1, i ));
        }

        return decodeList;
    }

    public int longestConsecutive(int[] nums){
        int length = 0;
        int maxLength = 1;

        Set<Integer> arrayAsASet = new HashSet<>();

        for(int i : nums) arrayAsASet.add(i);

        for(int i : nums){
            if(!arrayAsASet.contains(i - 1)){
                int count = 1; //for the current
                while ((arrayAsASet.contains(i + 1))){
                    i ++;
                    count ++;
                }
                maxLength = Math.max(count, maxLength);
            }
        }




        return maxLength;
    }
    public int maximumSubArray(int[] nums){
        int maxSum = 0, currentSum = 0;

        if(nums.length == 1) return nums[0];

        for(int n : nums){
            currentSum += n;
            maxSum = Math.max(maxSum, currentSum);

            if(currentSum < 0){
                currentSum = 0;
            }
        }
        return maxSum;
    }

    public int[][] insert(int[][] intervals, int[] newInterval){
        List<int[]> res = new ArrayList<>();

        for(int[] interval : intervals){
            if(newInterval == null || interval[1] < newInterval[0]){
                res.add(interval);
            }else if(interval[0] > newInterval[1]){
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            }else {
                //merge
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        if (newInterval != null) res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }

}
