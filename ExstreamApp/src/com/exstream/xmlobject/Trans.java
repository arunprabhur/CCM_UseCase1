package com.exstream.xmlobject;

import javax.xml.bind.annotation.XmlElement;

public class Trans {
String Desc="dafd", Amount ="100.00", Status="C";


@XmlElement (name="Desc")
public String getDesc()
{
	return Desc;
}

public void setDesc(String rg)
{
	Desc = rg;
}

@XmlElement (name="Amount") 
public String getAmount()
{
	return Amount;
}

public void setAmount(String rg)
{
	Amount = rg;
}

@XmlElement (name="Status")
public String getStatus()
{
	return Status;
}

public void setStatus(String rg)
{
	Status = rg;
}



}
