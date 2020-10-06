package ru.mirea;

public class Student {
    double iDNumber;
    public Student() {
        this.iDNumber = 0 + (int) (Math.random() * ((1000 - 0) + 1));
    }
    public int compareTo(Student student) {
        if (student.iDNumber < iDNumber)
            return -1;
        else if (student.iDNumber > iDNumber)
            return 1;
        return 0;
    }
    public String toString() {
        return "" + iDNumber;
    }
}
