package human;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {

        main2();

    }

    public static void main2() {
        System.out.println("Please choose one of the Following Options: \n1.Append \n2.Read\n3.Update \n4.Delete \n5.Marks \n6.Exit");
        Scanner obj4 = new Scanner(System.in);
        Student s = new Student();
        Person p = new Person();
        int option = obj4.nextInt();
        if (option == 1) {
            System.out.println("Choose file you want to append: \n1.Person\n2.Student");
            int option1 = obj4.nextInt();
            if (option1 == 1) {
                p.append();
                System.out.println("");
                main2();
            } else if (option1 == 2) {
                s.append();
                System.out.println("");
                main2();
            } else {
                System.out.println("Please choose a valid option next time:( \n");
                main2();
            }

        } else if (option == 2) {
            System.out.println("Choose file you want to read: \n1.Person\n2.Student");
            int option1 = obj4.nextInt();
            if (option1 == 1) {
                System.out.println("---------------------------------------------------");
                System.out.println("");
                p.read();
                System.out.println("");
                System.out.println("---------------------------------------------------");
                System.out.println("");
                main2();
            } else if (option1 == 2) {
                System.out.println("---------------------------------------------------");
                System.out.println("");
                s.read();
                System.out.println("");
                System.out.println("---------------------------------------------------");
                System.out.println("");
                main2();
            } else {
                System.out.println("Please choose a valid option next time:( \n");
                main2();
            }

        } else if (option == 3) {
            s.updating();
            System.out.println("");
            main2();

        } else if (option == 4) {
            s.deleting();
            System.out.println("");
            main2();

        } else if (option == 5) {
            System.out.println("Choose marks you want to see: \n1.Subject marks\n2.Course Result");
            int value = obj4.nextInt();
            if (value == 1) {
                s.subjectMarks();
                System.out.println("");
                main2();
            } else if (value == 2) {
                s.courseResult();
                System.out.println("");
                main2();
            } else {
                System.out.println("Please choose a valid option next time:( ");
                System.out.println("");
                main2();
            }

        } else if (option == 6) {
            exit(0);
        } else {
            System.out.println("Please choose a valid option next time:(");
            System.out.println("");
            main2();

        }
    }

}
