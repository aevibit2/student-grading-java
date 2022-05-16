package in.one2n.exercise;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Grader {

    // Parse CSV file and store in a list of Student.
    public List<Student> parseCSV(String filepath) {
        List<Student> students = Collections.emptyList();
        try {
            students = new CsvToBeanBuilder(new FileReader(filepath))
                    .withType(Student.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }

    // Calculate Grades of Students based on their marks.
    public List<Student> calculateGrade(List<Student> students) {
        for (Student s : students) {
            s.computeFinalScoreAndGrade();
        }
        return students;
    }

    // Finds Overall Topper from the List of Students.
    public Student findOverallTopper(List<Student> gradedStudents) {
        return gradedStudents.stream()
                .max(Comparator.comparing(Student::getFinalScore)).
                orElseThrow(NoSuchElementException::new);
    }

    // Find Topper Student for each University based on their Final Score.
    public Map<String, Student> findTopperPerUniversity(List<Student> gradedStudents) {
        HashMap<String, Student> result = new HashMap();
        for (Student s : gradedStudents) {
            if (!(result.containsKey(s.getUniversity())) ||
                    result.get(s.getUniversity()).getFinalScore() < s.getFinalScore()) {
                result.put(s.getUniversity(), s);
            }
        }
        return result;
    }
}
