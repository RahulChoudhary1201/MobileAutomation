package com.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions {

	AndroidDriver driver;

	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleRadio;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
	private WebElement maleRadio;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countyDropDown;

	@AndroidFindBy(id = "(//android.widget.Toast)[1]")
	private WebElement toastMsg;

//	String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
//	Assert.assertEquals(toastMsg, "Please enter your name");

	public void setName(String name) {
		nameField.sendKeys(name);
	}

	public void setGender(String gender) {
		if (gender.contains("female")) {
			femaleRadio.click();
		} else {
			maleRadio.click();
		}
	}

}
