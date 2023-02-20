package org.example.temp;

public class Tester2 {
    public static void main(String[] args) {
        Tester tester = new Tester();
        System.out.println(tester.getList().size());
        tester.getList().add(10);
        int rand = tester.getList().get(0);
        System.out.println(rand);
    }
}
