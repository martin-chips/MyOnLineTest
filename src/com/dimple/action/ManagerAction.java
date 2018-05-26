package com.dimple.action;

import com.dimple.entity.Manager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by Dimple on 2018/5/18/10:05
 */
@Controller
@Scope(value = "prototype")
public class ManagerAction extends ActionSupport implements ModelDriven<Manager> {
    private Manager manager = new Manager();

    @Override
    public Manager getModel() {
        return manager;
    }
}
