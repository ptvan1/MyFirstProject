import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.stringtemplate.v4.compiler.STParser.list_return as list_return
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import groovy.ui.text.FindReplaceUtility.ReplaceAction as ReplaceAction
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testdata.reader.ExcelFactory as ExcelFactory
import java.io.FileInputStream as FileInputStream
import java.io.FileNotFoundException as FileNotFoundException
import java.io.FileOutputStream as FileOutputStream
import java.io.IOException as IOException
import java.lang.String as String
import java.util.List as List
import org.apache.poi.ss.formula.functions.Replace as Replace
import org.apache.poi.ss.usermodel.Cell as Cell
import org.apache.poi.ss.usermodel.CellStyle as CellStyle
import org.apache.poi.ss.usermodel.Row as Row
import org.apache.poi.xssf.usermodel.XSSFCell as XSSFCell
import org.apache.poi.xssf.usermodel.XSSFCellStyle as XSSFCellStyle
import org.apache.poi.xssf.usermodel.XSSFRow as XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet as XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook as XSSFWorkbook
import com.kms.katalon.core.testobject.ConditionType
import commonKeywords.Common

//KeywordLogger log = new KeywordLogger()
Common commonPage = new Common()
//commonPage.writeExcel("E:\\Work\\BHS\\Automation\\Practice\\Data Files\\Vocabulary.xlsx", "Sheet2", 5, 1, "Test call function")
List<String> list_word = commonPage.readExcel("D:\\Van\\ptvan1\\Study\\English\\Vocabulary.xlsx", "Sheet2", "Words","List")
String string_word = commonPage.readExcel("D:\\Van\\ptvan1\\Study\\English\\Vocabulary.xlsx", "Sheet2", "Words","String")
//KeywordUtil.logInfo("Word: " + word)
//data = ExcelFactory.getExcelDataWithDefaultSheet("E:\\Work\\BHS\\Automation\\Practice\\Data Files\\Vocabulary.xlsx", "Sheet2", true)
KeywordUtil.logInfo("Word by list is: " + list_word)
KeywordUtil.logInfo("Word by string is: " + string_word)
/*for(int i=0; i<5; i++){
	KeywordUtil.logInfo("Word " + (i+1) + " is: " + list_word[i])
}*/

//String definationOfWord = "//*[h2]/following::span[@class='def'][1]"
//String searchBox = "//*[@id='q']"
//String searchIcon ="//*[input[@type='submit']]"

//Common commonPage = new Common()
//WebUI.openBrowser('')

//WebUI.navigateToUrl('https://www.oxfordlearnersdictionaries.com/us/')
//WebUI.navigateToUrl('google.com')

//commonPage.setTextElement(searchBox, word)
//commonPage.clickElement(searchIcon)

WebUI.closeBrowser()

