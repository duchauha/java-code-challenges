/**
 * 
 */
package hashing;

import java.util.ArrayList;
/**
 * @author duchauha
 *
 */
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

import com.google.common.base.Charsets;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class ConsistentHash<T> {
    private final HashFunction hashFunction;
    private final int numberOfReplicas;
    private final SortedMap<Long, T> circle = new TreeMap<Long, T>();

    public ConsistentHash(HashFunction hashFunction, int numberOfReplicas,
            Collection<T> nodes) {
        this.hashFunction = hashFunction;
        this.numberOfReplicas = numberOfReplicas;

        for (T node : nodes) {
            add(node);
        }
    }

    public void add(T node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.put(hashFunction.hashString(node.toString() + i,Charsets.UTF_8).asLong(),
                    node);
           
        }
    }

    public void remove(T node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.remove(hashFunction.hashString(node.toString() + i,Charsets.UTF_8).asLong());
        }
    }

    public T get(Object key) {
        if (circle.isEmpty()) {
            return null;
        }
        long hash = hashFunction.hashString(key.toString(),Charsets.UTF_8).asLong();
        if (!circle.containsKey(hash)) {
            SortedMap<Long, T> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }
    
    public static void main(String[] args) {
    	ArrayList<String> al = new ArrayList<String>(); 
        al.add("redis1");
        al.add("redis2");
        al.add("redis3");
        al.add("redis4");

        String[] userIds = 
        {"84942321036308",
        "76029520310209",
        "68343931116147",
        "54921760962352",
        "11111760962352",
        "redis30"
        };
        HashFunction hf = Hashing.md5();

        ConsistentHash<String> consistentHash = new ConsistentHash<String>(hf, 100, al); 
        for (String userId : userIds) {
            System.out.println(consistentHash.get(userId));
        }
   }
}