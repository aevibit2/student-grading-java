package in.one2n.exercise;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Grader {

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

    public List<Student> calculateGrade(List<Student> students) {
        for (Student s : students) {
            s.computeFinalScoreAndGrade();
        }
        return students;
    }

    public Student findOverallTopper(List<Student> gradedStudents) {
        Student topper = gradedStudents.stream()
                .max(Comparator.comparing(Student::getFinalScore)).
                orElseThrow(NoSuchElementException::new);
        return topper;
    }

    public Map<String, Student> findTopperPerUniversity(List<Student> gradedStudents) {
        HashMap<String, Student> result = new HashMap();
        for (Student s: gradedStudents) {
            if(!(result.containsKey(s.getUniversity())) ||
                    result.get(s.getUniversity()).getFinalScore() < s.getFinalScore()) {
                result.put(s.getUniversity(), s);
            }
        }
        return result;
    }
}
