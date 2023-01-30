import java.lang.*;
import java.util.Scanner;

public class JobSelction {
	static int[] chooseJob(int n,int[][]jobs) {
		int[] arr=new int[2];
		int maxProfit=jobs[0][2],job=0,total=0,start=jobs[0][0],end=jobs[0][1];
		//Selecting a job with maximum earning.
		for(int i=0;i<n;i++) {
			total+=jobs[i][2];
			if(maxProfit<jobs[i][2]) {
				maxProfit=jobs[i][2];
				start=jobs[i][0];
				end=jobs[i][1];
			}
		}
		
		job+=1;//counting the number of jobs done by lokesh.
		//Checking if there are jobs remaining that he can do after doing the job with maximum earnings.
		for(int i=0;i<n;i++) {
			if(jobs[i][0]>end) {
				maxProfit=maxProfit+jobs[i][2];
				start=jobs[i][0];
				end=jobs[i][1];
				job+=1;
			}
		}
		//storing the results in array to return
		arr[0]=n-job;
		arr[1]=total-maxProfit;
		//returning the values to main method
		return arr;
	}

	public static void main(String[] args) {
		// Scanner class to take input from user.
		Scanner sc = new Scanner(System.in);
		//Taking the values from the user.
		System.out.print("Enter the number of Jobs: ");
		int n=sc.nextInt();
		int[][] jobs= new int[n][3];
		
		for(int i=0;i<n;i++) {
			//System.out.println("Enter strat-time end-time and earnings of job"+(i+1));
			for(int j=0;j<3;j++) {
				
				jobs[i][j]=sc.nextInt();
			}
		}
		//storing the returned array.
		int[] arr=chooseJob(n,jobs);
		//Displaying the output 
		System.out.println("Tasks remaining is: "+arr[0]);
		System.out.println("Earnings left is: "+arr[1]);
		
	}

}