package com.appiumFrameworkTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AppiumDriverLocalService service;
	public AndroidDriver driver;

	@BeforeClass
	public void AppiumBase() throws MalformedURLException {
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C://Users//rk155//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Android9");
		options.setApp("D://JAVA Practice//appium//src//test//java//resources//General-Store.apk");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		// This is appium server url, //This is capabilities
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
}
