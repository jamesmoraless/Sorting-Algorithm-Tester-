package Lab2Q2;

public class StudentGrade implements Comparable<StudentGrade>{
    private String firstName, lastName;
    private int grade;


    @Override
    public int compareTo(StudentGrade other)//my compareTo method
    {
        double gr1 = this.getGrade();
        double gr2 = other.getGrade();
        if (gr1 < gr2)
            return -1;
        else if (gr1 == gr2)
            return 0;
        else
            return 1;
    }

    public StudentGrade(String firstName,String lastName,int grade)//constructor with parameters
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    //Below is all my getter and setter methods
    public String getFirstName()
        {
            return firstName;
        }

    public void setFirstName(String fName)
    {
        this.firstName = fName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lName)
    {
        this.lastName = lName;
    }

    public int getGrade()
    {
        return grade;
    }

    public void setGrade(int grd)
    {
        this.grade = grd;
    }

    public String toString()//My toString method that overrides the other toString method
    {
        return String.format("%1$-20s:%2$7s", firstName + " " + lastName, grade);
    }





}
