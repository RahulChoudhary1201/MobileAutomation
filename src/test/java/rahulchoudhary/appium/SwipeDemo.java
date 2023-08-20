package rahulchoudhary.appium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class SwipeDemo extends BaseTest {

	@Test
	public void scrollDemoTest() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Photos\"]")).click();
		WebElement firstImage = driver.findElement(By.xpath("//android.widget.ImageView[1]"));
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"),
				"true");

//		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
//				((RemoteWebElement) firstImage).getId(), "direction", "left", "percent", 0.75));

		swipeAction(firstImage, "left");

		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"),
				"false");
	}

}
