package pimco.com.codetask;

import java.util.Iterator;

public class FilteringIterator<E>  implements Iterator<E>{
	private IObjectTest<E> iObjectTest;
	private Iterator<E> iterator;
	private E nextCached;
	
	
	public FilteringIterator(IObjectTest<E> iObjectTest, Iterator<E> iterator) {
		super();
		this.iObjectTest = iObjectTest;
		this.iterator = iterator;
	}

	public boolean hasNext() {
		//find valid next item using iObejctTest, if found save it to nextCached. and return true ,else false.
		while(iterator.hasNext()){
			E temp=iterator.next();
			if(iObjectTest.test(temp)){
				nextCached=temp;
				return true;
			}
		}
		return false;
	}

	public E next() {
		return nextCached;
	}
	
	

}
