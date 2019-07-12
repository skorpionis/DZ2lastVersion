package packArr;

import java.util.Objects;

/**
 * Created by Ariec on 12.07.2019.
 */
public class ValuesClass {

    String word;
    Integer countWord = 1;

    public void countPlusOne() {
        countWord++;
    }

    public ValuesClass() {

    }

    public ValuesClass(String word) {
        this.word = word;
    }

    public ValuesClass(String word, Integer countWord) {
        this.word = word;
        this.countWord = countWord;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getCountWord() {
        return countWord;
    }

    public void setCountWord(Integer countWord) {
        this.countWord = countWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValuesClass valuesClass = (ValuesClass) o;
        return word.equals(valuesClass.word);

    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }


    @Override
    public String toString() {
        return word + " count = " + countWord;
    }


    public int compareTo(ValuesClass valuesClass) {

        int result = this.word.compareTo(valuesClass.word);
        return result;
    }
}
