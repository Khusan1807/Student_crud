package uz.nb.simple_trello.entity;


import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Getter
@Setter
@Entity
public class Student  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 50)
    private String firstname;

    @Column(nullable = false, length = 50)
    private String lastname;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Long course;

    @Column(nullable = false, length = 50)
    private String faculty;

    @Column(nullable = false)
    private Long groupNumber;



}
