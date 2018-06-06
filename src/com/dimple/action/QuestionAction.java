package com.dimple.action;

import com.dimple.entity.Paper;
import com.dimple.entity.Question;
import com.dimple.service.PaperService;
import com.dimple.service.QuestionService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Dimple on 2018/6/2/15:41
 */
@Controller
@Scope(value = "prototype")
public class QuestionAction extends ActionSupport implements ModelDriven<Question> {
    private Question question = new Question();
    private List<Question> questions;

    @Autowired
    QuestionService questionService;
    @Autowired
    PaperService paperService;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public String list() {
        questions = questionService.getQuestions();
        ServletActionContext.getRequest().setAttribute("mainPage", "WEB-INF/question/questionList.jsp");
        return SUCCESS;
    }

    /**
     * 查看试题
     *
     * @return
     */
    public String showQuestionInfo() {
        Question questionById = questionService.getQuestionById(question.getId());
        ServletActionContext.getRequest().setAttribute("mainPage", "WEB-INF/question/questionShow.jsp");
        ServletActionContext.getRequest().setAttribute("question", questionService.getQuestionById(question.getId()));//获取到所有的paper
        ServletActionContext.getRequest().setAttribute("papers", paperService.getPaperAll());//获取到所有的paper
        return SUCCESS;
    }

    public String readyUpdate() {
        ServletActionContext.getRequest().setAttribute("mainPage", "WEB-INF/question/questionUpdate.jsp");
        ServletActionContext.getRequest().setAttribute("papers", paperService.getPaperAll());//获取到所有的paper
        ServletActionContext.getRequest().setAttribute("question", questionService.getQuestionById(question.getId()));//获取到所有的paper

        return SUCCESS;
    }

    public String update() {
        questionService.updateQuestion(question);
        return "update";
    }


    public String delete() {
        questionService.deleteQuestion(question);
        ServletActionContext.getRequest().setAttribute("mainPage", "WEB-INF/question/questionList.jsp");
        return "update";
    }

    public String readyAdd() {
        ServletActionContext.getRequest().setAttribute("mainPage", "WEB-INF/question/questionAdd.jsp");
        ServletActionContext.getRequest().setAttribute("papers", paperService.getPaperAll());//获取到所有的paper
        System.out.println(paperService.getPaperAll());
        List<Paper> paperAll = paperService.getPaperAll();
        return SUCCESS;
    }

    public String add() {
        questionService.addQuestion(question);
        return "update";
    }

    @Override
    public Question getModel() {
        return question;
    }

    //    JSP页面传过来的需要进行查询的字段
    private String findName;

    public String getFindName() {
        return findName;
    }

    public void setFindName(String findName) {
        this.findName = findName;
    }

    public String find() {
        questions = questionService.findQuestions(getFindName());
        ServletActionContext.getRequest().setAttribute("mainPage", "WEB-INF/question/questionList.jsp");
        return SUCCESS;
    }
}
