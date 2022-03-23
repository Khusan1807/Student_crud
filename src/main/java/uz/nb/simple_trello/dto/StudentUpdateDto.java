package uz.nb.simple_trello.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentUpdateDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String address;
    private Long course;
    private String faculty;
    private Long groupNumber;
}
