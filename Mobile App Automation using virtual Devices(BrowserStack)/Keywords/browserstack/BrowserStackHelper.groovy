package browserstack
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.remote.RemoteWebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

class BrowserStackHelper {

	// Update your BrowserStack credentials
	static String username = "krupalsinhchavda1"
	static String accessKey = "rNvmAH9tMv1Uxaesnp7M"

	/**
	 * Updates the BrowserStack session status (pass/fail) with a reason
	 * @param status - 'passed' or 'failed'
	 * @param reason - reason text to show
	 */
	@Keyword
	static void updateSessionStatus(String status, String reason) {
		try {
			RemoteWebDriver driver = (RemoteWebDriver) DriverFactory.getWebDriver()
//			if (driver == null) {
				driver = (RemoteWebDriver) MobileDriverFactory.getDriver()
//			}
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			if(status=="passed") {
				jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
			}
			else {
				jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
			}

			/*String sessionId = driver.getSessionId().toString()
			String auth = username + ":" + accessKey
			String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes())

			URL url = new URL("https://api.browserstack.com/app-automate/sessions/" + sessionId + ".json")
			HttpURLConnection connection = (HttpURLConnection) url.openConnection()
			connection.setRequestMethod("PUT")
			connection.setRequestProperty("Authorization", "Basic " + encodedAuth)
			connection.setRequestProperty("Content-Type", "application/json")
			connection.setDoOutput(true)

			String body = "{\"status\":\"" + status + "\",\"reason\":\"" + reason + "\"}"
			connection.getOutputStream().write(body.getBytes("UTF-8"))

			int responseCode = connection.getResponseCode()
			println("BrowserStack update response code: " + responseCode)

			connection.disconnect()*/
		
		} catch (Exception e) {
			println("Error updating BrowserStack session status: " + e.getMessage())
		}
	}
}
