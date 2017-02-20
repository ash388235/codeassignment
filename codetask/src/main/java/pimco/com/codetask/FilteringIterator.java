package pimco.com.codetask;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
		if(nextCached!=null){
			E temp=nextCached;
			nextCached=null;
			return temp;
		}else if(hasNext()==true){
			E temp=nextCached;
			nextCached=null;
			return temp;
		}else{
		    throw new NoSuchElementException("No such Element available.");
		}
		
		
	}

	public IObjectTest<E> getiObjectTest() {
		return iObjectTest;
	}

	public void setiObjectTest(IObjectTest<E> iObjectTest) {
		this.iObjectTest = iObjectTest;
	}

	public Iterator<E> getIterator() {
		return iterator;
	}

	public void setIterator(Iterator<E> iterator) {
		this.iterator = iterator;
	}
	
	

}
