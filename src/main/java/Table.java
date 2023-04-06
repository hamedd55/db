package main.java;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Vector;

public class Table implements Serializable
{
	String tableName;
	Vector<Page> Pages;
	int TotalPages;
	String cluStringKey;
	Hashtable<String,String> colNamType;
	Hashtable<String, String> colmin;
	Hashtable<String, String> colmax;
	Vector<String> min=new Vector<String>();
	Vector<String> columns=new Vector<String>();
	Vector<String>index=new Vector<String>();
	
	public Table(String name,String cString, Hashtable<String,String> cnt,Hashtable<String,String>colmin,Hashtable<String,String>colmax)
	{
		tableName=name;
		Pages=new Vector<Page>();
		cluStringKey=cString;
		colNamType=cnt;
		this.colmin=colmin;
		this.colmax=colmax;
	}
}
