import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager


// GET Users
def response = WS.sendRequest(findTestObject('API/GET Users'))

// Validate
WS.verifyResponseStatusCode(response, 200)
assertThat(response.getResponseText()).contains('Leanne Graham')


