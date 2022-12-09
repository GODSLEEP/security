package phone_book;

public class Person {
    private int id;
    private static int num = 1;
    private String name;
    private String sex;
    private int age;
    private String telnumber;

    public Person() {
        super();
    }

    public Person(String name, String sex, int age, String telnumber) {
        super();
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.telnumber = telnumber;
        this.id = num;
        num++;
    }

    public int getId() {
        return id;
    }

    public void setCount(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public String toString() {
        return "Person" + "[id" + id + ",name=" + name + ", sex=" + sex + ", age=" + age + ", telnumber=" + telnumber + "]";
    }

}