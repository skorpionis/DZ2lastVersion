package packArr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * Created by Ariec on 12.07.2019.
 */
public class MainArrayListCLass {

    public static ArrayList<ValuesClass> readWordsFromFile2(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = null;
        ArrayList<ValuesClass> arr = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            String[] s1 = line.split("\\s+");

            for (String str : s1) {
                ValuesClass valuesClass=new ValuesClass(str);
                if(!arr.contains(valuesClass)){
                    arr.add(valuesClass);
                }else{
                    ValuesClass valuesClass1 = arr.get(arr.indexOf(valuesClass));
                    arr.set(arr.indexOf(valuesClass), new ValuesClass(valuesClass1.getWord(),valuesClass1.getCountWord()+1));
                }
            }
        }
        return arr;
    }

    public static ArrayList<ValuesClass> sortFromArrayABCD(ArrayList<ValuesClass> returnArr) {
        boolean flag = false;
        ValuesClass temp;
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


    public static void printStatArr(ArrayList<ValuesClass> printArr) {
        for (int i = 0; i <printArr.size() ; i++) {
            System.out.println("Слово: " + printArr.get(i).getWord() + " " + "Кол-во раз: " + printArr.get(i).getCountWord() );
        }
    }
    public static void maxPovtorov(ArrayList<ValuesClass> maxArrIndex) {
            int max = maxArrIndex.stream().mapToInt(ValuesClass::getCountWord).max().getAsInt();
            System.out.println(maxArrIndex.stream().filter(s-> s.getCountWord() == max).collect(toList()));
    }

    public static void main(String[] args) throws IOException {
        String filename = "C:\\Users\\Ariec\\text.txt";
        ArrayList<ValuesClass > testList = readWordsFromFile2(filename);
        testList = sortFromArrayABCD(testList);
        printStatArr(testList);
        maxPovtorov(testList);
    }
}
