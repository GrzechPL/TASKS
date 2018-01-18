package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="tasks")
@Table(name = "tasks", schema = "task_crud")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String title;
    @Column(name = "description")
    private String content;

}

