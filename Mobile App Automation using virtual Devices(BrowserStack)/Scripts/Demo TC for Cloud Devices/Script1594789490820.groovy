

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.appium.driver.AppiumDriverManager
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.remote.DesiredCapabilities
import com.kms.katalon.core.mobile.driver.MobileDriverType

/*
// Set the Browserstack credentials: USERNAME and ACCESS_KEY
String browserStackServerURL = "https://krupalsinhchavda1:rNvmAH9tMv1Uxaesnp7M@hub-cloud.browserstack.com/wd/hub";

// Define Desired Capabilities
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability("app", "bs://c33a5bb6d6a6928d0c456e738289755c366ae1c6")
capabilities.setCapability("device", "Samsung Galaxy S10e");
capabilities.setCapability("os_version", "9.0");

// Define Appium server
AppiumDriverManager.createMobileDriver(MobileDriverType.ANDROID_DRIVER, capabilities, new URL(browserStackServerURL));*/

// Write your code here

// Start Mobile Application
Mobile.startApplication('bs://1a5d8e533534d4a28c65f60a023cf89244ef3274', true)

// Enter login details
Mobile.setText(findTestObject('Login/Txt_Username'), "manager@ccs", 10)
Mobile.pressBack()
Mobile.setText(findTestObject('Login/Txt_Password'), "manager", 10)
Mobile.pressBack()

//Click on Login
Mobile.tap(findTestObject('Login/Btn_Login'), 10)

// Verify loged in successfully
Mobile.waitForElementPresent(findTestObject('Object Repository/Login/Box_search'), 10)
Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Box_search'), 10)
Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Img_at_home'),10)
