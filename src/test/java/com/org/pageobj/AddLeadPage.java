package com.org.pageobj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.basefile.BaseFileLynnox;

public class AddLeadPage {
		public AddLeadPage() {
			PageFactory.initElements(BaseFileLynnox.driver, this);
		}
		
		@FindBy(xpath="//span[contains(text(),'ADD LEAD')]")
		private WebElement add_lead_select;

		public WebElement getAdd_lead_select() {
			return add_lead_select;
		}

}
