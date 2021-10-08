public class STNode<Key, Value> {
	private Key k; // key
	private Value v; // value 
	private STNode<Key, Value> l; // next node

	public STNode()  {
		this.k = null;
		this.v = null;
		this.l = null;
	}
	
	public STNode(Key k, Value v)  {
		this.k = k;
		this.v = v;
		this.l = null;
	}

	public STNode(Key k, Value v, STNode<Key, Value> l)  {
		this.k = k;
		this.v = v;
		this.l = l;
	}
	
	public Key getKey() {
		return this.k;
	}

	public void setKey(Key k) {
		this.k = k;
	}

	public Value getValue() {
		return this.v;
	}
	
	public void setValue(Value v) {
		this.v = v;
	}

	public STNode<Key, Value> getLink() {
		return this.l;
	}

	public void setLink(STNode<Key, Value> n) {
		this.l = n;
	}

	public static void main(String [] args) {
		STNode<String, Integer> x = new STNode<>("x",5); // using diamond notation because Java compiler will infer our types of k and v
		System.out.println(x.getValue());
		System.out.println(x.getKey());
	}
}
