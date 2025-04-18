package status
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.remote.RemoteWebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.HttpURLConnection
import java.net.URL
import java.util.Base64
import groovy.json.JsonOutput

class MarkPassedFailed{

	@Keyword
	static void MarkPassFail(String status, String reason) {

		RemoteWebDriver driver = (RemoteWebDriver) DriverFactory.getWebDriver()
		//			if (driver == null) {
		driver = (RemoteWebDriver) MobileDriverFactory.getDriver()
		//			}
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		if(status=="Passed") {
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
		}
		else {
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
		}
	}
}

