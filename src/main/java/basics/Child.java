package basics;

public class Child extends Parent {
    public Child() {
        super();
       // System.out.println("Child");
    }

    @Override
    public void print(){
        System.out.println("Child");
        String s = "b";
        System.out.println(s);
    }
    public static final String s = "a";
}
