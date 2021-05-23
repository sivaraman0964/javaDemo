package com.stepdef;

import java.io.IOException;

import com.Utils.BaseClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BaseClass {

	@Before
	public void Before() {
		chromeDriver();

	}

	@After
	public void after(Scenario sc) throws IOException {
		screenShot(sc.getName());
		close();

	}

}
