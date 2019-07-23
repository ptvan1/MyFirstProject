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
import common.Common

data = ExcelFactory.getExcelDataWithDefaultSheet("D:\\Van\\ptvan1\\Study\\English\\Vocabulary.xlsx", "Sheet2", true)
FileInputStream fis = new FileInputStream("D:\\Van\\ptvan1\\Study\\English\\Vocabulary.xlsx")
XSSFWorkbook workbook = new XSSFWorkbook(fis)
XSSFSheet sheet = workbook.getSheet("Sheet2")


int rowCount = data.getRowNumbers()
String word=''

String definationOfWordObj = "//*[h2]/following::span[@class='def'][%s]"
String searchBoxObj = "//*[@id='q']"
String searchIconObj ="//*[input[@type='submit']]"
String typeOfWordObj ="//*[h2]/span[3]"
String pronounceObj ="//*[h2]/following::span[@class='phon']"
String exampleObj ="//*[h2]/following::span[@class='def'][%s]/following::span[@class='x-gs'][1]/span[@class='x-g'][1]"
String synonymObj ="//*[span[text()='synonym']]//span[@class='xh']"
String oppositeObj ="//*[span[text()='opposite']]//span[@class='xh']"
String synonym =''
String opposite =''
String definition = ''
String type = ''
String pronounce = ''
String example = ''

Common commonPage = new Common()
WebUI.openBrowser('')
//WebUI.maximizeWindow()

WebUI.navigateToUrl('https://www.oxfordlearnersdictionaries.com/us/')

for (int i=1; i<=rowCount; i++){
	word = data.getValue("Words", i)
	commonPage.setTextElement(searchBoxObj, word)
	commonPage.clickElement(searchIconObj)
	type = commonPage.getTextElement(typeOfWordObj)
	pronounce = commonPage.getTextElement(pronounceObj)
	for(int j = 1; j<=2; j++){
		String xpath_def = String.format(definationOfWordObj, j)
		String xpath_exp = String.format(exampleObj,j)
		if(WebUI.verifyElementVisible(commonPage.object(xpath_def), FailureHandling.OPTIONAL)){
			definition = definition + "- " + commonPage.getTextElement(xpath_def) + "\n"
			xpath_def = ''
		}else{
			break;
		}
			
		if(WebUI.verifyElementVisible(commonPage.object(xpath_exp), FailureHandling.OPTIONAL)){
			example = example + "- " + commonPage.getTextElement(xpath_exp) + "\n"
			xpath_exp = ''
		}else{
			break;
		}	
	}
	if(WebUI.verifyElementVisible(commonPage.object(synonymObj), FailureHandling.OPTIONAL)){
		synonym = "- " + commonPage.getTextElement(synonymObj)
		sheet.getRow(i).createCell(4).setCellValue(synonym)
	}
		
	if(WebUI.verifyElementVisible(commonPage.object(oppositeObj), FailureHandling.OPTIONAL)){
		opposite = "- " + commonPage.getTextElement(oppositeObj)
		sheet.getRow(i).createCell(5).setCellValue(opposite)
	}
	sheet.getRow(i).createCell(0).setCellValue(i)
	sheet.getRow(i).createCell(2).setCellValue(type)
	sheet.getRow(i).createCell(3).setCellValue(pronounce)
	sheet.getRow(i).createCell(6).setCellValue(definition)
	sheet.getRow(i).createCell(7).setCellValue(example)
	definition = ''
	example = ''
}
FileOutputStream fos = new FileOutputStream("D:\\Van\\ptvan1\\Study\\English\\Vocabulary.xlsx")
workbook.write(fos)
fos.close()
WebUI.closeBrowser()

