import java.util.*;
public class ConnectCell
{
	

	public static int getRegionSize(int matrix[][],int row,int col)
	{
					//	System.out.println("row :"+row+"col: "+col);

		if(row<0 || col<0 || row>=matrix.length || col>=matrix[row].length)// boundray case 
			return 0;
		if(matrix[row][col]==0)
			return 0;

		matrix[row][col]=0;
		int size=1;
		for(int r=row-1; r<=row+1;r++){
			for(int c=col-1;c<=col+1;c++){
				if(r!=row || c!=col){
					size+=getRegionSize(matrix,r,c);
				//System.out.println(size+=getRegionSize(matrix,r,c));
				}

			}
		}
		return size;
	}


	public static int getBiggestRegion(int matrix [][])
	{
		int maxregion=0;
		for(int r=0; r<matrix.length;r++)
		{
			for(int c=0;c<matrix[r].length;c++){
				
				if(matrix[r][c]==1){
					int size=getRegionSize(matrix,r,c);
					System.out.println("size:: "+ size);
					maxregion=Math.max(size,maxregion);

				}
			}
		}
		return maxregion;
	}

	public static void main(String[] args) {


		int matrix[][]={{1,1,0,0},{0,1,1,0},{0,0,1,0},{1,0,0,0}};
		System.out.println("biggetst=::"+getBiggestRegion(matrix));				
		
	}
}