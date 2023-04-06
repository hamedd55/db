package main.java;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;


public class DBApp implements DBAppInterface{
	
	static String md="src/main/resources/metadata.csv";
	
	public static TreeMap<String,Vector<Object>> fin2(Vector<TreeMap<String,Vector<Object>>> x)
	{
		TreeMap<String,Vector<Object>> s =new TreeMap<String,Vector<Object>>() ;
		TreeMap<String,Vector<Object>> sum =new TreeMap<String,Vector<Object>>() ;
		int count=0;
		Vector<Object>r1=new Vector<Object>();
		for(int i=0; i< x.size();i++) 
		{
			Iterator<String> itr2=x.get(i).keySet().iterator();
			while(itr2.hasNext()) 
			{
				String z=itr2.next();
				s.put(i+"", x.get(i).get(z));
			}
		}
		if(x.size()>=1)
		{
			Iterator<String> itr=x.get(0).keySet().iterator();
			while(itr.hasNext()) 
			{
				String z=itr.next();
				Iterator<String> itr3=s.keySet().iterator();
				while(itr3.hasNext()) 
				{
					String z1=itr3.next();
					if(s.get(z1).equals(x.get(0).get(z)))
					{
						count++;
						r1=s.get(z1);
					}
				}
				if(count!=x.size())
					sum.put(z,r1);
				count=0;
			}
		}
		return sum;
		
	}
	
	public static TreeMap<String,Vector<Object>> fin1(Vector<TreeMap<String,Vector<Object>>> x)
	{
		TreeMap<String,Vector<Object>> s =new TreeMap<String,Vector<Object>>() ;
		TreeMap<String,Vector<Object>> sum =new TreeMap<String,Vector<Object>>() ;
		int count=0;
		Vector<Object>r1=new Vector<Object>();
		for(int i=0; i< x.size();i++) 
		{
			Iterator<String> itr2=x.get(i).keySet().iterator();
			while(itr2.hasNext()) 
			{
				String z=itr2.next();
				s.put(i+"", x.get(i).get(z));
			}
		}
		if(x.size()>=1)
		{
			Iterator<String> itr=x.get(0).keySet().iterator();
			while(itr.hasNext()) 
			{
				String z=itr.next();
				Iterator<String> itr3=s.keySet().iterator();
				while(itr3.hasNext()) 
				{
					String z1=itr3.next();
					if(s.get(z1).equals(x.get(0).get(z)))
					{
						count++;
						r1=s.get(z1);
					}
				}
				if(count==x.size())
					sum.put(z,r1);
				count=0;
			}
		}
		return sum;
		
	}
	
	public static Vector<String> fin(Vector<Vector<String>> x)
	{
		Vector<String> s = new Vector<String>() ;
		Vector<String> sum = new Vector<String>() ;
		int count=0;
		String r="";
		for(int i=0; i< x.size();i++) 
		{
			for(int j=0;j<x.get(i).size();j++) 
			{
				s.add(x.get(i).get(j));
			}
		}
		if(x.size()>=1)
		{
			for (int i= 0 ; i< x.get(0).size();i++) 
			{
				for(int j=0; j<s.size();j++) 
				{
					if(s.get(j).equals(x.get(0).get(i))) 
					{
					 count++;
					 r=s.get(j);
					}
					
				}
				if(count==x.size())
					sum.add(r);
				count=0;
			}
		}
		return sum;
		
	}
	
	public static Vector<String> findIds(Vector<Integer> []arr)
	{
		Vector<String> res=new Vector<String>();
	    int n = arr.length;
	    int []indices = new int[n];
	    for(int i = 0; i < n; i++)
	        indices[i] = 0;
	 
	    while (true)
	    {
	    		
	    	for(int i = 0; i < n; i++)
    		{
	    		String m="";
	    		for(int k=0;k<arr.length;k++)
	    		{
	    			m=m+arr[i].get(indices[i]);
	    			i++;
	    		}
	    		i--;
	    		res.add(m);
    		}

	        int next = n - 1;
	        while (next >= 0 &&
	              (indices[next] + 1 >=
	                   arr[next].size()))
	            next--;
	 
	        if (next < 0)
	            return res;
	 
	        indices[next]++;
	 
	        for(int i = next + 1; i < n; i++)
	            indices[i] = 0;
	    }
	}
	public static Vector<Integer>[] findSize(Vector<Vector<Range>> x)
	{
		Vector<Integer>[] n=new Vector [x.size()];

		for(int i=0;i<x.size();i++)
		{
			n[i]=new Vector<Integer>();
			for(int j=0;j<x.get(i).size();j++)
			{
				n[i].add(j);
			}
		}
		return n;
	}
	
	public static int findPoint(String x)
	{
		for(int i=0;i<x.length();i++)
		{
			if(x.charAt(i)=='.')
			{
				x=x.substring(i+1);
			}
		}
		return x.length();
	}
	
	public static int getAscii(String x)
	{
		int l=0;
		for(int i=0 ;i<x.length();i++)
		{
			l=l+((int)x.charAt(i));
		}
		return l;
	}
	public static String getIndexName(String tableName, String[] columnNames)
	{
		String s="";
		s=tableName+"_";
		for(int i=0;i<columnNames.length;i++)
		{
			s=s+columnNames[i]+"_";
		}
		s=s+"index";
		return s;
	}
	public static int binarySearch(Vector<String>m, int first, int last, String key)
	{
		  int mid = (first + last)/2;  
		   while( first <= last ){  
		      if ((m.get(mid)).compareTo(key)<0){
		        first = mid;     
		      }
		      else if((m.get(mid)).equals(key))
		      {
		    	  return mid;
		      }
		      else{  
		         last = mid;  
		      }  
		      mid = (first + last)/2;
		      if(mid==first)
		      {
		    	  if(last==m.size()-1 && key.compareTo(m.get(last))>=0)
		    		  mid=last;
		    	  break;
		      }
		   }  
		   return mid;
	}
	
	public static String getMonth(String s)
	{
		switch(s)
		{
		case "Jan":return "01";
		case "Feb":return "02";
		case "Mar":return "03";
		case "Apr":return "04";
		case "May":return "05";
		case "Jun":return "06";
		case "Jul":return "07";
		case "Aug":return "08";
		case "Sep":return "09";
		case "Oct":return "10";
		case "Nov":return "11";
		case "Dec":return "12";
		}
		return s;
	}
	public static void ToWrite(String towrite,String filepath)
	{
		try {
			FileWriter writer=new FileWriter(filepath,true);
			BufferedWriter write=new BufferedWriter(writer);
			PrintWriter p=new PrintWriter(write);
			p.println(towrite);
			p.flush();
			p.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String[] ToRead(String filepath) throws IOException
	{
		FileReader read=new FileReader(filepath);
		BufferedReader br=new BufferedReader(read);
		String currentLine = "";
		String x="";
		while ((currentLine = br.readLine()) != null) 
		{
			x=x+currentLine+",";
		}
		return x.split(",");
	}
	
	public static void serialize(Object p,String path)
	{
		  try
	        {   
	            //Saving of object in a file
	            FileOutputStream file = new FileOutputStream(path);
	            ObjectOutputStream out = new ObjectOutputStream(file);
	              
	            // Method for serialization of object
	            if(p instanceof Table)
	            	out.writeObject((Table)p);
	            else if(p instanceof Page)
	            	out.writeObject((Page)p);
	            else if(p instanceof Index)
	            	out.writeObject((Index)p);
	            else if(p instanceof Bucket)
	            	out.writeObject((Bucket)p);
	              
	            out.close();
	            file.close();
	        }
	          
	        catch(IOException ex)
	        {
	            System.out.println("IOException is caught");
	        }
	}
	
	public static Object deserialize(String path)
	{
		 try
	        {   
	            // Reading the object from a file
	            FileInputStream file = new FileInputStream(path);
	            ObjectInputStream in = new ObjectInputStream(file);
	            Object p=null; 
	            // Method for deserialization of object
	            p = (Object)in.readObject();  
	            in.close();
	            file.close();
	            return p;
	       
	        }
	          
	        catch(IOException ex)
	        {
	            System.out.println("IOException is caught");
	            return null;
	        }
	          
	        catch(ClassNotFoundException ex)
	        {
	            System.out.println("ClassNotFoundException is caught");
	            return null;
	        }
	}
	
	public static boolean check(String t)
	{
		Table tab=(Table) deserialize("src/main/resources/"+t+".ser");
		if(tab!=null)
			return true;
		else 
			return false;
	}

	public static boolean check2(Iterator<String> itr,Hashtable<String, String> colNameType)
	{
		ArrayList<String> y=new ArrayList<String>();
		y.add("java.lang.Integer"); 
		y.add("java.lang.String");
		y.add("java.lang.Double");
		y.add("java.util.Date");
		while(itr.hasNext())
		{
			String z=itr.next();
			if(!(y.contains(colNameType.get(z)))) 
				return true;
		}
		return false;
	}
	
	public static Vector<Object> getTuple(Hashtable<String, Object> y,Vector<String> x)
	{
		Vector<Object> t=new Vector<Object>();
		for(int i=0;i<x.size();i++)
		{
			t.add(y.get(x.get(i)));
		}
		return t;
	}
	
	public static String getLast(TreeMap<String, Vector<Object>> NV)
	{
		Iterator<String> itr=NV.keySet().iterator();
		String z="";
		while(itr.hasNext())
		{
			z=itr.next();
		}
		return z;
	}
	
	public static String getFirst(TreeMap<String, Vector<Object>> NV)
	{
		Iterator<String> itr=NV.keySet().iterator();
		return itr.next();
	}
	
	public static void updateMin(Table t)
	{
		Vector<String> temp=new Vector<String>();
		for(int i=0;i<t.TotalPages;i++)
		{	
			Page p=(Page) deserialize("src/main/resources/"+t.tableName+","+i+".ser");
			String s=getFirst(p.colNameValue);
			temp.add(s);
		}
		t.min=temp;
	}
	
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createTable(String tableName, String clusteringKey,
			Hashtable<String, String> colNameType,
			Hashtable<String, String> colNameMin,
			Hashtable<String, String> colNameMax) throws DBAppException {
		
			Iterator<String> itr = colNameType.keySet().iterator();
			Iterator<String> itr2 = colNameType.keySet().iterator();
			
			//check that all types are valid.
			if(check2(itr2,colNameType))
				throw new DBAppException();
			Vector<String> columns=new Vector<String>();
			while(itr.hasNext())
			{
				String z=itr.next();
				columns.add(z);
				StringBuilder sb=new StringBuilder();
				sb.append(tableName);
				sb.append(",");
				sb.append(z);
				sb.append(",");
				sb.append(colNameType.get(z));
				sb.append(",");
				if(z.equals(clusteringKey))
				{
					sb.append("True");
				}
				else
				{
					sb.append("False");
				}
				sb.append(",");
				sb.append("False");
				sb.append(",");
				sb.append(colNameMin.get(z));
				sb.append(",");
				sb.append(colNameMax.get(z));
				ToWrite(sb.toString(), md);
			}
			Table t=new Table(tableName,clusteringKey,colNameType,colNameMin,colNameMax);
			t.columns=columns;
			serialize(t,"src/main/resources/"+tableName+".ser");
			t=null;
	}

	@Override
	public void createIndex(String tableName, String[] columnNames)
			throws DBAppException 
	{
		Index x=new Index(getIndexName(tableName, columnNames),columnNames);
		
		Table t=(Table)deserialize("src/main/resources/"+tableName+".ser");
		for(int i=0;i<columnNames.length;i++)
		{
			Vector<Range>v=new Vector<Range>();
			
			if(t.colNamType.get(columnNames[i]).equals("java.lang.Integer"))
			{
				int colMin=Integer.parseInt(t.colmin.get(columnNames[i]));
				int colMax=Integer.parseInt(t.colmax.get(columnNames[i]));

				int range=(int)Math.ceil((0.0+colMax-colMin)/10);
				for(int k=0;k<10;k++)
				{
					Range r=new Range(colMin+"",(colMin+range)+"");
					v.add(k,r);
					colMin=colMin+range;
				}
			}
			else if(t.colNamType.get(columnNames[i]).equals("java.lang.String"))
			{
				String colMin= t.colmin.get(columnNames[i]);
				String colMax= t.colmax.get(columnNames[i]);

				int firstMin=getAscii(colMin);
				int firstMax=getAscii(colMax);
				int range=(int)Math.ceil((0.0+firstMax-firstMin)/10);
				for(int k=0;k<10;k++)
				{
					Range r=new Range(firstMin+"",(firstMin+range)+"");
					v.add(k,r);
					firstMin=firstMin+range;
				}
			}
			else if(t.colNamType.get(columnNames[i]).equals("java.lang.Double"))
			{
				Double colMin=Double.parseDouble(t.colmin.get(columnNames[i]));
				Double colMax=Double.parseDouble(t.colmax.get(columnNames[i]));
	
				Double range=(colMax-colMin)/10;
				for(int k=0;k<10;k++)
				{
					Range r=new Range(colMin+"",(colMin+range)+"");
					v.add(k,r);
					colMin+=range;
				}
			}
			else
			{
				String colMin= t.colmin.get(columnNames[i]);
				String colMax= t.colmax.get(columnNames[i]);

				int firstMin=getAscii(colMin);
				int firstMax=getAscii(colMax);
				int range=(int)Math.ceil((0.0+firstMax-firstMin)/10);
				for(int k=0;k<10;k++)
				{
					Range r=new Range(firstMin+"",(firstMin+range)+"");
					v.add(k,r);
					firstMin=firstMin+range;
				}
			}
			x.dimension.add(v);
		}
		
		Vector<String> Id=findIds(findSize(x.dimension));
		
		for(int i=0; i<Id.size();i++)
		{
			Vector<Range> temp=new Vector<Range>();
			for(int j=0;j<x.dimension.size();j++)
			{
				int index =Integer.parseInt(Id.get(i).charAt(j)+"");
				temp.add(x.dimension.get(j).get(index));
			}
			
			Vector<Vector<String>> preData=new Vector<Vector<String>>();
			for(int l=0;l<columnNames.length;l++)
			{
				Vector<String>ForCol=new Vector<String>();
				preData.add(ForCol);
				for(int k=0;k<t.TotalPages;k++)
				{
					Page p=(Page) deserialize("src/main/resources/"+t.tableName+","+k+".ser");
					Iterator<String> itr=p.colNameValue.keySet().iterator();
					while(itr.hasNext())
					{
						String Hash=itr.next();
						Vector<Object> tuple=p.colNameValue.get(Hash);
						int indexOfCloumn=t.columns.indexOf(columnNames[l]);
						
						if(t.colNamType.get(columnNames[l]).equals("java.lang.Integer"))
						{
							int compare=Integer.parseInt(tuple.get(indexOfCloumn)+"");
							int max=Integer.parseInt(temp.get(l).max);
							int min=Integer.parseInt(temp.get(l).min);
							if(compare<max && compare>=min)
								preData.get(l).add(Hash);	
						}
						
						else if(t.colNamType.get(columnNames[l]).equals("java.lang.Double"))
						{
							Double compare=Double.parseDouble(tuple.get(indexOfCloumn)+"");
							Double max=Double.parseDouble(temp.get(l).max);
							Double min=Double.parseDouble(temp.get(l).min);
							if(compare<max && compare>=min)
								preData.get(l).add(Hash);
						}
						
						else if(t.colNamType.get(columnNames[l]).equals("java.lang.String"))
						{
							int compare=getAscii(tuple.get(indexOfCloumn)+"");
							int max=Integer.parseInt(temp.get(l).max);
							int min=Integer.parseInt(temp.get(l).min);
							if(compare<max && compare>=min)
								preData.get(l).add(Hash);
						}
						else if(t.colNamType.get(columnNames[l]).equals("java.lang.Date"))
						{
							int compare=getAscii(tuple.get(indexOfCloumn)+"");
							int max=Integer.parseInt(temp.get(l).max);
							int min=Integer.parseInt(temp.get(l).min);
							if(compare<max && compare>=min)
								preData.get(l).add(Hash);
						}
					}
				}
			}
			Vector<String> data=fin(preData);
			if(data.size()!=0)
			{
				Bucket b=new Bucket(Id.get(i));
				b.totalNumBuckets++;
				b.num=b.totalNumBuckets;
				int mz=100;
				for(int k=0;k<data.size();k++)
				{
					if(k==mz)
					{
						if(k==100)
							x.data.put(Id.get(i), b);
						serialize(b,"src/main/resources/"+x.name+","+b.id+","+b.num+".ser");
						b.totalNumBuckets++;
						int tem=b.totalNumBuckets;
						b=new Bucket(Id.get(i));
						b.totalNumBuckets=tem;
						b.num=b.totalNumBuckets;
						mz=mz+100;
					}
					int num=0;
					for(int l=0;l<t.TotalPages;l++)
					{
						Page p=(Page) deserialize("src/main/resources/"+t.tableName+","+l+".ser");
						if(p.colNameValue.containsKey(data.get(k)))
						{
							num=p.PageNumber;
							break;
						}
					}
					Pointer p=new Pointer(data.get(k));
					p.PageNumber=num;
					b.pointers.add(p);
				}
				if(data.size()<=mz)
					x.data.put(Id.get(i), b);
				serialize(b,"src/main/resources/"+x.name+","+b.id+","+b.num+".ser");
			}
		}
		t.index.add(x.name);
		serialize(t,"src/main/resources/"+tableName+".ser");
		serialize(x,"src/main/resources/"+x.name+".ser");
		t=null;
		x=null;
	}

	@Override
	public void insertIntoTable(String tableName,
			Hashtable<String, Object> colNameValue) throws DBAppException 
	{
		try {
			String[]x=ToRead(md);
			boolean flag =false;
			for(int i=0;i<x.length;i=i+7)
			{
				if(x[i].equals(tableName))
					flag=true;
			}
			if(flag==false)
			{
				throw new DBAppException();
			}
			Table t=(Table)deserialize("src/main/resources/"+tableName+".ser");
			Iterator<String> itr=colNameValue.keySet().iterator();
			while(itr.hasNext())
			{
				boolean flag1=false;
				String z=itr.next();
				for(int i=0;i<x.length;i=i+7)
				{
					if(x[i].equals(tableName) && x[i+1].equals(z))
					{
						flag1=true;
						if(t.colNamType.get(z).equals("java.lang.Date"))
						{
							String []n=colNameValue.get(z).toString().split(" ");
							String n1=n[5]+"-"+getMonth(n[1])+"-"+n[2];
							 if(n1.compareTo(x[i+5])<0 || x[i+6].compareTo(n1)<0)
							 {
								throw new DBAppException(); 
							 }
						}
						else if(t.colNamType.get(z).equals("java.lang.Integer"))
						{
							int n1=Integer.parseInt(""+colNameValue.get(z));
							int n2=Integer.parseInt(x[i+5]);
							int n3=Integer.parseInt(x[i+6]);
							if(n1<n2 || n1>n3)
							{
								throw new DBAppException();
							}
						}
						else if(t.colNamType.get(z).equals("java.lang.Double"))
						{
							Double n1=Double.parseDouble(""+colNameValue.get(z));
							Double n2=Double.parseDouble(x[i+5]);
							Double n3=Double.parseDouble(x[i+6]);
							if(n1<n2 || n1>n3)
							{
								throw new DBAppException();
							}
						}
						else if(t.colNamType.get(z).equals("java.lang.String"))
						{
							if((colNameValue.get(z)+"").compareTo(x[i+5])<0 || x[i+6].compareTo(colNameValue.get(z)+"")<0)
							{
								throw new DBAppException();
							}
						}
					}
				}
				if(flag1==false)
				{
					throw new DBAppException();
				}
			}
			String index=colNameValue.get(t.cluStringKey)+"";
			for(int i=0;i<t.index.size();i++)
			{
				Vector<Object>change=new Vector<Object>();
				Index ind=(Index) deserialize("src/main/resources/"+t.index.get(i)+".ser");				
				
				for(int j=0;j<ind.colnames.length;j++)
				{
					if(ind.colnames[i].equals(t.cluStringKey))
						change.add(index);
					else
						change.add(colNameValue.get(ind.colnames[i]));
				}
				String index1="";
				for(int j=0;j<ind.dimension.size();j++)
				{
					Vector<Range>range=ind.dimension.get(i);
					for(int k=0;k<range.size();k++)
					{
						if(t.colNamType.get(ind.colnames[j]).equals("java.lang.String"))
						{
							int compare=getAscii(change.get(j)+"");
							int max=Integer.parseInt(range.get(k).max);
							int min=Integer.parseInt(range.get(k).min);
							if(compare<max && compare>=min)
							{
								index1=index1+k;
								break;
							}
							
						}
						else if(t.colNamType.get(ind.colnames[j]).equals("java.lang.Integer"))
						{
							int compare=Integer.parseInt(change.get(j)+"");
							int max=Integer.parseInt(range.get(k).max);
							int min=Integer.parseInt(range.get(k).min);
							if(compare<max && compare>=min)
							{
								index1=index1+k;
								break;
							}
						}
						else if(t.colNamType.get(ind.colnames[j]).equals("java.lang.Double"))
						{
							Double compare=Double.parseDouble(change.get(j)+"");
							Double max=Double.parseDouble(range.get(k).max);
							Double min=Double.parseDouble(range.get(k).min);
							if(compare<max && compare>=min)
							{
								index1=index1+k;
								break;
							}
						}
						else if(t.colNamType.get(ind.colnames[j]).equals("java.lang.Date"))
						{
							int compare=getAscii(change.get(j)+"");
							int max=Integer.parseInt(range.get(k).max);
							int min=Integer.parseInt(range.get(k).min);
							if(compare<max && compare>=min)
							{
								index1=index1+k;
								break;
							}
						}
					}
				}
				Bucket b=(Bucket) deserialize("src/main/resources/"+ind.name+","+index1+","+1+".ser");
				int k=1;
				for(k=1;k<=b.totalNumBuckets;k++)
				{
					b=(Bucket) deserialize("src/main/resources/"+ind.name+","+index1+","+k+".ser");
				}
				int yes=binarySearch(t.min, 0, t.min.size()-1, index);
				Pointer p=new Pointer(index);
				p.PageNumber=yes;
				if(b.pointers.size()==100)
				{
					Bucket b1=new Bucket(index);
					b.totalNumBuckets++;
					b1.num=b.totalNumBuckets;
					b1.totalNumBuckets=b.totalNumBuckets;
					b1.pointers.add(p);
					serialize(b1,"src/main/resources/"+ind.name+","+index1+","+b1.num+".ser");
				}
				else	
					b.pointers.add(p);
				serialize(b,"src/main/resources/"+ind.name+","+index1+","+k+".ser");
				serialize(ind,"src/main/resources/"+t.index.get(i)+".ser");

				
			}
			Vector<Object>tup=new Vector<Object>();
			Iterator<String> itr2=colNameValue.keySet().iterator();
			while(itr2.hasNext()) 
			{
				String z=itr2.next();
				tup.add(colNameValue.get(z));
			}
			if(t.TotalPages==0)
			{
				Page p=new Page(0);
				p.colNameValue.put(index, tup);
				p.totalNumTuples++;
				serialize(p, "src/main/resources/"+t.tableName+","+0+".ser");
				p=null;
				t.Pages.add(p);
				t.TotalPages++;
				updateMin(t);
				serialize(t,"src/main/resources/"+tableName+".ser");
				t=null;
				return;
			}
			Vector<String> min =t.min;
			int yes=binarySearch(min, 0, min.size()-1, index);
			Page p=(Page) deserialize("src/main/resources/"+t.tableName+","+yes+".ser");
			p.colNameValue.put(index, tup);
			if(p.colNameValue.size()>200)
			{
				String last=getLast(p.colNameValue);
				Vector<Object> temp=p.colNameValue.get(last);
				p.colNameValue.remove(last);
				serialize(p, "src/main/resources/"+t.tableName+","+yes+".ser");
				if(yes<(t.TotalPages)-1)
				{
					p=(Page) deserialize("src/main/resources/"+t.tableName+","+(yes+1)+".ser");
					if(p.totalNumTuples<200)
					{
						p.colNameValue.put(last, temp);
						p.totalNumTuples++;
						serialize(p, "src/main/resources/"+t.tableName+","+(yes+1)+".ser");
						p=null;
						updateMin(t);
						return;
					}
					else
					{
						for(int i=t.TotalPages-1;i>=yes+1;i--)
						{
							Page p2=(Page) deserialize("src/main/resources/"+t.tableName+","+i+".ser");
							serialize(p2,"src/main/resources/"+t.tableName+","+(i+1)+".ser");
						}
						Page p3=new Page(yes+1);
						p3.colNameValue.put(last, temp);
						p3.totalNumTuples++;
						serialize(p3, "src/main/resources/"+t.tableName+","+(yes+1)+".ser");
						p3=null;
						t.Pages.add(p3);
						t.TotalPages++;
						updateMin(t);
						serialize(t,"src/main/resources/"+tableName+".ser");
						t=null;
						return;
					}
				}
				else
				{
					p=null;
					Page p1=new Page(yes+1);
					p1.colNameValue.put(index, tup);
					p1.totalNumTuples++;
					serialize(p1, "src/main/resources/"+t.tableName+","+(yes+1)+".ser");
					p1=null;
					t.Pages.add(p1);
					t.TotalPages++;
					updateMin(t);
					serialize(t,"src/main/resources/"+tableName+".ser");
					t=null;
					return;
				}
			}
			serialize(p, "src/main/resources/"+t.tableName+","+yes+".ser");
			p.totalNumTuples++;
			p=null;
			updateMin(t);
			serialize(t,"src/main/resources/"+tableName+".ser");
			t=null;
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateTable(String tableName, String clusteringKeyValue,
			Hashtable<String, Object> columnNameValue) throws DBAppException {
		try {
			String[]x=ToRead(md);
			boolean flag =false;
			for(int i=0;i<x.length;i=i+7)
			{
				if(x[i].equals(tableName))
					flag=true;
			}
			if(flag=false)
				throw new DBAppException();
			Table t=(Table)deserialize("src/main/resources/"+tableName+".ser");
			Iterator<String> itr=columnNameValue.keySet().iterator();
			while(itr.hasNext())
			{
				boolean flag1=false;
				String z=itr.next();
				for(int i=0;i<x.length;i=i+7)
				{
					if(x[i].equals(tableName) && x[i+1].equals(z))
					{
						flag1=true;
						if(t.colNamType.get(z).equals("java.lang.Date"))
						{
							String []n=columnNameValue.get(z).toString().split(" ");
							String n1=n[5]+"-"+getMonth(n[1])+"-"+n[2];
							 if(n1.compareTo(x[i+5])<0 || x[i+6].compareTo(n1)<0)
							 {
								throw new DBAppException(); 
							 }
						}
						else if(t.colNamType.get(z).equals("java.lang.Integer"))
						{
							int n1=Integer.parseInt(""+columnNameValue.get(z));
							int n2=Integer.parseInt(x[i+5]);
							int n3=Integer.parseInt(x[i+6]);
							if(n1<n2 || n1>n3)
							{
								throw new DBAppException();
							}
						}
						else if(t.colNamType.get(z).equals("java.lang.Double"))
						{
							Double n1=Double.parseDouble(""+columnNameValue.get(z));
							Double n2=Double.parseDouble(x[i+5]);
							Double n3=Double.parseDouble(x[i+6]);
							if(n1<n2 || n1>n3)
							{
								throw new DBAppException();
							}
						}
						else if(t.colNamType.get(z).equals("java.lang.String"))
						{
							if((columnNameValue.get(z)+"").compareTo(x[i+5])<0 || x[i+6].compareTo(columnNameValue.get(z)+"")<0)
							{
								throw new DBAppException();
							}
						}
					}
				}
				if(flag1==false)
				{
					throw new DBAppException();
				}
			}
			for(int i=0;i<t.index.size();i++)
			{
				Vector<Object>change=new Vector<Object>();
				Index ind=(Index) deserialize("src/main/resources/"+t.index.get(i)+".ser");
				Iterator<String> itr2=ind.data.keySet().iterator();
				String z="";
				while(itr2.hasNext())
				{
					z=itr2.next();
					Bucket b=(Bucket) deserialize("src/main/resources/"+ind.name+","+z+","+1+".ser");
					for(int k=1;k<=b.totalNumBuckets;k++)
					{
						b=(Bucket) deserialize("src/main/resources/"+ind.name+","+z+","+k+".ser");
						for(int k1=0;k1<b.pointers.size();k1++)
						{
							if(b.pointers.get(i).primaryKey.equals(clusteringKeyValue))
							{
								b.pointers.remove(i);
							}
						}
						serialize(b,"src/main/resources/"+ind.name+","+z+","+k+".ser" );
					}
				}
				
				
				for(int j=0;j<ind.colnames.length;j++)
				{
					if(ind.colnames[i].equals(t.cluStringKey))
						change.add(clusteringKeyValue);
					else
						change.add(columnNameValue.get(ind.colnames[i]));
				}
				String index="";
				for(int j=0;j<ind.dimension.size();j++)
				{
					Vector<Range>range=ind.dimension.get(i);
					for(int k=0;k<range.size();k++)
					{
						if(t.colNamType.get(ind.colnames[j]).equals("java.lang.String"))
						{
							int compare=getAscii(change.get(j)+"");
							int max=Integer.parseInt(range.get(k).max);
							int min=Integer.parseInt(range.get(k).min);
							if(compare<max && compare>=min)
							{
								index=index+k;
								break;
							}
							
						}
						else if(t.colNamType.get(ind.colnames[j]).equals("java.lang.Integer"))
						{
							int compare=Integer.parseInt(change.get(j)+"");
							int max=Integer.parseInt(range.get(k).max);
							int min=Integer.parseInt(range.get(k).min);
							if(compare<max && compare>=min)
							{
								index=index+k;
								break;
							}
						}
						else if(t.colNamType.get(ind.colnames[j]).equals("java.lang.Double"))
						{
							Double compare=Double.parseDouble(change.get(j)+"");
							Double max=Double.parseDouble(range.get(k).max);
							Double min=Double.parseDouble(range.get(k).min);
							if(compare<max && compare>=min)
							{
								index=index+k;
								break;
							}
						}
						else if(t.colNamType.get(ind.colnames[j]).equals("java.lang.Date"))
						{
							int compare=getAscii(change.get(j)+"");
							int max=Integer.parseInt(range.get(k).max);
							int min=Integer.parseInt(range.get(k).min);
							if(compare<max && compare>=min)
							{
								index=index+k;
								break;
							}
						}
					}
				}
				Bucket b=(Bucket) deserialize("src/main/resources/"+ind.name+","+index+","+1+".ser");
				int k=1;
				for(k=1;k<=b.totalNumBuckets;k++)
				{
					b=(Bucket) deserialize("src/main/resources/"+ind.name+","+index+","+k+".ser");
				}
				int yes=binarySearch(t.min, 0, t.min.size()-1, clusteringKeyValue);
				Pointer p=new Pointer(clusteringKeyValue);
				p.PageNumber=yes;
				if(b.pointers.size()==100)
				{
					Bucket b1=new Bucket(index);
					b.totalNumBuckets++;
					b1.num=b.totalNumBuckets;
					b1.totalNumBuckets=b.totalNumBuckets;
					b1.pointers.add(p);
					serialize(b1,"src/main/resources/"+ind.name+","+index+","+b1.num+".ser");
				}
				else	
					b.pointers.add(p);
				serialize(b,"src/main/resources/"+ind.name+","+index+","+k+".ser");
				serialize(ind,"src/main/resources/"+t.index.get(i)+".ser");

				
			}
			
			Vector<Object>temp=new Vector<Object>();
			for(int i=0;i<t.columns.size()-1;i++)
			{
				Iterator<String> itr2=columnNameValue.keySet().iterator();
				String z="";
				while(itr2.hasNext())
				{
					z=itr2.next();
					if(z.equals(t.columns.get(i)))
						temp.add(columnNameValue.get(z));
				}
			}
			temp.add(clusteringKeyValue);
			Vector<String> min =t.min;
			int yes=binarySearch(min, 0, min.size()-1, clusteringKeyValue);
			Page p=(Page) deserialize("src/main/resources/"+t.tableName+","+yes+".ser");
			if(p.colNameValue.containsKey(clusteringKeyValue))
			{
				p.colNameValue.replace(clusteringKeyValue, temp);
				serialize(p, "src/main/resources/"+t.tableName+","+yes+".ser");
				p=null;
			}
			else
			{
				serialize(p, "src/main/resources/"+t.tableName+","+yes+".ser");
				p=null;
			}
			serialize(t,"src/main/resources/"+tableName+".ser");
			t=null;
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteFromTable(String tableName,
			Hashtable<String, Object> columnNameValue) throws DBAppException {
		try {
			String[]x=ToRead(md);
			boolean flag =false;
			for(int i=0;i<x.length;i=i+7)
			{
				if(x[i].equals(tableName))
					flag=true;
			}
			if(flag=false)
				throw new DBAppException();
			Table t=(Table)deserialize("src/main/resources/"+tableName+".ser");
			Iterator<String> itr=columnNameValue.keySet().iterator();
		
			while(itr.hasNext())
			{
				boolean flag1=false;
				String z=itr.next();
				for(int i=0;i<x.length;i=i+7)
				{
					if(x[i].equals(tableName) && x[i+1].equals(z))
					{
						flag1=true;
						if(t.colNamType.get(z).equals("java.lang.Date"))
						{
							String []n=columnNameValue.get(z).toString().split(" ");
							String n1=n[5]+"-"+getMonth(n[1])+"-"+n[2];
							 if(n1.compareTo(x[i+5])<0 || x[i+6].compareTo(n1)<0)
							 {
								throw new DBAppException(); 
							 }
						}
						else if(t.colNamType.get(z).equals("java.lang.Integer"))
						{
							int n1=Integer.parseInt(""+columnNameValue.get(z));
							int n2=Integer.parseInt(x[i+5]);
							int n3=Integer.parseInt(x[i+6]);
							if(n1<n2 || n1>n3)
							{
								throw new DBAppException();
							}
						}
						else if(t.colNamType.get(z).equals("java.lang.Double"))
						{
							Double n1=Double.parseDouble(""+columnNameValue.get(z));
							Double n2=Double.parseDouble(x[i+5]);
							Double n3=Double.parseDouble(x[i+6]);
							if(n1<n2 || n1>n3)
							{
								throw new DBAppException();
							}
						}
						else if(t.colNamType.get(z).equals("java.lang.String"))
						{
							if((columnNameValue.get(z)+"").compareTo(x[i+5])<0 || x[i+6].compareTo(columnNameValue.get(z)+"")<0)
							{
								throw new DBAppException();
							}
						}
					}
				}
				if(flag1==false)
				{
					throw new DBAppException();
				}
					
			}
			String index=columnNameValue.get(t.cluStringKey)+"";
			
			for(int j=0;j<t.index.size();j++)
			{
				Index ind=(Index) deserialize("src/main/resources/"+t.index.get(j)+".ser");
				Iterator<String> itr2=ind.data.keySet().iterator();
				String z="";
				while(itr2.hasNext())
				{
					z=itr2.next();
					Bucket b=(Bucket) deserialize("src/main/resources/"+ind.name+","+z+","+1+".ser");
					for(int k=1;k<=b.totalNumBuckets;k++)
					{
						b=(Bucket) deserialize("src/main/resources/"+ind.name+","+z+","+k+".ser");
						for(int k1=0;k1<b.pointers.size();k1++)
						{
							if(b.pointers.get(k1).primaryKey.equals(index))
							{
								b.pointers.remove(k1);
							}
						}
						serialize(b,"src/main/resources/"+ind.name+","+z+","+k+".ser" );
					}
				}
				serialize(ind,"src/main/resources/"+t.index.get(j)+".ser");
			}
			
			
			Vector<String> min =t.min;
			int yes=binarySearch(min, 0, min.size()-1, index);
			Page p=(Page) deserialize("src/main/resources/"+t.tableName+","+yes+".ser");
			if(p.colNameValue.containsKey(index))
			{
				p.colNameValue.remove(index);
				if(p.colNameValue.size()==0)
				{
					if(t.Pages.size()-1>yes)
					{
						for(int i=yes;i<t.Pages.size()-1;i--)
						{
							Page p2=(Page) deserialize("src/main/resources/"+t.tableName+","+(i+1)+".ser");
							serialize(p2,"src/main/resources/"+t.tableName+","+i+".ser");
							p2=null;
						}
					}
					t.TotalPages=t.TotalPages-1;
					p=null;
				}
				else
				{
					serialize(p, "src/main/resources/"+t.tableName+","+yes+".ser");
					p=null;
				}
				updateMin(t);
			}
			else
			{
				serialize(p, "src/main/resources/"+t.tableName+","+yes+".ser");
				p=null;
			}
			serialize(t,"src/main/resources/"+tableName+".ser");
			t=null;
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Iterator selectFromTable(SQLTerm[] sqlTerms, String[] arrayOperators)
			throws DBAppException 
	{
		TreeMap<String,Vector<Object>> res=new TreeMap<String,Vector<Object>>();
		Vector<TreeMap<String,Vector<Object>>> restemp=new Vector<TreeMap<String,Vector<Object>>> ();
		for(int i=0;i<sqlTerms.length;i++)
		{
			Date value1=new Date(0,0,0);
			int value2=0;
			Double value3=0.0;
			String value4="";
			String tableName=sqlTerms[i]._strTableName;
			String colName=sqlTerms[i]._strColumnName;
			String op=sqlTerms[i]._strOperator;
			Table t=(Table)deserialize("src/main/resources/"+tableName+".ser");
			String flag="";
			if(t.colNamType.get(colName).equals("java.lang.Date"))
			{
				 value1=(Date) sqlTerms[i]._objValue;
				 flag="date";
			}
			else if(t.colNamType.get(colName).equals("java.lang.Integer"))
			{
				value2=(Integer) sqlTerms[i]._objValue;
				flag="int";
			}
			else if(t.colNamType.get(colName).equals("java.lang.Double"))
			{
				value3=(Double) sqlTerms[i]._objValue;
				flag="double";
			}
			else if(t.colNamType.get(colName).equals("java.lang.String"))
			{
				value4=(String) sqlTerms[i]._objValue;
				flag="string";
			}
			if(arrayOperators[0].equals("OR"))
			{
				if(op.equals("="))
				{
					for(int j=0;j<t.TotalPages;j++)
					{
						Page p=(Page) deserialize("src/main/resources/"+t.tableName+","+j+".ser");
						Vector<Object>temp=new Vector<Object>();
						int ind=t.columns.indexOf(colName);
						Iterator<String> itr=p.colNameValue.keySet().iterator();
						while(itr.hasNext())
						{
							String z=itr.next();
							temp=p.colNameValue.get(z);
							if(flag.equals("string"))
							{
								if(((String)temp.get(ind)).equals(value4))
								{
									res.put(z,temp);
								}
							}
							else if(flag.equals("date"))
							{
								if(((Date)temp.get(ind)).equals(value1))
								{
									res.put(z,temp);
								}
							}
							else if(flag.equals("int"))
							{
								if((Integer)temp.get(ind)==value2)
								{
									res.put(z,temp);
								}
							}
							else if(flag.equals("double"))
							{
								if((Double)temp.get(ind)==value3)
								{
									res.put(z,temp);
								}
							}
						}
					}
				}
				else if(op.equals("<"))
				{
					for(int j=0;j<t.TotalPages;j++)
					{
						Page p=(Page) deserialize("src/main/resources/"+t.tableName+","+j+".ser");
						Vector<Object>temp=new Vector<Object>();
						int ind=t.columns.indexOf(colName);
						Iterator<String> itr=p.colNameValue.keySet().iterator();
						while(itr.hasNext())
						{
							String z=itr.next();
							temp=p.colNameValue.get(z);
							if(flag.equals("string"))
							{
								if(((String)temp.get(ind)).compareTo(value4)<0)
								{
									res.put(z,temp);
								}
							}
							else if(flag.equals("date"))
							{
								if(((Date)temp.get(ind)).compareTo(value1)<0)
								{
									res.put(z,temp);
								}
							}
							else if(flag.equals("int"))
							{
								if((Integer)temp.get(ind)<value2)
								{
									res.put(z,temp);
								}
							}
							else if(flag.equals("double"))
							{
								if((Double)temp.get(ind)<value3)
								{
									res.put(z,temp);
								}
							}
						}
					}
				}
				else if(op.equals("<="))
				{
					for(int j=0;j<t.TotalPages;j++)
					{
						Page p=(Page) deserialize("src/main/resources/"+t.tableName+","+j+".ser");
						Vector<Object>temp=new Vector<Object>();
						int ind=t.columns.indexOf(colName);
						Iterator<String> itr=p.colNameValue.keySet().iterator();
						while(itr.hasNext())
						{
							String z=itr.next();
							temp=p.colNameValue.get(z);
							if(flag.equals("string"))
							{
								if(((String)temp.get(ind)).compareTo(value4)<=0)
								{
									res.put(z,temp);
								}
							}
							else if(flag.equals("date"))
							{
								if(((Date)temp.get(ind)).compareTo(value1)<=0)
								{
									res.put(z,temp);
								}
							}
							else if(flag.equals("int"))
							{
								if((Integer)temp.get(ind)<=value2)
								{
									res.put(z,temp);
								}
							}
							else if(flag.equals("double"))
							{
								if((Double)temp.get(ind)<=value3)
								{
									res.put(z,temp);
								}
							}
						}
					}
				}
				else if(op.equals(">"))
				{
					for(int j=0;j<t.TotalPages;j++)
					{
						Page p=(Page) deserialize("src/main/resources/"+t.tableName+","+j+".ser");
						Vector<Object>temp=new Vector<Object>();
						int ind=t.columns.indexOf(colName);
						Iterator<String> itr=p.colNameValue.keySet().iterator();
						while(itr.hasNext())
						{
							String z=itr.next();
							temp=p.colNameValue.get(z);
							if(flag.equals("string"))
							{
								if(((String)temp.get(ind)).compareTo(value4)>0)
								{
									res.put(z,temp);
								}
							}
							else if(flag.equals("date"))
							{
								if(((Date)temp.get(ind)).compareTo(value1)>0)
								{
									res.put(z,temp);
								}
							}
							else if(flag.equals("int"))
							{
								if((Integer)temp.get(ind)>value2)
								{
									res.put(z,temp);
								}
							}
							else if(flag.equals("double"))
							{
								if((Double)temp.get(ind)>value3)
								{
									res.put(z,temp);
								}
							}
						}
					}
				}
				else if(op.equals(">="))
				{
					for(int j=0;j<t.TotalPages;j++)
					{
						Page p=(Page) deserialize("src/main/resources/"+t.tableName+","+j+".ser");
						Vector<Object>temp=new Vector<Object>();
						int ind=t.columns.indexOf(colName);
						Iterator<String> itr=p.colNameValue.keySet().iterator();
						while(itr.hasNext())
						{
							String z=itr.next();
							temp=p.colNameValue.get(z);
							if(flag.equals("string"))
							{
								if(((String)temp.get(ind)).compareTo(value4)>=0)
								{
									res.put(z,temp);
								}
							}
							else if(flag.equals("date"))
							{
								if(((Date)temp.get(ind)).compareTo(value1)>=0)
								{
									res.put(z,temp);
								}
							}
							else if(flag.equals("int"))
							{
								if((Integer)temp.get(ind)>=value2)
								{
									res.put(z,temp);
								}
							}
							else if(flag.equals("double"))
							{
								if((Double)temp.get(ind)>=value3)
								{
									res.put(z,temp);
								}
							}
						}
					}
				}
				else if(op.equals("!="))
				{
					for(int j=0;j<t.TotalPages;j++)
					{
						Page p=(Page) deserialize("src/main/resources/"+t.tableName+","+j+".ser");
						Vector<Object>temp=new Vector<Object>();
						int ind=t.columns.indexOf(colName);
						Iterator<String> itr=p.colNameValue.keySet().iterator();
						while(itr.hasNext())
						{
							String z=itr.next();
							temp=p.colNameValue.get(z);
							if(flag.equals("string"))
							{
								if(!(((String)temp.get(ind)).equals(value4)))
								{
									res.put(z,temp);
								}
							}
							else if(flag.equals("date"))
							{
								if(!(((Date)temp.get(ind)).equals(value1)))
								{
									res.put(z,temp);
								}
							}
							else if(flag.equals("int"))
							{
								if((Integer)temp.get(ind)!=value2)
								{
									res.put(z,temp);
								}
							}
							else if(flag.equals("double"))
							{
								if((Double)temp.get(ind)!=value3)
								{
									res.put(z,temp);
								}
							}
						}
					}
				}
			}
			else if(arrayOperators[0].equals("AND"))
			{
				TreeMap<String,Vector<Object>>tempo=new TreeMap<String,Vector<Object>>();
				if(op.equals("="))
				{
					for(int j=0;j<t.TotalPages;j++)
					{
						Page p=(Page) deserialize("src/main/resources/"+t.tableName+","+j+".ser");
						Vector<Object>temp=new Vector<Object>();
						int ind=t.columns.indexOf(colName);
						Iterator<String> itr=p.colNameValue.keySet().iterator();
						while(itr.hasNext())
						{
							String z=itr.next();
							temp=p.colNameValue.get(z);
							if(flag.equals("string"))
							{
								if(((String)temp.get(ind)).equals(value4))
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("date"))
							{
								if(((Date)temp.get(ind)).equals(value1))
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("int"))
							{
								if((Integer)temp.get(ind)==value2)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("double"))
							{
								if((Double)temp.get(ind)==value3)
								{
									tempo.put(z,temp);
								}
							}
						}
					}
				}
				else if(op.equals("<"))
				{
					for(int j=0;j<t.TotalPages;j++)
					{
						Page p=(Page) deserialize("src/main/resources/"+t.tableName+","+j+".ser");
						Vector<Object>temp=new Vector<Object>();
						int ind=t.columns.indexOf(colName);
						Iterator<String> itr=p.colNameValue.keySet().iterator();
						while(itr.hasNext())
						{
							String z=itr.next();
							temp=p.colNameValue.get(z);
							if(flag.equals("string"))
							{
								if(((String)temp.get(ind)).compareTo(value4)<0)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("date"))
							{
								if(((Date)temp.get(ind)).compareTo(value1)<0)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("int"))
							{
								if((Integer)temp.get(ind)<value2)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("double"))
							{
								if((Double)temp.get(ind)<value3)
								{
									tempo.put(z,temp);
								}
							}
						}
					}
				}
				else if(op.equals("<="))
				{
					for(int j=0;j<t.TotalPages;j++)
					{
						Page p=(Page) deserialize("src/main/resources/"+t.tableName+","+j+".ser");
						Vector<Object>temp=new Vector<Object>();
						int ind=t.columns.indexOf(colName);
						Iterator<String> itr=p.colNameValue.keySet().iterator();
						while(itr.hasNext())
						{
							String z=itr.next();
							temp=p.colNameValue.get(z);
							if(flag.equals("string"))
							{
								if(((String)temp.get(ind)).compareTo(value4)<=0)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("date"))
							{
								if(((Date)temp.get(ind)).compareTo(value1)<=0)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("int"))
							{
								if((Integer)temp.get(ind)<=value2)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("double"))
							{
								if((Double)temp.get(ind)<=value3)
								{
									tempo.put(z,temp);
								}
							}
						}
					}
				}
				else if(op.equals(">"))
				{
					for(int j=0;j<t.TotalPages;j++)
					{
						Page p=(Page) deserialize("src/main/resources/"+t.tableName+","+j+".ser");
						Vector<Object>temp=new Vector<Object>();
						int ind=t.columns.indexOf(colName);
						Iterator<String> itr=p.colNameValue.keySet().iterator();
						while(itr.hasNext())
						{
							String z=itr.next();
							temp=p.colNameValue.get(z);
							if(flag.equals("string"))
							{
								if(((String)temp.get(ind)).compareTo(value4)>0)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("date"))
							{
								if(((Date)temp.get(ind)).compareTo(value1)>0)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("int"))
							{
								if((Integer)temp.get(ind)>value2)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("double"))
							{
								if((Double)temp.get(ind)>value3)
								{
									tempo.put(z,temp);
								}
							}
						}
					}
				}
				else if(op.equals(">="))
				{
					for(int j=0;j<t.TotalPages;j++)
					{
						Page p=(Page) deserialize("src/main/resources/"+t.tableName+","+j+".ser");
						Vector<Object>temp=new Vector<Object>();
						int ind=t.columns.indexOf(colName);
						Iterator<String> itr=p.colNameValue.keySet().iterator();
						while(itr.hasNext())
						{
							String z=itr.next();
							temp=p.colNameValue.get(z);
							if(flag.equals("string"))
							{
								if(((String)temp.get(ind)).compareTo(value4)>=0)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("date"))
							{
								if(((Date)temp.get(ind)).compareTo(value1)>=0)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("int"))
							{
								if((Integer)temp.get(ind)>=value2)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("double"))
							{
								if((Double)temp.get(ind)>=value3)
								{
									tempo.put(z,temp);
								}
							}
						}
					}
				}
				else if(op.equals("!="))
				{
					for(int j=0;j<t.TotalPages;j++)
					{
						Page p=(Page) deserialize("src/main/resources/"+t.tableName+","+j+".ser");
						Vector<Object>temp=new Vector<Object>();
						int ind=t.columns.indexOf(colName);
						Iterator<String> itr=p.colNameValue.keySet().iterator();
						while(itr.hasNext())
						{
							String z=itr.next();
							temp=p.colNameValue.get(z);
							if(flag.equals("string"))
							{
								if(!(((String)temp.get(ind)).equals(value4)))
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("date"))
							{
								if(!(((Date)temp.get(ind)).equals(value1)))
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("int"))
							{
								if((Integer)temp.get(ind)!=value2)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("double"))
							{
								if((Double)temp.get(ind)!=value3)
								{
									tempo.put(z,temp);
								}
							}
						}
					}
				}
				restemp.add(tempo);
			}
			else if(arrayOperators[0].equals("XOR"))
			{
				TreeMap<String,Vector<Object>>tempo=new TreeMap<String,Vector<Object>>();
				if(op.equals("="))
				{
					for(int j=0;j<t.TotalPages;j++)
					{
						Page p=(Page) deserialize("src/main/resources/"+t.tableName+","+j+".ser");
						Vector<Object>temp=new Vector<Object>();
						int ind=t.columns.indexOf(colName);
						Iterator<String> itr=p.colNameValue.keySet().iterator();
						while(itr.hasNext())
						{
							String z=itr.next();
							temp=p.colNameValue.get(z);
							if(flag.equals("string"))
							{
								if(((String)temp.get(ind)).equals(value4))
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("date"))
							{
								if(((Date)temp.get(ind)).equals(value1))
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("int"))
							{
								if((Integer)temp.get(ind)==value2)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("double"))
							{
								if((Double)temp.get(ind)==value3)
								{
									tempo.put(z,temp);
								}
							}
						}
					}
				}
				else if(op.equals("<"))
				{
					for(int j=0;j<t.TotalPages;j++)
					{
						Page p=(Page) deserialize("src/main/resources/"+t.tableName+","+j+".ser");
						Vector<Object>temp=new Vector<Object>();
						int ind=t.columns.indexOf(colName);
						Iterator<String> itr=p.colNameValue.keySet().iterator();
						while(itr.hasNext())
						{
							String z=itr.next();
							temp=p.colNameValue.get(z);
							if(flag.equals("string"))
							{
								if(((String)temp.get(ind)).compareTo(value4)<0)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("date"))
							{
								if(((Date)temp.get(ind)).compareTo(value1)<0)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("int"))
							{
								if((Integer)temp.get(ind)<value2)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("double"))
							{
								if((Double)temp.get(ind)<value3)
								{
									tempo.put(z,temp);
								}
							}
						}
					}
				}
				else if(op.equals("<="))
				{
					for(int j=0;j<t.TotalPages;j++)
					{
						Page p=(Page) deserialize("src/main/resources/"+t.tableName+","+j+".ser");
						Vector<Object>temp=new Vector<Object>();
						int ind=t.columns.indexOf(colName);
						Iterator<String> itr=p.colNameValue.keySet().iterator();
						while(itr.hasNext())
						{
							String z=itr.next();
							temp=p.colNameValue.get(z);
							if(flag.equals("string"))
							{
								if(((String)temp.get(ind)).compareTo(value4)<=0)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("date"))
							{
								if(((Date)temp.get(ind)).compareTo(value1)<=0)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("int"))
							{
								if((Integer)temp.get(ind)<=value2)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("double"))
							{
								if((Double)temp.get(ind)<=value3)
								{
									tempo.put(z,temp);
								}
							}
						}
					}
				}
				else if(op.equals(">"))
				{
					for(int j=0;j<t.TotalPages;j++)
					{
						Page p=(Page) deserialize("src/main/resources/"+t.tableName+","+j+".ser");
						Vector<Object>temp=new Vector<Object>();
						int ind=t.columns.indexOf(colName);
						Iterator<String> itr=p.colNameValue.keySet().iterator();
						while(itr.hasNext())
						{
							String z=itr.next();
							temp=p.colNameValue.get(z);
							if(flag.equals("string"))
							{
								if(((String)temp.get(ind)).compareTo(value4)>0)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("date"))
							{
								if(((Date)temp.get(ind)).compareTo(value1)>0)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("int"))
							{
								if((Integer)temp.get(ind)>value2)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("double"))
							{
								if((Double)temp.get(ind)>value3)
								{
									tempo.put(z,temp);
								}
							}
						}
					}
				}
				else if(op.equals(">="))
				{
					for(int j=0;j<t.TotalPages;j++)
					{
						Page p=(Page) deserialize("src/main/resources/"+t.tableName+","+j+".ser");
						Vector<Object>temp=new Vector<Object>();
						int ind=t.columns.indexOf(colName);
						Iterator<String> itr=p.colNameValue.keySet().iterator();
						while(itr.hasNext())
						{
							String z=itr.next();
							temp=p.colNameValue.get(z);
							if(flag.equals("string"))
							{
								if(((String)temp.get(ind)).compareTo(value4)>=0)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("date"))
							{
								if(((Date)temp.get(ind)).compareTo(value1)>=0)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("int"))
							{
								if((Integer)temp.get(ind)>=value2)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("double"))
							{
								if((Double)temp.get(ind)>=value3)
								{
									tempo.put(z,temp);
								}
							}
						}
					}
				}
				else if(op.equals("!="))
				{
					for(int j=0;j<t.TotalPages;j++)
					{
						Page p=(Page) deserialize("src/main/resources/"+t.tableName+","+j+".ser");
						Vector<Object>temp=new Vector<Object>();
						int ind=t.columns.indexOf(colName);
						Iterator<String> itr=p.colNameValue.keySet().iterator();
						while(itr.hasNext())
						{
							String z=itr.next();
							temp=p.colNameValue.get(z);
							if(flag.equals("string"))
							{
								if(!(((String)temp.get(ind)).equals(value4)))
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("date"))
							{
								if(!(((Date)temp.get(ind)).equals(value1)))
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("int"))
							{
								if((Integer)temp.get(ind)!=value2)
								{
									tempo.put(z,temp);
								}
							}
							else if(flag.equals("double"))
							{
								if((Double)temp.get(ind)!=value3)
								{
									tempo.put(z,temp);
								}
							}
						}
					}
				}
				restemp.add(tempo);
			}
		}
		if(arrayOperators[0].equals("OR"))
		{
			Iterator<String> itr2=res.keySet().iterator();
			return itr2;
		}
		else if(arrayOperators[0].equals("AND"))
		{
			res=fin1(restemp);
			Iterator<String> itr2=res.keySet().iterator();
			return itr2;
		}
		else
		{
			res=fin2(restemp);
			Iterator<String> itr2=res.keySet().iterator();
			return itr2;
		}
		
		
	}
}
