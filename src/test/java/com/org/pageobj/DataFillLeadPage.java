package com.org.pageobj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.basefile.BaseFileLynnox;

public class DataFillLeadPage {
	public DataFillLeadPage() {
		PageFactory.initElements(BaseFileLynnox.driver, this);
	}

	@FindBy(id = "firstName")
	private WebElement firstname;

	@FindBy(id = "lastName")
	private WebElement lastname;

	@FindBy(id = "phNo")
	private WebElement phonenumber;

	@FindBy(id = "email")
	private WebElement emailid;

	@FindBy(id = "addressLine1")
	private WebElement addressline_1;

	@FindBy(id = "addressLine2")
	private WebElement addressline_2;

	@FindBy(id = "countryIso")
	private WebElement country_select;

	@FindBy(id = "regionIso")
	private WebElement state_select;

	@FindBy(id = "townCity")
	private WebElement city_select;

	@FindBy(id = "postal-code")
	private WebElement zip_postal_code;

	@FindBy(id = "comments")
	private WebElement comment_data;

	@FindBy(id = "calender1")
	private WebElement request_date;

	@FindBy(className = "ui-datepicker-title")
	private WebElement month_year_select;

	@FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-e']")
	private WebElement next_month_year;

	@FindBy(id = "scheduleRequestTime")
	private WebElement request_time;

	@FindBy(id = "calender2")
	private WebElement appointment_date;

	@FindBy(id = "appointmentRequestTime")
	private WebElement appointment_time;

	@FindBy(xpath = "//p[contains(text(),'Add Document')]")
	private WebElement add_document;

	@FindBy(name = "documents[1].documentType")
	private WebElement select_document_type;

	@FindBy(id = "multipleFileSelect-1")
	private WebElement select_file;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	private WebElement cancel_file_load;

	@FindBy(xpath = "//span[contains(text(),'Add To Lead')]")
	private WebElement add_to_lead;

	@FindBy(id = "multipleImageSelect[0]")
	private WebElement add_image_select;

	@FindBy(id = "btn-addLeadsForm")
	private WebElement save_new_lead;

	@FindBy(xpath = "//span[contains(text(),'SAVE LEAD')]")
	private WebElement new_lead_saved;

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getPhonenumber() {
		return phonenumber;
	}

	public WebElement getEmailid() {
		return emailid;
	}

	public WebElement getAddressline_1() {
		return addressline_1;
	}

	public WebElement getAddressline_2() {
		return addressline_2;
	}

	public WebElement getCountry_select() {
		return country_select;
	}

	public WebElement getState_select() {
		return state_select;
	}

	public WebElement getCity_select() {
		return city_select;
	}

	public WebElement getZip_postal_code() {
		return zip_postal_code;
	}

	public WebElement getComment_data() {
		return comment_data;
	}

	public WebElement getRequest_date() {
		return request_date;
	}

	public WebElement getMonth_year_select() {
		return month_year_select;
	}

	public WebElement getNext_month_year() {
		return next_month_year;
	}

	public WebElement getRequest_time() {
		return request_time;
	}

	public WebElement getAppointment_date() {
		return appointment_date;
	}

	public WebElement getAppointment_time() {
		return appointment_time;
	}

	public WebElement getAdd_document() {
		return add_document;
	}

	public WebElement getSelect_document_type() {
		return select_document_type;
	}

	public WebElement getAdd_to_lead() {
		return add_to_lead;
	}

	public WebElement getAdd_image_select() {
		return add_image_select;
	}

	public WebElement getSelect_file() {
		return select_file;
	}

	public WebElement getCancel_file_load() {
		return cancel_file_load;
	}

	public WebElement getSave_new_lead() {
		return save_new_lead;
	}

	public WebElement getNew_lead_saved() {
		return new_lead_saved;
	}

}
