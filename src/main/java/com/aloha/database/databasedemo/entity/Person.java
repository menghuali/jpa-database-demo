package com.aloha.database.databasedemo.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Person {

    private int id;
    private String name;
    private String location;
    private Date birthDate;

}
