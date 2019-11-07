package com.test.excel;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.google.common.collect.Iterators;

public class MainIterator {
	public static void main(String args[]) {
		List<Integer> l = new LinkedList<Integer>();

		// Now add elements to the Link List
		l.add(2);
		l.add(3);
		l.add(4);

		// Iterator to iterate over a Link List
		Iterator<Integer> it = l.iterator();
		int size = Iterators.size(it);
		
		while (it.hasNext()) {
			System.out.println("Value: " + it.next());
//			System.out.println("sss "+size);
		}

	}
}