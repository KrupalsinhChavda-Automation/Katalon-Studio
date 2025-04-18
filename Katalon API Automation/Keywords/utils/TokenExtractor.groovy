package utils

import com.kms.katalon.core.testobject.ResponseObject

public class TokenExtractor {
    static String extractToken(ResponseObject response) {
        def jsonResponse = new groovy.json.JsonSlurper().parseText(response.getResponseText())
        return jsonResponse.token
    }
}