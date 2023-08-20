package rahulchoudhary.appium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class DragDropDemo extends BaseTest {

	@Test
	public void scrollDemoTest() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

//		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
//				ImmutableMap.of("elementId", ((RemoteWebElement) source).getId(), "endX", 593, "endY", 528));

		dragAction(source, 593, 528);
		String text = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(text, "Dropped!");

	}

}
