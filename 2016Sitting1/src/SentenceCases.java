
public class SentenceCases {
    public static String convert(String s) {
        if (s.length() == 0) return "";
        String res = "" + Character.toUpperCase(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr != ' ') {
                res += Character.toLowerCase(curr);
            } else {
                char next = s.charAt(i+1);
                res = res + " " + Character.toUpperCase(next);
                i++;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        String s = args[0];
        String ans = convert(s);
        System.out.println(ans);
    }
}
