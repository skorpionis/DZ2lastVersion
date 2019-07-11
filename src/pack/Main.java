package pack;

import javafx.util.Pair;
import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.util.*;

/*Есть входной файл с набором слов, написанных через пробел
Необходимо:
Прочитать слова из файла.   -- ArrayList<String> arr (C//:sdsds)
Отсортировать в алфавитном порядке. -- ArrayList<String> arr (ArrayList<String> returnArr)
Посчитать сколько раз каждое слово встречается в файле. -- ArrayList<String> returnArr (HashMap<String, Integer> )
Вывести статистику на консоль  -- HashMap<String, Integer>
Найти слово с максимальным количеством повторений.  -- HashMap<String, Integer> (entry.keySet())
Вывести на консоль это слово и сколько раз оно встречается в  -- entry.keySet()
файле*/
public class Main {

    public static void maxPovtorov(HashMap<String, Integer> map) {
        int maxValueInMap = Collections.max(map.values());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                System.out.println("Слово с максимальным кол-вом повторов - " + entry.getKey());
            }
        }
    }

    public static void printStatMap(HashMap<String, Integer> printMap) {
        for (Map.Entry<String, Integer> entry : printMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Слово: " + key + " " + "Кол-во раз: " + value);
        }
    }

    public static HashMap<String, Integer> countSameWordsFromFile(ArrayList<String> arrayList) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arrayList.size(); i++) {
            String c = arrayList.get(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    public static ArrayList<String> readWordsFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = null;
        ArrayList<String> arr = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            String[] s1 = line.split("\\s+");
            for (int i = 0; i < s1.length; i++) {
                arr.add(s1[i]);
            }
        }
        return arr;
    }

    public static ArrayList<String> sortFromArrayABC(ArrayList<String> returnArr) {
        boolean flag = false;
        String temp;
        while (!flag) {
            flag = true;
            for (int i = 0; i < returnArr.size() - 1; i++) {
                if (returnArr.get(i).compareTo(returnArr.get(i + 1)) > 0) {
                    flag = false;
                    temp = returnArr.get(i);
                    returnArr.set(i, returnArr.get(i + 1));
                    returnArr.set(i + 1, temp);
                }
            }
        }
        return returnArr;
    }


    public static void main(String[] args) throws IOException {
            String filename = "C:\\Users\\Ariec\\text.txt";
            ArrayList<String > testList = readWordsFromFile(filename);
            testList = sortFromArrayABC(testList);
           HashMap<String,Integer> testList1 = countSameWordsFromFile(testList);
           printStatMap(testList1);
           maxPovtorov(testList1);
        }
    }