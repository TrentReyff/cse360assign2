package assign1;

/**
 * @author Trent Reyff
 * <br><br>ClassID: 428
 * <br><br>Assignment: 1
 * <br><br>Description: A list that can hold up to 10 integers with basic functionality.
 * 		 Can add or remove elements, return the count, search for an element
 * 		 or return the list as a string. 
 */

public class SimpleList
{
	
	private int[] list;
	private int count;
	
	/**
	 * Basic constructor.
	 * Creates an array that holds 10 ints and sets count to 0.
	 */
	public SimpleList()
	{
		this.list = new int[10];
		this.count = 0;
	}
	
	/**
	 * Add a number to the beginning of list moving all other integers over.
	 * If list is full the list size is increased by 50%
	 *
	 * @param num - the number to be added
	 */
	public void add(int num)
	{
		int loopIndex = 0;
		
		if(count  == list.length)
		{
			int[] tempList = new int[list.length * 3 / 2];
			while(loopIndex < list.length)
			{
				tempList[loopIndex] = list[loopIndex];
				loopIndex++;
			}
			
			list = tempList;
		}
		
		count++;
		
		loopIndex = count - 1;
		
		while(loopIndex > 0)
		{
			list[loopIndex] = list[loopIndex - 1];
			loopIndex--;
		}
		
		list[0] = num;
	}
	
	/**
	 * Remove an element from the list if found
	 * Also checks if list is less than 3/4 full and reduces the list size if true
	 * @param num - the number to be removed
	 */
	public void remove(int num)
	{
		int removeIndex = search(num);
		int loopIndex;
		
		if(removeIndex != -1)
		{
			loopIndex = removeIndex + 1;
			while(loopIndex < count)
			{
				list[loopIndex - 1] = list[loopIndex];
				loopIndex++;
			}
			list[count - 1] = 0;
			count--;
		}
		
		if(count < list.length * 3 / 4)
		{
			int[] tempList = new int[count];
			loopIndex = 0;
			while(loopIndex < count)
			{
				tempList[loopIndex] = list[loopIndex];
				loopIndex++;
			}
			list = tempList;
		}
	}
	
	/**
	 * Returns the integer count in the list
	 * 
	 * @return count
	 */
	public int count()
	{
		return count;
	}
	
	/**
	 * Returns the list as a string
	 */
	public String toString()
	{
		String listString = "[";
		int loopIndex = 0;
		
		while(loopIndex < count)
		{
			listString+= " " + list[loopIndex];
		}
		listString+= "]";
		
		return listString;		
	}
	
	/**
	 * Searches for the index of the param within the list
	 * 
	 * @param num - the number to search for
	 * @return the index the number was found at within the list
	 * 			or -1 if not found
	 */
	public int search(int num)
	{
		int loopIndex = 0;
		int numIndex = -1;
		while(loopIndex < count && numIndex == -1)
		{
			if(list[loopIndex] == num)
			{
				numIndex = loopIndex;
			}
			loopIndex++;
		}
		return numIndex;
	}
	
}
