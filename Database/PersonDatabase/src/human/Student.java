package human;

import java.io.*;
import java.util.Scanner;

public class Student {

    String stuID;
    String personID;
    String course;
    String subject;
    String date;
    String joiningDate;
    int marks;
    String courseName;
    double[][] courseValueOfMarks = new double[2][10];
    double[][] courseSum = new double[2][10];
    int[][] count = new int[2][10];
    String nameOfPerson = "";
    String result = "";
    double gpa = 0.0;
    double sumS = 0.0;
    int countS = 0;
    double subjectResult = 0.0;
    String personIdOfStudent = "";
    String nameOfStudent = "";
    String resultOfSubject = "";
    String subjectS;
    Scanner obj2 = new Scanner(System.in);

    public void append() {
        setPersonID();
        stuID();
        course();
        joiningDate();
        subject();
        date();
        marks();
        write();
    }

    public void write() {
        BufferedWriter bw1 = null;
        try {
            File f2 = new File("C:\\Users\\eesha\\Desktop\\PersonDatabase\\student.txt");
            if (!f2.exists()) {
                f2.createNewFile();
            }
            bw1 = new BufferedWriter(new FileWriter(f2, true));
            Person p1 = new Person();
            String info = personID + "," + stuID + "," + course + "," + joiningDate + "," + subject + "," + date + "," + marks;
            bw1.write(info);
            bw1.newLine();
            bw1.close();
        } catch (Exception e) {
        }
    }

    public void read() {
        BufferedReader br1 = null;
        try {
            File fi = new File("C:\\Users\\eesha\\Desktop\\PersonDatabase\\student.txt");
            br1 = new BufferedReader(new FileReader(fi));
            String content = br1.readLine();
            while (content != null) {
                System.out.println(content);
                content = br1.readLine();
            }
        } catch (Exception e) {
        }
    }

    public void stuID() {
        System.out.println("Please enter the Student ID: ");
        String stuID = obj2.nextLine();
        this.stuID = stuID;
    }

    public void setPersonID() {
        System.out.println("Please enter the person's ID: ");
        String personID = obj2.nextLine();
        this.personID = personID;
    }

    public void course() {
        System.out.println("Please enter the name of the Course: ");
        String course = obj2.nextLine();
        this.course = course;
    }

    public void subject() {
        System.out.println("Please enter the name of the Subject: ");
        String subject = obj2.nextLine();
        this.subject = subject;
    }

    public void date() {
        System.out.println("Please enter the name of the Date of exam: ");
        String date = obj2.nextLine();
        this.date = date;
    }

    public void joiningDate() {
        System.out.println("Please enter the starting Date of the course: ");
        String joiningDate = obj2.nextLine();
        this.joiningDate = joiningDate;
    }

    public void marks() {
        System.out.println("Please enter the Marks: ");
        int marks = obj2.nextInt();
        this.marks = marks;
    }


    public void subjectMarks() {

        try {
            System.out.println("Please enter the Student ID whose result is required: ");
            String stuIdS = obj2.nextLine();
            System.out.println("Please enter the Subject whose result is required: ");
            subjectS = obj2.nextLine();

            BufferedReader br2 = new BufferedReader(new FileReader(new File("C://Users//eesha//Desktop//PersonDatabase//student.txt")));

            String content1;

            while ((content1 = br2.readLine()) != null) {

                String[] arr = content1.split(",");
                //      if (arr[0].equals("") || arr[0].equals(null)) break;

                double valueOfMarks = Double.parseDouble(arr[6]);
                if (arr[1].equalsIgnoreCase(stuIdS) && arr[4].equalsIgnoreCase(subjectS)) {
                    sumS = sumS + valueOfMarks;
                    countS++;
                    personIdOfStudent = arr[0];
                }
            }

            subjectResult = (sumS / countS);
            if (subjectResult >= 60) {
                resultOfSubject = "Pass";
            } else {
                resultOfSubject = "Fail";
            }
            BufferedReader br3 = new BufferedReader(new FileReader(new File("C://Users//eesha//Desktop//PersonDatabase//person.txt")));
            String content2;
            while ((content2 = br3.readLine()) != null) {

                String[] arr2 = content2.split(",");
                //      if (arr2[0].equals("") || arr2[0].equals(null)) break;
                if (arr2[0].equalsIgnoreCase(personIdOfStudent)) {
                    nameOfStudent = arr2[1];
                }
            }
            System.out.println("");
            System.out.println("Marks scored by " + nameOfStudent + " in " + subjectS + " are: " + subjectResult);
            System.out.println("Result of " + nameOfStudent + " in " + subjectS + " is: " + resultOfSubject);
            br3.close();
            br2.close();
        } catch (Exception e) {
            System.out.println("exception is there testing: " + e.toString());
        }

    }

    public void courseResult() {
        try {

            System.out.println("Please enter the name of the Course: ");
            courseName = obj2.nextLine();
            System.out.println("Please enter the Student ID: ");
            String stuIdC = obj2.nextLine();

            BufferedReader br1 = new BufferedReader(new FileReader(new File("C:\\\\Users\\\\eesha\\\\Desktop\\\\PersonDatabase\\\\student.txt")));
            BufferedReader br2 = new BufferedReader(new FileReader(new File("C:\\\\Users\\\\eesha\\\\Desktop\\\\PersonDatabase\\\\person.txt")));
            String content2 = br2.readLine();

            String content1;

            while ((content1 = br1.readLine()) != null) {
                String[] arr = content1.split(",");
                double valueOfMarks = Double.parseDouble(arr[6]);
                if (arr[1].equalsIgnoreCase(stuIdC) && arr[2].equalsIgnoreCase(courseName)) {
                    if (courseName.equalsIgnoreCase("Mob App")) {

                        while (content2 != null) {
                            String[] arr2 = content2.split(",");
                            if (arr2[0].equalsIgnoreCase(arr[0])) {
                                nameOfPerson = arr2[1];
                            }
                            content2 = br2.readLine();
                        }
                        if (arr[4].equalsIgnoreCase("java")) {
                            courseSum[0][0] = courseSum[0][0] + valueOfMarks;
                            count[0][0]++;
                        }
                        if (arr[4].equalsIgnoreCase("database")) {
                            courseSum[0][1] = courseSum[0][1] + valueOfMarks;
                            count[0][1]++;
                        }
                        if (arr[4].equalsIgnoreCase("iOS")) {
                            courseSum[0][2] = courseSum[0][2] + valueOfMarks;
                            count[0][2]++;
                        }
                        if (arr[4].equalsIgnoreCase("Mobile Web")) {
                            courseSum[0][3] = courseSum[0][3] + valueOfMarks;
                            count[0][3]++;
                        }
                        if (arr[4].equalsIgnoreCase("entrepreneurship")) {
                            courseSum[0][4] = courseSum[0][4] + valueOfMarks;
                            count[0][4]++;
                        }
                    }
                    if (courseName.equalsIgnoreCase("Com Eng")) {
                        while (content2 != null) {
                            String[] arr2 = content2.split(",");
                            if (arr2[0].equalsIgnoreCase(arr[0])) {
                                nameOfPerson = arr2[1];
                            }
                            content2 = br2.readLine();
                        }
                        if (arr[4].equalsIgnoreCase("Calculus")) {
                            courseSum[1][0] = courseSum[1][0] + valueOfMarks;
                            count[1][0]++;
                        }
                        if (arr[4].equalsIgnoreCase("Physics")) {
                            courseSum[1][1] = courseSum[1][1] + valueOfMarks;
                            count[1][1]++;
                        }
                        if (arr[4].equalsIgnoreCase("Electronics")) {
                            courseSum[1][2] = courseSum[1][2] + valueOfMarks;
                            count[1][2]++;
                        }
                        if (arr[4].equalsIgnoreCase("Data Structures")) {
                            courseSum[1][3] = courseSum[1][3] + valueOfMarks;
                            count[1][3]++;
                        }
                        if (arr[4].equalsIgnoreCase("Networking")) {
                            courseSum[1][4] = courseSum[1][4] + valueOfMarks;
                            count[1][4]++;
                        }
                    }
                }

            }
            if (courseName.equalsIgnoreCase("Mob App")) {
                for (int o = 0; o < 5; o++) {
                    courseValueOfMarks[0][o] = courseSum[0][o] / count[0][o];
                }
                if (courseValueOfMarks[0][0] >= 60 && courseValueOfMarks[0][1] >= 60 && courseValueOfMarks[0][2] >= 60 && courseValueOfMarks[0][3] >= 60 && courseValueOfMarks[0][4] >= 60) {
                    result = "Pass";
                } else {
                    result = "Fail";
                }
                gpa = (courseValueOfMarks[0][0] + courseValueOfMarks[0][1] + courseValueOfMarks[0][2] + courseValueOfMarks[0][3] + courseValueOfMarks[0][4]) / (125);
                System.out.println("The GPA score is: " + gpa);
                if (courseValueOfMarks[0][0] < 60) {
                    System.out.println(nameOfPerson + " has failed the Java Exam :(");
                }
                if (courseValueOfMarks[0][1] < 60) {
                    System.out.println(nameOfPerson + " has failed the Database Exam :(");
                }
                if (courseValueOfMarks[0][2] < 60) {
                    System.out.println(nameOfPerson + " has failed the iOS Exam :(");
                }
                if (courseValueOfMarks[0][3] < 60) {
                    System.out.println(nameOfPerson + " has failed the Mobile Web Exam :(");
                }
                if (courseValueOfMarks[0][4] < 60) {
                    System.out.println(nameOfPerson + " has failed the entrepreneurship Exam :(");
                }
                System.out.println("Therefore, " + nameOfPerson + "'s result is: " + result);
            }
            if (courseName.equalsIgnoreCase("Com Eng")) {
                for (int o = 0; o < 5; o++) {
                    courseValueOfMarks[1][o] = courseSum[1][o] / count[1][o];
                }
                if (courseValueOfMarks[1][0] >= 60 && courseValueOfMarks[1][1] >= 60 && courseValueOfMarks[1][2] >= 60 && courseValueOfMarks[1][3] >= 60 && courseValueOfMarks[1][4] >= 60) {
                    result = "Pass";
                } else {
                    result = "Fail";
                }
                gpa = (courseValueOfMarks[1][0] + courseValueOfMarks[1][1] + courseValueOfMarks[1][2] + courseValueOfMarks[1][3] + courseValueOfMarks[1][4]) / (125);
                System.out.println("The GPA score is: " + gpa);
                if (courseValueOfMarks[1][0] < 60) {
                    System.out.println(nameOfPerson + " has failed the Calculus Exam :(");
                }
                if (courseValueOfMarks[1][1] < 60) {
                    System.out.println(nameOfPerson + " has failed the Physics Exam :(");
                }
                if (courseValueOfMarks[1][2] < 60) {
                    System.out.println(nameOfPerson + " has failed the Electronics Exam :(");
                }
                if (courseValueOfMarks[1][3] < 60) {
                    System.out.println(nameOfPerson + " has failed the Data Structures Exam :(");
                }
                if (courseValueOfMarks[1][4] < 60) {
                    System.out.println(nameOfPerson + " has failed the Networking Exam :(");
                }
                System.out.println("Therefore, " + nameOfPerson + "'s result is: " + result);
            }

        } catch (Exception e) {
            System.out.println("exception is there:" + e.toString());
        }

    }

    public void deleting() {
    	File f1 = null;
    	File f2 = null;
    	BufferedReader br = null;
    	BufferedWriter bw = null;
        try {
            Scanner obj8 = new Scanner(System.in);
            f1 = new File("C:\\Users\\eesha\\Desktop\\PersonDatabase\\temp_student.txt");
            f2 = new File("C:\\Users\\eesha\\Desktop\\PersonDatabase\\student.txt");
            br = new BufferedReader(new FileReader(f2));
            bw = new BufferedWriter(new FileWriter(f1, true));

            if (!f1.exists()) {
                f1.createNewFile();
            }

            System.out.println("Please Enter the Student ID you want delete");
            String delstuid = obj8.nextLine();
            System.out.println("Please enter the subject");
            String delsub = obj8.nextLine();
            String content;

            while ((content = br.readLine()) != null) {
                String[] array = content.split(",");


                if (array[1].equalsIgnoreCase(delstuid) && array[4].equalsIgnoreCase(delsub)) {
                    continue;
                } else {
                    String abc = array[0] + "," + array[1] + "," + array[2] + "," + array[3] + "," + array[4] + "," + array[5] + "," + array[6];
                    bw.write(abc);
                    bw.newLine();
                }

                bw.flush();
            }
            bw.close();
            br.close();
            f2.delete();
            boolean successful = f1.renameTo(f2);
          

        } catch (Exception e) {
            System.out.println("there is an exception:" + e.toString());
        }
     
    }


    public void updating() {

        File f1 = new File("C:\\\\Users\\\\eesha\\\\Desktop\\\\PersonDatabase\\\\student.txt");
        File f2 = new File("C:\\\\Users\\\\eesha\\\\Desktop\\\\PersonDatabase\\\\temp_student.txt");
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(f1));
            bw = new BufferedWriter(new FileWriter(f2, true));
            Scanner obj9 = new Scanner(System.in);
            System.out.println("Please enter the Student ID you want to update");
            String nam = obj9.nextLine();
            System.out.println("Please enter the Subject you want to update");
            String nam1 = obj9.nextLine();
            setPersonID();
            stuID();
            course();
            joiningDate();
            subject();
            date();
            marks();

            if (!f2.exists()) {
                f2.createNewFile();
            }

            String abc = br.readLine();
            while (abc != null) {
                String[] arr = abc.split(",");
                if (arr[1].equalsIgnoreCase(nam) && arr[4].equalsIgnoreCase(nam1)) {

                    String info = personID + "," + stuID + "," + course + "," + joiningDate + "," + subject + "," + date + "," + marks;

                    bw.write(info);
                    bw.newLine();

                } else {
                    bw.write(abc);
                    bw.newLine();
                }
                abc = br.readLine();
            }
            bw.close();
            br.close();
            f1.delete();
            f2.renameTo(f1);
        } catch (IOException e
        		) {
        	System.out.println(e);
        	
        }
        
    }


}
