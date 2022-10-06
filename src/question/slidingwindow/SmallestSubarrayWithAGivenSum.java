package question.slidingwindow;

public class SmallestSubarrayWithAGivenSum {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 1, 5, 2, 3, 2};
        int s=7;

        System.out.println(solution(arr,s));
    }

    public static int solution(int arr[],int s){
        int start = 0;
        int end = 0;
        int sum = 0;

        int result = Integer.MAX_VALUE;

        while (end < arr.length){
            sum += arr[end];

            while (sum >= s){
                int length = end - start + 1;
                result = Math.min(result,length);
                sum -= arr[start];
                start++;
            }
            end++;
        }

        return result;
    }
}
