package Lesson_3;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
//        System.out.print(" Введите строку: ");
//        Scanner scan = new Scanner(System.in);
//        String text = scan.nextLine();
//        ReverseString reverseString = new ReverseString(text);
//        System.out.println("Перевёрнутый результат: " + reverseString.getResult());
//
//        System.out.print("Вывод приоритетной очереди: ");
//        PriorityQue priorityQue = new PriorityQue(5);
//        priorityQue.insert(2);
//        priorityQue.insert(1);
//        priorityQue.insert(25);
//        priorityQue.insert(15);
//
//        while (!priorityQue.isEmpty()){
//            System.out.print(priorityQue.remove());
//            System.out.print(" ");
//        }

        System.out.println("");
        Deque deque = new Deque(5);
//        deque.insertRight(1);
//        deque.insertRight(2);
//        deque.insertRight(3);
//        deque.insertRight(4);
//        deque.insertRight(5);
//        deque.insertRight(6);

        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);
        deque.insertLeft(4);
        deque.insertLeft(5);
        deque.insertLeft(6);
        deque.insertLeft(7);
        deque.insertLeft(8);

        System.out.println(deque.size());

        while (!deque.isEmpty()){
            //System.out.print(deque.removeRight());
            System.out.print(deque.removeLeft());
            System.out.print(" ");
        }
    }
}

class ReverseString {
    String inStr;
    public ReverseString(String inStr){
        this.inStr = inStr;
    }

    public String getResult(){

        int size = inStr.length();
        MyStack myStack = new MyStack(size);
        for (char ch : inStr.toCharArray()){
            myStack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while(!myStack.isEmpty())
        {
            sb.append(myStack.pop());
        }
        return sb.toString();
    }
}

class MyStack
{
    private int maxSize; // Размер массива
    private char[] stackArray;
    private int top; // Вершина стека

    public MyStack(int s) // Конструктор
    {
        maxSize = s; // Определение размера стека
        stackArray = new char[maxSize]; // Создание массива
        top = -1; // Пока нет ни одного элемента
    }

    public void push(char j) // Размещение элемента на вершине стека
    {
        stackArray[++top] = j; // Вставка элемента
    }

    public char pop() // Извлечение элемента с вершины стека
    {
        return stackArray[top--]; // Извлечение элемента
    }
    public char peek() // Чтение элемента с вершины стека
    {
        return stackArray[top];
    }

    public boolean isEmpty() // True, если стек пуст
    {
        return (top == -1);
    }

    public boolean isFull() // True, если стек полон
    {
        return (top == maxSize-1);
    }
}

class PriorityQue
{
    // Элементы массива сортируются по значению ключа,
    // от максимумa (0) до минимума (maxSize-1)
    private int maxSize;
    private long[] queArray;
    private int nItems;

    public PriorityQue(int s) // Конструктор
    {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }

    public void insert(long item) // Вставка элемента
    {
        int j;
        if(nItems == 0) // Если очередь пуста,
            queArray[nItems++] = item; // вставляем в ячейку 0
        else // Если очередь содержит элементы
        {
            for(j = nItems-1; j >= 0; j--) // Перебор в обратном направлении
            {
                if(item > queArray[j]) // Если новый элемент больше,
                   queArray[j+1] = queArray[j]; // сдвинуть вверх
                else // Если меньше,
                    break; // сдвиг прекращается
            }
            queArray[j+1] = item; // Вставка элемента
            nItems++;
        }
    }

    public long remove() // Извлечение минимального элемента
    { return queArray[--nItems]; }

    public long peekMin() // Чтение минимального элемента
    { return queArray[nItems-1]; }

    public boolean isEmpty() // true, если очередь пуста
    { return (nItems == 0); }

    public boolean isFull() // true, если очередь заполнена
    { return (nItems == maxSize); }

}

class Deque
{
    private int maxSize;
    private int[] dequeArray;
    private int front;
    private int rear;
    private int nItems;

    public Deque(int s) // Конструктор
    {
        maxSize = s;
        dequeArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insertLeft(int j) // Вставка элемента в начало дека
    {
        if(rear == maxSize - 1)
            rear = -1;
        int[] tempArr =  Arrays.copyOf(dequeArray, dequeArray.length);
        dequeArray[++rear] = j;
        for (int i = rear+1; i < dequeArray.length; i++){
            dequeArray[i] = tempArr[i-1];
        }
        nItems++;
    }

    public void insertRight(int j) // Вставка элемента в конец дека
    {
        if(rear == maxSize - 1)
           rear = -1;
        dequeArray[++rear] = j;
        nItems++;
    }

    public int removeRight() // Извлечение элемента в конце дека
    {
        int temp = dequeArray[rear--];
        if(rear <= 0)
            rear = maxSize-1;
        nItems--;
        return temp;
    }

    public int removeLeft() // Извлечение элемента в начале дека
    {
        int temp = dequeArray[front++];
        if(front == maxSize)
           front = 0;
        nItems--;
        return temp;
    }

    public int peekFront() // Чтение элемента в начале дека
    {
        return dequeArray[front];
    }
    public boolean isEmpty() // true, если дек пуст
    {
        return (nItems == 0);
    }
    public boolean isFull() // true, если дек заполнен
    {
        return (nItems == maxSize);
    }
    public int size() // Количество элементов в деке
    {
        return nItems;
    }
}