package org.awolart.fin.pv;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class AnnuitiesTest {
	
	Annuities annuities = new Annuities();
	
	//DataProvider for the data flow test
	@DataProvider
	 public static Object[][] dataProviderOrdinaryAnnuityArray() {
		double[] Cempty = {};
		double[] C = {1000.0,1500.0,2000.0};
		return new Object[][] {
			{Cempty,0.1,0},
			{C,0.9,1233.42}
		};
	}
	
	//Unit test for the data flow test
	@Test
	@UseDataProvider("dataProviderOrdinaryAnnuityArray")
	public void OrdinaryAnnuityArrayTest(double[] C, double y, double expected) {
		
		Assert.assertEquals(expected, annuities.OrdinaryAnnuity(y, C), 0.001);
		
	}
	
	//DataProvider for the black box test
	@DataProvider
	 public static Object[][] dataProviderOrdinaryAnnuityN() {
		return new Object[][] {
			{2, 0, 1000, 0},
			//{-1.0,	3,	1000,	-1}
			{2, 3, 0, 0},
			{-1.1, 3, -10000.01, 9100009.10},
		};
	}
	
	
	//Unit test for the black box test
	@Test
	@UseDataProvider("dataProviderOrdinaryAnnuityN")
	public void OrdinaryAnnuityNTest(double y, int n, double C, double expected) {
		
		
		
		Assert.assertEquals(expected, annuities.OrdinaryAnnuity(y, n, C), 0.001);
		
	}

}