/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;

/**
 *
 * @author Admin
 */
public class tra {
    
    void clear() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    //Display node need visit to console
    void visit(Node needVisit) {
        if (needVisit != null) {
            System.out.print(needVisit.info);
        }
    }

    //(3)- Traverse and display all node of list
    void traverse() {
        Node p = head;
        while (p != null) {
            System.out.print(p.info + " ");
            p = p.next;
        }
        System.out.println();
    }

    // Add new list from 2 array
    void addMany(String a[], int b[]) {
        for (int i = 0; i < a.length; i++) {
            addLast(new Person(a[i], b[i]));
        }
    }

    //(1) - Add new node to the last of list
    void addLast(Person x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
    }

    //(2) - Add new node to the head of list
    void addFirst(Person x) {
        Node n = new Node(x);
        if (isEmpty()) {
            tail = head = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    //(3) - Search and return node that have name
    Node searchByName(String xName) {
        Node p = head;
        while (p != null) {
            if (p.info.name.equals(xName)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    Node searchByAge(int xAge) {
        Node p = head;
        while (p != null) {
            if (p.info.age == xAge) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    // (4) - Add new node after current node
    public void insertAfter(Node q, Person x) {
        if (q == null) {
            return;
        }

        Node qNext = q.next;
        Node p = new Node(x, qNext);
        q.next = p;
        if (tail == q) {
            tail = p;
        }

    }

    // (5) - Add new node before current node
    void insertBefore(Node needInsertBefore, Person x) {
        if (needInsertBefore == null) {
            return;
        }
        Node f = head;
        while (f != null && f.next != needInsertBefore) {
            f = f.next;
        }

        if (f == null) {
            return;
        }

        insertAfter(f, x);

    }

    public void removeFirst() {
        if (isEmpty()) {
            return;
        }

        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    // (6) - Remove node from the list
    public void remove(Node q) {
        if (isEmpty()) {
            return;
        }
        if (q == head) {
            removeFirst();
            return;
        }
        Node f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            return;
        }
        f.next = q.next;

        if (f.next == null) {
            tail = f;
        }
    }

    // (7) Remove node that have name need to remove
    void remove(String xName) {
        Node findName = head;

        while (findName != null) {
            if (findName.info.name.equals(xName)) {
                remove(findName);
                return;
            }
            findName = findName.next;
        }

    }

    // (8)Remove node that have age need to remove
    void remove(int xAge) {
        Node findAge = head;

        while (findAge != null) {
            if (findAge.info.age == xAge) {
                remove(findAge);
                return;
            }
            findAge = findAge.next;
        }

    }

    // (9)- Remove all node that have the same age value to ageNeedRemove
    void removeAll(int xAge) {
        Node findAge = head;

        while (findAge != null) {
            if (findAge.info.age == xAge) {
                remove(findAge);
            }
            findAge = findAge.next;
        }

    }

    // (10) - Return node at the position index
    Node pos(int k) {
        if (isEmpty() || k < 0) {
            return null;
        }
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == k) {
                return current;
            }
            count++;
            current = current.next;
        }
        return null;
    }

    // (11) - Remove node at index using above function
    void removePos(int k) {
        Node nodeToRemove = pos(k);
        if (nodeToRemove != null) {
            remove(nodeToRemove);
        }
    }

    // (12)- sort ascending, less name value up to head
    void sortByName() {
        Node pi, pj;
        Person x;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pi.info.name.compareTo(pj.info.name) > 0) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
            }
        }
    }

    // (13) - sort ascending, less age value up to head 
    void sortByAge() {
        Node pi, pj;
        Person x;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pi.info.age > pj.info.age) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
            }
        }
    }

    // (14)- size of list
    int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // (15)
    Person[] toArray() {
        int size = size();
        Person[] result = new Person[size];
        Node current = head;
        int index = 0;
        while (current != null) {
            result[index] = current.info;
            index++;
            current = current.next;
        }
        return result;
    }

    // (16)- Reverse the list, using swap head and tail
    void reverse() {
        if (isEmpty()) {
            return;
        }
        Node prevNode = null;
        Node current = head;
        Node nextNode = null;
        while (current != null) {
            nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
        }
        tail = head;
        head = prevNode;
    }

    // (17) - return age value is max
    Node findMaxAge() {
        if (isEmpty()) {
            return null;
        }
        Node current = head;
        Node maxAgeNode = head;
        while (current != null) {
            if (current.info.age > maxAgeNode.info.age) {
                maxAgeNode = current;
            }
            current = current.next;
        }
        return maxAgeNode;
    }

    // (18) - return age value is min
    Node findMinAge() {
        if (isEmpty()) {
            return null;
        }
        Node current = head;
        Node minAgeNode = head;
        while (current != null) {
            if (current.info.age < minAgeNode.info.age) {
                minAgeNode = current;
            }
            current = current.next;
        }
        return minAgeNode;
    }

    // (19) -Replace data of node with new data
    void setData(Node p, Person x) {
        if (p != null) {
            p.info = x;
        }
    }

    // (20) - sort by age from k to h
    void sortByAge(int k, int h) {
        if (isEmpty() || k < 0 || h < 0 || k > h) {
            return;
        }
        Node start = pos(k);
        Node end = pos(h);
        if (start == null || end == null) {
            return;
        }
        Node current = start;
        while (current != end.next) {
            Node nextNode = current.next;
            while (nextNode != end.next) {
                if (current.info.age > nextNode.info.age) {
                    Person temp = current.info;
                    current.info = nextNode.info;
                    nextNode.info = temp;
                }
                nextNode = nextNode.next;
            }
            current = current.next;
        }
    }

    // (21) - reverse from k to h 
    void reverse(int k, int h) {
        if (isEmpty() || k < 0 || h < 0 || k > h) {
            return;
        }
        for (int i = k, j = h; i < j; i++, j--) {
            Person temp = pos(i).info;
            pos(i).info = pos(j).info;
            pos(j).info = temp;
        }
    }
}
