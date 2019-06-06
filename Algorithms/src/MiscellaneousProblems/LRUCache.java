package MiscellaneousProblems;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

	static class Node {
		int data;

		public Node(int data) {
			this.data = data;
		}
	}

	static Map<Integer, Node> map = new HashMap<>();
	static Deque<Node> dq = new LinkedList<>();
	static int cSize;

	LRUCache(int cSize) {
		LRUCache.cSize = cSize;
	}

	public void refer(int x) {
		if(map.get(x)==null) {
			if(dq.size() == cSize) {
				Node n = dq.removeLast();
				map.remove(n.data);
			}
		}else {
			dq.remove(map.get(x));
		}
		map.put(x, new Node(x));
		dq.push(map.get(x));
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(4);
		cache.refer(1);
		cache.refer(2);
		cache.refer(3);
		cache.refer(1);
		cache.refer(4);
		cache.refer(5);
		LRUCache.dq.stream().map(n -> n.data).forEach(System.out::println);

	}

}
