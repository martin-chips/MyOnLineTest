package com.dimple.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Dimple on 2018/5/21/21:44
 */
@Entity
public class Exam {
    private int id;
    private Timestamp examDate;
    private Double singleScore;
    private Double moreScore;
    private Integer paperId;
    private Integer studentId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "examDate", nullable = true)
    public Timestamp getExamDate() {
        return examDate;
    }

    public void setExamDate(Timestamp examDate) {
        this.examDate = examDate;
    }

    @Basic
    @Column(name = "singleScore", nullable = true, precision = 0)
    public Double getSingleScore() {
        return singleScore;
    }

    public void setSingleScore(Double singleScore) {
        this.singleScore = singleScore;
    }

    @Basic
    @Column(name = "moreScore", nullable = true, precision = 0)
    public Double getMoreScore() {
        return moreScore;
    }

    public void setMoreScore(Double moreScore) {
        this.moreScore = moreScore;
    }

    @Basic
    @Column(name = "paperId", nullable = true)
    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    @Basic
    @Column(name = "studentId", nullable = true)
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return id == exam.id &&
                Objects.equals(examDate, exam.examDate) &&
                Objects.equals(singleScore, exam.singleScore) &&
                Objects.equals(moreScore, exam.moreScore) &&
                Objects.equals(paperId, exam.paperId) &&
                Objects.equals(studentId, exam.studentId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, examDate, singleScore, moreScore, paperId, studentId);
    }
}
