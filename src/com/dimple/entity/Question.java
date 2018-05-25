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
public class Question {
    private int id;
    private String question;
    private String answer;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private Timestamp createTime;
    private Integer paperId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "question", nullable = true, length = 255)
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Basic
    @Column(name = "answer", nullable = true, length = 255)
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Basic
    @Column(name = "optionA", nullable = true, length = 255)
    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    @Basic
    @Column(name = "optionB", nullable = true, length = 255)
    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    @Basic
    @Column(name = "optionC", nullable = true, length = 255)
    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    @Basic
    @Column(name = "optionD", nullable = true, length = 255)
    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    @Basic
    @Column(name = "createTime", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "paperId", nullable = true)
    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return id == question1.id &&
                Objects.equals(question, question1.question) &&
                Objects.equals(answer, question1.answer) &&
                Objects.equals(optionA, question1.optionA) &&
                Objects.equals(optionB, question1.optionB) &&
                Objects.equals(optionC, question1.optionC) &&
                Objects.equals(optionD, question1.optionD) &&
                Objects.equals(createTime, question1.createTime) &&
                Objects.equals(paperId, question1.paperId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, question, answer, optionA, optionB, optionC, optionD, createTime, paperId);
    }
}
