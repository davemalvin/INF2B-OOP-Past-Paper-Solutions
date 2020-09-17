import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class FruitySmartPhone extends Phone {
    private HashMap<String,Integer> installedApps = new HashMap<>();
    private int cpuSpeed;
    private int freeMemory;
    
    public int getCpuSpped() {
        return cpuSpeed;
    }
    
    public int getFreeMemory() {
        return freeMemory;
    }
    
    public FruitySmartPhone(String name, int freeMemory, int cpuSpeed) {
        super(name);
        this.freeMemory = freeMemory;
        this.cpuSpeed = cpuSpeed;
    }
    
    public boolean installApp(App a) {
        boolean boolean1 = installedApps.containsKey(a.getName());
        boolean boolean2 = a.getMemoryReq() > freeMemory;
        boolean boolean3 = a.getCpuReq() > cpuSpeed;
        if (boolean1 || boolean2 || boolean3) {
            return false;
        } 
        installedApps.put(a.getName(),a.getMemoryReq());
        freeMemory = freeMemory - a.getMemoryReq();
        return true;
    }
    
    public boolean uninstallApp(App app) {
        boolean a = installedApps.containsKey(app.getName());

        if (!a) {
            return false;
        }

        installedApps.remove(app.getName());
        freeMemory = freeMemory + app.getMemoryReq();
        return true;
    }
    
    public boolean useApp(String s) {
        if (!installedApps.containsKey(s) || freeMemory < 1) {
            return false;
        }
        
        freeMemory = freeMemory - 1;
        installedApps.put(s, installedApps.get(s) + 1);
        return true;
    }
    
    public ArrayList<String> getInstalledApps(){
        ArrayList<String> installedNames = new ArrayList<>();
        ArrayList<Integer> installedMemReq = new ArrayList<>(installedApps.values());
        Collections.sort(installedMemReq);
        Collections.reverse(installedMemReq);
        
        for (int v : installedMemReq) {
            for (String s : installedApps.keySet()) {
                if (installedNames.contains(s) == false && installedApps.get(s) == v) {
                    installedNames.add(s); 
                }
            }
        }
  
        return installedNames;
    }
    
    public static void main(String[] args) {
        FruitySmartPhone p = new FruitySmartPhone("John Smith", 100, 10);
        p.installApp(new App("Camera",1,2));
        p.installApp(new App("Music",2,3));
        p.installApp(new App("Podcast",2,11));
        p.useApp("Music");
        System.out.println(p.getInstalledApps());
    }
}
