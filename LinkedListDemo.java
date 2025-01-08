public class LinkedListDemo {

    // Nested Link class
    static class Link {
        public int key;
        public int data;
        public Link next;

        public Link(int key, int data) {
            this.key = key;
            this.data = data;
        }

        public void display() {
            System.out.print("{" + key + "," + data + "}");
        }
    }

    // Nested LinkedList class
    static class LinkedList {
        private Link first;

        public LinkedList() {
            first = null;
        }

        public void insertFirst(int key, int data) {
            Link link = new Link(key, data);
            link.next = first;
            first = link;
        }

        public Link deleteFirst() {
            Link tempLink = first;
            first = first.next;
            return tempLink;
        }

        public void display() {
            Link current = first;
            System.out.print("[ ");
            while (current != null) {
                current.display();
                current = current.next;
                System.out.print(" ");
            }
            System.out.print("]");
        }

        public Link find(int key) {
            Link current = first;
            if (first == null) {
                return null;
            }
            while (current.key != key) {
                if (current.next == null) {
                    return null;
                } else {
                    current = current.next;
                }
            }
            return current;
        }

        public Link delete(int key) {
            Link current = first;
            Link previous = null;
            if (first == null) {
                return null;
            }
            while (current.key != key) {
                if (current.next == null) {
                    return null;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
            if (current == first) {
                first = first.next;
            } else {
                previous.next = current.next;
            }
            return current;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public int length() {
            int length = 0;
            for (Link current = first; current != null; current = current.next) {
                length++;
            }
            return length;
        }

        public void sort() {
            int i, j, k, tempKey, tempData;
            Link current, next;
            int size = length();
            k = size;
            for (i = 0; i < size - 1; i++, k--) {
                current = first;
                next = first.next;
                for (j = 1; j < k; j++) {
                    if (current.data > next.data) {
                        tempData = current.data;
                        current.data = next.data;
                        next.data = tempData;

                        tempKey = current.key;
                        current.key = next.key;
                        next.key = tempKey;
                    }
                    current = current.next;
                    next = next.next;
                }
            }
        }

        public LinkedList reverse() {
            LinkedList reversedList = new LinkedList();
            Link nextLink;
            reversedList.insertFirst(first.key, first.data);

            Link currentLink = first;
            while (currentLink.next != null) {
                nextLink = currentLink.next;
                reversedList.insertFirst(nextLink.key, nextLink.data);
                currentLink = currentLink.next;
            }
            return reversedList;
        }

        public void concatenate(LinkedList list) {
            if (first == null) {
                first = list.first;
            }
            if (list.first == null) {
                return;
            }
            Link temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = list.first;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertFirst(1, 10);
        list.insertFirst(2, 20);
        list.insertFirst(3, 30);
        list.insertFirst(4, 1);
        list.insertFirst(5, 40);
        list.insertFirst(6, 56);

        System.out.print("\nOriginal List: ");
        list.display();
        System.out.println("");
        while (!list.isEmpty()) {
            Link temp = list.deleteFirst();
            System.out.print("Deleted value:");
            temp.display();
            System.out.println("");
        }
        System.out.print("List after deleting all items: ");
        list.display();
        System.out.println("");
        list.insertFirst(1, 10);
        list.insertFirst(2, 20);
        list.insertFirst(3, 30);
        list.insertFirst(4, 1);
        list.insertFirst(5, 40);
        list.insertFirst(6, 56);

        System.out.print("Restored List: ");
        list.display();
        System.out.println("");

        Link foundLink = list.find(4);
        if (foundLink != null) {
            System.out.print("Element found: ");
            foundLink.display();
            System.out.println("");
        } else {
            System.out.println("Element not found.");
        }

        list.delete(4);
        System.out.print("List after deleting an item: ");
        list.display();
        System.out.println("");
        foundLink = list.find(4);
        if (foundLink != null) {
            System.out.print("Element found: ");
            foundLink.display();
            System.out.println("");
        } else {
            System.out.print("Element not found. {4,1}");
        }
        System.out.println("");
        list.sort();
        System.out.print("List after sorting the data: ");
        list.display();
        System.out.println("");
        System.out.print("Reverse of the list: ");
        LinkedList list1 = list.reverse();
        list1.display();
        System.out.println("");

        LinkedList list2 = new LinkedList();

        list2.insertFirst(9, 50);
        list2.insertFirst(8, 40);
        list2.insertFirst(7, 20);

        list.concatenate(list2);
        System.out.print("List after concatenation: ");
        list.display();
        System.out.println("");
    }
}
