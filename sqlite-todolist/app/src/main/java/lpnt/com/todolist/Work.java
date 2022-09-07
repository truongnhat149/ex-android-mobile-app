package lpnt.com.todolist;

public class Work {

    private int workId;

    private String name;

    public Work(){

    }

    public Work(int workId, String name) {
        this.workId = workId;
        this.name = name;
    }

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Work{" +
                "workId=" + workId +
                ", name='" + name + '\'' +
                '}';
    }
}
