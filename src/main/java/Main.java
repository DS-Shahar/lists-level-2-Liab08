package Explorer;
		import java.util.Scanner; 
		public class Main {
			public static Scanner reader = new Scanner(System.in); 

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
			

			public static int q3(Node<Integer> a1, int n){
				Node<Integer> a = a1;
				int i=0;
				int length=0;

				 while (a!= null) {
			            length++;
			            a =a.getNext();
			        }
				 a=a1;
				 
				 int minl=length;
				 int minr=length;
				 
				 while(a!=null) {
					if(a.getValue()==n) {
						if(i<minl) {
							minl=i;
							
						}
						if(length-i-1<minr) {
							minr=length-i-1;
						}
					}
					i++;
					a=a.getNext();
				}
				 return minr+minl;
				
			}
			
			
			 public static boolean q4(Node<Integer>head) {
				 Node<Integer> list = head;
				 Node<Integer> current = head.getNext();
				 while(list!=null) {
					 
					 while(current!=null) {
						 if(list.getValue()==current.getValue()) {
							 return false;
						 }
						 else {
							 current=current.getNext();
						 }
					 }
					 list=list.getNext();
				 }
			return true;	 
			 }
			 
			public static Node q5(Node<Integer>L1) {
				    Node<Integer> head = L1;
				    Node<Integer> current1 = L1;
				    Node<Integer> current2 = L1;


				    while (current1.hasNext()) {
				    	current2=current1;
					    while (current2.hasNext()) {
					    	if(current1.getValue()==current2.getNext().getValue()) {
					    		current2.setNext(current2.getNext().getNext());
					    	}
					    	else {
					    		current2=current2.getNext();
					    	}
					    	
					    }
			    		current1=current1.getNext();

				    	
				    }
			    	return head;

				}
				
			 public static int q6(Node<Integer> L1) {
			        Node<Integer> head = L1;
			        int counter = 1;
			        int max = 0;

			        while (head.getNext() != null) {
			            if (head.getNext().getValue() >= head.getValue()) {
			                counter++;
			                head = head.getNext();
			            } else {
			            	if(counter>max) {
			            		max=counter;
			            	}
			                counter = 1;
			                head = head.getNext();
			            }
			        }
			        if(counter>max) {
			        	max=counter;
			        }
			        return max;
			    }
			 
			 
			 public static void q7(Node<Integer> L1) {
				    Node<Integer> head = L1;
				    Node<Integer> maxPointer = head;
				    Node<Integer> startMax = head;
				    Node<Integer> startCur= head;
				    int counter = 1;
				    int max = 0;

				    while (head.getNext() != null) {
				        if (head.getNext().getValue() >= head.getValue()) {
				            counter++;
				            head = head.getNext();
				        } 
				        else {
				            if (counter > max) {
				                max = counter;
				                startMax = startCur;
				            }
				            counter = 1;
				            head = head.getNext();
				            startCur = head;
				        }
				    }
				    if (counter > max) {
				        max = counter;
				        startMax = startCur;
				    }

				    Node<Integer> temp = startMax;
				    for (int i = 0; i < max; i++) {
				        System.out.print(temp.getValue() + " ");
				        System.out.println();
				        temp = temp.getNext();
				    }
				}
			 

			
			
			public static boolean q8(Node<Integer> a1,Node<Integer> b1){
				Node<Integer> a = a1;
		        Node<Integer> b = b1;
				while(a!=null) {
					if(b==null) {
						b=b1;
					}
					if(a.getValue()==b.getValue()) {
						b=b.getNext();
					}
					else {
						return false;
					}
					a=a.getNext();
				}
				if(b==null) {
					return true;
				}
				return false;
				
			}
			
			
			public static boolean q9(Node<Integer> a1,Node<Integer> b1){
				Node<Integer> a = a1;
		        Node<Integer> b = b1;
				while(a!=null) {
					if(b==null) {
						return true;
					}
					if(a.getValue()==b.getValue()) {
						b=b.getNext();
					}
					else {
						b=b1;
					}
					a=a.getNext();
				}
				if(b==null) {
					return true;
				}
				return false;
			}
			
			
			
			public static boolean q10(Node<Integer> a1){
				int [] arr= {0,0,0,0,0,0,0,0,0,0,0};
				while(a1!=null) {
					if(a1.getValue()>10 && a1.getValue()<1) {
						arr[a1.getValue()-1]++;
					}
					a1=a1.getNext();
				}
				for(int i=0;i<10;i++) {
					if(arr[i]==0) {
						return false;
					}
				}
				return true;
			}
			
			
			public static boolean f10(Node<Integer> a1){
				Node<Integer> a = a1;
				boolean b=false;
				for(int i=1;i<11;i++) {
					b=false;
					while(a1!=null) {
						if(i==a1.getValue()) {
							b=true;
						}
						a1=a1.getNext();
				}
					a1=a;
					if(b==false) {
						return false;
					}
				}
				return true;
			
			}

			
			
		    public static void main(String[] args) {
		        Node<Integer> node1 = new Node<>(1);
		        Node<Integer> node2 = new Node<>(3);
		        Node<Integer> node3 = new Node<>(5);
		        Node<Integer> node4 = new Node<>(1);
		        Node<Integer> node5 = new Node<>(1);
		        Node<Integer> node6 = new Node<>(8);

		        node1.setNext(node2);
		        node2.setNext(node3);
		        node3.setNext(node4);
		        node4.setNext(node5);
		        node5.setNext(node6);
		        
		        Node<Integer> n1 = new Node<>(1);
		        Node<Integer> n2 = new Node<>(3);
		        Node<Integer> n3 = new Node<>(5);
		      

		        n1.setNext(n2);
		        n2.setNext(n3);
		  
		        
		        System.out.println(q3(node1,5));
		
		      }

		    }
