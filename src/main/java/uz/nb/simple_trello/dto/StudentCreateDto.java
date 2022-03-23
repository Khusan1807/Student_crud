package uz.nb.simple_trello.dto;


import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateDto {
    private String firstname;
    private String lastname;
    private String address;
    private Long course;
    private String faculty;
    private Long groupNumber;
}
