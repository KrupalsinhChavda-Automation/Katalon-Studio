import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
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
import utils.RandomDataGenerator as RandomDataGenerator
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

String newTitle = RandomDataGenerator.randomTitle()

def response = WS.sendRequest(findTestObject('API/PUT UpdatePost', [('postId') : GlobalVariable.PostID, ('title') : newTitle]))

WS.verifyResponseStatusCode(response, 200)

String[] responseJson = new groovy.json.JsonSlurper().parseText(response.getResponseText())
println(responseJson)

String responeTitle = responseJson[1];

String id = responseJson[3]
println(responeTitle)
WS.verifyMatch("title=" + newTitle, responeTitle, false)

