/**
 * Java. Level 2  Lesson 3.
 *
 * @author Shangareev Rinat
 * @version dated 29.11.2017
 */

import java.util.*;

public class MainClass {

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        String[] strArray = new String[]{"Apricot", "Avocado", "Pawpaw", "Orange",
                "Banana", "apple", "grapes", "kiwi", "lime", "melon", "Apricot",
                "Banana", "lime", "Apricot"};
        mainClass.calcFruit(strArray);

        Phonebook phonebook = new Phonebook();
        phonebook.add("АГУРЕЕВ", "89025800000", "89025800273");
        phonebook.add("ВАВИЛОВ ", "8 902 581-99-99");
        phonebook.add("ВаСЕнЕВ", "8 902 58 14 673");
        phonebook.add("МАКАРЕВ", "89025812345", "89025887654");
        phonebook.add("Макарев", "8-902-582-38-91", "8-902-581-12-99");
        System.out.print("МАКАРЕВ: " + phonebook.get("МАКАРЕВ"));
    }

    private void calcFruit(String[] strArray) {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(strArray.length);
        int i = 1;
        Arrays.sort(strArray);
        for (String str : strArray) {
            if (linkedHashMap.containsKey(str)) {
                linkedHashMap.remove(str);
                linkedHashMap.put(str, ++i);
            } else {
                i = 1;
                linkedHashMap.put(str, i);
            }
        }
        System.out.println(linkedHashMap.toString());
    }
}

class Phonebook {
   private TreeMap<String, ArrayList<String>> treeMap = new TreeMap<>();

   public void add(String fio, String... numberPhone){
       String[] numbersPhone = numberPhone;
       String newFio = fio.toUpperCase().replaceAll("\\s|\\d", "");
       ArrayList<String> numberPhoneList = new ArrayList<>();
       if (treeMap.containsKey(newFio)){
           numberPhoneList = treeMap.get(newFio);
       }

       for (String phone : numbersPhone) {
           String newPhone = phone.replaceAll("\\s|\\D", "");
           if (!numberPhoneList.contains(newPhone))
                numberPhoneList.add(newPhone);
           else {
               System.out.println("Телефон " + phone + " уже присуствует в телефонном справочнике, операция будет отменена");
               return;
           }
       }
       treeMap.put(newFio, numberPhoneList);
   }

   public ArrayList<String> get(String fio){
       String newFio = fio.toUpperCase().replaceAll("\\s|\\d", "");
       if (treeMap.containsKey(newFio)){
           return treeMap.get(newFio);
       }
       else {
          System.out.println(fio + " отсутствует в телефонном справочнике");
       }
       return null;
   }
}



