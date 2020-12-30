package com.example.demo.model;

import lombok.*;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class ErrorLog {

    @Id
    @GeneratedValue
    private Long id;
    @Column(columnDefinition = "DATE")
    private LocalDate date;
    @Lob
    private String stacktrace;


    public ErrorLog(Exception e) {
        this.setDate(LocalDate.now());
        this.setStacktrace(ExceptionUtils.getStackTrace(e));
    }
}
