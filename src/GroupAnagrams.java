import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs.length == 0){
            return null;
        }

        if(strs.length == 1){
            return new ArrayList<>();
        }

        HashMap<String, List<String>> myMaps = new HashMap<>();
        for(String s: strs){
            char[] characters = s.toCharArray();
            Arrays.sort(characters);

            String tempStringToCheckAsKey = String.valueOf(characters);

            if(myMaps.containsKey(tempStringToCheckAsKey)){
                myMaps.get(tempStringToCheckAsKey).add(s);
            }else {
                myMaps.put(tempStringToCheckAsKey, new ArrayList<>());
                myMaps.get(tempStringToCheckAsKey).add(s);
            }

        }

        return new ArrayList<>(myMaps.values());
    }
}
