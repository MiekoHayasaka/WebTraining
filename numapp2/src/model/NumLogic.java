package model;

public class NumLogic {
	public void execute(Num num) {
		String snum = num.getSnum();
		String[] snums = snum.split(",");
		int[] nums = new int[snums.length];

		for(int i=0;i<snums.length;i++) {
			int n = Integer.parseInt(snums[i]);
			nums[i] = n;
		}

		int sum=0;
		for(int i=0;i<nums.length;i++) {
			sum += nums[i];
		}

		int max=nums[0];
		for(int i=1;i<nums.length-1;i++) {
			if(nums[0]<nums[i]) {
				max=nums[i];
			}
		}
		int min=nums[0];
		for(int i=1;i>nums.length-1;i++) {
			if(nums[0]<nums[i]) {
				min=nums[i];
			}
		}

		num.setCount(nums.length);
		num.setSum(sum);
		num.setMax(max);
		num.setMin(min);
	}
}
