package com.dimple.action;

import com.dimple.entity.Paper;
import com.dimple.service.PaperService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Dimple on 2018/6/1/18:21
 */
@Controller
@Scope(value = "prototype")
public class PaperAction extends ActionSupport implements ModelDriven<Paper> {

    @Autowired
    PaperService paperService;
    Paper paper = new Paper();
    private List<Paper> papers;

    public List<Paper> getPapers() {
        return papers;
    }

    public void setPapers(List<Paper> papers) {
        this.papers = papers;
    }

    public String list() {
        papers = paperService.getPaperAll();
        ServletActionContext.getRequest().setAttribute("mainPage", "WEB-INF/paper/paperList.jsp");
        return SUCCESS;
    }

    public String delete() {
        paperService.deletePaper(paper);
        return "paperUpdate";
    }

    public String readyUpdate(){
        ServletActionContext.getRequest().setAttribute("mainPage", "WEB-INF/paper/paperAdd.jsp");
        return SUCCESS;
    }

    public String readyAdd() {
        ServletActionContext.getRequest().setAttribute("mainPage", "WEB-INF/paper/paperAdd.jsp");
        return SUCCESS;
    }

    public String add(){
        return SUCCESS;
    }
    @Override
    public Paper getModel() {
        return paper;
    }
}
