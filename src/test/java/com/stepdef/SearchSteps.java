package com.stepdef;

import java.io.IOException;
import java.util.List;

import com.Utils.BaseClass;
import com.pojo.PomMgr;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class SearchSteps extends BaseClass {
	PomMgr p;

	@Given("user launches the browser")
	public void user_launches_the_browser() {

		launchPage("https://www.google.com/");

	}

	@When("user enters the keyword and clicks search and prints in console")
	public void user_enters_the_keyword_and_clicks_search(DataTable table) throws IOException {
		List<String> list = table.asList();
		p = new PomMgr();

		sendKeys(p.getS().getTxtBoxSearch(), list.get(0));
		click(p.getS().getBtnSearch());
		System.out.println(p.getR().getTxtResult().getText());
		p.getS().getTxtBoxSearch().clear();
		for (int i = 1; i < list.size(); i++) {
			sendKeys(p.getS().getTxtBoxSearch(), list.get(i));
			click(p.getR().getBtnSearch());
			System.out.println(p.getR().getTxtResult().getText());
			p.getS().getTxtBoxSearch().clear();
System.out.println("done");

		}
	}

	@Then("user closes the browser")
	public void user_closes_the_browser() {
		System.out.println("**result printed**");
	}

}