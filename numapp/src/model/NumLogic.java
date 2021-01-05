package model;

public class NumLogic {
	public void execute(Num num){
		String[] nums=num.getOrg().split(",");
		int first=Integer.parseInt(nums[0]);
		int max,min,sum;
		max=min=sum=first;

		for(int i=1;i<nums.length;i++){
			int pick=Integer.parseInt(nums[i]);
			if(pick>max){
				max=pick;
			}
			if(pick<min){
				min=pick;
			}
			sum+=pick;
		}
		num.setLen(nums.length);
		num.setMax(max);
		num.setMin(min);
		num.setSum(sum);
	}
}