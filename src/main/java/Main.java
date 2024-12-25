package Explorer;
		import java.util.Scanner; 
		public class Main {
			public static Scanner reader = new Scanner(System.in); 


			public static Node<Integer> f1(Node<Integer> H) {
				Node<Integer> current = H;
				Node<Integer> newH = new Node<>(null);
				Node<Integer> newCurrent = newH;
				while (current.getNext().getNext()!=null) {
					newCurrent.setNext(current.getNext());
					newCurrent = current.getNext();
					current.setNext(current.getNext().getNext());
					current = current.getNext();
				}
				newCurrent.setNext(current.getNext());
				current.setNext(current.getNext().getNext());
				return newH.getNext();
			}
		

			public static Node<Integer> f2(Node<Integer> head) {
			    Node<Integer> current1 = head;

			    while (current1 != null) {
			        Node<Integer> current2 = current1.getNext();
			        Node<Integer> previous2 = current1;

			        while (current2 != null) {
			            if (current2.getValue()==current1.getValue()) {
			                previous2.setNext(current2.getNext()); 
			            } else {
			                previous2 = current2;  
			            }
			            current2 = current2.getNext();  
			        }
			        current1 = current1.getNext();   
			    }

				return head;
			}
			
		
			
			public static Node<Integer> q1(Node <Integer> list1, Node <Integer>list2) {
			    Node <Integer> Head = null, c = null;
   
			    while (list1 != null && list2 != null) {
			        if (list1.getValue() <= list2.getValue()) {
			            if (Head == null) {
			               Head = c = list1;
			            } else {
			                c.setNext(list1);
			                c = c.getNext();
			            }
			            list1 = list1.getNext();
			        } else {
			            if (Head == null) {
			                Head = c = list2;
			            } else {
			                c.setNext(list2);
			                c = c.getNext();
			            }
			            list2 = list2.getNext();
			        }
			    }

			    if (list1 != null) {
			        c.setNext(list1);
			    } else if (list2 != null) {
			       c.setNext(list2);
			    }

			    return Head;
			}
			
			public static Node<Integer> q2(Node<Integer> head) {
			    if (head == null || head.getNext() == null) {
			        return head; 
			    }

			    Node<Integer> current = head;

			    while (current != null) {
			        Node<Integer> minNode = current;
			        Node<Integer> nextNode = current.getNext();

			        while (nextNode != null) {
			        	if (nextNode.getValue() < minNode.getValue()) {	
			                minNode = nextNode;
			            }
			            nextNode = nextNode.getNext();
			        }

			        int tempValue = current.getValue();
			        current.setValue(minNode.getValue());
			        minNode.setValue(tempValue);

			        current = current.getNext();
			    }

			    return head;
			}

			
			
		    public static void main(String[] args) {
		        Node<Integer> node1 = new Node<>(-8);
		        Node<Integer> node2 = new Node<>(-6);
		        Node<Integer> node3 = new Node<>(-1);
		        Node<Integer> node4 = new Node<>(1);
		        Node<Integer> node5 = new Node<>(4);
		        Node<Integer> node6 = new Node<>(6);

		        node1.setNext(node2);
		        node2.setNext(node3);
		        node3.setNext(node4);
		        node4.setNext(node5);
		        node5.setNext(node6);
		        
		        Node<Integer> n1 = new Node<>(1);
		        Node<Integer> n2 = new Node<>(3);
		        Node<Integer> n3 = new Node<>(5);
		        Node<Integer> n4 = new Node<>(8);
		        Node<Integer> n5 = new Node<>(10);
		        Node<Integer> n6 = new Node<>(11);

		        n1.setNext(n2);
		        n2.setNext(n3);
		        n3.setNext(n4);
		        n4.setNext(n5);
		        n5.setNext(n6);
		        
		        System.out.println(q1(node1,n1));
		
		      }

		    }
