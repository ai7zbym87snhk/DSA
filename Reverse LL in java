public void reverse(){
        Node prev = null;                               // 3 Variables 
        Node current = tail = head;
        Node next;
        // Reversing in 4 steps inside a while loop
        while(current != null){
            next = current.next;
            current.next = prev;              // Main Reversing step
            prev = current;
            current = next;
        }
        head = prev;      // Changing the head 
    }
