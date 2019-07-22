
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import com.kms.katalon.core.testobject.TestObject

import java.lang.String

import org.openqa.selenium.WebElement


def static "com.example.WebUICustomKeywords.isElementPresent"(
    	TestObject to	
     , 	int timeout	) {
    (new com.example.WebUICustomKeywords()).isElementPresent(
        	to
         , 	timeout)
}

def static "com.example.WebUICustomKeywords.getHtmlTableRows"(
    	TestObject table	
     , 	String outerTagName	) {
    (new com.example.WebUICustomKeywords()).getHtmlTableRows(
        	table
         , 	outerTagName)
}

def static "com.example.WebUICustomKeywords.getHtmlTableColumns"(
    	WebElement row	
     , 	String tagName	) {
    (new com.example.WebUICustomKeywords()).getHtmlTableColumns(
        	row
         , 	tagName)
}

def static "common.Common.object"(
    	String xpath	) {
    (new common.Common()).object(
        	xpath)
}

def static "common.Common.clickElement"(
    	String xpath	) {
    (new common.Common()).clickElement(
        	xpath)
}

def static "common.Common.getTextElement"(
    	String xpath	) {
    (new common.Common()).getTextElement(
        	xpath)
}

def static "common.Common.setTextElement"(
    	String xpath	
     , 	String text	) {
    (new common.Common()).setTextElement(
        	xpath
         , 	text)
}

def static "common.Common.readExcel"(
    	String path	
     , 	String sheet	
     , 	String columnName	
     , 	String outputType	) {
    (new common.Common()).readExcel(
        	path
         , 	sheet
         , 	columnName
         , 	outputType)
}

def static "common.Common.writeExcel"(
    	String path	
     , 	String sheetName	
     , 	int column	
     , 	int row	
     , 	String value	) {
    (new common.Common()).writeExcel(
        	path
         , 	sheetName
         , 	column
         , 	row
         , 	value)
}
