package human;

import java.io.*;
import java.util.Scanner;

public class Person {

    String name;
    String street;
    String phone;
    String dob;
    String city;
    String personID;
    Scanner obj1 = new Scanner(System.in);
    static int i = 0;

    public void append() {
        setName();
        setPersonID();
        setDob();
        setStreet();
        setCity();
        setPhone();
        write();
    }

    public void write() {
        BufferedWriter bw = null;
        try {
            File f1 = new File("C:\\Users\\eesha\\Desktop\\PersonDatabase\\person.txt");
            if (!f1.exists()) {
                f1.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(f1, true));

            String info = personID + "," + name + "," + dob + "," + street + "," + city + "," + phone;
            bw.write(info);
            bw.newLine();
            bw.close();
        } catch (Exception e) {
        }
    }

    public void read() {
        BufferedReader br = null;
        try {
            File fi = new File("C:\\Users\\eesha\\Desktop\\PersonDatabase\\person.txt");
            br = new BufferedReader(new FileReader(fi));
            String content = br.readLine();
            while (content != null) {
                System.out.println(content);
                content = br.readLine();
            }
        } catch (Exception e) {
        }
    }

    public void setName() {
        System.out.println("Please enter the Name: ");
        String name = obj1.nextLine();
        this.name = name;
    }

    public void setPersonID() {
        System.out.println("Please enter the person's ID: ");
        String personID = obj1.nextLine();
        this.personID = personID;
    }

    public void setDob() {
        System.out.println("Please enter the Date of Birth: ");
        String dob = obj1.nextLine();
        this.dob = dob;
    }

    public void setStreet() {
        System.out.println("Please enter the Address: ");
        String street = obj1.nextLine();
        this.street = street;
    }

    public void setCity() {
        System.out.println("Please enter the City: ");
        String city = obj1.nextLine();
        this.city = city;
    }

    public void setPhone() {
        System.out.println("Please enter the Phone: ");
        String phone = obj1.nextLine();
        this.phone = phone;
    }


}

