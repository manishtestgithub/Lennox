package com.org.pageobj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.basefile.BaseFileLynnox;


public class LoginPage {
		public LoginPage() {
			PageFactory.initElements(BaseFileLynnox.driver,this);
		}
		@FindBy(xpath="//a[contains(text(),'Sign In')]")
		private WebElement SignIn_Select;
		
		@FindBy(id="j_username")
		private WebElement User_Name;
		
		@FindBy(id="j_password")
		private WebElement Pass_Word;
		
		@FindBy(id="loginSubmit")
	private WebElement Submit_Login;

	public WebElement getSignIn_Select() {
		return SignIn_Select;
	}

	public WebElement getUser_Name() {
		return User_Name;
	}

	public WebElement getPass_Word() {
		return Pass_Word;
	}

	public WebElement getSubmit_Login() {
		return Submit_Login;
	}
}
