package uz.nb.simple_trello.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String address;
    private Long course;
    private String faculty;
    private Long groupNumber;




}
