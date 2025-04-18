import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil

try {
	
	// Start Mobile Application
	Mobile.startApplication('bs://1a5d8e533534d4a28c65f60a023cf89244ef3274', true)

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
	
	// Marking Test cases passed
	KeywordUtil.markPassed("Login passed")
	
	Mobile.closeApplication()
	
	

}catch(Exception ex) {

	// Failed Login process
	'Failed Login process'
	KeywordUtil.markFailed("Failed Login process")
	Mobile.closeApplication()
}

