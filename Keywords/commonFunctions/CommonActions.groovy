package commonFunctions
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ObjectRepository as OR

class CommonActions {

	@Keyword
	def login(String username, String password) {
		WebUI.setText(OR.findTestObject('Login Page/txt_Username'), username)
		WebUI.setEncryptedText(OR.findTestObject('Login Page/txt_Password'), password)
		WebUI.click(OR.findTestObject('Login Page/btn_Login'))
	}

	@Keyword
	def logout() {
		WebUI.click(OR.findTestObject('Logout/btn_Menu'))
		WebUI.click(OR.findTestObject('Logout/btn_Logout'))
		WebUI.verifyElementPresent(OR.findTestObject('Login Page/btn_Login'), 10)
	}

	@Keyword
	def makeAppointment(String facility, String date, String comment) {
		WebUI.selectOptionByLabel(OR.findTestObject('Appointment Page/dropdown_Facility'), facility, false)
		WebUI.click(OR.findTestObject('Appointment Page/chk_HospitalReadmission'))
		WebUI.click(OR.findTestObject('Appointment Page/radio_HealthcareProgram_Medicare'))
		WebUI.setText(OR.findTestObject('Appointment Page/txt_Date'), date)
		WebUI.setText(OR.findTestObject('Appointment Page/txt_Comment'), comment)
		WebUI.click(OR.findTestObject('Appointment Page/btn_BookAppointment'))
	}
}