import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{		
		Create o = new Create(); 
		o.GetInputInfo();

		    
		Thread[] newThreads = new Thread[o.amountOfThreads];

		for (int i = 0; i < o.amountOfThreads; i++) {
			newThreads[i] = new Thread(new Create());
			newThreads[i].run();
		}
				    
		    System.out.println("Сумма чисел от 1 до "+o.amountOfNum+" равна "+o.Sum);
		    
	}
}


class Create extends Thread
{
	static volatile int counter = 0;
	static volatile long Sum = 0;
	static int amountOfThreads = 0;
	static volatile int amountOfNum = 0;
	
	public void GetInputInfo()
	{
		System.out.println("Введите количество Потоков");
		Scanner scan=new Scanner(System.in);
		amountOfThreads=scan.nextInt();
		System.out.println("Введите количество Чисел");
		amountOfNum=scan.nextInt();
	}
	
	public void run() 
	{		
		counter++; 
		
		for(int i=counter; i<=amountOfNum;i=i+amountOfThreads)
		{
			Sum=Sum+i;
		}		
		
		//System.out.println("Counter: " + counter+"    "+Sum);
	}
}
