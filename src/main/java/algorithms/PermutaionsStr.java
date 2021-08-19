package algorithms;

public class PermutaionsStr {
    public static void main(String[] args) {
        PermutaionsStr obj = new PermutaionsStr();
        String str = "abc";

        obj.permutaions(str);
    }

    void permutaions(String str) {
        permutaions(str, "");
    }

    void permutaions(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);

                //System.out.println("remaining str: " + rem);
                permutaions(rem, prefix + str.charAt(i));
            }
        }
    }
}
