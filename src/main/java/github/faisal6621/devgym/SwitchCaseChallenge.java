package github.faisal6621.devgym;

/**
 * SwitchChallenge
 */
public class SwitchCaseChallenge {

    public static void main(String[] args) {
        int variable = 50;
        String str = "";
        switch (variable) {
            case 30:
                str += "zz";
                break;
            case 50:
                str += "Mn";
            case 10:
                str += "Ne";

            default:
                str += "H";
        }

        System.out.println(str);
    }
}
