import java.util.*;
public class Factory
{
    private String name= "";
    private Warehouse warehouse1= null, warehouse2= null, warehouse3= null;
    private int maxCap=0, n = 0;
    
    public Factory()
    {

    }

    public String getName()
    {
        return name;
    }// Gets the name of the factory

    public void setName(String inputName)
    {
        name= inputName;
    }//Sets the name of the factory

    public void addWarehouse(Scanner x)
    {
        boolean u= false;
        if (warehouse1==null || warehouse2==null || warehouse3==null)
            {   
                System.out.println("Please enter the name of your warehouse:");
                x.nextLine();
                String name = x.nextLine();
                System.out.println("Please enter the name of your fruit:");
                String fruit = x.nextLine();
                System.out.println(" Please enter the capacity of your warehouse in tonnes:");
                int capacity= x.nextInt();
                maxCap += capacity;
                if (maxCap > maxCap)
                {
                    System.out.println(" The warehouse is too big therefore cannot be added");
                    return;
                }
                System.out.println("Please enter the fruit of the warehouse:");
                x.nextLine();
                
                while(!u)
                {
                    if (fruit.equalsIgnoreCase("apple")||fruit.equalsIgnoreCase("pear")||fruit.equalsIgnoreCase("orange"))
                    u= true;
                    else 
                    {
                        System.out.println(" Fruit can only be apple, pear or orange. Please enter the fruit of the warehouse");
                        fruit= x.nextLine();
                    }
                }
        if (warehouse1!=null)
            {
                if (name.equals(warehouse1.getName()) && fruit.equals(warehouse1.getFruit()) && capacity==warehouse1.getCapacity())
                {
                    System.out.println("That warehouse already exists so it can't be added");
                    return;
                }
            }
        if (warehouse2!=null)
            {
                if (name.equals(warehouse2.getName()) && fruit.equals(warehouse2.getFruit()) && capacity==warehouse2.getCapacity())
                {
                    System.out.println("That warehouse already exists so it can't be added");
                    return;
                }
            }
        if (warehouse3!=null)
            {
                if (name.equals(warehouse3.getName()) && fruit.equals(warehouse3.getFruit()) && capacity==warehouse3.getCapacity()) 
                {
                    System.out.println("That warehouse already exists so it can't be added");
                    return;
                }
            }
        if (warehouse1==null)
            {
                warehouse1= new Warehouse();
                warehouse1.setName(name);
                warehouse1.setFruit(fruit);
                warehouse1.setCapacity(capacity);
            }
        else if (warehouse2==null)
            {
                warehouse2= new Warehouse();
                warehouse2.setName(name);
                warehouse2.setFruit(fruit);
                warehouse2.setCapacity(capacity);
            }
        else if (warehouse3==null)
            {
                warehouse3= new Warehouse();
                warehouse3.setName(name);
                warehouse3.setFruit(fruit);
                warehouse3.setCapacity(capacity);
            }       
        }
        else
            {
                System.out.println(" There is no space available");
            }
    } // Used in every function of companyInterface
public int getNumberWarehouses()
{
    if (warehouse1!=null && warehouse2!=null && warehouse3!=null)
    {
        n = n + 3;
    }
    return n;
}// Gets the number of warehouses in a factory
public String list()
{
    String returnS=null;
    if (warehouse1!=null || warehouse2!=null || warehouse3!=null)
    {
        if (warehouse1!=null)
        {
            returnS= "\n\n Warehouse name:" + warehouse1.getName() + "\n Warehouse fruit: " +warehouse1.getFruit() + "\n Warehouse capacity:" +warehouse1.getCapacity();
        }
        if (warehouse2!=null)
        {
            returnS= "\n\n Warehouse name: "+warehouse2.getName() + "\n Warehouse fruit:" +warehouse2.getFruit() + "\n Warehouse capacity: " +warehouse2.getCapacity();
        }
        if (warehouse3!=null)
        {
            returnS= "\n\n Warehouse name: "+warehouse3.getName() + "\n Warehouse fruit:" +warehouse3.getFruit() + "\n Warehouse capacity:" +warehouse3.getCapacity();
        }
        return returnS;
    }
    else
    return ("\n There is no warehouses in the Factory");
}// Gives list of warehouses

public String listFruit(String f)
{
    String fruit="";
    if (warehouse1!=null)
        {
        if (warehouse1.getFruit().equals(f))
            {
                fruit += warehouse1.getName();
            }
        } 
    if (warehouse2!=null)
        {
        if (warehouse2.getFruit().equals(f))
            {
                fruit += "\n"+warehouse2.getName();
            }
        } 
    if (warehouse3!=null)
        {
        if (warehouse3.getFruit().equals(f))
            {
                fruit += "\n"+ warehouse3.getName();
            }
        } 
    return fruit;
}
public String underCapacity(int x)
{
    String return2="";
    if (warehouse1!=null)
    {
        if (warehouse1.getCapacity()<x)
        {
            return2 += warehouse1.getName();
        }
    }
    if (warehouse2!=null)
    {
        if (warehouse2.getCapacity()<x)
        {
            return2 += "\n" +warehouse2.getName();
        }
    }
    if (warehouse3!=null)
    {
        if (warehouse3.getCapacity()<x)
        {
            return2 += "\n" +warehouse3.getName();
        }
    }
    return return2;
}// Checks which warehouses are under the maximun capacity
    

public void deleteWarehouse(String c)
{
    if(warehouse1!=null)
    {
        if(warehouse1.getName().equals(c))
        {   
            System.out.println(warehouse1.getName()+"was deleted");
            warehouse1=null;
        }
    }
    if(warehouse2!=null)
    {
        if(warehouse2.getName().equals(c))
        {   
            System.out.println(warehouse2.getName()+"was deleted");
            warehouse2=null;
        }
    }   
    if(warehouse3!=null)
    {
        if(warehouse3.getName().equals(c))
        {   
            System.out.println(warehouse3.getName()+"was deleted");
            warehouse3=null;
        }
    }               
}

public boolean checkWarehouseExists(String c)
{	
	boolean u=false;
	if(warehouse1!=null)
	{
		if(warehouse1.getName().equals(c))
		{
			u=true;
		}
	}
	if(warehouse2!=null)
	{
		if(warehouse2.getName().equals(c))
		{
			u=true;
		}
	}
	if(warehouse3!=null)
	{
		if(warehouse3.getName().equals(c))
		{
			u=true;
		}
	}
	return u;
}

public boolean checkWarehouse()
{ 
	if (warehouse1==null && warehouse2==null && warehouse3==null)
	{
		return false;
	}
	else
	{	
		return true;
	}
}
}
