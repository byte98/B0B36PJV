package cz.cvut.fel.pjv;

/**
 * Implementation of the {@link Queue} backed by fixed size array.
 */
public class CircularArrayQueue implements Queue {
    
    /**
     * Stores information about <code>Queue</code> capacity.
     */
    private int capacity;
    
    /**
     * Stores information about count of members in <code>Queue</code>.
     */
    private int count;
    
    /**
     * Stores index of first added element to <code>Queue</code>.
     */
    private int head;
    
    /**
     * Stores index of last added element to </code>Queue</code>.
     */
    private int tail;
    
    /**
     * Space for data stored in <code>Queue</code>.
     */
    private String[] data;
    

    /**
     * Creates the queue with capacity set to the value of 5.
     */
    public CircularArrayQueue()
    {
        this.capacity = 5;
        this.prepareQueue();
    }
    
    /**
     * Creates the queue with given {@code capacity}. The capacity represents maximal number of elements that the
     * queue is able to store.
     * @param capacity of the queue
     */
    public CircularArrayQueue(int capacity)
    {
        this.capacity = capacity;
        this.prepareQueue();
    }
    
     /**
     * Function to prepare space for data, indexes of head and tail and count of members in <code>Queue</code>.
     */
    private void prepareQueue()
    {
        this.data = new String[this.capacity];
        this.count = 0;
        this.head = 0;
        this.tail = 0;
    }
    
    /**
     * Adds elements into <code>Queue</code> without checking, if it is possible.
     * @param element String to be added to </code>Queue</code>
     */
    private void push(String element)
    {
        this.data[this.tail] = element;
        this.tail++;
        this.tail = this.tail % this.capacity;
        this.count++;
    }
    
    /**
     * Gets first added element from <code>Queue</code> without checking, if it is possible.
     * @return First added element to <code>Queue</code>
     */
    private String pop()
    {
        String reti = this.data[this.head];
        this.head++;
        this.head = this.head % this.capacity;
        this.count--;
        return reti;
    }
    
    @Override
    public int size()
    {
        return this.count;
    }

    @Override
    public boolean isEmpty()
    {
        return (this.count == 0);
    }

    @Override
    public boolean isFull()
    {
        return (this.count == this.capacity);
    }

    @Override
    public boolean enqueue(String obj)
    {
        boolean reti = false;
        if (this.isFull() == false && obj != null)
        {
            reti = true;
            this.push(obj);
        }
        
        return reti;
    }

    @Override
    public String dequeue()
    {
        String reti = null;
        if (this.isEmpty() == false)
        {
            reti = this.pop();
        }
        return reti;
    }

    @Override
    public void printAllElements()
    {
        for (int i = 0; i < this.count; i++)
        {
            System.out.println(this.data[(this.head + i) % 5]);
        }
    }
}
