package kz.yerz.greetgotechtask.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="t_students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="fullName")
    private String fullName;

    @Column(name="address")
    private String address;

    @Column(name="phone")
    private String phone;

    @Column(name="age")
    private int age;
}
