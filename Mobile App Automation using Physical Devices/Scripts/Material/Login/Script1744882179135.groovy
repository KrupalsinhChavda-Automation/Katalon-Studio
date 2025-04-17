import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil

try {
	// Start Mobile Application
	String projectPath = System.getProperty("user.dir");
	System.out.println("Project Path: " + projectPath);
	Mobile.startApplication(projectPath + '\\MaterialLogin.apk', true)

	// Enter Email Address
	'Enter Email Address'
	Mobile.setText(findTestObject('Object Repository/Material/Material Login/txt_email'), Email, 10)

	// Enter Password
	'Enter Password'
	Mobile.setText(findTestObject('Object Repository/Material/Material Login/txt_password'), Password, 10)

	// 'Tap on Login button'
	'Tap on Login button'
	Mobile.tap(findTestObject('Object Repository/Material/Material Login/btn_login'), 0)

	// Verify Login process
	'Verify Login process'
	Mobile.verifyElementText(findTestObject('Object Repository/Material/Material Login/verify_helloWorld'), 'Hello world!')
	
	Mobile.closeApplication()

}catch(Exception ex) {

	// Failed Login process
	'Failed Login process'
	KeywordUtil.markFailed("Failed Login process")
}

