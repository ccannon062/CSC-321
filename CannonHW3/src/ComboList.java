import java.util.ArrayList;
import java.util.List;

/**
 * Starter class for implementing a ComboList.
 *   @author Dave Reed (modified by Caleb Cannon)
 *   @author 2/9/24
 */
public class ComboList<T> {
    private Node<ArrayList<T>> front;
    private Node<ArrayList<T>> back;
    private int nodeCapacity;
    private int listSize;
    
    /**
     * Constructs an empty list.
     *   @param capacity maximum number of values that can be stored in a node
     */
    public ComboList(int capacity) {
        this.nodeCapacity = capacity;
        this.front = new Node<ArrayList<T>>(new ArrayList<T>(), null);
        this.back = this.front;
    }
    
    /**
     * Adds an element to the end of the list.
     *   @param item the item to be added
     */
    public void add(T item) {
        if (this.back.getData().size() == this.nodeCapacity) {
            this.back.setNext(new Node<ArrayList<T>>(new ArrayList<T>(), null));
            this.back = this.back.getNext();
        }
        this.back.getData().add(item);
        listSize++;
    }

    /**
     * Displays the contents of the ComboList, node by node, for debugging purposes.
     */
    public void sneakPeek() {
        Node<ArrayList<T>> stepper = this.front;
        int nodeNum = 0;
        while (stepper != null) {
            System.out.println(nodeNum++ + ": " + stepper.getData());
            stepper = stepper.getNext();
        }	
    }
    
    /**
     * Method that accesses the private listSize field and returns its value.
     * @return listSize 
     */
    
    public int size() {
    	return listSize;
    }
    
	/**
	 * Method that finds the appropriate node and accesses the appropriate index of its ArrayList.
	 * @param index
	 * @return stepper.getData().(index)), the value of the character at the specified index.
	 */
    
    public T get(int index) {
    	Node<ArrayList<T>> stepper = this.front;
    	if (index == 0) {
    		return(stepper.getData().get(0));
    	}
    	while(index - stepper.getData().size() >= 0) {
    		index -= stepper.getData().size();
    		if(stepper.getNext() == null) {
    			throw new IndexOutOfBoundsException("Invalid index");
    		}
    		stepper = stepper.getNext();
    	}
    	return(stepper.getData().get(index));
    }
    
    /**
     * Method that provides capability of inserting at a specific index within the list.
     * @param index
     * @param value
     * @return true
     */
    
    public boolean add(int index, T value) {
    	Node<ArrayList<T>> stepper = this.front;
	    	while(index - stepper.getData().size() >= 0) {
	    		index -= stepper.getData().size();
	    		if(stepper.getNext() == null) {
	    			throw new IndexOutOfBoundsException("Invalid index");
	    		}
	    		stepper = stepper.getNext();
	    	}
	    	if (stepper.getData().size() < nodeCapacity) {
	    		stepper.getData().add(index, value);
	    		listSize++;
		    	return true;
	    	}
	    	else if(stepper.getNext() == null) {
	    		T removeVal = stepper.getData().remove(nodeCapacity - 1);
	    		stepper.getData().add(index, value);
	    		add(removeVal);
	    		listSize++;
	    		return true;
	    	}
	    	else if(stepper.getNext().getData().size() < nodeCapacity) {
    			T removeVal = stepper.getData().remove(nodeCapacity - 1);
    			stepper.getData().add(index, value);
    			stepper.getNext().getData().add(0, removeVal);
    			listSize++;
    			return true;
    		}
	    	else {
	    		T newValue = stepper.getData().remove(nodeCapacity - 1);
    			stepper.getData().add(index, value);
    			Node<ArrayList<T>> newNode = new Node<ArrayList<T>>(new ArrayList<T>(), stepper.getNext());
    			newNode.getData().add(newValue);
    			stepper.setNext(newNode);
    			listSize++;
    			return true;
	    	}
    }
    
    /**
     * Method that compiles multiple ArrayLists into a single ArrayList.
     * @return combinedArray
     */
    
    public List<T> tolist() {
    	ArrayList<T> combinedArray = new ArrayList<>();
    	Node<ArrayList<T>> stepper = this.front;
    	while(stepper != null) {
    		for(int i = 0; i < stepper.getData().size(); i++) {
    			combinedArray.add(stepper.getData().get(i));
    		}
    		stepper = stepper.getNext();
    	}
    	return combinedArray;
    }
    
    /**
     * Overriden toString method that comples multiple values of an ArrayList into a string format.
     * @return combinedString
     */
    
    @Override
    public String toString() {
    	String combinedString = "";
    	List<T> fullist = tolist();
    	combinedString += "[";
    	for(int i = 0; i < fullist.size(); i++) {
    		if(i == fullist.size() - 1) {
    			combinedString += fullist.get(i);
    			break;
    		}
    		combinedString += fullist.get(i) + ", ";
    	}
    	combinedString += "]";
    	return combinedString;
    }
}
