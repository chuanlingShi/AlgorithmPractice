import com.sun.corba.se.spi.presentation.rmi.PresentationManager;

public class Hello {
    public static void main(String[] argv) {
        Student tom = new Student();
        System.out.println(tom.name);

//        // bitwise and
//        // 0101 & 0111=0101 = 5
//        System.out.println("a&b = " + (a & b));
//
//        // bitwise or
//        // 0101 | 0111=0111 = 7
//        System.out.println("a|b = " + (a | b));
//
//        // bitwise xor
//        // 0101 ^ 0111=0010 = 2
//        System.out.println("a^b = " + (a ^ b));
//
//        // bitwise not
//        // ~00000000 00000000 00000000 00000101=11111111 11111111 11111111 11111010
//        // will give 1's complement (32 bit) of 5 = -6
//        System.out.println("~a = " + ~a);
//
//        // can also be combined with
//        // assignment operator to provide shorthand
//        // assignment
//        // a=a&b
//        a &= b;
//        System.out.println("a= " + a);
    }
}

class Student{
    String name;
    int age;
    double gpa;
    boolean enrolled;


    public Student(String name, int age, double gpa, boolean enrolled){
        this.name = name;
    }

    public void sayHello(){
        System.out.println("hello, this is" + name);
    }
//    overload
    public void sayHello(Student anotherStudent){
        System.out.println("hello"+ anotherStudent.name + ",this is " + name);
    }
}