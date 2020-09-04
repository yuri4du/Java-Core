package ru.geekbrains.lesson_c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Words {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("man");
        arrayList.add("woman");
        arrayList.add("dog");
        arrayList.add("cat");
        arrayList.add("mouse");
        arrayList.add("man");
        arrayList.add("human");
        arrayList.add("rabbit");
        arrayList.add("jug");
        arrayList.add("ship");
        arrayList.add("sheep");
        arrayList.add("heap");
        arrayList.add("cheese");
        arrayList.add("dog");
        arrayList.add("mouse");
        arrayList.add("flag");
        arrayList.add("pig");
        arrayList.add("heat");
        arrayList.add("rat");
        arrayList.add("pig");
        findUniqueWords(arrayList);
        countWords(arrayList);
    }

    private static void findUniqueWords(ArrayList<String> arrayList) {
        ArrayList<String> arrayListUnique = new ArrayList<>();

        for (int i = 0; i < arrayList.size()-1; i++) {
            if (!arrayListUnique.contains(arrayList.get(i))) {
                arrayListUnique.add(arrayList.get(i));
            }
        }

        System.out.println(arrayList.toString());
        System.out.println(arrayListUnique.toString());
    }

    public static void countWords(ArrayList<String> arrayList) {
        HashMap<String, Integer> hm = new HashMap<>();


        for (int i = 0; i < arrayList.size()-1; i++) {
            Iterator<String> iter = arrayList.iterator();
            int temp = 0;
            while (iter.hasNext()) {
                String str = iter.next();
                if (str.equals(arrayList.get(i))){
                    temp +=1;
                    hm.put(arrayList.get(i), temp);

                }
            }
        }
        System.out.println(hm);
    }

}
