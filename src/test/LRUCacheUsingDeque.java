/**
 * 
 */
package test;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author duchauha
 *
 */
public class LRUCacheUsingDeque {
	
	private Deque<Integer> cache;
	private HashSet<Integer> hashset;
	private  int CACHE_SIZE;
	
	LRUCacheUsingDeque(int capacity){
		cache = new LinkedList<>();
		hashset = new HashSet<>();
		CACHE_SIZE = capacity;
	}
    
	private void refer(int page) {
		if(!hashset.contains(page)) {
			if(CACHE_SIZE == cache.size()) {
				int last = cache.removeLast();
				hashset.remove(last);
			}
			
		}else {
			cache.remove(page);
		}
		cache.push(page);
		hashset.add(page);
	}
	
	private void display() {
		Iterator<Integer> itr = cache.iterator();
		while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCacheUsingDeque cache = new LRUCacheUsingDeque(4);
		cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);
        
        cache.display();
	}

}
