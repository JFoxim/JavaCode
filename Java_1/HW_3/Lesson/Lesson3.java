class Lesson3 {

    public static void main(String[] args) {
        Lesson3 obj = new Lesson3();
        obj.print(12);
        obj.print(1.2f);
        print(true);
    }

    void print(int i) {
        System.out.println("Integer " + i);
    }

    void print(float f) {
        System.out.println("Float " + f);
    }

    static void print(boolean b) {
        System.out.println("Boolean " + b);
    }
}