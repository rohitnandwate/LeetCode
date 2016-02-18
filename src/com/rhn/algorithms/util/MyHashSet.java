package com.rhn.algorithms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MyHashSet<K> implements Set<K>{
		
	private static final int DEFAULT_CAPACITY = 16;
	private static final double LOAD_FACTOR = 0.75;
	private static final int EXPANSION_FACTOR = 10;

	private Object[] table;
	private int capacity;
	private int size;

	public MyHashSet() {
		table = new Object[DEFAULT_CAPACITY];
		capacity = DEFAULT_CAPACITY;
		size = 0;
	}
	
	public MyHashSet(int initialCapacity) {
		table = new Object[initialCapacity];
		capacity = initialCapacity;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		int index = hash(o);
		Entry entry = (MyHashSet<K>.Entry) table[index];
		if(entry == null) {
			return false;
		}
		while(entry != null) {
			if(entry.equals(o)) {
				return true;
			}
			entry = entry.next;
		}
		return false;
	}

	@Override
	public Iterator<K> iterator() {
		return new EntryIterator();
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
	public boolean add(K e) {
		if(isOverloaded()) {
			resize();
		}
		int index = hash(e);
		Entry entry = (MyHashSet<K>.Entry) table[index];
		if(entry == null) {
			entry = new Entry(e);
			table[index] = entry; 
			return true;
		} else {
			while(entry != null) {
				if(e.equals(entry.value)) {
					return false;
				}
				entry = entry.next;
			}
			Entry newEntry = new Entry(e);
			entry.next = newEntry;
			return true;
		}
	}

	private int hash(Object e) {
		int hashCode = e.hashCode();
		return hashCode % capacity;
	}

	private void resize() {
		Object[] oldTable = table;
		capacity = capacity * EXPANSION_FACTOR;
		table = new Object[capacity];
		for(Object o : oldTable){
			Entry e = (MyHashSet<K>.Entry) o;
			if(e == null) {
				continue;
			}
			while(e != null) {
				this.add(e.value);
				e = e.next;
			}
		}
	}

	private boolean isOverloaded() {
		double load = (double)size/(double)capacity;
		return load >= 0.75;
	}

	@Override
	public boolean remove(Object o) {
		int index = hash(o);
		Entry entry = (MyHashSet<K>.Entry) table[index];
		if(entry == null) {
			return false;
		}
		Entry prev = null;
		while(entry != null) {
			if(o.equals(entry)) {
				break;
			}
			prev = entry;
			entry = entry.next;
		}
		if(prev == null) {
			table[index] = null;
			return true;
		} else if(entry == null){
			return false;
		} else {
			prev.next = entry.next;
			return true;
		}
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends K> c) {
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
	
	final class EntryIterator implements Iterator<K> {
		
		private int count = 0;
		private int currIndex = 0;
		private Entry currEntry = null;

		@Override
		public boolean hasNext() {
			return count < size;
		}

		@Override
		public K next() {
			if(!hasNext()) {
				return null;
			}
			while(currEntry == null && currIndex < capacity) {
				currEntry =  (MyHashSet<K>.Entry) table[currIndex++];
			}
			if(currEntry != null) {
				K next = currEntry.value;
				currEntry = currEntry.next;
				return next;
			}
			return null;
		}
		
	}
	

	final class Entry {
		private K value;
		private Entry next;
		public Entry(K value) {
			this.value = value;
			this.next = null;
		}
	}
}
