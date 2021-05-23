package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.BaseClass;

public class Results extends BaseClass {
	public Results() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@id='result-stats']")
	private WebElement txtResult;
	@FindBy(xpath = "//button[@class='Tg7LZd']")
	private WebElement btnSearch;

	public WebElement getTxtResult() {
		return txtResult;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

}
