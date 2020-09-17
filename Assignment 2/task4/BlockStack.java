package task4;

import myExceptions.StackException;

/**
 * Class BlockStack
 * Implements character block stack and operations upon it.
 *
 * $Revision: 1.4 $
 * $Last Revision Date: 2018/02/04 $
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca;
 * Inspired by an earlier code by Prof. D. Probst

 */
class BlockStack
{
	/**
	 * Keeps track of number of times stack is accessed.
	 */
	private int accessCounter; // TASK 1: added stack access counter attribute; TASK 2.1: visibility changed to private
	/**
	 * # of letters in the English alphabet + 2
	 */
	public static final int MAX_SIZE = 28;

	/**
	 * Default stack size
	 */
	public static final int DEFAULT_SIZE = 6;

	/**
	 * Current size of the stack
	 */
	private int iSize = DEFAULT_SIZE; // TASK 2.1: visibility changed to private

	/**
	 * Current top of the stack
	 */
	private int iTop = 3; // TASK 2.1: visibility changed to private

	/**
	 * stack[0:5] with four defined values
	 */
	private char acStack[] = new char[] {'a', 'b', 'c', 'd', '$', '$'}; // TASK 2.1: visibility changed to private

	/**
	 * Default constructor
	 */
	public BlockStack()
	{
	}

	/**
	 * Supplied size
	 */
	public BlockStack(final int piSize)
	{
		if(piSize != DEFAULT_SIZE)
		{
			this.acStack = new char[piSize];

			// Fill in with letters of the alphabet and keep
			// 2 free blocks
			for(int i = 0; i < piSize - 2; i++)
				this.acStack[i] = (char)('a' + i);

			this.acStack[piSize - 2] = this.acStack[piSize - 1] = '$';

			this.iTop = piSize - 3;
			this.iSize = piSize;
		}
	}

	/**
	 * Getter for stackAccessCounter 
	 * @return int value
	 */
	public int getAccessCounter() // TASK 2.1: added getter for private attributes
	{
		return accessCounter;
	}

	/**
	 * Getter for iSize 
	 * @return int value
	 */
	public int getISize() // TASK 2.1: added getter for private attributes
	{
		return iSize;
	}

	/**
	 * Getter for iTop 
	 * @return int value
	 */
	public int getITop() // TASK 2.1: added getter for private attributes
	{
		return iTop;
	}

	/**
	 * Getter for acStack 
	 * @return array of char
	 */
	public char[] getAcStack() // TASK 2.1: added getter for private attributes
	{
		return acStack;
	}

	/**
	 * Picks a value from the top without modifying the stack
	 * @return top element of the stack, char
	 */
	public char pick() throws StackException
	{
		// TASK 2.3: check if stack is empty before popping elements.
		if (isEmpty())
			throw new StackException("No stack top. Stack is empty.");

		accessCounter++; // TASK 1: increment stack access counter when this method is called
		return this.acStack[this.iTop];
	}

	/**
	 * Returns arbitrary value from the stack array
	 * @return the element, char
	 */
	public char getAt(final int piPosition) throws StackException
	{
		// TASK 2.3: check if piPosition is in the stack's array bounds.
		if (piPosition < 0 || piPosition > iSize - 1) // index is out of bounds
			throw new StackException("Index: " + piPosition + " is out of bounds of the stack's array");

		// no need to check for other exceptions. If the stack is empty, simply return the empty char '$'.

		accessCounter++; // TASK 1: increment stack access counter when this method is called
		return this.acStack[piPosition];
	}

	/**
	 * Standard push operation
	 */
	public void push(final char pcBlock) throws StackException
	{
		// TASK 2.3: check if stack if full before pushing elements.
		if (isFull())
			throw new StackException("Cannot push new element to a full stack.");

		accessCounter++; // TASK 1: increment stack access counter when this method is called
		// TASK 2.2: if stack is empty, place 'a' on top
		if (isEmpty())
			acStack[++iTop] = 'a';
		else
			this.acStack[++this.iTop] = pcBlock;
	}

	/**
	 * Standard pop operation
	 * @return ex-top element of the stack, char
	 */
	public char pop() throws StackException
	{
		// TASK 2.3: check if stack is empty before popping elements.
		if (isEmpty())
			throw new StackException("Cannot pop element from an empty stack.");

		accessCounter++; // TASK 1: increment stack access counter when this method is called
		char cBlock = this.acStack[this.iTop];
		this.acStack[this.iTop--] = '$'; // Leave prev. value undefined
		return cBlock;
	}
	/**
	 * Checks if the stack is empty.
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty() // TASK 2: empty stack implementation
	{
		return (iTop == -1);
	}
	/**
	 * Checks if the stack is full.
	 * @return true if full, false otherwise
	 */
	public boolean isFull() // TASK 2: full stack implementation
	{
		return (iTop == iSize - 1);
	}
}

// EOF
