package assign1;

import java.util.Arrays;

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
	 * If list is full the last element is removed.
	 * 
	 * @param num - the number to be added
	 */
	public void add(int num)
	{
		int loopIndex;
		
		if(count  != 10)
		{
			count++;
		}
		
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
	 * 
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
