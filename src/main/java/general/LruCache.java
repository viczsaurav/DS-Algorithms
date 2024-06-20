package general;
import java.util.*;

/**
 * LRU Cache Algorithm implementation
 * https://youtu.be/iuqZvajTOyA?t=624
 */
//TODO

public class LruCache {

    private final Map<Integer, Node> map;
    private final int capacity;

    private Node head= new Node(0,0); //dummy head;
    private Node tail= new Node(0,0); //dummy tail;

    public LruCache(int capacity){
        this.map = new HashMap<Integer, Node>();
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    /**
     *  define GET method
     *  1. Check if item is in the cache
     *  2. If yes:
     *      a. return value;
     *      b. bring the element to head of doubly linked list => delete from current position, insert to head position
     */
    public int get(int key){
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }


    /**
     * Define PUT method
     * 1. If item already exists, update item and move to head
     * 2. If item is not present, check if cache is full(capacity)
     *      a. if not full, add to head and map
     *      b. if full, remove the tail and insert at head.
     */
    public void put(int key, int value){
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size()==this.capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }


    /**
     * Operation functions
     */

    private void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node){
        map.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public static void main(String[] args) {
//        LruCache lRUCache = new LruCache(2);
//        lRUCache.put(1, 1); // cache is {1=1}
//        lRUCache.put(2, 2); // cache is {1=1, 2=2}
//        lRUCache.get(1);    // return 1
//        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//        lRUCache.get(2);    // returns -1 (not found)
//        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//        lRUCache.get(1);    // return -1 (not found)
//        lRUCache.get(3);    // return 3
//        lRUCache.get(4);    // return 4
        LruCache lRUCache = new LruCache(1);
        lRUCache.put(2, 1); // cache is {2=1}
        lRUCache.get(2);    // return 1
    }

}

class Node {
    int key, value;
    Node prev, next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
