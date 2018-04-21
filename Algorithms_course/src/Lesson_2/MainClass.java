package Lesson_2;
import java.util.Arrays;
import java.util.Random;

public class MainClass {

    public static void main(String[] args) {
        MyNewArray bigArray = new MyNewArray(1000000);
        bigArray.fillRandom();

        MyNewArray array = new MyNewArray(10);
        array.insert(20);
        array.insert(29);
        array.insert(1);
        array.insert(1);
        array.insert(25);
        array.insert(2);
        array.insert(1);
        array.insert(25);
        array.display();
        System.out.println("Удаление всех элментов равных 25");
        array.deleteAllEntry(25);
        System.out.println("Удаление элемента равного 1");
        array.delete(1);
        array.display();
        System.out.println("Поиск элемента равного 29");
        System.out.println("Индекс искомого элемента: " + array.find(29));

        array.fillRandom();
        int[] arr = Arrays.copyOf(array.getArray(),  array.getArray().length);
        System.out.println("------------Bubble Sort--------------");
        array.display();
        array.sortBubble();
        array.display();
        System.out.println("Кол-во сравнений: " + array.getCompareCount());
        System.out.println("Кол-во перестановок: " + array.getChangeCount());

        System.out.println("------------Insert Sort--------------");
        array.setArr(arr);
        array.display();
        array.sortInsert();
        array.display();
        System.out.println("Кол-во сравнений: " + array.getCompareCount());
        System.out.println("Кол-во перестановок: " + array.getChangeCount());

        System.out.println("-----------Select Sort---------------");
        array.setArr(arr);
        array.display();
        array.sortSelect();
        array.display();
        System.out.println("Кол-во сравнений: " + array.getCompareCount());
        System.out.println("Кол-во перестановок: " + array.getChangeCount());

    }
}

class MyNewArray {
    private int[] arr; // Ссылка на массив a
    private int size; // Количество элементов данных
    private int changeCount;
    private int compareCount;


    public MyNewArray(int max) // Конструктор
    {
        arr = new int[max]; // Создание массива
        size = 0;
    }

    public void setArr(int[] arrayNew){
        arr = Arrays.copyOf(arrayNew, arrayNew.length);
    }

    public int getChangeCount()
    {
        return changeCount;
    }

    public int getCompareCount()
    {
        return compareCount;
    }

    public int[] getArray()
    {
        return arr;
    }

    public void fillRandom(){ //Заполнение случайными числами
        Random rn = new Random();
        for (int i = 0; i < arr.length; i++){
            arr[i] = rn.nextInt(100);
        }
    }

    public int getSize() {
        return size;
    }

    public int find(int searchKey) { //Бинарный поиск
        int lowerBound = 0;
        int upperBound = size - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (arr[curIn] == searchKey)
                return curIn; // Элемент найден
            else if (lowerBound > upperBound)
                return size; // Элемент не найден
            else // Деление диапазона
            {
                if (arr[curIn] < searchKey)
                    lowerBound = curIn + 1; // В верхней половине
                else
                    upperBound = curIn - 1; // В нижней половине
            }
        }
    }

    public void insert(int value) // Вставка элемента в массив
    {
        int j;
        for (j = 0; j < size; j++) // Определение позиции вставки
            if (arr[j] > value) // (линейный поиск)
                break;
        for (int k = size; k > j; k--) // Перемещение последующих элементов
            arr[k] = arr[k - 1];
        arr[j] = value; // Вставка
        size++; // Увеличение размера
    }


    public boolean delete(int value) { //Удаление элемента из массива
        int j = find(value);
        if (j == size) // Найти не удалось
            return false;
        else // Элемент найден
        {
            for (int k = j; k < size; k++) // Перемещение последующих элементов
                arr[k] = arr[k + 1];
            size--; // Уменьшение размера
            return true;
        }
    }

    public boolean deleteAllEntry(int value) {// Удаление всех вхождений элемента
        boolean isDeleted = false;
        while (true) {
            int j = find(value);
            if (j == size) { // Найти не удалось
                break;
            }
            else // Элемент найден
            {
                for (int k = j; k < size; k++) // Перемещение последующих элементов
                    arr[k] = arr[k + 1];
                size--; // Уменьшение размера
                isDeleted = true;
            }
        }
        return isDeleted;
    }

    public void display(){ //Вывод в консоль массива
        System.out.print("[");
        for (int i=0; i < arr.length; i++) {
            if (i == arr.length-1){
                System.out.print(arr[i]);
            }
            else {
                System.out.print(arr[i] + ",");
            }
        }
        System.out.println("]");
    }

    //Сложность O(N) для отсортированных данных, для случайных O(N^2)
    public void sortInsert() {//Сортировка вставки
        compareCount = 0;     //Операций сравнения приблизительно равно кол-ву операций сравнения
        changeCount = 0;
        for (int out = 0; out < arr.length; out++) {
            int temp = arr[out];
            int in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
                compareCount++;
                changeCount++;
            }
            arr[in] = temp;
        }
        //System.out.println("Среднее число сравнений: " + arr.length*(arr.length - 1)/4);
    }

    //Сложность O(N^2)
    public void sortSelect() { //Сортировка выбора
        compareCount = 0;
        changeCount = 0;
        int out, in, min;
        for(out=0; out < arr.length-1; out++)
        {
            min = out; // Минимум
            for(in = out+1; in < arr.length; in++) {
                if (arr[in] < arr[min]) {// Если значение min больше,
                    min = in; // значит, найден новый минимум
                }
                compareCount++;
            }
            int temp = arr[out];
            arr[out] = arr[min];
            arr[min] = temp;
            changeCount++;
        }
        //System.out.println("Cреднее число сравнений: " + arr.length*(arr.length - 1)/2);
    }

    //Сложность O(N^2), для случайных данных N^2/4
    public void sortBubble() { // Сортировка пузырька
        compareCount = 0;
        changeCount = 0;
        for (int i = arr.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    changeCount++;
                }
                compareCount++;
            }
        }
        //System.out.println("Среднее число сравнений: " + arr.length*(arr.length - 1)/2);
    }
}

