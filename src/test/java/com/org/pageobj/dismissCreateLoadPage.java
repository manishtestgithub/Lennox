package com.org.pageobj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.basefile.BaseFileLynnox;

public class dismissCreateLoadPage {
	public dismissCreateLoadPage() {
		PageFactory.initElements(BaseFileLynnox.driver, this);
	}

	@FindBy(xpath = "//p[contains(text(),'The lead you have created already exists :  ')]")
	private WebElement already_lead_exist;

	@FindBy(xpath = "//a[contains(text(),'Dismiss')]")
	private WebElement dismiss_create_lead;

	@FindBy(xpath = "//*[@id=\"duplicate-lead-modal\"]/div/div[3]/div/button")//"//button[contains(text(),'Create Duplicate')]")
	@CacheLookup
	private WebElement dublicate_create_lead;

	public WebElement getAlready_lead_exist() {
		return already_lead_exist;
	}

	public WebElement getDismiss_create_lead() {
		return dismiss_create_lead;
	}

	public WebElement getDublicate_create_lead() {
		return dublicate_create_lead;
	}

}
