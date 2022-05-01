import java.io.*;
import java.util.*;

class Student {
  String name;
  String grno;
  String rollno;
  String branch;
  String division;

  public Student(String n, String g, String r, String b, String d) {
    name = n;
    grno = g;
    rollno = r;
    branch = b;
    division = d;
  }

  public static List < Student > fromString(String s) {
    int len = s.length();
    s = s.substring(0, len - 1);
    
    List < Student > students = new ArrayList < Student > ();
    String[] lst;
    lst = s.split(";");
    for (String str: lst) {
      String[] inner;
      inner = str.split(",");
      Student newstudent = new Student(inner[0], inner[1], inner[2], inner[3], inner[4]);
      students.add(newstudent);
    }
    
    return students;
  }
}

class Main {
  private static File myObj = new File("filename.txt");
  private static Scanner read;
  public static void main(String[] args) {
    try {

      read = new Scanner(System.in);
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }

      int ch = -1;
      do {
        System.out.print("\n\nStudent DataBase Using Files:\n1.Insert\n2.Delete\n3.Display\n4.Search\n0.Exit\n--->");
        ch = read.nextInt();
        read.nextLine();
        switch (ch) {
        case 1: {
          System.out.print("Enter name of the student : ");
          String name = read.nextLine();
          System.out.print("Enter Roll Number : ");
          String rollno = read.nextLine();
          System.out.print("Enter Gr Number : ");
          String grno = read.nextLine();
          System.out.print("Enter Branch : ");
          String branch = read.nextLine();
          System.out.print("Enter Division : ");
          String division = read.nextLine();

          Student s = new Student(name, grno, rollno, branch, division);
          write(s);
        }
        break;
        case 2: {
          System.out.print("Enter Roll number to delete : ");
          int x = read.nextInt();
          delete(x);
        }
        break;
        case 3: {
          print();

        }
        break;
        case 4: {
          System.out.print("Enter Roll number to search : ");
          int x = read.nextInt();
          search(x);
        }
        break;
        case 0:
          break;
        }
      } while (ch != 0);

    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public static void write(Student s) throws java.io.IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter("filename.txt", true));
    writer.write(s.name + ',' + s.grno + ',' + s.rollno + ',' + s.branch + ',' + s.division + ';');
    writer.close();
    System.out.println("Successfully wrote to the file.");
  }

  public static List < Student > read() throws java.io.IOException {
    List < Student > students = new ArrayList < > ();
    Scanner reader = new Scanner(myObj);
    while (reader.hasNextLine()) {
      String data = reader.nextLine();
      students.addAll(Student.fromString(data));
    }
    reader.close();
    return students;
  }

  public static void delete(int rollno) throws java.io.IOException {
    List < Student > students = read();
    myObj.delete();
    myObj.createNewFile();
    BufferedWriter writer = new BufferedWriter(new FileWriter("filename.txt", true));

    for (int i = 0; i < students.size(); i++) {
      Student s = students.get(i);
      if (!s.rollno.equals(String.valueOf(rollno))) {
        writer.write(s.name + ',' + s.grno + ',' + s.rollno + ',' + s.branch + ',' + s.division + ';');
      }

    }
    writer.close();
    System.out.println("File Modified!");
  }

  public static void search(int rollno) throws java.io.IOException {
    List < Student > students = read();

    for (int i = 0; i < students.size(); i++) {
      Student s = students.get(i);
      if (s.rollno.equals(String.valueOf(rollno))) {
        System.out.println("\nStudent Record Found -> ");
        System.out.println(s.name + ',' + s.grno + ',' + s.rollno + ',' + s.branch + ',' + s.division);
      }

    }

  }

  public static void print() throws java.io.IOException {
    List < Student > students = read();
    System.out.println();
    for (int i = 0; i < students.size(); i++) {
      Student s = students.get(i);
      System.out.println(String.valueOf(i + 1) + ". " + s.name + ',' + s.grno + ',' + s.rollno + ',' + s.branch + ',' + s.division);
    }
  }

}