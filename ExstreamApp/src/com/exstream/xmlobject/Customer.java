package com.exstream.xmlobject;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;  
import javax.xml.bind.annotation.XmlAccessType;
  
@XmlRootElement(name="Customer")
@XmlType(propOrder = { "accountNumber","customerFirstName", "customerLastName", "addressLine1", "addressLine2","city", "state", "zip", "docID", "channel", "coverageAmount", "mobile", "office", "residence", "storeCode", "premium_Month_Amount", "premium_year_Amount", "trans"})
public class Customer {
	String CustomerFirstName="",middleName="",CustomerLastName="", AddressLine1="", AddressLine2="", City="", State="", Zip="";
	String Mobile="", Residence="", Office="", coverageAmount="", premium_month="", premium_year="", DocID="";
	String AccountNumber="314", StoreCode="324", Channel="E";
	Trans[] tn = new Trans[10];
	
	@XmlElement
	public Trans[] getTrans()
	{
		tn[0]=new Trans();
		tn[1]=new Trans();
		return tn;
	}
	public Customer()
	{
		CustomerFirstName="";
		middleName="";		
		CustomerLastName ="";
	}
	public Customer (String fname, String mname,String lname)
	{
		CustomerFirstName = fname;
		middleName= mname;
		CustomerLastName = lname;
	}
	
	@XmlElement (name="AccountNumber")  
	public String getAccountNumber()
	{
		return AccountNumber;
	}
	
	@XmlElement (name="StoreCode")
	public String getStoreCode()
	{
		return StoreCode;
	}
	
	@XmlElement (name="Channel")  
	public String getChannel()
	{
		return Channel;
	}
	
	@XmlElement (name="CustomerFirstName")
	public String getCustomerFirstName()
	{
		return CustomerFirstName;
	}
	
	@XmlElement (name="CustomerLastName")
	public String getCustomerLastName()
	{
		return CustomerLastName;
	}
	
	
	public void setmiddleName(String mname)
	{
		middleName = mname;
	}
	
	@XmlElement (name="AddressLine1")
	public String getaddressLine1()
	{
		return AddressLine1;
	}
	
	public void setraddressLine1(String rg)
	{
		AddressLine1 = rg;
	}
	@XmlElement (name="AddressLine2")
	public String getaddressLine2()
	{
		return AddressLine2;
	}
	
	public void setraddressLine2(String rg)
	{
		AddressLine2 = rg;
	}
	
	@XmlElement (name="City")
	public String getCity()
	{
		return City;
	}
	
	public void setCity(String rg)
	{
		City = rg;
	}
	
	@XmlElement (name="State")
	public String getState()
	{
		return State;
	}
	
	public void setState(String rg)
	{
		State = rg;
	}
	
	@XmlElement (name="Zip")
	public String getZip()
	{
		return Zip;
	}
	
	public void setZip(String rg)
	{
		Zip = rg;
	}
	
	@XmlElement (name="Mobile")
	public String getMobile()
	{
		return Mobile;
	}
	
	public void setMobile(String rg)
	{
		Mobile = rg;
	}
	
	@XmlElement  (name="Residence")
	public String getResidence()
	{
		return Residence;
	}
	
	public void setResidence(String rg)
	{
		Residence = rg;
	}
	
	@XmlElement (name="Office")
	public String getOffice()
	{
		return Office;
	}
	
	public void setOffice(String rg)
	{
		Office = rg;
	}
	
	@XmlElement (name="coverageAmount")
	public String getCoverageAmount()
	{
		return coverageAmount;
	}
	
	public void setCoverageAmount(String rg)
	{
		coverageAmount = rg;
	}
	
	@XmlElement (name="premium_month")
	public String getpremium_Month_Amount()
	{
		return premium_month;
	}
	
	public void setpremium_Month_Amount(String rg)
	{
		premium_month = rg;
	}
	
	@XmlElement (name="premium_year")
	public String getpremium_year_Amount()
	{
		return premium_year;
	}
	
	public void setDocID(String rg)
	{
		DocID = rg;
	}
	@XmlElement (name="DocID")
	public String getDocID()
	{
		return DocID;
	}
	
	public void setpremium_year_Amount(String rg)
	{
		premium_year = rg;
	}
	
	
}
