import java.util.*;
public class CommonChild{

	public static int commonChildLength(String str1,String str2){
		int maxLength[][]=new int[str1.length()+1][str2.length()+1];
		for(int i=0;i<=str1.length();i++)
		{
			for(int j=0;j<=str2.length();j++){
				
				if(i==0 || j==0)
					maxLength[i][j]=0;
				else if(str1.charAt(i-1)==str2.charAt(j-1))
					maxLength[i][j]=maxLength[i-1][j-1]+1;
				else{

					maxLength[i][j]=Math.max(maxLength[i][j-1],maxLength[i-1][j]);
				}
			}
		}
		return maxLength[str1.length()][str2.length()];

	}

	public static void main(String[] args) {

		String str1="H";
		String str2="H";
		
		System.out.println("commonChildLength :"+ commonChildLength(str1,str2));
	}
}