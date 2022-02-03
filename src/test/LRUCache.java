/**
 * 
 */
package test;

//LRU cache basically a combination of DoublyLinkedList and
//HashMap to support all the operation in constant time
import java.util.HashMap;

 
class DList{
    int key;
    int val;
    DList next;
    DList prev;
    
    DList(int key,int val){
        this.key=key;
        this.val=val;
    }
    
}

class LRUCache {
    
    HashMap<Integer,DList> map;
    DList head;
    DList tail;
    int cacheSize;
    
    public LRUCache(int capacity) {
        cacheSize = capacity;
        map = new HashMap<>();
        head = new DList(-1,-1);
        tail = new DList(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    private void addNode(DList node){
        map.put(node.key,node);
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next =node;
    }
    
    private void deleteNode(DList node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            DList node = map.get(key);
            deleteNode(node);
            addNode(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            DList node = map.get(key);
            deleteNode(node);
        }else if(map.size()==cacheSize){
            deleteNode(tail.prev);
        }
         addNode(new DList(key,value));
    }

 
    public static void main(String[] args) {
    	LRUCache lRUCache = new LRUCache(2);
    	lRUCache.put(1, 1); // cache is {1=1}
    	lRUCache.put(2, 2); // cache is {1=1, 2=2}
    	System.out.println(lRUCache.get(1));    // return 1
    	lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    	System.out.println(lRUCache.get(2));    // returns -1 (not found)
    	lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    	System.out.println(lRUCache.get(1));    // return -1 (not found)
    	System.out.println(lRUCache.get(3));    // return 3
    	System.out.println(lRUCache.get(4));    // return 4
    }
}
