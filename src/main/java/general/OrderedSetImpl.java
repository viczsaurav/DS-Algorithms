package general;

import java.util.*;

public class OrderedSetImpl<T> {
	/**
	 * Implement OrderedSet
	 * .add(num)
	 * .remove(num)
	 * .toArray()
	 * .contain(num)
	 */

	private List<T> orderedSet =  new ArrayList<>();
	private transient Object[] elementData;

	public boolean add(T num){
		if (orderedSet.contains(num)){
			// Assumption: Addition of new Object in Set changes the order(makes its current). RETURN here if not required
			orderedSet.remove(num);
		}
		return orderedSet.add(num);
	}

	public boolean remove(T num){
		return orderedSet.remove(num);
	}

	@SuppressWarnings("unchecked")
	public T[] toArray(){
		T[] arr = (T[])new Object[orderedSet.size()];
		List<T> newList =  Collections.unmodifiableList(orderedSet);		// Creating read-only list
		return newList.toArray(arr);		// Shallow copy of original
	}


	public boolean contain(T num) {
		return orderedSet.contains(num);
	}
}

class Num {

	private Integer num;

	public Num(int i){
		this.num=i;
	}

	public Integer getNum(){
		return num;
	}

	public static void main(String[] args) {


		Num num1 = new Num(1);
		Num num2 = new Num(2);
		Num num3 = new Num(3);
		Num num4 = new Num(4);
		Num num5 = new Num(5);

		OrderedSetImpl<Num> mySet = new OrderedSetImpl<>();

		mySet.add(num1);
		mySet.add(num2);
		mySet.add(num3);
		mySet.add(num4);

		Object[] val = mySet.toArray();

		for (int i=0; i<val.length;i++){
			System.out.println(((Num)val[i]).getNum());
		}

		mySet.add(num2);
		mySet.remove(num3);
		System.out.println(mySet.contain(num3));

		val = mySet.toArray();
		for (int i=0; i<val.length;i++){
			System.out.println(((Num)val[i]).getNum());
		}
	}
}


