package solution02;

import java.util.*;


/**
 * This class file is to buid a hashmap which allows us to map from an element an item 
 * of type T to an ArrayList of type E.
 * This is a common solution to key conflicts.
 * This is the generic format.
 * @author qiuyi
 *
 */
public class HashMapList<T, E> {
	private HashMap<T, ArrayList<E>> map = new HashMap<T, ArrayList<E>>();
	
	/**
	 * This method is to add an item to this hash map list
	 * @param key
	 * @param item
	 */
	public void put(T key, E item) {
		if(!map.containsKey(key)) {
			map.put(key, new ArrayList<E>());
		}
		map.get(key).add(item);
	}
	
	/**
	 * This method is to put an array list which is indexed with its key into the hash map list.
	 * @param key
	 * @param items
	 */
	public void put(T key, ArrayList<E> items) {
		map.put(key, items);
	}
	
	/**
	 * This method is to get an array list with its key.
	 * @param key
	 * @return
	 */
	public ArrayList<E> get(T key) {
		return map.get(key);
	}
	
	/**
	 * This method is to check if the map contains the key.
	 * @param key
	 * @return
	 */
	public boolean containsKey(T key) {
		return map.containsKey(key);
	}
	
	/**
	 * This method is to check if this array list given its key contains the value.
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean containsValue(T key, E value) {
		ArrayList<E> list = map.get(key);
		if(list == null) return false;
		return list.contains(value);
	}
	
	/**
	 * This method is to get the key set contained in this map.
	 * @return
	 */
	public Set<T> keySet() {
		return map.keySet();
	}
	
	@Override
	public String toString() {
		return map.toString();
	}
}
