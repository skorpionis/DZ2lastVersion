package packArr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ariec on 12.07.2019.
 */
public class MainArrayListCLass {

    public static ArrayList<String> readWordsFromFile2(String filename) throws IOException {
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

    public static ArrayList<String> sortFromArrayABCD(ArrayList<String> returnArr) {
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

    public static int dopFuncPoiska(ArrayList<ValuesClass> arr, String s){
        for (int i = 0; i < arr.size(); i++) {
            if(s.equals(arr.get(i).getWord())){
                return i;
            }
        }
        return -1;
    }

    public static ArrayList<ValuesClass> countSameWordsFromFile(ArrayList<String> arrayList) {
        ArrayList<ValuesClass> arr = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
           String c = arrayList.get(i);
           int dopF=dopFuncPoiska(arr,c);
           if(dopF!=-1){
              ValuesClass abc =  arr.get(dopF);
              abc.countPlusOne();
           }else {
               arr.add(new ValuesClass(c));
           }
        }
        return arr;
    }

    public static void printStatArr(ArrayList<ValuesClass> printArr) {
        for (int i = 0; i <printArr.size() ; i++) {
            System.out.println("Слово: " + printArr.get(i).getWord() + " " + "Кол-во раз: " + printArr.get(i).getCountWord() );
        }
    }
    public static void maxPovtorov(ArrayList<ValuesClass> maxArrIndex) {
        ValuesClass max=maxArrIndex.get(0);
        for (int i = 1; i < maxArrIndex.size(); i++) {
            if(maxArrIndex.get(i).getCountWord()>max.getCountWord()){
              max=maxArrIndex.get(i);
            }
        }
        System.out.println("Слово с максимальным кол-вом повторов - " + max.toString());
    }

    public static void main(String[] args) throws IOException {
        String filename = "C:\\Users\\Ariec\\text.txt";
        ArrayList<String > testList = readWordsFromFile2(filename);
        testList = sortFromArrayABCD(testList);
        ArrayList<ValuesClass> arr1 = countSameWordsFromFile(testList);
        printStatArr(arr1);
        maxPovtorov(arr1);
    }
}
