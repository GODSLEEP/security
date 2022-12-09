package phone_book;

import java.util.Scanner;

public class PhoneBook {
    Scanner sc = new Scanner(System.in);

    // enter 1-6
    public static int input() {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        while (true) {
            if (i > 6 && i < 0) {
                System.out.println("Error！Please re-enter！");
                i = sc.nextInt();
            } else
                break;
        }
        return i;
    }

    // create person person id number，name，gender，age，phone number,
    int total;
    private Person[] arr;
    int count;


    public PhoneBook(int total) {
        arr = new Person[total];
        this.total = total;
    }


    public void add(Person p) {
        if (count < total) {
            arr[count] = p;
            count++;
        } else
            System.out.println("phone book is full！");
    }


    public Person[] find(String name) {
        Person[] p = new Person[count];

        int idx = 0;
        for (int i = 0; i < count; i++) {
            if (arr[i].getName().equals(name)) {

                p[idx] = arr[i];
                idx++;
            }
        }
        return p;
    }


    public void findAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(arr[i].toString());
        }
    }


    public Person update(int id) {
        for (int i = 0; i < count; i++) {
            if (arr[i].getId() == id) {
                return arr[i];
            }
        }
        return null;
    }

    public void delete(int id) {
        int idx = -1;
        for (int i = 0; i < count - 1; i++) {
            if (arr[i].getId() == id) {
                idx = i;
            }
        }
        if (idx != -1) {
            for (int i = idx; i < count - 1; i++) {
                arr[i] = arr[i + 1];
            }

        }
        arr[count - 1] = null;
        count--;

    }

}