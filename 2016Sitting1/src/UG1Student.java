
public class UG1Student extends Student {
    private char mainSchedule;
    
    public UG1Student(String name, String uun, char sched) {
        super(name,uun,1);
        this.mainSchedule = sched;
    }
    
    //  write a zero argument constructor that invokes your first constructor with arguments “not set", “not set”, ‘X’
    public UG1Student() {
        this("not set", "not set", 'X');
    }
    
    public boolean addCourse(Course c) {
        if (c.getLevel()==7 || c.getLevel()==8) {
            super.addCourse(c);
            return true;
        }
        return false;
    }
    
    public boolean addCourses(Course[] cs) {
        boolean added = true;
        for (Course c : cs) {
            if (!addCourse(c)) {
                added = false;
            }
        }
        return added;
    }
    
    public String toString() {
        String s = super.toString() + "\nMain schedule " + mainSchedule + " courses:";
        for (Course c : super.getCourses()) {
            s.concat("\n" + c.getName());
        }
        return s;
    }
}
