package middle.Math;

/**
 * No.43 字符串相乘 （Microsoft)
 * 字符串模拟的题目好难。。纯找规律模拟，需要二刷背诵
 */
public class No_43 {
    public static  String multiply(String num1, String num2) {
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        if (n1 < 0 || n2 < 0) return "";
        int[] nums = new int[n1 + n2 + 2];
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        for (int i = n1; i >= 0; i --) {
            int a = arr1[i] - '0';
            for (int j = n2; j >= 0; j --) {
                int val = a * (arr2[j] - '0');
                val += nums[i + j + 1];
                nums[i + j] += val / 10;
                nums[i + j + 1] = val % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }

        while (sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String nums1 = "123";
        String nums2 = "45";
        No_43.multiply(nums1, nums2);
    }
}
