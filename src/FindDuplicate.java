import java.util.HashSet;

public class FindDuplicate {
    public static void main(String[] args) {


        int[] nums = {1,1,3,3,4,3,2,4,2};

        FindDuplicate findDuplicate = new FindDuplicate();
        System.out.println((findDuplicate.isContain(nums)));

        System.out.printf("**");
    }

    public boolean isContain(int[] nums){
        HashSet<Integer> vals = new HashSet<>();
        for(int num: nums){
            if(vals.contains(num)){
             //   System.out.println("ll");
                return true;
            }else{
                vals.add(num);
            }
        }
    //    System.out.println("bb");
        return false;
    }
}
