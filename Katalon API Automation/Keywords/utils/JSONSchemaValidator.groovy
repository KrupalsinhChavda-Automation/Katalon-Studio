package utils


import org.everit.json.schema.Schema
import org.everit.json.schema.loader.SchemaLoader
import org.json.JSONObject
import org.json.JSONTokener

import com.kms.katalon.core.testobject.ResponseObject

class JSONSchemaValidator {
	static void validate(ResponseObject response, String schemaString) {
		JSONObject rawSchema = new JSONObject(new JSONTokener(schemaString))
		Schema schema = SchemaLoader.load(rawSchema)
		schema.validate(new JSONObject(response.getResponseText()))
	}
}
