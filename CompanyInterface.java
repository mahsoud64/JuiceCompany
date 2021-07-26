import java.util.*;
public class CompanyInterface
{	
	private Factory factory1=null, factory2=null, factory3=null;
	private int end1 = 0, choice2;
	private Warehouse warehouse1=null, warehouse2=null, warehouse3=null;
	private String name1;	 
	
public static void main(String[]args)
    {
	 CompanyInterface ci = new CompanyInterface();
	 ci.run();
	}

private void run(){ //Refactored
	do
	{	Scanner console = new Scanner(System.in);
			System.out.println("(1) create a factory");
			System.out.println("(2) create a new warehouse for a factory");
			System.out.println("(3) list of warehouses");
			System.out.println("(4) list of factories");
			System.out.println("(5) list of warehouses with a particular fruit");
			System.out.println("(6) analyse what juices the company can make");
			System.out.println("(7) delete a factory");
			System.out.println("(8) delete a warehouse");
			System.out.println("(9) exit");
			int choice = console.nextInt();

	switch (choice)
	{
	  case 1:
		{
		 makeFactory(console);
		 break;
		}
	  case 2:
		{
		makeWarehouse(console);
		break;
		}
	  case 3:
		{
		listWarehouses(console);
		break;
		}
	  case 4:
		{
		listFactories(console);
		break;
		}
	  case 5:
		{
		listFruit(console);
		break;
		}
	  case 6:
		{
		analyse(console);
		break;
		}
	  case 7:
		{
		deleteFactory(console);
		break;
		}
	  case 8:
		{
		deleteWarehouse(console);
		break;
		}
	  case 9:
		{
		System.out.println("You exited!");
		console.close();
		return;
		}
		default:		// Used if the user inputs a number that isn't in the switch case	
		{
		System.out.println(" Incorrect input, please start again and enter 1-9\n");
		}
	}
	System.out.println("\n Do you want to continue? (any) yes, (0) no");
	end1 = console.nextInt();	
	} while(end1!=0);
}

public void makeFactory(Scanner y)		// creates a factory and produces an error if factory already exists
    {
          if (factory1==null||factory2==null||factory3==null) //Factory limit check
	  {	
		 System.out.println( "Please enter the name of your Factory");
		 y.nextLine();
		 name1= y.nextLine();
		
		if (!checkFactoryExist(name1))
		{ 
		 if (factory1==null)
		   {
			factory1= new Factory();
			factory1.setName(name1);
			System.out.println("Name:" + factory1.getName());
		    }
		    else if (factory2==null)
		    {
			factory2= new Factory();
			factory2.setName(name1);
			System.out.println("Name:" + factory2.getName());
		    }
		    else if (factory3==null)
		    {
			factory3= new Factory();
			factory3.setName(name1);
			System.out.println("Name:" + factory3.getName());
		     }
		}
		else
		{
			System.out.println("That factory already exits");
		}
	  }
		else
	  {
		    System.out.println("There is no space");
	  }
	 }// Adds a factory 
	 
public void makeWarehouse(Scanner y)
    {
	if(factory1==null && factory2==null && factory3==null)

	  { 
		System.out.println( "There are no factories to add a warehouse to");
		return;
	  }
	System.out.println( " what factory would you like to add a warehouse into");
	if (factory1!=null)
		System.out.println(" Press (1) to add a warehouse to" +factory1.getName());
	if (factory2!=null)
		System.out.println(" Press (2) to add a warehouse to" +factory2.getName());
	if (factory3!=null)
		System.out.println(" Press (3) to add a warehouse to" +factory3.getName());

	choice2= y.nextInt();
	  switch(choice2)
	  {
		case 1:
		{	
			if(factory1!= null)
			{
			  int n = factory1.getNumberWarehouses();
			  if (n== 3)
			  {
			System.out.println(" You cannot add more then 3 factories, delete before adding another one");
			  }
			else
		 	  {
			factory1.addWarehouse(y);
			  }
			}
			else
			{
			System.out.println(" You didn't choose a valid option");
			}
		  break;
		}
		case 2:
		{
			if (factory2!= null)
			{
			  int n = factory2.getNumberWarehouses();
			  if (n== 3)
			  {
			System.out.println(" You cannot add more then 3 factories, delete before adding another one");
			  }
			else
		 	  {
			factory2.addWarehouse(y);
			  }
			}
			else
			{
			System.out.println(" You didn't choose a valid option");
			}
		  break;
		}
		case 3:
		{
			if (factory3!= null)
			{
			  int n = factory3.getNumberWarehouses();
			  if (n== 3)
			  {
			System.out.println(" You cannot add more then 3 factories, delete before adding another one");
			  }
			else
		 	  {
			factory3.addWarehouse(y);
			  }
			}
			else
			{
			System.out.println(" You didn't choose a valid option");
			}
		  break;
		}
	}
    }// Adds a new warehouse to a factory. Doesn't add a warehouse if the factory doesn't exist or is full.
public void listWarehouses(Scanner y)
    {
		boolean u;
		System.out.println(" What factory would you like to list all the warehouse for?");
		if(factory1!=null) System.out.println("Press (1) for all the warehouses in" +factory1.getName());
		if(factory2!=null) System.out.println("Press (2) for all the warehouses in" +factory2.getName());
		if(factory3!=null) System.out.println("Press (3) for all the warehouses in" +factory3.getName());
		choice2=y.nextInt();
		switch (choice2)
		{
			case 1:
			{
			   if (factory1!=null)
			   {
					u= factory1.checkWarehouse();
					if(!u)
					{
					System.out.println("There is no warehouse within this factory so the warehouse cannot be listed");
					}
					System.out.println(factory1.list());
			   }
			   else
			   System.out.println("That wasn't a valid factory so it cannot be listed");
			  break;
			}
			case 2:
			{
			 if (factory2!=null)
			   {
					u= factory2.checkWarehouse();
					if(!u)
					{
					System.out.println("There is no warehouse within this factory so the warehouse cannot be listed");
					}
					System.out.println(factory2.list());
			   }
			   else
			   System.out.println("That wasn't a valid factory so it cannot be listed");
			  break;
			}
			case 3:
			{
			 if (factory3!=null)
			   {
					u= factory3.checkWarehouse();
					if(!u)
					{
					System.out.println("There is no warehouse within this factory so the warehouse cannot be listed");
					}
					System.out.println(factory3.list());
			   }
			   else
			   System.out.println("That wasn't a valid factory so it cannot be listed");
			  break;
			 }
			 
		}
    }// List all the warehouses
public void listFactories( Scanner y)
    {
		System.out.println("The following is a list of all factories and warehouses");
		if (factory1==null && factory2==null && factory3==null)
		{
			System.out.println(" There are no factories to list");
		}
		if ( factory1!=null)
		{
			System.out.println("Factory name: " +factory1.getName());
			System.out.println(factory1.list());
		}
		if ( factory2!=null)
		{
			System.out.println("Factory name: " +factory2.getName());
			System.out.println(factory2.list());
		}
		if ( factory3!=null)
		{
			System.out.println("Factory name: " +factory3.getName());
			System.out.println(factory3.list());
		}
    }//List all the factories
public void listUnder(Scanner y)
    {               int under;
                System.out.println("What is the maximum capacity in tonnes?");
                under= y.nextInt();
                System.out.println("All the warehouses under this mass are:");
                if (warehouse1 !=null)
                {   
					// System.out.print(warehouse1.underCapacity(under));
					System.out.println("lol-1"+under);
                }
                if (warehouse2!=null)
                {   
					// System.out.print(warehouse2.underCapacity(under));
					System.out.println("lol-1"+under);
                }
                if (warehouse3!=null)
                {   
					// System.out.print(warehouse3.underCapacity(under));
					System.out.println("lol-1"+under);
                }
     }//List all the warehouses under a certain weight limit
public void listFruit(Scanner y)
    {
		String fruit;
		boolean u = false;
		System.out.println("please enter the fruit you want a list of warehouses for");
		y.nextLine();
		fruit=y.nextLine();
		while(!u)
		  {
			if ( fruit.equalsIgnoreCase("apple") || fruit.equalsIgnoreCase("orange") || fruit.equalsIgnoreCase("pear"))
			{
				u= true;
			}
			{	
				System.out.println("Fruit can only be apple,pear or orange, please enter the fruit of the warehouse: ");
			fruit=y.nextLine();
			}
		   }
		System.out.println("All the warehouses of this fruit are: ");
			if (factory1==null && factory2==null && factory3==null)
			{
				System.out.println("There are no warehouses with this fruit");
			}
			if (factory1!=null)
			{
				System.out.println(factory1.listFruit(fruit));
			}
			if (factory2!=null)
			{
				System.out.println("\n" +factory2.listFruit(fruit));
			}
			if (factory3!=null)
			{
				System.out.println("\n" +factory3.listFruit(fruit));
			}
			if (factory3!=null && factory2!=null && factory1!=null && factory1.listFruit(fruit).equals("") && factory2.listFruit(fruit).equals("") && factory3.listFruit(fruit).equals(""))
			{
				System.out.println("There are no warehouses to display within any of the factories");
			}
     }// List all the warehouse with a specific fruit. Don't show if warehouse doesn't exist
public void deleteFactory(Scanner y)
     {
	String choice="";
	boolean u = false;
		System.out.println(" Please enter the name of the factory you would like to delete from the following options:");
		if (factory1!=null || factory2!=null || factory3!=null)
		{
		  if (factory1!=null) 
			System.out.println(factory1.getName());
		  if (factory2!=null) 
			System.out.println(factory2.getName());
		  if (factory3!=null) 
			System.out.println(factory3.getName());
		  y.nextLine();
		  choice= y.nextLine();
		}
		else 
		{
			System.out.println (" There are no factories to list you must create them before deleting");
			u= true;
		}
		if (factory1!=null)
		{
		  if (factory1.getName().equalsIgnoreCase(choice))
		  {
			System.out.println(factory1.getName()+ "was deleted");
			factory1=null;
			u=true;
		  }
		}
		if (factory2!=null)
		{
		  if (factory2.getName().equalsIgnoreCase(choice))
		  {
			System.out.println(factory2.getName()+ "was deleted");
			factory2=null;
			u=true;
		  }
		}
		if (factory3!=null)
		{
		  if (factory3.getName().equalsIgnoreCase(choice))
		  {
			System.out.println(factory3.getName()+ "was deleted");
			factory3=null;
			u=true;
		  }
		}
		if (!u)
		 {
			System.out.println("That factory doesn't exist");
		 }
    }   // Deletes a factory
public void deleteWarehouse (Scanner y)
    {   
	String choice;
	System.out.println("Please enter the warehouse that you would like to delete, the options are:");
	if (factory1!=null)
		System.out.println(" All warehouses in" +factory1.getName()+"are"+factory1.list());
	if (factory2!=null)
		System.out.println(" All warehouses in" +factory2.getName()+"are"+factory2.list());
	if (factory3!=null)
		System.out.println(" All warehouses in" +factory3.getName()+"are"+factory3.list());
	else
		System.out.println("There are no warehouses to delete");
		choice = y.next();
	if (factory1!=null)
	  {
		if (factory1.checkWarehouseExists(choice))
		{
			factory1.deleteWarehouse(choice);
		}
	  }
	if (factory2!=null)
	  {
		if (factory2.checkWarehouseExists(choice))
		{
			factory2.deleteWarehouse(choice);
		}
	  }
	if (factory3!=null)
	  {
		if (factory3.checkWarehouseExists(choice))
		{
			factory3.deleteWarehouse(choice);
		}
	  }
    }// Deletes a warehouse
public Boolean checkFactoryExist(String x)
    {
        if(factory1 != null)
        {
            if(factory1.getName().equals(x))
            {
                return true;
            }
        }
        if(factory2 != null)
        {
            if(factory2.getName().equals(x))
            {
                return true;
            }
        }
        if(factory3 != null)
        {
            if(factory3.getName().equals(x))
            {
                return true;
            }
        }
        return false;
	}
	public void analyse(Scanner y){
		System.out.println("ANALYSE NEEDS WORK LAD!");
	}

}
