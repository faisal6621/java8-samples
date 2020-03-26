package github.faisal6621;

public class NoStaticBlockExecuted {
    // static HasStaticBlock block;

    public static void main(String[] args) {
        HasStaticBlock.print();
        // System.out.println(HasStaticBlock.count);
        // System.out.println(new HasStaticBlock().number);
        System.out.println("Hello");
    }
}

class HasStaticBlock {
    static {
        System.out.println("static block");
        // count2 = 5;
    }

    public static final int count = 1;
    public static final int count2 = 10;// = 1;

    public static void print(){
        System.out.println("printed");
    }
    // public final int number = 10;

    // {

    // System.out.println("init block");
    // }

}
