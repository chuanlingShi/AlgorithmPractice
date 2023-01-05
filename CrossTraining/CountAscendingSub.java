package CrossTraining;

import java.util.*;

public class CountAscendingSub {
    Set<List<Integer>> lists;
    public int numIncreasingSubsequences(int[] nums) {
        // Write your solution here
        lists = new HashSet<>();
        recursion(nums,0,new ArrayList());
        return lists.size();
    }

    void recursion(int[] nums,int curr,List<Integer> temp){
        if(temp.size() >= 1){
            lists.add(new ArrayList(temp));
        }

        for(int i = curr;i < nums.length; i++)
        {
            if(temp.size()==0 || temp.get(temp.size()-1) <= nums[i])
            {
                temp.add(nums[i]);
                recursion(nums,i+1,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}
