package com.dimple.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Dimple on 2018/5/21/21:44
 */
@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Timestamp examDate;
    private Double singleScore;
    private Double moreScore;

    @ManyToOne(targetEntity = Paper.class)
    @JoinColumn(name = "paperId", referencedColumnName = "id")
    private Paper paper;

    @ManyToOne(targetEntity = Student.class)
    @JoinColumn(name = "studentId", referencedColumnName = "id")
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getExamDate() {
        return examDate;
    }

    public void setExamDate(Timestamp examDate) {
        this.examDate = examDate;
    }

    public Double getSingleScore() {
        return singleScore;
    }

    public void setSingleScore(Double singleScore) {
        this.singleScore = singleScore;
    }

    public Double getMoreScore() {
        return moreScore;
    }

    public void setMoreScore(Double moreScore) {
        this.moreScore = moreScore;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
