package com.dimple.service.impl;

import com.dimple.dao.ManagerDao;
import com.dimple.entity.Manager;
import com.dimple.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dimple on 2018/5/26/11:19
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerDao managerDao;

    @Override
    public Manager getManagerById(Manager manager) {
        if (manager.getId() == 0 || manager== null) {
            return null;
        }
        Manager managerById = managerDao.getManagerById(manager.getId());
        if (managerById != null && managerById.getPassword().equals(manager.getPassword())) {
            return managerById;
        }
        return null;
    }
}
