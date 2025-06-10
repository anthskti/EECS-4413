import java.util.Objects;

class Student {

  private Long id;
  private String name;
  private int courseID;

  Student() {}

  Student(String name, int courseID) {

    this.name = name;
    this.courseID = courseID;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public int getCourseID() {
    return this.courseID;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCOurseID(int cid) {
    this.courseID = cid;
  }

  
  public String toJSON() {
	    return "Student{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.courseID + '\'' + '}';
  } 
  public String toHTML() {
	    return "<p>" +  "name=" + this.name + " registered for course" + this.courseID + '\'' + "\\p>";
} 

  
}
