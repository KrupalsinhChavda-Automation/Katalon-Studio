import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory

class Listener {
	
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */

	def currentTestSuiteId;
	@BeforeTestSuite
	def getCurrentTestSuiteId(TestSuiteContext testSuiteContext)
	{
		currentTestSuiteId = testSuiteContext.getTestSuiteId().substring(testSuiteContext.getTestSuiteId().lastIndexOf("/") + 1)
		KeywordUtil.logInfo("Current test suite = " + testSuiteContext.getTestSuiteId().substring(testSuiteContext.getTestSuiteId().lastIndexOf("/") + 1))

		def remoteRun = DriverFactory.getRemoteWebDriverServerType()
		boolean remote = (remoteRun != null)
		if (remote) {

			'Set Project & build to browserstack'
			def projectVariable = currentTestSuiteId
//			String project = projectVariable.split("_")[1]
//			String project1 = project.split(" ")[0]
			Random rnd = new Random()
			String randomNumber=rnd.nextInt(9999)
			println(randomNumber)
			String Profile = RunConfiguration.executionProfile
			println(Profile)

			RunConfiguration.setDriverPreferencesProperty("Remote", "projectName", currentTestSuiteId +" " +randomNumber)
			RunConfiguration.setDriverPreferencesProperty("Remote", "buildName", "Material_"+randomNumber)
			RunConfiguration.setDriverPreferencesProperty("Remote", "buildIdentifier", "${DATE_TIME}")
		}
	}

	def currentTestCaseId;
	@BeforeTestCase
	def getCurrentTestCaseId(TestCaseContext testCaseContext)
	{

		currentTestCaseId = testCaseContext.getTestCaseId().substring(testCaseContext.getTestCaseId().lastIndexOf("/") + 1)
		KeywordUtil.logInfo("Current test case = " + testCaseContext.getTestCaseId().substring(testCaseContext.getTestCaseId().lastIndexOf("/") + 1))
	

//	@BeforeTestCase
//	def getRemoteTestCaseName() {

		def remoteRun = DriverFactory.getRemoteWebDriverServerType()
		boolean remote = (remoteRun != null)
		if (remote) {
			
			'Set Test case Name to browserstack'
			RunConfiguration.setDriverPreferencesProperty("Remote", "name", currentTestCaseId)
			KeywordUtil.logInfo("Remote run. Speficied name = " + currentTestCaseId)
		}
	}

	@BeforeTestCase
	def waitforBrowserstackLoad()
	{
		WebUI.delay(2)
	}
	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext) {
		println testCaseContext.getTestCaseId()
		println testCaseContext.getTestCaseStatus()
		WebUI.delay(10)
	}

	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@BeforeTestSuite
	def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {
		println testSuiteContext.getTestSuiteId()

	}

	/**
	 * Executes after every test suite ends.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@AfterTestSuite
	def sampleAfterTestSuite(TestSuiteContext testSuiteContext) {
		println testSuiteContext.getTestSuiteId()}
}