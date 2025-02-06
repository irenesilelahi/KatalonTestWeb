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
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper

// Define updated request body
def updatedRequestBody = """{
    "id": 1001,
    "username": "${GlobalVariable.Username}",
    "firstName": "John",
    "lastName": "Smith",
    "email": "john.smith@example.com",
    "password": "newpassword123",
    "phone": "0987654321",
    "userStatus": 1
}"""

// Send PUT request
RequestObject request = new RequestObject()
request.setRestUrl(GlobalVariable.BaseURL + "/user/" + GlobalVariable.Username)
request.setRestRequestMethod("PUT")
request.setBodyContent(new com.kms.katalon.core.testobject.impl.HttpTextBodyContent(updatedRequestBody, "UTF-8", "application/json"))

// Execute API Request
ResponseObject response = WS.sendRequest(request)

// Validate Response
WS.verifyResponseStatusCode(response, 200)
WS.verifyElementPropertyValue(response, 'code', 200)

