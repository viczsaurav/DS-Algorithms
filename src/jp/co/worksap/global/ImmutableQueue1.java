package jp.co.worksap.global;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * The Queue class represents an immutable first-in-first-out (FIFO) queue of
 * objects.
 * 
 * @param <E>
 */
public class ImmutableQueue1<E> {
	/**
	 * requires default constructor.
	 */

	private static class InternalStack<E> {
		private E front;
		private InternalStack<E> rear;
		private int size;

		private InternalStack() {
			this.front = null;
			this.rear = null;
			this.size = 0;
		}

		private InternalStack(E element, InternalStack<E> rear) {
			this.front = element;
			this.rear = rear;
			this.size = rear.size + 1;
		}

		private static InternalStack newStack() {
			return new InternalStack();
		}

		public InternalStack<E> toReverseStack() {
			InternalStack<E> invertedStack = new InternalStack<E>();
			InternalStack<E> tail = this;
			while (!tail.isEmpty()) {
				invertedStack = invertedStack.push(tail.front);
				tail = tail.rear;
			}
			return invertedStack;
		}

		public boolean isEmpty() {
			return this.size == 0;
		}

		public InternalStack<E> push(E element) {
			return new InternalStack<E>(element, this);
		}
	}

	private InternalStack<E> orderedStack;
	private InternalStack<E> reversedStack;
	private E topElement;

	public ImmutableQueue1() {
		this.orderedStack = InternalStack.newStack();
		this.reversedStack = InternalStack.newStack();
	}

	public ImmutableQueue1(InternalStack<E> inOrder, InternalStack<E> inReverse) {
		this.orderedStack = inOrder;
		this.reversedStack = inReverse;
	}

	public ImmutableQueue1<E> enqueue(E e) {
		if (null == e)
			throw new IllegalArgumentException();
		return new ImmutableQueue1<E>(this.orderedStack.push(e), this.reversedStack);
	}

	public ImmutableQueue1<E> dequeue() {
		if (this.isEmpty())
			throw new NoSuchElementException();
		if (!this.reversedStack.isEmpty())
			return new ImmutableQueue1<E>(this.orderedStack,
					this.reversedStack.rear);
		else
			return new ImmutableQueue1<E>(InternalStack.newStack(),
					this.orderedStack.toReverseStack().rear);
	}

	private boolean isEmpty() {
		// TODO Auto-generated method stub
		return size() == 0;
	}

	public E peek() {
		if (this.isEmpty())
			throw new NoSuchElementException();
		if (this.reversedStack.isEmpty())
			balanceQueue();
		return this.reversedStack.front;
	}

	public int size() {
		return this.orderedStack.size + this.reversedStack.size;
	}

	private void balanceQueue() {
		this.reversedStack = this.orderedStack.toReverseStack();
		this.orderedStack = InternalStack.newStack();
	}
}
