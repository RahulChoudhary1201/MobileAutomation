package rahulchoudhary.appium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class GeneralStore extends BaseTest {

	@Test
	public void formFillingTestCase_1() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rahul Choudhary");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Austria']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		// For capturing toast msgs from the screen.
//		String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
//		Assert.assertEquals(toastMsg, "Please enter your name");

		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));

		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

		for (int i = 0; i < productCount; i++) {
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i)
					.getText();

			if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(
				driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

		String checkoutPageProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName"))
				.getText();
		Assert.assertEquals(checkoutPageProduct, "Jordan 6 Rings");

	}

}
