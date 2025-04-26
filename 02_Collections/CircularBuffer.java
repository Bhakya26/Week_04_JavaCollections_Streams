public class CircularBuffer {
    private int[] buffer;
    private int head = 0;
    private int count = 0;
    private int size;

    public CircularBuffer(int capacity) {
        buffer = new int[capacity];
        size = capacity;
    }

    public void insert(int value) {
        buffer[head] = value;
        head = (head + 1) % size;
        if (count < size) {
            count++;
        }
    }

    public void printBuffer() {
        System.out.print("Buffer: [");
        for (int i = 0; i < count; i++) {
            int index = (head + i) % size;
            System.out.print(buffer[index]);
            if (i != count - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.printBuffer();  

        cb.insert(4);      
        cb.printBuffer(); 
        cb.insert(5);      
        cb.printBuffer(); 
    }
}

	
