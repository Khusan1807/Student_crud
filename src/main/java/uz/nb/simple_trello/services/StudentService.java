package uz.nb.simple_trello.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.nb.simple_trello.dto.StudentCreateDto;
import uz.nb.simple_trello.dto.StudentDto;
import uz.nb.simple_trello.dto.StudentUpdateDto;
import uz.nb.simple_trello.entity.Student;
import uz.nb.simple_trello.mapper.StudentMapper;
import uz.nb.simple_trello.reposiroty.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentMapper mapper;
    private final StudentRepository repository;


    public void create(StudentCreateDto dto) {
        Student student = mapper.fromCreateDto(dto);
        student.setFirstname(dto.getFirstname());
        student.setLastname(dto.getLastname());
        student.setAddress(dto.getAddress());
        student.setCourse(dto.getCourse());
        student.setFaculty(dto.getFaculty());
        student.setGroupNumber(dto.getGroupNumber());
        repository.save(student);
    }

    public StudentDto get(Long id) {
        Student student = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Topilmadi");
        });
        return mapper.toDto(student);
    }

    public List<StudentDto> getAll() {
        return mapper.toDto(repository.getAllStudents());
    }

    public void update(StudentUpdateDto dto) {
        Student student = mapper.fromUpdateDto(dto);
        repository.save(student);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
