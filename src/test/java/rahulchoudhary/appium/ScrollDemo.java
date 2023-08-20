package rahulchoudhary.appium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest {

	@Test
	public void scrollDemoTest() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
		
		//Scrolling down when we know where to scroll
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

		//scrolling when we don't have prior knowledge where to scroll
//		scrollDownAction();

	}

}
