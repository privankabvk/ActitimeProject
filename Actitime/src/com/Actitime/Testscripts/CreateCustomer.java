package com.Actitime.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrary.Baseclass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.ObjectRepository.HomePage;
import com.Actitime.ObjectRepository.TaskPage;

public class CreateCustomer extends Baseclass {
	
	
	@Test
	public void createcustomer() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.getTasktab().click();
		TaskPage tp=new TaskPage(driver);
		tp.getAddnewbtn().click();
		tp.getNewcust().click();
		FileLibrary f1=new FileLibrary();
		String customer = f1.readDataFromExcel("Data", 2, 1);
		tp.getCustname().sendKeys(customer);
		String description = f1.readDataFromExcel("Data", 3, 2);
		tp.getCustdesp().sendKeys(description);
		tp.getCreatebtn().click();
		String expectedresult = customer;
		String actualresult = driver.findElement(By.xpath("(//div[.='"+customer+"'])[2]")).getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(actualresult, expectedresult);
		
	}

}
