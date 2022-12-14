package com.virginmoney.uk.entity;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Person {
    private String firstName;
    private String lastName;
    private LocalDate dob;
}