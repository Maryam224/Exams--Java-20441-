package SolvedQuestions;


public class SolvedExamQuestions {
	


	/** Exam 2021A moed-A 85 Question#1 **/
	
	public static int minPrice(int mat[][]) {
		return minPrice(mat,0,1);
	}
	
	private static int minPrice(int mat[][],int lastS,int curS) {//lastS= last station ,curS=current station
		
		if(curS==mat.length-1)//arrived to the last station
			return mat[lastS][curS];
		
		int stop=mat[lastS][curS]+minPrice(mat,curS,curS+1);
		int dontStop=minPrice(mat,lastS,curS+1);
		
		
		 return Math.min(dontStop,stop);
		 
	}//end method 

	
	/*////////////////////////////////////////////
	public static int minPrice(int mat[][]) {
		return minPrice(mat,0,1,0);
	}
	
	private static int minPrice(int mat[][],int lastS,int curS,int lastPrice) {//lastS= last station ,curS=current station//
		
		if(curS==mat.length-1)//arrived to the last station
			return mat[lastS][curS]+lastPrice;
		
		int stop=minPrice(mat,curS,curS+1,mat[lastS][curS]+lastPrice);
		int dontStop=minPrice(mat,lastS,curS+1,lastPrice);
		
		
		 return Math.min(dontStop,stop);
		 
	}//end method 
	
	*//////////////////////////////////////////////
	/** Exam 2021A moed-A 85 Question#2 **/
	public static boolean findAverage(int[] arr,double x) {
		double sum=sumArray(arr);
		int len=arr.length;
		int left=0;
		int right=arr.length-1;
		while(left<=right) {
			double avg=sum/len;
			if(avg==x) {
				System.out.println(left+"---"+right);
				return true;
			}
			if(avg>x) {
				sum=sum-arr[right];
				right--;
				len--;
			}
			else {
				sum=sum-arr[left];
				left++;
				len--;
			}
		
		}
		System.out.println("no such sequence");
		return false;
	}
	
	/**
	 * this is a helper method for findAverage(int[] arr,double x)
	 */
	private static int sumArray(int[] arr) {
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		return sum;
		
	}
	
	//end
	
	/** Exam September 2020B 96 Question#1 **/
	public static int maxSumKnight(int[][] mat) {
		int tmp=maxSumKnight(mat,0,0);
		if(tmp==0)return -1;
		return tmp;

	}
	
	
	
	public static int maxSumKnight(int[][] m,int i,int j) {
		if(i==m.length-1 && j==m.length-1)
			return m[i][j];
		int tmp=m[i][j];
		m[i][j]=-100;//Been Here 
		int val1=0,val2=0,val3=0,val4=0,val5=0,val7=0,val6=0,val8=0;
		if(i+2<m.length && j+1<m.length)
			if(Math.abs((m[i+2][j+1])-(tmp))<=1) {
				 val1=maxSumKnight(m,i+2,j+1);
				}
		if(i+2<m.length && j-1>=0)
			if(Math.abs((m[i+2][j-1])-(tmp))<=1) {
				 val2=maxSumKnight(m,i+2,j-1);
				}
		if(i-2>=0 && j+1<m.length)
			if(Math.abs((m[i-2][j+1])-(tmp))<=1) {
				 val3=maxSumKnight(m,i-2,j+1);
				}
		if(i-2>=0 && j-1>=0)
			if(Math.abs((m[i-2][j-1])-(tmp))<=1) {
				 val4=maxSumKnight(m,i-2,j-1);
				}
		if(i+1<m.length && j+2<m.length)
			if(Math.abs((m[i+1][j+2])-(tmp))<=1) {
				 val5=maxSumKnight(m,i+1,j+2);
				}
		if(i+1<m.length && j-2>=0)
			if(Math.abs((m[i+1][j-2])-(tmp))<=1) {
				 val6=maxSumKnight(m,i+1,j-2);
				}
		if(i-1>=0 && j+2<m.length)
			if(Math.abs((m[i-1][j+2])-(tmp))<=1) {
				 val7=maxSumKnight(m,i-1,j+2);
				}
		if(i-1>=0 && j-2>=0)
			if(Math.abs((m[i-1][j-2])-(tmp))<=1) {
				 val8=maxSumKnight(m,i-1,j-2);
			}
		m[i][j]=tmp;
		if (!(val1==0 && val2==0 && val3==0 && val4==0 && val5==0 && val7==0 && val6==0 && val8==0)) {
		int max= Math.max(Math.max(Math.max(val1,val2),Math.max(val3,val4)),Math.max(Math.max(val5,val6),Math.max(val7,val8)));
		return max+m[i][j];
		}
		return 0;
	}
	//end
	
	/** Exam September 2020B 96 Question#2 **/
	
	/**
	 * This is a class we need to use for this question
	 */
	public class Range{//assume _small <= _big 
		private int _small,_big;
		public Range(int s,int b) {
			_small=s;
			_big=b;
		}
		public int getSmall() {return _small;}
		public int getBig() {return _big;}
	}
	/**
	 * This function returns the min positive value
	 * exists in one of the the ranges in Range[] array each
	 * @param rangeA is an ascending array of ranges 
	 * @return
	 */
	public static int minimalPositive (Range[] rangeA) {
		int high=rangeA.length-1;
		int low=0;
		int mid=(high+low)/2;
		Range cur=rangeA[mid];

		while (low<=high) {
			mid=(high+low)/2;
			cur=rangeA[mid];
			
			if(cur.getSmall()<=0 && cur.getBig()>0) {
				return 1;
			}	
			else if(cur.getSmall()<=0 && cur.getBig()<=0) {
					if(low==high) return -1;
				low=mid+1;
			}
			else if (cur.getSmall()>0 && cur.getBig()>0 ) {
					if(low==high) return cur.getSmall();
				high=mid;
			}
		}
		return -1;//not needed really 
	}
	
	
	public static void main(String[] args) {
		/** Tester for Exam September 2020B 96 Question#2 **/
		
		Range[] a=new Range[5];
		SolvedExamQuestions s= new SolvedExamQuestions();
		//some_array=[-70,-69,...,-60,-50,-49,...,-40,-30,-29,...,-20,-10,...,0,1,2,6,...,9,10]
		//then the range array suited for some_array is the following :
		a[0]=s.new Range(-70,-60);
		a[1]=s.new Range (-50,-40);
		a[2]=s.new Range (-30,-20);
		a[3]=s.new Range (-10,2);
		a[4]=s.new Range (6,10);
			
		//int minPos=minimalPositive(a);
		//System.out.println(minPos);
		//end tester for Q2
		
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
/** Exam of 2020B 84 Question#1 **///Hard
	
	public static void findWord(char[][]arr, String word) {
		int[][] path=new int[arr.length][arr.length];
		if(findWord(arr,0,0,path,1,word,word)==true) {
			print2D(path);
		}
		else {
			System.out.println("No such sequence");
		}
		
		
	}
	private static boolean findWord(char[][]arr,int i,int j,int [][]path,int count,  String word,String again){
		
		if(i==arr.length || j==arr.length) return false;
		
		if(word.length()==1 && arr[i][j]==word.charAt(0)) {
			path[i][j]=count;
			return true;
			}

		
		boolean goRight=false;
		boolean goDown=false;
		
		if(arr[i][j]==word.charAt(0)) {

			if(j+1<arr.length) 
			{
				if(arr[i][j+1]==word.charAt(1)) {
					path[i][j]=count;
					count++;
					goRight=findWord(arr,i,j+1,path,count,word.substring(1),again);
				}
				else {
					//path[i][j]=0;//?
					goRight=findWord(arr,i,j+1,path,1,again,again);
					
				}
				
				
			}
			if(goRight==false && i+1<arr.length) 
			{
				if(arr[i+1][j]==word.charAt(1)) {
					path[i][j]=count;
					count++;
					goDown=findWord(arr,i+1,j,path,count,word.substring(1),again);
				}
				else {
					path[i][j]=0;
					goDown=findWord(arr,i+1,j,path,1,again,again);		
				}
				
			}
			
		}
		
		
		else {
			goRight=findWord(arr,i,j+1,path,1,again,again);
			if(goRight==false)
				goDown=findWord(arr,i+1,j,path,1,again,again);
		}
				
		return goDown||goRight;
	}
	
	//end needed method for Q1
	
	/**
	 * this method prints the 2D array in matrix shape
	 * @param matrix of characters 
	 **/
	public static void print2D(char [][]matrix) {//helper - this method is used for Q1
		
		for (int i = 0; i < matrix.length; i++) {
			
			for (int j = 0; j < matrix[i].length; j++) {
		        System.out.print(matrix[i][j] + " ");
		    }
		    System.out.println();
		}
		
		
	}
	
	public static void print2D(int [][]matrix) {//helper - this method is used for Q1
		
		for (int i = 0; i < matrix.length; i++) {
			
			for (int j = 0; j < matrix[i].length; j++) {
		        System.out.print(matrix[i][j] + " ");
		    }
		    System.out.println();
		}
		
		
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*if this was the given matrix
	 * [ 1 , 1 , -1 , 1 , 1]
	 * [ 1 , 0 ,  0 ,-1 , 1]
	 * [ 1 , 1 ,  1 , 1 ,-1]
	 * [-1 ,-1 ,  1 , 1 , 1]
	 * [ 1 , 1 , -1 ,-1 , 1]
	 * the answer would be: 9
	 * 
	 */
	/** Exam of 2020A 84 Question#1 **///
	public static int findMaximum(int[][]mat){
		return findMaximum(mat,0,0);
	}
	public static int findMaximum(int[][]m,int i,int j){
		final int BEEN=-10;
		if (!((i+1<m.length && m[i+1][j]>=0)||(i%2==0 && j+1<m[0].length && m[i][j+1]>=0) ||
		(i%2==1 && j-1>=0 && m[i][j-1]>=0))){//this means end of path
		return m[i][j];
		}
		int tmp=m[i][j];
		m[i][j]=BEEN;
		
		int left=-1,right=-1,down=-1;
		if(i+1<m.length && m[i+1][j]>=0){
			down = findMaximum(m,i+1,j);
		}
		if(i%2==0 && j+1<m[0].length){
			right=findMaximum(m,i,j+1);
		}
		else if(i%2==1 && j-1>=0){
			left=findMaximum(m,i,j-1);	
		}
		m[i][j]=tmp;
		if(down==-1 && left==-1 && right==-1 )return -1;
		return m[i][j]+Math.max(Math.max(down,right),left);

	}//end 
	
	/** Exam of 2020A 84 Question#1 **/
	/*
	 * how many strictly increasing sub arrays 
	 * sub array is an array with minimum length equal to 2
	 * sub array is made of adjacent cells of the original array 
	 * example [1,2,4,4,5]:possible sub arrays :
	 * [1,2],[1,2,4],[2,4],[4,5]
	 * with the answer 4 (number of sub array)
	 * 
	 * Time complexity :O(n^2)
	 * Space complexity:O(1)
	 */
	
	public static int strictlyIncreasing(int[]a){
		int c=0;
		for(int i=0;i<a.length-1;i++){//n-1
			
			for(int j=i+1;j<a.length&&a[j-1]<a[j];j++){
			c++;
				
			}
		}
		return c;
	}
	//end
	
	
	
	/** Exam of 2020A 87 Question#1 **/
	/*
	 * how many paths (from [0][0] to [m.length][m.length]) contain k turns 
	 * path is allowed to the right or down 
	 * turn is going in an angel shape:
	 * from right path to down or from down path to right .
	 * 
	 *
	 */
	public static int totalWays(int[][]mat,int k){
		return totalWays(mat,0,1,k,true)+totalWays(mat,1,0,k,false);
		
	}
	public static int totalWays(int [][]m,int i,int j,int k,boolean rightPath){
		if(i==m.length-1 && j==m[0].length-1 ){
			if(k==0)
			return 1;
			else return 0;
		}
		int right=0,down=0;
		if(i+1<m.length){//going down
			if(rightPath==true)
				right=totalWays(m,i+1,j,k-1,false);
			if(rightPath==false)
				right=totalWays(m,i+1,j,k,false);
			
			
		}
		if(j+1<m[0].length){//going right
			if(rightPath==true)
				down=totalWays(m,i,j+1,k,true);
			if(rightPath==false)
				down=totalWays(m,i,j+1,k-1,true);
		}
		return right+down;

	}//end
	
	
	/** Exam of 2020A 87 Question#2 **/
	
	/* print all Triplets in the array which their product is equal to num
	 * 
	 * example:a={1,2,3,4,5,7,8,9,10},num=40 => (1,4,10),(1,5,8),(2,4,5) 
	 * 
	 * TC:O(N^2)
	 * SC:O(1)
	 * 
	 */
	public static void printTriplets(int[]a,int num){
		int low,high;
		int tmp;
		for(int i=0;i<a.length;i++) {//this is the first number from index 0 to len-2
			tmp=num;
			if(tmp%a[i]==0) {//we consider the first number only if its ok to divide
				tmp=tmp/a[i];//the rest of the number after divided by the first
				low=i+1;//checking for the second number from i+1 
				high=a.length-1;//checking for the third number from len-1
				while(low<high) {
					if(tmp%a[low]!=0) {
						low++;
					}
					else if(tmp/a[low]<a[high]) high--;//since the array is in ascending order
					else if(tmp/a[low]>a[high]) low++;//this means wrong first and second,check for another second
					else if(tmp/a[low]==a[high] ) {
						
						System.out.println(a[i]+" "+a[low]+" "+a[high]);
						low++;//check for another second(bigger)
						high--;//check for another third(smaller)
						
					} 

				}
			}
			
		}
		
	}//end
	
	
	
	
	
	/** Exam of 2019A 84 Question#1 **/
	public static boolean sumPower(int num){
		return sumPower(num,0);
	}
	public static boolean sumPower(int num,int i){
		int tmp=(int) Math.pow(3,i);
		
		if(num==tmp)return true;
		if(tmp>num)return false;
		
		
		return sumPower(num-tmp,i+1)||sumPower(num,i+1);
		
		
		
	}//end
	
	/** Exam of 2019A 84 Question#2 **/
	/*
	 * This method returns index of where the array is "split"
	 * in two halves, left(0 to i) , right side (i+1 to a.length-1)
	 * where the difference between left side average and right side average is the maximum
	 * among other partitions.
	 * TC:O(n)
	 * SC:O(1)
	 */
	public static int average(int[]a){
		double sum1=0;//left side sum
		double sum2=sumArrayQ2(a);//right side sum
		double avg1,avg2;//avg1=left side average, avg2=right side average
		double maxdiff=0;//the maximum difference between left side and right side averages
		int index=0;//index we need to return
		
		/*
		 * we start from i=0 for left side and i+1 for right side
		 * add to the left side sum a[i]
		 * remove from right side sum a[i]
		 * calculate the new average.
		 * check if the difference is bigger than the previous,
		 * if so assign current diff to be maxdiff and change the value of index to current i
		 */
		for(int i=0;i<a.length-1;i++){
			sum1=sum1+a[i];
			sum2=sum2-a[i];
			avg1=(sum1/(i+1));
			avg2=(sum2/(a.length-(i+1)));
			double diff=Math.abs(avg1-avg2);
			
			if(diff>maxdiff){
			maxdiff=diff;
			index=i;
			}
			
		}
		return index;

		} 
	
		public static double sumArrayQ2(int[]a){
			double sum=0;
			for(int i=0;i<a.length;i++){
			sum+=a[i];	
			}
			return sum;
		}//end
		
		/** Exam of 2018A 85 Question#1 **/
		public static int longestSlope(int [][]mat,int num){
			return longestSlope(mat,0,0,num,0);
		}

		public static int longestSlope(int [][]m,int i,int j,int num,int max) {
			if(j==m[0].length)
				return longestSlope(m,i+1,0,num,max);
			if(i==m.length)
				return max;
			
			int curSlope=countSlope(m,i,j,num,m[i][j],0);
			if(curSlope>max)
				max=curSlope;
			return longestSlope(m,i,j+1,num,max);	
		}
		public static int countSlope(int[][]m,int i,int j,int num,int n,int k) {
			
			if(i==m.length || j==m[0].length || i<0 || j<0) {
				return k;
			}

			if(m[i][j]!=n-(k*num)) return k;
			
			final int BEEN=-100;
			int tmp=m[i][j];
			m[i][j]=BEEN;
			
			int right=0,down=0,left=0,up=0;
			right = countSlope (m,i,j+1,num,n,k+1);
		    left = countSlope (m,i,j-1,num,n,k+1);
		    down = countSlope (m,i+1,j,num,n,k+1);
		    up = countSlope (m,i-1,j,num,n,k+1);

			m[i][j]=tmp;
			return Math.max(Math.max(up,left),Math.max(down,right));

		}
		//end 2018A 85 Q1

		

		
		
		
}
