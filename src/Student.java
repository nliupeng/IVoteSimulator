
public class Student {
    
    private String id;
    
    public Student() {
        this.id = this.toString();      // assign unique id
    }
    
    public String getId() {
        return id;
    }
}
