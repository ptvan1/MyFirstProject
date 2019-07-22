package common

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.ExcelData
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
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
import org.eclipse.persistence.internal.oxm.record.json.JSONParser.array_return

import internal.GlobalVariable
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testdata.reader.ExcelFactory as ExcelFactory

public class Common {
	//KeywordLogger log = new KeywordLogger()
	/** Define object by using xpath
	 * @param xpath	xpath of object
	 */

	@Keyword
	def object(String xpath){
		TestObject obj = new TestObject()
		obj.addProperty("xpath", ConditionType.EQUALS, xpath)
		return obj
	}

	/**
	 * Click element
	 * @param obj Katalon test object
	 */
	@Keyword
	def clickElement(String xpath) {
		TestObject obj = this.object(xpath)
		try {
			WebUI.waitForElementClickable(obj, 30)
			WebUI.click(obj)
		} catch (Exception e) {
			KeywordUtil.markError(e)
		}
	}

	/**
	 * Get text element
	 * @param obj Katalon test object
	 */
	@Keyword
	def getTextElement(String xpath) {
		TestObject obj = this.object(xpath)
		try {
			WebUI.waitForElementVisible(obj, 30)
			String text = WebUI.getText(obj)
			return text
		} catch (Exception e) {
			KeywordUtil.markError(e)
		}
	}

	/**
	 * Set text element
	 * @param obj Katalon test object
	 */
	@Keyword
	def setTextElement(String xpath, String text) {
		TestObject obj = this.object(xpath)
		try {
			WebUI.waitForElementClickable(obj, 30)
			WebUI.click(obj)
			WebUI.setText(obj, text)
		} catch (Exception e) {
			KeywordUtil.markError(e)
		}
	}

	/**
	 * Read excel file
	 * @param path where store the data file
	 * @param sheet name of sheet you want to read
	 * @param columnName name of column you want to read
	 * @param outputType type of output, include List or String
	 */
	@Keyword
	def readExcel(String path, String sheet, String columnName,String outputType) {
		Object data = ExcelFactory.getExcelDataWithDefaultSheet(path, sheet, true)
		List<String> dataOut_List = new ArrayList<String>()
		String dataOut_String = ''
		int rowCount = data.getRowNumbers()
		for(int i=1; i<=rowCount; i++){
			dataOut_String = dataOut_String + data.getValue(columnName, i) + "; "
			dataOut_List.add(data.getValue(columnName, i))
		}
		if(outputType=='String'){
			return dataOut_String
		}
		else{
			return dataOut_List
		}
	}

	/**
	 * Write excel file
	 * @param path path of data file
	 * @param sheet sheet is written
	 * @param column column index
	 * @param row row index
	 */
	@Keyword
	def writeExcel(String path, String sheetName, int column, int row, String value) {
		FileInputStream fis = new FileInputStream(path)
		XSSFWorkbook workbook = new XSSFWorkbook(fis)
		XSSFSheet sheet = workbook.getSheet(sheetName)
		Cell cell = sheet.getRow(row).createCell(column)
		cell.setCellValue(value)
		FileOutputStream fos = new FileOutputStream(path)
		workbook.write(fos)
		fos.close()
	}
}