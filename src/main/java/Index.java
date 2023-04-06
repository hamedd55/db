package main.java;

import java.io.Serializable;
import java.util.TreeMap;
import java.util.Vector;

public class Index implements Serializable
{
	String name;
	String []colnames;
	Vector<Vector<Range>> dimension=new Vector<Vector<Range>>();
	TreeMap<String,Bucket> data=new TreeMap<String,Bucket>();
	public Index(String name, String[]colnames)
	{
		this.name=name;
		this.colnames=colnames;
	}
}
