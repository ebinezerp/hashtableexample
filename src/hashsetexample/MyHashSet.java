package hashsetexample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class MyHashSet<E> implements Set<E> {

	private Hashtable<Integer, Bucket<E>> hashtable;
	private static int noOfElements;
	private int size = 10;

	public MyHashSet() {
		// TODO Auto-generated constructor stub
		hashtable = new Hashtable<Integer, Bucket<E>>(size);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		ArrayList<E> elements=new ArrayList<E>();

		for (Entry<Integer, Bucket<E>> entries : hashtable.entrySet()) {
			Iterator<E> iterator=entries.getValue().iterator();
			while(iterator.hasNext())
			{
				elements.add(iterator.next());
			}
			
		}

		return elements.iterator();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		resize();
		if (hashtable.get(hashing(e)) == null) {
			Bucket<E> bucket = new Bucket<E>();
			bucket.add(e);
			noOfElements++;
			hashtable.put(hashing(e), bucket);
		} else {
			hashtable.get(hashing(e)).add(e);
		}
		return true;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		try {
		Integer i=hashing(o);
		hashtable.remove(i);
		size--;
		return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	private int hashing(Object o) {
		return o.hashCode() % this.size();
	}

	private void resize() {
		
		
		
		
		
		if (noOfElements + 1 > (150 * this.size()) / 100) {
			this.size = this.size() + 10;
			
			
			
			Hashtable<Integer, Bucket<E>> hashtable = new Hashtable<Integer, Bucket<E>>(this.size);

			for (Entry<Integer, Bucket<E>> entry : this.hashtable.entrySet()) {
				hashtable.put(entry.getKey(), entry.getValue());
			}

			this.hashtable = hashtable;

		}
	}
	
	
	public E get(E e)
	{
	      LinkedList<E> list= hashtable.get(hashing(e));
	      
	      for(E ele:list)
	      {
	    	  if(ele.equals(e))
	    	  {
	    		  return ele;
	    	  }
	      }
	      
	      return null;
	      
	}
	


}