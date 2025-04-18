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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable


import org.openqa.selenium.Keys as Keys


try {
	
	// Start Mobile Application
	Mobile.startApplication('bs://1a5d8e533534d4a28c65f60a023cf89244ef3274', true)

	// Tap on new account creation link
	'Tap on new account creation link'
	Mobile.tap(findTestObject('Object Repository/Material/Material Create one/link_CreateOne'), 10)

	// Enter Name
	'Enter Name'
	Mobile.setText(findTestObject('Object Repository/Material/Material Create one/txt_name'), Name, 0)

	// Enter Address
	'Enter Address'
	Mobile.setText(findTestObject('Object Repository/Material/Material Create one/txt_address'), Address, 0)

	// Enter Email
	'Enter Email'
	Mobile.setText(findTestObject('Object Repository/Material/Material Create one/txt_email'), Email, 0)

	// Enter Mobile Number
	'Enter Mobile Number'
	Mobile.setText(findTestObject('Object Repository/Material/Material Create one/num_mobileNumber'), Mo_Number, 0)

	// Enter Password
	'Enter Password'
	Mobile.setText(findTestObject('Object Repository/Material/Material Create one/txt_password'), Password, 0)

	// Re-Enter Password
	'Re-Enter Password'
	Mobile.scrollToText('CREATE ACCOUNT')
	Mobile.setText(findTestObject('Object Repository/Material/Material Create one/txt_reenterPassword'),Re_Password, 0)

	// Tap on Create Account button
	'Tap on Create Account button'
	Mobile.scrollToText('CREATE ACCOUNT')
	Mobile.tap(findTestObject('Object Repository/Material/Material Create one/btn_createAccount'), 10)

	// Verify Account creation
	'Verify Account creation'
	Mobile.verifyElementText(findTestObject('Object Repository/Material/Material Create one/verify_helloWorld'), 'Hello world!')

	// Marking Test cases passed
	KeywordUtil.markPassed("Account Creation has been Passed")
	Mobile.closeApplication()


}catch(Exception ex) {

	// Failed Account creation
	'Failed Account creation'
	KeywordUtil.markFailed("Account Creation has been Failed")
	Mobile.closeApplication()
}

