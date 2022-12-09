package phone_book;

import java.util.Scanner;
public class Test {

    private static final String Person = null;

    public static void main(String[] args) {
        showInfo();
    }

    public static void showInfo(){
        Scanner sc = new Scanner(System.in);
        PhoneBook pb = new PhoneBook(10);
        boolean flag = true;
        do{
            System.out.println("\t\t1.Create new contact");
            System.out.println("\t\t2.Find contact");
            System.out.println("\t\t3.Check all contacts");
            System.out.println("\t\t4.change information of contact");
            System.out.println("\t\t5.Delete contact information");
            System.out.println("\t\t6.exit");
            System.out.print("\t\tPlease enter ID:");
            int i = PhoneBook.input();
            switch(i){
                case 1: System.out.println("Please enter the new contact name:");
                    String name = sc.next();
                    System.out.println("Please enter the new contact gender:");
                    String sex = sc.next();
                    System.out.println("Please enter the new contact age:");
                    int age = sc.nextInt();
                    System.out.println("Please enter the new contact phone number:");
                    String tel = sc.next();
                    Person person = new Person(name,sex,age,tel);
                    pb.add(person);
                    break;
                case 2: System.out.println("Please enter the name you want to search：");
                    String name2 = sc.next();
                    Person[] p = pb.find(name2);
                    for (Person person2 : p) {
                        if(person2!=null){
                            System.out.println(person2.toString());
                        }else{
                            System.out.println("No result!");
                        }
                    }
                    break;
                case 3: pb.findAll();
                    break;
                case 4: System.out.println("Which one you want to change：");
                    int id = sc.nextInt();
                    Person p4 = pb.update(id);
                    System.out.println("Please change the name：");
                    String name4 = sc.next();
                    System.out.println("Please change  the phone number：");
                    String tel4 = sc.next();
                    p4.setName(name4);
                    p4.setTelnumber(tel4);
                    break;
                case 5: System.out.println("Which one you want to delete?");
                    int id1 = sc.nextInt();
                    pb.delete(id1);
                    break;
                case 6: flag = false;
            }
        }while(flag);
    }

}
