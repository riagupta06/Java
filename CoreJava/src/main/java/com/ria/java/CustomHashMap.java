
public class CustomHashMap<K,V> {
	
	private int capacity = 4;
	private Entry<K,V> [] table;
	
	@SuppressWarnings("unchecked")
	public CustomHashMap() {
		table = new Entry[capacity];
	}
	
	static class Entry<K,V> {
		K key;
		V value;
		Entry<K,V> next;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}
	
	public V get(K key) {
		int hash = hash(key);
		Entry<K,V> entries = table[hash];
		if(entries == null) {
			return null;
		} 
		while(entries != null) {
			if(entries.key.equals(key)) {
				return entries.value;
			}
			entries = entries.next;
		}
		return null;
	}
	
	public void put(K key, V value) {
		int hash = hash(key);
		Entry<K, V> entry = new Entry<K, V>(key, value);
		Entry<K, V> entries = table[hash];
		if(entries == null) {
			table[hash] = entry;
		} else {
			Entry<K, V> previous = null;
			Entry<K, V> current = entries;
			while(current != null) {
				if(current.key.equals(key)){
					current.value = value;
					break;
				} else {
					previous = current;
					current = current.next;
				}
			}
			if(previous != null) {
				previous.next = entry;	
			}
		}
	}
	
	/*public boolean remove(K key) {
		int hash = hash(key);
		Entry<K, V> entries = table[hash];
		
		
		return false;
	}*/
	
	private int hash(K key) {
		return Math.abs(key.hashCode()%4);
	}

}
