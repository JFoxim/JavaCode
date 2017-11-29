
/**
 * Java. Level 1  HomeWork 5.
 *
 * @author Shangareev Rinat
 * @version dated 11.10.2017
 */


public class HomeWork5 {

    public static void main(String[] args){
        Person[] persArray = new Person[5];
        persArray[0] = new Person("���� ������", "�������" , "IvanovII@mail.ru", "2357", 3000000
                , 18);
        persArray[1] = new Person("������ ������", "������� �������" , "PetrovSV@mail.ru", "2715", 18000000
                , 55);
        persArray[2] = new Person("������� ������", "��������" , "PupkinVS@mail.ru", "2415", 1000000
                , 22);
        persArray[3] = new Person("������ �������", "��������" , "@mail.ru", "2715", 48000000
                , 45);
        persArray[4] = new Person();
        persArray[4].setName("����� ������");
        persArray[4].setPosition("������������ ������");
        persArray[4].setEmail("NurievAM@mail.ru");
        persArray[4].setPhone("2715");
        persArray[4].setSalary(5000000);
        persArray[4].setAge(44);

        for (int i = 0, n =1; i < persArray.length; i++){
            if (persArray[i].getAge() > 40) {
                System.out.println("\n��������� "+ n++);
                persArray[i].print();
            }
        }
    }
}

class Person {
    private String name;
    private String position;
    private String email;
    private String phone;
    private long salary;
    private int age;

    Person(){}

    Person(String name, String position, String email, String phone, long salary, int age){
        setName(name);
        setPosition(position);
        setPhone(phone);
        setEmail(email);
        setSalary(salary);
        setAge(age);
    }

    public String toString(){
        return this.name;
    }

    public void print(){
        System.out.println("��� : "+name);
        System.out.println("��������� : "+position);
        System.out.println("����� : "+email);
        System.out.println("������� : "+phone);
        System.out.println("�������� : "+salary);
        System.out.println("������� : "+age);
    }

    public void setName(String name) {
        if(name != null && !name.isEmpty())
           this.name = name;
        else
            System.out.println("�������� ��� ����� �� ������ ������");
    }

    public void setPosition(String position) {
        if(position != null && !position.isEmpty())
           this.position = position;
        else
            System.out.println("�������� ��������� ����� �� ������ ������");
    }

    public void setEmail(String email) {
        if(email != null && !email.isEmpty() && email.contains("@"))
          this.email = email;
        else
            System.out.println("�������� ����� ����� �� ������ ������");
    }

    public void setPhone(String phone) {
        if(phone != null && !phone.isEmpty())
           this.phone = phone;
        else
            System.out.println("�������� ������� ����� �� ������ ������");
    }

    public void setSalary(long salary) {
        if (salary > 0)
            this.salary = salary;
        else
            System.out.println("�������� �������� �� ����� ���� ������ 0");
    }

    public void setAge(int age) {
        if (age > 0)
            this.age = age;
        else
            System.out.println("�������� �������� �� ����� ���� ������ 0");
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public long getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

}