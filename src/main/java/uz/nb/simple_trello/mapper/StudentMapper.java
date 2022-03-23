package uz.nb.simple_trello.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.nb.simple_trello.dto.StudentCreateDto;
import uz.nb.simple_trello.dto.StudentDto;
import uz.nb.simple_trello.dto.StudentUpdateDto;
import uz.nb.simple_trello.entity.Student;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface StudentMapper  extends BaseMapper<
        Student,
        StudentDto,
        StudentCreateDto,
        StudentUpdateDto> {
    @Override
    StudentDto toDto(Student student);

    @Override
    List<StudentDto> toDto(List<Student> e);

    @Override
    Student fromCreateDto(StudentCreateDto studentCreateDto);

    @Override
    Student fromUpdateDto(StudentUpdateDto studentUpdateDto);
}
