/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quêu;

/**
 *
 * @author Admin
 */
public class LinkedQueue {
    private int length;
    private ListNode front, rear;
 
    //  Creates an empty queue.
    public LinkedQueue(){
         length = 0;
         front = rear = null;
    }

    //  Adds the specified data to the rear of the queue.
    public void enQueue (int data){
         ListNode node = new ListNode(data);
         if (isEmpty())
              front = node;
         else
              rear.setNext (node);
         rear = node;
         length++;
    }

    //  Removes the data at the front of the queue and returns a
    //  reference to it. Throws an Exception if the
    //  queue is empty.

    public int deQueue() throws Exception{
        if (isEmpty())
              throw new Exception ("queue");
        int result = front.getData();
        front = front.getNext();
        length--;
        if (isEmpty())
             rear = null;
        return result;
    }

    //  Returns a reference to the data at the front of the queue.
    //  The data is not removed from the queue.  Throws an
    //  Exception if the queue is empty.  
    public int first() throws Exception{
        if (isEmpty())
            throw new Exception(); 

        return front.getData();
    }

    //  Returns true if this queue is empty and false otherwise. 
    public boolean isEmpty(){
         return (length == 0);
    }

    //  Returns the number of elements in this queue.
    public int size(){
        return length;
    }

    //  Returns a string representation of this queue. 
    public String toString(){
        String result = "";
        ListNode current = front;
        while (current != null){
            result = result + current.toString() + "\n";
            current = current.getNext();
        }
        return result;
    }
}
