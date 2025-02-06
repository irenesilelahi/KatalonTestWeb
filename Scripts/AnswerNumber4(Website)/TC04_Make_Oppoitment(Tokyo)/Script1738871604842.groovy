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

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import commonFunctions.CommonActions


// Open Browser
WebUI.openBrowser('https://katalon-demo-cura.herokuapp.com/')
WebUI.maximizeWindow()

// Get Test Data
def credData = TestDataFactory.findTestData('TestData_Credentials')
String username = credData.getValue('Username', 1)
String password = credData.getValue('Password', 1)

def appointmentData = TestDataFactory.findTestData('TestData_Appointment')
String facility = appointmentData.getValue('Facility', 1)
String date = appointmentData.getValue('Date', 1)
String comment = appointmentData.getValue('Comment', 1)

// Login
CommonActions actions = new CommonActions()
actions.login(username, password)

// Navigate to Appointment Page
WebUI.click(findTestObject('Dashboard/btn_MakeAppointment'))

// Make an Appointment
actions.makeAppointment(facility, date, comment)

// Verify Appointment Confirmation
WebUI.verifyElementPresent(findTestObject('Appointment Page/lbl_ConfirmationMessage'), 10)

// Logout & Close Browser
actions.logout()
WebUI.closeBrowser()

