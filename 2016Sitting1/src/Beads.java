import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Beads {
    public static Set<Integer> sums(ArrayList<Integer> beads, int n) {
        Set<Integer> resultSet = new HashSet<Integer>();
        
        if (n < 1 || beads.isEmpty()) {
            return new HashSet<Integer>();
        }
        
        for (int i=0; i<beads.size(); i++) {
            int sum = 0;
            for (int j=0; j<n; j++) {
                sum += beads.get((i+j)%beads.size());
            }
            resultSet.add(sum);
        }
        return resultSet;
    }
    
    public static Set<Integer> allSums(ArrayList<Integer> a) {
        Set<Integer> resultSet = new HashSet<>();
        for (int i=1; i<a.size()+1; i++) {
            resultSet.addAll(sums(a,i));
        }
        return resultSet;
    }
    
    public static int findMax(Set<Integer> set) {
        ArrayList<Integer> setTwo = new ArrayList<>(set);
        
        int max = 0;
        if (!setTwo.contains(1)) {
            max = 0;
        }
        
        for (int i = 0; i < set.size() - 1; i++) {
            if (setTwo.get(i + 1) != (setTwo.get(i) + 1)) {
                max = setTwo.get(i);
                break;
            }
                else if (setTwo.get(i + 1) > max) {
                    max = setTwo.get(i + 1);
                }
        }
        return max;
        
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> beads = new ArrayList<Integer>();
        for (int i = 0; i < args.length; i++) {
            beads.add(Integer.parseInt(args[i]));
        }
        Set<Integer> allTheSums = allSums(beads);
        System.out.print(allTheSums);
    }
}
