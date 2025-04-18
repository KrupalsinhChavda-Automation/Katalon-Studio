<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>GET Users</name>
   <tag></tag>
   <elementGuidId>707b22af-d89d-4efc-bb95-3945ad903a1b</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>c703b08c-d55e-4f5a-913e-e1380f79ff0c</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://jsonplaceholder.typicode.com/users</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()


String jsonPass =
&quot;&quot;&quot;
{
  &quot;\$id&quot;: &quot;https://example.com/person.schema.json&quot;,
  &quot;\$schema&quot;: &quot;https://json-schema.org/draft/2020-12/schema&quot;,
  &quot;title&quot;: &quot;Person&quot;,
  &quot;type&quot;: &quot;object&quot;,
  &quot;properties&quot;: {
    &quot;firstName&quot;: {
      &quot;type&quot;: &quot;string&quot;,
      &quot;description&quot;: &quot;The person's first name.&quot;
    },
    &quot;lastName&quot;: {
      &quot;type&quot;: &quot;string&quot;,
      &quot;description&quot;: &quot;The person's last name.&quot;
    },
    &quot;age&quot;: {
      &quot;description&quot;: &quot;Age in years which must be equal to or greater than zero.&quot;,
      &quot;type&quot;: &quot;integer&quot;,
      &quot;minimum&quot;: 0
    }
  }
}
&quot;&quot;&quot;
boolean successful = WS.validateJsonAgainstSchema(response,jsonPass)


String[] arrayResponse = [&quot;why&quot;, &quot;hello&quot;, &quot;there&quot;]
String[] arrayExpect = [&quot;there&quot;, &quot;why&quot;, &quot;hello&quot;]
assertThat(arrayResponse).containsOnly(&quot;there&quot;, &quot;hello&quot;, &quot;why&quot;)
assertThat(arrayResponse).containsOnlyElementsOf(Arrays.asList(&quot;why&quot;, &quot;there&quot;, &quot;hello&quot;))

assertThat(arrayResponse).containsExactly(&quot;why&quot;, &quot;hello&quot;, &quot;there&quot;)
assertThat(arrayResponse).containsExactlyElementsOf(Arrays.asList(&quot;why&quot;, &quot;hello&quot;, &quot;there&quot;))

assertThat(arrayResponse).containsSequence(&quot;why&quot;, &quot;hello&quot;)
assertThat(arrayResponse).containsSubsequence(&quot;why&quot;, &quot;there&quot;)
assertThat(arrayResponse).containsAnyOf(&quot;why&quot;, &quot;nothing&quot;, &quot;new&quot;)

assertThat(arrayResponse).contains(&quot;hello&quot;, atIndex(1))


String graphQLSchema = 
'''
type Author {
  id: ID!
  firstName: String!
  lastName: String!
}

type Query {
  findAllAuthors: [Author]!
  countAuthors: Long!
}

type Mutation {
  newAuthor(firstName: String!, lastName: String!) : Author!
}

type Query {
    findAllAuthors: [Author]!
    countAuthors: Long!
    findAllBooks: [Book]!
    countBooks: Long!
}

type Mutation {
    newAuthor(id: ID!, firstName: String!, lastName: String!) : Author!
    newBook(id: ID!, title: String!, isbn: String, pageCount: Int, author: ID!) : Book!
    deleteBook(id: ID!) : Boolean
    updateBookPageCount(pageCount: Int!, id: ID!) : Book!
}
'''

boolean successful = WS.validateGraphqlRequestAgainstSchema(request, graphQLSchema)


assertThat(response.getResponseText()).isEqualTo(&quot;Katalon Test Project&quot;)


assertThat(response.getResponseText()).contains('Katalon Test Project')


assertThat(response.getResponseText()).contains('Katalon Test Project')


def jsonSlurper = new JsonSlurper()

def jsonResponse = jsonSlurper.parseText(response.getResponseText())


String jsonPass =
&quot;&quot;&quot;
{
  &quot;\$id&quot;: &quot;https://example.com/person.schema.json&quot;,
  &quot;\$schema&quot;: &quot;https://json-schema.org/draft/2020-12/schema&quot;,
  &quot;title&quot;: &quot;Person&quot;,
  &quot;type&quot;: &quot;object&quot;,
  &quot;properties&quot;: {
    &quot;firstName&quot;: {
      &quot;type&quot;: &quot;string&quot;,
      &quot;description&quot;: &quot;The person's first name.&quot;
    },
    &quot;lastName&quot;: {
      &quot;type&quot;: &quot;string&quot;,
      &quot;description&quot;: &quot;The person's last name.&quot;
    },
    &quot;age&quot;: {
      &quot;description&quot;: &quot;Age in years which must be equal to or greater than zero.&quot;,
      &quot;type&quot;: &quot;integer&quot;,
      &quot;minimum&quot;: 0
    }
  }
}
&quot;&quot;&quot;
boolean successful = WS.validateJsonAgainstSchema(response,jsonPass)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
