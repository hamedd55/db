package main.java;

import java.io.Serializable;
import java.util.Vector;

public class Bucket implements Serializable
{
	String id;
	int totalNumBuckets;
	int num;
	Vector<Pointer> pointers=new Vector<Pointer>();
	
	public Bucket(String id)
	{
		this.id=id;
	}
}
