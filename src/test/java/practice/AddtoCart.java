package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddtoCart {
	@Test(dataProvider = "dataprovider_AddtoCart")
	public void addtoCartTest(String pName,int qty) {
		System.out.println("add to cart"+pName+"");
		
	}
	@DataProvider
	public Object[][] dataprovider_AddtoCart() {
		Object[][] objArr=new Object[4][2];
		objArr[0][0]="vivo_y83";
		objArr[0][1]=1;
		
		objArr[1][0]="bag";
		objArr[1][1]=10;
		
		objArr[2][0]="dell_laptop";
		objArr[2][1]=1;
		
		objArr[3][0]="appel_12";
		objArr[3][1]=1;
		return objArr;
		
		
		
	}

}
