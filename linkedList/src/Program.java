public class Program {

	interface Node {
		public int getValue();
		public void setValue(int value);
		
		public Node getNext();
		public void setNext(Node node);
	}
	
	class NodeImpl implements Node {

		private int _value;
		private Node _node;
		
		@Override
		public int getValue() {
			// TODO Auto-generated method stub
			return _value;
		}

		@Override
		public void setValue(int value) {
			// TODO Auto-generated method stub
			_value = value;
		}

		@Override
		public Node getNext() {
			// TODO Auto-generated method stub
			return _node;
		}

		@Override
		public void setNext(Node node) {
			// TODO Auto-generated method stub
			_node = node;
		}
	}
	
	public static Node getList() {
		Node node = new Program().new NodeImpl();
		Node first = node;
		
		node.setValue(1);
		
		for(int i=2; i<=100; i++) {
			Node n = new Program().new NodeImpl();
			n.setValue(i);
			
			node.setNext(n);
			node = n;
		}
		
		return first;
	}
	
	public static Node revList(Node node) {
		Node lastNode = new Program().new NodeImpl();
	    lastNode.setValue(node.getValue());

	    while(node.getNext() != null) {	        
	        Node backNode = new Program().new NodeImpl();
	        backNode.setValue(node.getNext().getValue());
	        backNode.setNext(lastNode);
	        
	        lastNode = backNode;
	        node = node.getNext();
	    }
	    
	    return lastNode;
	}
	
	public static void main(String[] args) {
		System.out.println("Start");
		
		Node node = getList();
		node = revList(node);
		
		while(node != null) {
			System.out.println(node.getValue());
			node = node.getNext();
		}
	}
}
