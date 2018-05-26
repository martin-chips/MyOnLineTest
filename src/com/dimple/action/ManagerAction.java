package com.dimple.action;

import com.dimple.entity.Manager;
import com.dimple.service.ManagerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by Dimple on 2018/5/18/10:05
 */
@Controller
@Scope(value = "prototype")
public class ManagerAction extends ActionSupport implements ModelDriven<Manager> {
    private Manager manager = new Manager();//使用模型驱动的方式获取表单信息
    @Autowired
    ManagerService managerService;
    public String login(){
        Manager managerById = managerService.getManagerById(manager);
        if (managerById != null) {
            ServletActionContext.getRequest().getSession().setAttribute("currentUser", managerById);
            ServletActionContext.getRequest().getSession().setAttribute("flag", 1);
            manager = managerById;
            return SUCCESS;
        }
        return ERROR;
    }

    public String logout() {
        ServletActionContext.getRequest().getSession().invalidate();
        return "logout";
    }





    @Override
    public Manager getModel() {
        return manager;
    }
}
