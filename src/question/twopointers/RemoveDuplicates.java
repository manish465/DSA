package question.twopointers;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 3, 3, 6, 9, 9};

        System.out.println(soution(nums));
        System.out.println(soution1(nums));
    }

    public static int soution(int[] nums){
        int last = Integer.MAX_VALUE;
        int length = 0;

        for(int num : nums){
            if(last != num) {
                length++;
                last = num;
            }
        }

        return length;
    }

    public static int soution1(int[] nums){
        int nonDuplicateIdx = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[nonDuplicateIdx - 1] != nums[i]){
                nums[nonDuplicateIdx] = nums[i];
                nonDuplicateIdx++;
            }
        }

        return nonDuplicateIdx;
    }
}
