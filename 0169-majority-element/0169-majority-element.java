// class Solution {
//     public int majorityElement(int[] nums) {
        
//         int candidate = 0;
//         int count = 0;

//         for(int num : nums){
//             if(count == 0){
//                 candidate = num;
//             }

//             if(num == candidate){
//                 count ++;
//             }
//             else{
//                 count --;
//             }
//         }
//         return candidate;
//     }
// }

import java.util.HashMap;

class Solution{
    public int majorityElement(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);

            if(map.get(num) > nums.length / 2){
                return num;
            }
        } 
        return -1;
    }
}