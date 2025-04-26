import java.io.*;

public class StudentDataStreamExample {
    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        writeStudentData();
        readStudentData();
    }

    public static void writeStudentData() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(8.5);

            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(7.9);

            dos.writeInt(103);
            dos.writeUTF("Charlie");
            dos.writeDouble(9.1);

            System.out.println("Student data written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing student data: " + e.getMessage());
        }
    }

    public static void readStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("\nStudent Details:");
            while (dis.available() > 0) {
                int rollNo = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNo + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading student data: " + e.getMessage());
        }
    }
}
