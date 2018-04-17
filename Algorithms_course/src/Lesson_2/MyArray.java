package Lesson_2;

public class MyArray {
    private char[] arr;
    private int size;
    private int current;
    private boolean isSorted = false;

    MyArray(int size) {
        this.current = 0;
        this.arr = new char[size];
    }

    void insert(char value) {
        if (this.current == this.arr.length) {
            char[] newArr = new char[current * 2];
            System.arraycopy(this.arr, 0, newArr, 0, current);
            this.arr = newArr;
        }
        this.arr[this.current] = value;
        this.current++;
    }

    boolean delete(char value) {
        int index = search(value);
        if (index != -1) {
            System.arraycopy(this.arr, index + 1,
                    this.arr, index,
                    this.current - index - 1);
            this.current--;
            return true;
        }
        return false;
    }

    public int search(char value) {
        for (int i = 0; i < this.current; i++) {
            if (this.arr[i] == value)
                return i;
        }
        return -1;
    }

    public boolean hasValue(char value) {
        if (!isSorted) throw new RuntimeException("Not sorted array!");
        int low = 0;
        int high = this.current - 1;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (value == this.arr[mid]) {
                return true;
            } else {
                if (value < this.arr[mid])
                    high = mid;
                else
                    low = mid + 1;
            }
        }
        return false;
    }
    /*
**** РЎРѕР·РґР°С‚СЊ РјР°СЃСЃРёРІ (С‚С‹СЃСЏС‡Сѓ СЌР»РµРјРµРЅС‚РѕРІ).
**** РћРїРёСЃР°С‚СЊ РјРµС‚РѕРґ РєРѕС‚РѕСЂС‹Р№ Р±С‹ СѓРґР°Р»СЏР» РІСЃРµ РІС…РѕР¶РґРµРЅРёСЏ РґР°РЅРЅРѕРіРѕ Р·РЅР°С‡РµРЅРёСЏ РІ РјР°СЃСЃРёРІ
**** РќР°РїРёСЃР°С‚СЊ РјРµС‚РѕРґС‹ СѓРґР°Р»РµРЅРёСЏ, РґРѕР±Р°РІР»РµРЅРёСЏ, РїРѕРёСЃРєР° СЌР»РµРјРµРЅС‚Р° РјР°СЃСЃРёРІР°.
**** Р—Р°РїРѕР»РЅРёС‚СЊ РјР°СЃСЃРёРІ СЃР»СѓС‡Р°Р№РЅС‹РјРё С‡РёСЃР»Р°РјРё.
**** РќР°РїРёСЃР°С‚СЊ РјРµС‚РѕРґС‹, СЃРѕСЂС‚РёСЂРѕРІРѕРє Рё РІС‹РІРµСЃС‚Рё РЅР° СЌРєСЂР°РЅ РєРѕР»РёС‡РµСЃС‚РІРѕ
     РґРµР№СЃС‚РІРёР№ Рё СЃСЂР°РІРЅРёС‚СЊ РµРіРѕ СЃРѕ СЃР»РѕР¶РЅРѕСЃС‚СЊСЋ СЃРѕСЂС‚РёСЂРѕРІРєРё.
*/

    private void change(int a, int b) {
        char temp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = temp;
    }

    public void sortInsert() {
        for (int out = 0; out < this.current; out++) {
            char temp = this.arr[out];
            int in = out;
            while(in > 0 && this.arr[in - 1] >= temp) {
                this.arr[in] = this.arr[in - 1];
                in--;
            }
            this.arr[in] = temp;
        }
        this.isSorted = true;
    }

    public void sortSelect() {
        for (int out = 0; out < this.current; out++) {
            int pos = out;
            for (int in = out + 1; in < this.current; in++) {
                if (this.arr[in] < this.arr[pos])
                    pos = in;
            }
            change(out, pos);
        }
        this.isSorted = true;
    }

    public void sortBubble() {
        for (int i = current - 1; i > 1; i--)
            for (int j = 0; j < i; j++)
                if (this.arr[j] > this.arr[j + 1])
                    change(j, j + 1);
        this.isSorted = true;
    }

    @Override
    public String toString() {
        if (arr == null)
            return "null";
        int iMax = current - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(arr[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }
}