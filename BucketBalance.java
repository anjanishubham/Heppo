import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BucketBalance {
	
	public static  Stack<Character> st=new Stack();
	
	public static boolean isBucketBalance(char currentChar,char popupChar)
	{
		//System.out.println(currentChar +"  "+ popupChar);
		switch(currentChar) {
		case ']':
		{
			if(popupChar=='[')
				return true;
			else return false;
		}
		case '}':{
			if(popupChar=='{') 
				return true;
			else return false;
		}
			
		case ')':
		{
			if(popupChar=='(')
				return true;
			else return false;
		}
		default: return false;
		}
	}
	
	
	
	public static void main(String[] args) {
		
		String str="[[{{((8978]979))}}]]";
		int i=0;
		while(i<str.length()) {
			
			if(str.charAt(i)=='[' ||str.charAt(i)=='{' ||str.charAt(i)=='(') {
				//System.out.println("pushed char"+str.charAt(i));
				st.push(str.charAt(i));

			}
			else if(str.charAt(i)==']' ||str.charAt(i)=='}' ||str.charAt(i)==')')
			{
				if(st.size()>0)
				{
					if(!isBucketBalance(str.charAt(i),st.pop())){
						break;
					}
				}
			}
			i++;
				
		}
		if(i==str.length())
		{
			System.out.println("Bucket is Balanced");

		}
		else
			System.out.println("Bucket is not Balanced");


		
		
	}
	

}
