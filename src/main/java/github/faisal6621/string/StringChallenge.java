package github.faisal6621.string;

public class StringChallenge {

    @SuppressWarnings({ "java:S4973", "java:S2129" })
    public static void main(String[] args) {
        String s = "ABCDE";
        String s1 = s.substring(0, 2);
        String s2 = s.substring(0, 2);
        System.out.println(s1.equals(s2));

        System.out.println(s1 == s2);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        String b1 = "ABC";
        String b2 = new String("ABC");
        System.out.println(b1.hashCode());
        System.out.println(b2.hashCode());
    }
}
