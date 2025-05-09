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
import org.openqa.selenium.Keys as Keys


'Launch browser'
WebUI.openBrowser('')

WebUI.maximizeWindow()

'Navigate to url http://automationexercise.com'
WebUI.navigateToUrl('http://automationexercise.com/')

'Verify that home page is visible successfully'
WebUI.waitForElementVisible(findTestObject('Object Repository/Home Page/Menu_Home'), GlobalVariable.Long_Timeout)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Home Page/Menu_Home'), 'style', 'color: orange;', GlobalVariable.Short_Timeout)

// Verify Img home page
WebUI.verifyElementVisible(findTestObject('Object Repository/Home Page/img_Home'), FailureHandling.OPTIONAL)

'Click on "Products" button'
WebUI.waitForElementVisible(findTestObject('Object Repository/Home Page/Menu_Products'), 10)
WebUI.click(findTestObject('Object Repository/Home Page/Menu_Products'))

'Verify "All Products" is visible'
WebUI.verifyElementText(findTestObject('Object Repository/Products/verify_AllProducts'), 'ALL PRODUCTS')

'Get Product Name 1'
def product01= WebUI.getText(findTestObject('Object Repository/Products/ProductName01')).trim()

'Hover over on "Products 1" button'
WebUI.scrollToElement(findTestObject('Object Repository/Products/Product01'), 10)
WebUI.mouseOver(findTestObject('Object Repository/Products/Product01'))

'Click on "Products 1" button'
WebUI.waitForElementVisible(findTestObject('Object Repository/Products/btn_AddToCart1'), 10)
WebUI.click(findTestObject('Object Repository/Products/btn_AddToCart1'))

'Click on "Continue Shopping" button'
WebUI.waitForElementVisible(findTestObject('Object Repository/Products/btn_ContinueShopping'), 10)
WebUI.click(findTestObject('Object Repository/Products/btn_ContinueShopping'))

'Click on "View Cart" button'
WebUI.waitForElementVisible(findTestObject('Object Repository/Home Page/Menu_Cart'), 10)
WebUI.click(findTestObject('Object Repository/Home Page/Menu_Cart'))

'Get Product Name 1'
def verifyproduct01= WebUI.getText(findTestObject('Object Repository/Cart/Product01'))

WebUI.verifyMatch(product01, verifyproduct01, false)

'Click on "Remove" button'
WebUI.waitForElementVisible(findTestObject('Object Repository/Products/btn_Remove'), 10)
WebUI.click(findTestObject('Object Repository/Products/btn_Remove'))

'Verify Cart is empty!'
def verifyempty= WebUI.getText(findTestObject('Object Repository/Products/verify_Empty'))

WebUI.verifyMatch(verifyempty, "Cart is empty! Click here to buy products.", false)

//WebUI.closeBrowser();