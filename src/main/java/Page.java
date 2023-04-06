package main.java;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.Vector;

public class Page implements Serializable
{
	int PageNumber;
	int totalNumTuples;
	TreeMap<String,Vector<Object>> colNameValue;
	
	public Page(int num)
	{
		PageNumber=num;
		colNameValue=new TreeMap<String,Vector<Object>>();
	}
}
