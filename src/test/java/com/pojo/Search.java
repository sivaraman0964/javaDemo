package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.BaseClass;
import com.stepdef.Hooks;

public class Search extends BaseClass {

	public Search() {
		PageFactory.initElements(Hooks.driver, this);

	}

	@FindBy(xpath = "//input[@class='gLFyf gsfi']")
	private WebElement txtBoxSearch;
	@FindBy(xpath = "(//input[@class='gNO89b'])[2]")
	private WebElement btnSearch;

	public WebElement getTxtBoxSearch() {
		return txtBoxSearch;
	}

	public WebElement getBtnSearch() {
		return btnSearch;

	}

}
