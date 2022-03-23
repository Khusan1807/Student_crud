package uz.nb.simple_trello.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.nb.simple_trello.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "select * from Student s order by s.id asc ", nativeQuery = true)
    List<Student> getAllStudents();
}
