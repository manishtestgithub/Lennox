package com.org.pageobj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.basefile.BaseFileLynnox;

public class SelectLeadPage {
public SelectLeadPage() {
	PageFactory.initElements(BaseFileLynnox.driver,this);
}

@FindBy(xpath="//a[contains(text(),'SELECT LEAD')]")     //"//a[contains(text(),'SELECT LEAD')]")
private WebElement select_lead;

public WebElement getSelect_lead() {
	return select_lead;
}


}
