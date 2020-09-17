import java.util.Arrays;
import java.util.HashMap;

public class Entropy {
    public static int[] charCount(String s) {
        
        if (s.equals(null) || s.isEmpty()) {
            return null;
        }
        
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        for (char c : cs) {
            if (map.containsKey(c)) {
                int val = map.get(c) + 1;
                map.put(c, val);
            } else {
                map.put(c, 1);
            }
        }
        
        int[] result = new int[map.size()];
        int i = 0;
        for (int n : map.values()) {
            result[i] = n;
            i++;
        }
        
        return result;
    }
    
    public static double[] normalise(int[] c) {
        
        int sum = 0;
        for (int n : c) {
            sum = n + sum;
        }
        
        double[] result = new double[c.length];
        int i = 0;
        for (int n : c) {
            result[i] = (double) n / sum;
            i++;
        }
        
        return result;
    }
    
    public static double entropyOf(double[] p) {
        double negSum = 0;
        for (double n : p) {
            double neg = -(n * Math.log(n));
            negSum = negSum + neg;
        }
        return negSum;
    }
    
    public static boolean containsChar(String s, char c) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }
    
    public static String remove(String s, char c) {
        String rem = "" + c;
        String output = s.replaceAll(rem, "");
        return output;
    }
    
    public static int[][] charCountArray(String[] a){
        int[] letters = new int[26];
        
        for ( int i = 0; i < a.length; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (containsChar(a[i], c)) {
                    letters[c - 'a']++;
                }
            }
        }
        
        for (char c = 'a'; c <= 'z'; c++) {
            if (letters[c-'a'] > 1) {
                for (int i = 0; i < a.length; i++) {
                    a[i] = remove(a[i],c);
                }
            }
        }
        
        int[][] targetArray = new int[a.length][];
        
        for (int i = 0; i < a.length; i++) {
            targetArray[i] = charCount(a[i]);
        }
        
        return targetArray;
    }
    
    public static void main(String[] args) {
        System.out.println("Character Probabilities in " + args[0] + " : " + Arrays.toString(normalise(charCount(args[0]))));
        System.out.println("Entropy of " + args[0] + " : " + entropyOf(normalise(charCount(args[0]))));
        System.out.println("Entropy of " + args[1] + " : " + entropyOf(normalise(charCount(args[1]))));
        String[] a = new String[args.length];
        for (int i = 0; i < args.length; i++) {
            a[i] = args[i];
        }
        int[][] counted = charCountArray(a);
        for (int i = 0; i < counted.length; i++) {
            System.out.println("Entropy of unique chars in " + args[i] + " : " + entropyOf(normalise(counted[i])));
        }
    }
    
}

