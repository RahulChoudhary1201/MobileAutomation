package rahulchoudhary.appium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Assingment1 extends BaseTest {

	@Test
	public void scrollDemoTest() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(By.id("io.appium.android.apis:id/two_buttons")).click();
		driver.findElement(By.id("android:id/button2")).click();
		driver.findElement(By.id("io.appium.android.apis:id/two_buttons2")).click();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("io.appium.android.apis:id/two_buttons2ultra")).click();
		driver.findElement(By.id("android:id/button2")).click();
		driver.findElement(By.id("io.appium.android.apis:id/select_button")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Command two']")).click();

		String message = driver.findElement(By.id("android:id/message")).getText();
		Assert.assertEquals(message, "You selected: 1 , Command two");

		driver.navigate().back();

		WebElement ele = driver.findElement(By.id("io.appium.android.apis:id/progress_button"));
		ele.click();
		driver.findElement(By.id("io.appium.android.apis:id/text_entry_button")).click();

		driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys("Rahul");
		driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("RahulPassword");
		driver.findElement(By.id("android:id/button1")).click();

	}

}
