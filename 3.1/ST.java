import java.util.ArrayList;
import java.util.Scanner;

public class ST<Key, Value> {
	private int size;
	private STNode<Key, Value> head;
	private STNode<Key, Value> tail;

	public ST() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}

	public void put(Key key, Value value) {
		STNode<Key, Value> newNode = new STNode<>(key, value);
		if (size == 0) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.setLink(newNode);
			this.tail = newNode;
		}
		this.size += 1;
	}

	public Value get(Key key) {
		Value out = null;
		STNode<Key, Value> currNode = this.head;
		for (int i = 0; i < this.size; i++) {
			if (currNode.getKey().equals(key)) {
				out = currNode.getValue();
				break;
			}
			currNode = currNode.getLink();
		}
		return out;
	}

	public ArrayList<Key> keys() {
		ArrayList<Key> out = new ArrayList<Key>(); // not valid
		STNode<Key, Value> currNode = this.head;
		for (int i = 0; i < this.size; i++) {
			out.add(currNode.getKey());
			currNode = currNode.getLink();
		}
		return out;
	}

	public int size() {
		return this.size;
	}

	public static void main(String[] args) {
		ST<String, Double> x = new ST<>();
		x.put("A+",4.33);
		x.put("A",4.00);
		x.put("A-",3.67);
		x.put("B+",3.33);
		x.put("B",3.00);
		x.put("B-",2.67);
		x.put("C+",2.33);
		x.put("C",2.00);
		x.put("C-",1.67);
		x.put("D",1.00);
		x.put("F",0.00);

		Double sum = 0.0;
		int count = 0;
		Scanner s = new Scanner(System.in);

		System.out.println("I will compute your GPA from letter grades. Please enter the grades:");
		while (s.hasNext()) {
			String token = s.next();
			if (token.equals("done")) break;
			sum += x.get(token);	
			count += 1;
		}

		double GPA = sum / count;
		System.out.println("Your GPA is " + GPA);

	}
}
