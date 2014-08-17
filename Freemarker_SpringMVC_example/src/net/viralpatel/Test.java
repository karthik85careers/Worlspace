package net.viralpatel;

public class Test {     
    int a = 10;
    
    public void doStuff(int a) {
        a += 1;
        System.out.println(++a);
    }
    public static void main(String args[]) {
        Test t = new Test();
        t.doStuff(3);
    }
}
