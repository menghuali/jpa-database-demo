package com.aloha.database.databasedemo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NamedQuery(name="find_all_persons", query = "select p from Person p")
// @Table(name = "person")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Setter
@Getter
public class Person {

    @GeneratedValue
    @Id
    private int id;

    // @Column(name = "name")
    private String name;
    private String location;
    private Date birthDate;

}
