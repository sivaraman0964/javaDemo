package com.Utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static WebElement element;
	private static Scanner s;

	public static void firefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	public static void chromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void iEDriver() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
	}

	public static void launchPage(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void waitImplicit(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public static WebElement xpath(String xpath) {
		element = driver.findElement(By.xpath(xpath));
		return element;
	}

	public static WebElement id(String id) {
		element = driver.findElement(By.id(id));
		return element;
	}

	public static WebElement name(String name) {
		element = driver.findElement(By.name(name));
		return element;
	}

	public static WebElement className(String classpath) {
		element = driver.findElement(By.className(classpath));
		return element;
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void sendKeys(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static String getUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void doubleclk(WebElement element) {

		Actions act = new Actions(driver);
		act.doubleClick(element).perform();

	}

	public static String getAttribute(WebElement element, String name) {
		String text = element.getAttribute(name);
		System.out.println(text);
		return text;
	}

	public static String getText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
		return text;

	}

	public static void close() {
		driver.close();
	}

	public static void quit() {
		driver.quit();
	}

	public static void moveToElement(WebElement element) {

		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public static void dragAndDrop(String srcxpth, String trgtxpth) {
		WebElement source = xpath(srcxpth);
		WebElement target = xpath(trgtxpth);
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}

	public static void contextClick(WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();

	}

	public static void frame(String frname) {
		driver.switchTo().frame(frname);
	}

	public static void windowHandle() {
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for (String x : child) {
			if (!x.equals(parent)) {
				driver.switchTo().window(x);
			}
		}
	}

	public static void scrollDown(WebElement element) {
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		jk.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public static void scrollUp(String xpath) {
		element = xpath(xpath);
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		jk.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	public static void screenShot(String fpath) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "\\target\\" + fpath + ".png");
		FileUtils.copyFile(source, dest);
	}

	public static void isMultiple() {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);
	}

	public static void robotDown(int value) throws AWTException {
		Robot rt = new Robot();
		for (int i = 0; i < value; i++) {
			rt.keyPress(KeyEvent.VK_DOWN);
			rt.keyRelease(KeyEvent.VK_DOWN);
		}
		rt.keyPress(KeyEvent.VK_ENTER);
		rt.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void robotCopy() throws AWTException {
		Robot rt = new Robot();
		rt.keyPress(KeyEvent.VK_CONTROL);
		rt.keyPress(KeyEvent.VK_C);
		rt.keyRelease(KeyEvent.VK_CONTROL);
		rt.keyRelease(KeyEvent.VK_C);
	}

	public static void robotPaste() throws AWTException {
		Robot rt = new Robot();
		rt.keyPress(KeyEvent.VK_CONTROL);
		rt.keyPress(KeyEvent.VK_V);
		rt.keyRelease(KeyEvent.VK_CONTROL);
		rt.keyRelease(KeyEvent.VK_V);
	}

	public static void robotCut() throws AWTException {
		Robot rt = new Robot();
		rt.keyPress(KeyEvent.VK_CONTROL);
		rt.keyPress(KeyEvent.VK_X);
		rt.keyRelease(KeyEvent.VK_CONTROL);
		rt.keyRelease(KeyEvent.VK_X);
	}

	public static void alertAccept() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	public static void alertDismiss() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	public static void alertSendKeysAccept(String value) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(value);
		a.accept();
	}

	public static void alertSendKeysDismiss(String value) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(value);
		a.dismiss();
	}

	public static void To(String url) {
		driver.navigate().to(url);
	}

	public static void Back() {
		driver.navigate().back();
	}

	public static void Forward() {
		driver.navigate().forward();
	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	public static void isDisplayed() {
		boolean displayed = element.isDisplayed();
		System.out.println(displayed);
	}

	public static void isEnabled() {
		boolean enabled = element.isEnabled();
		System.out.println(enabled);
	}

	public static void isSelected() {
		boolean selected = element.isSelected();
		System.out.println(selected);
	}

	public static void frameParent() {
		driver.switchTo().parentFrame();
	}

	public static void frameDefault() {
		driver.switchTo().defaultContent();
	}

	public static void javaScriptSendKeys(String args) {
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		jk.executeScript(args, element);
	}

	public static void javaScriptclick() {
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		jk.executeScript("arguments[0].click()", element);

	}

	public static String scannerNextline(String text) {
		s = new Scanner(System.in);
		System.out.println(text);
		String value = s.nextLine();
		System.out.println(value);
		return value;

	}

	public String setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {
		File xlfile = new File("C:\\\\Users\\\\ramsi\\\\eclipse-workspace\\\\GoogleDemo\\\\target\\\\first.xlsx");
		if (!xlfile.exists()) // If file not exists then create new file
		{
			Workbook book = new XSSFWorkbook();

		}

		FileInputStream f2 = new FileInputStream(
				"C:\\\\Users\\\\ramsi\\\\eclipse-workspace\\\\GoogleDemo\\\\target\\\\first.xlsx");
		Workbook book1 = new XSSFWorkbook(f2);

		if (book1.getSheetIndex(sheetName) == -1) // If sheet not exists then create new Sheet
			book1.createSheet(sheetName);

		Sheet s = book1.getSheet(sheetName);

		if (s.getRow(rownum) == null) // If row not exists then create new Row
			s.createRow(rownum);
		Row r = s.getRow(rownum);

		Cell c = r.createCell(colnum);
		c.setCellValue(data);
		FileOutputStream f1 = new FileOutputStream(
				"C:\\Users\\ramsi\\eclipse-workspace\\GoogleDemo\\target\\first.xlsx");
		book1.write(f1);
		f2.close();
		return data;

	}

	public static String excel(String value) throws IOException {

		File f = new File("C:\\Users\\ramsi\\eclipse-workspace\\GoogleDemo\\target\\first.xlsx");
		FileInputStream st = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(st);
		Sheet sheet = book.getSheet("Sheet1");
		Row r = null;
		int rowid = 0;
		List<String> li = new ArrayList<String>();
		li.add(value);
		for (String string : li) {
			sheet.createRow(rowid++);
			int cellid = 0;
			for (String string2 : li) {
				Cell c = r.createCell(cellid++);
				c.setCellValue(string2);

			}

		}

		FileOutputStream st1 = new FileOutputStream(f);
		book.write(st1);
		return null;

	}
}
