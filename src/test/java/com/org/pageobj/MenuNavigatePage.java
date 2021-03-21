package com.org.pageobj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.basefile.BaseFileLynnox;

public class MenuNavigatePage {
	public MenuNavigatePage() {
		PageFactory.initElements(BaseFileLynnox.driver, this);
	}

	@FindBy(xpath = "//*[@id=\"page\"]/div[1]/div/div[1]")
	private WebElement Menu_Bar_Option;

	@FindBy(xpath = "//a[contains(text(),'Sales Tools')]")
	private WebElement Sales_Tool_select;

	@FindBy(xpath = "//a[contains(text(),'Build a Proposal')]")
	private WebElement Build_a_Proposal_select;

	public WebElement getMenu_Bar_Option() {
		return Menu_Bar_Option;
	}

	public WebElement getSales_Tool_select() {
		return Sales_Tool_select;
	}

	public WebElement getBuild_a_Proposal_select() {
		return Build_a_Proposal_select;
	}

	
}
