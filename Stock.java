
import java.util.ArrayList;
import java.util.List;
import java.util.*;



public class Stock
{

public class Interval {
	private int sellingPrice;
	private int  buyingPrice;
	private int buyingDay;
	private int sellingDay;
	public int getBuyingDay() {
		return buyingDay;
	}
	public void setBuyingDay(int buyingDay) {
		this.buyingDay = buyingDay;
	}
	public int getSellingDay() {
		return sellingDay;
	}
	public void setSellingDay(int sellingDay) {
		this.sellingDay = sellingDay;
	}
	public int getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public int getBuyingPrice() {
		return buyingPrice;
	}
	public void setBuyingPrice(int buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	@Override
	public String toString() {
		return "Interval [sellingPrice=" + sellingPrice + ", buyingPrice=" + buyingPrice + ", buyingDay=" + buyingDay
				+ ", sellingDay=" + sellingDay + "]";
	}
	
	
}
	public  List<Interval> interval=new ArrayList<>();

	public void stockBuySell(int price[],int day) {
		int buy,buyDay;
		buy=price[0];
		buyDay=1;
		
		for(int i=1;i<day;i++) {
			if(buy>price[i])
			{
				buy=price[i];
				buyDay=i+1;
			}
			else if(buy<price[i])
			{
				for(;i<day && price[i-1]<price[i];++i); // this loop ended once price decreased 
				Interval ob= new Interval();
				//System.out.println("i:"+i+"Day:"+day);
				ob.setSellingPrice(price[i-1]);
				ob.setSellingDay(i);
				ob.setBuyingPrice(buy);
				ob.setBuyingDay(buyDay);
				interval.add(ob);
				
				if(i+1<day)
				{
					buy=price[i+1];
					buyDay=i+1;
					i++;
				}
				
			}
		}
		calculateProfit();
	}
	public  void calculateProfit() 
	{
		int profit=0;

		for(Interval i:interval) {
			if(interval.size()>0)
			{
				profit+=(i.getSellingPrice()-i.getBuyingPrice());
			}
			
		}
		System.out.println("profit::"+profit);
		
	}
	
	
	public static void main(String[] args) {
		Stock ob=new Stock();
		
		int price[]= {5,1,4,6,7,8,4,3,7,9};
		
		if(price.length<=1)
		{
			System.out.println("");
		}
		else {
			ob.stockBuySell(price,price.length);
			
		}
		//ob.calculateProfit();
		
		
		
		
	}
}

