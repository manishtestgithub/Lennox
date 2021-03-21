package com.org.pageobj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.basefile.BaseFileLynnox;

public class SavedLeadVarificationPage {
		public SavedLeadVarificationPage() {
			PageFactory.initElements(BaseFileLynnox.driver,this);
		}
		
		@FindBy(xpath="//li[contains(text(),'Lead Saved Successfully')]")
		private WebElement success_lead_added;
		
		@FindBy(xpath="//h1[contains(text(),'Lead Details')]")
		private WebElement sucess_header;
		
		
		@FindBy(xpath="//span[contains(text(),'New')]")
		@CacheLookup
		private WebElement new_lead_created;
		
		public WebElement getSuccess_lead_added() {
			return success_lead_added;
		}

		public WebElement getSucess_header() {
			return sucess_header;
		}

		public WebElement getNew_lead_created() {
			return new_lead_created;
		}
		
		
}
