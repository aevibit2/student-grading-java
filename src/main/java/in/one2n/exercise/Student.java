package in.one2n.exercise;

import com.opencsv.bean.CsvBindByName;

public class Student {

    @CsvBindByName(column = "FirstName")
    private String firstname;
    @CsvBindByName(column = "LastName")
    private String lastname;
    @CsvBindByName(column = "University")
    private String university;
    @CsvBindByName(column = "Test1")
    private Double test1Score;
    @CsvBindByName(column = "Test2")
    private Double test2Score;
    @CsvBindByName(column = "Test3")
    private Double test3Score;
    @CsvBindByName(column = "Test4")
    private Double test4Score;

    // computed fields
    private Double finalScore;
    private Grade grade;

    public Student() {
    }

    public Student(String firstname, String lastname, String university) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.university = university;
    }

    public Student(String firstname, String lastname, String university, Double test1Score, Double test2Score, Double test3Score, Double test4Score) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.university = university;
        this.test1Score = test1Score;
        this.test2Score = test2Score;
        this.test3Score = test3Score;
        this.test4Score = test4Score;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Double getTest1Score() {
        return test1Score;
    }

    public void setTest1Score(Double test1Score) {
        this.test1Score = test1Score;
    }

    public Double getTest2Score() {
        return test2Score;
    }

    public void setTest2Score(Double test2Score) {
        this.test2Score = test2Score;
    }

    public Double getTest3Score() {
        return test3Score;
    }

    public void setTest3Score(Double test3Score) {
        this.test3Score = test3Score;
    }

    public Double getTest4Score() {
        return test4Score;
    }

    public void setTest4Score(Double test4Score) {
        this.test4Score = test4Score;
    }

    public Double getFinalScore() {
        return finalScore;
    }

    public Grade getGrade() {
        return grade;
    }

    public void computeFinalScoreAndGrade() {
        finalScore = (test1Score + test2Score + test3Score + test4Score) / 4;
        if (finalScore >= 70) {
            grade = Grade.A;
        } else if (finalScore >= 50) {
            grade = Grade.B;
        } else if (finalScore >= 35) {
            grade = Grade.C;
        } else {
            grade = Grade.F;
        }
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Student)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Student c = (Student) o;

        // Compare the data members and return accordingly
        return firstname.equals(c.firstname) &&
                lastname.equals(c.lastname) &&
                university.equals(c.university);
    }

}

