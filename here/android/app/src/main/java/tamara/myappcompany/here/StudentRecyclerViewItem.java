package tamara.myappcompany.here;

public class StudentRecyclerViewItem {

    private String StudentName;
    private String StudentNumber;
    private int StudentImageId;

    public StudentRecyclerViewItem(String StudentName, String StudentNumber, int StudentImageId) {
        this.StudentName = StudentName;
        this.StudentNumber = StudentNumber;
        this.StudentImageId = StudentImageId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getStudentNumber() {
        return StudentNumber;
    }

    public void setStudentNumber(String StudentNumber) {
        this.StudentNumber = StudentNumber;
    }

    public int getStudentImageId() {
        return StudentImageId;
    }

    public void setStudentImageId(int StudentImageId) {
        this.StudentImageId = StudentImageId;
    }

}
