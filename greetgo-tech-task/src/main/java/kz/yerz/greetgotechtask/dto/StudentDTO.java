package kz.yerz.greetgotechtask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {

    private Long id;

    private String fullName;

    private String address;


    private String phone;

    private int age;

}
