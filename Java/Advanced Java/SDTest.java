import java.io.*;

class Student implements Serializable
{
	int no;
	String name;
	float avg;
	
	public void putData(int n,String na,float avg)
	{
		System.out.println("Student:putData()");
		no = n;name = na;this.avg=avg;
	}
	
	public void display()
	{
		System.out.println("Student:display() -- "+no+" "+name+" "+avg);
	}
	
}

public class SDTest
{
	public void mySerialize(Object obj)
	{
		try
		{
			FileOutputStream fos=new FileOutputStream("abc.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
			fos.close();oos.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Object myDeserialize()
	{
		Object obj=null;
		try
		{
			FileInputStream fis=new FileInputStream("abc.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			obj=ois.readObject();
			fis.close();ois.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return obj;
	}
	
	public static void main(String args[])
	{
		SDTest sd = new SDTest();
		Student st = new Student();
		st.putData(101,"uday",58.98f);
		
		sd.mySerialize(st);
		System.out.println("Serialization complete");
		
		Object obj = sd.myDeserialize();
		Student st2 = (Student)obj;
		st2.display();
		System.out.println("DeSerialization complete");
	}
}