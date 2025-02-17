package com.crm.qa.pages;

import com.crm.qa.base.TestBase;

public class testing extends TestBase{
	
	
	//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
	
}
