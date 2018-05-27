package com.dimple.dao;

import com.dimple.entity.Manager;

/**
 * Created by Dimple on 2018/5/25/16:26
 */
public interface ManagerDao {
    //    修改管理员账户密码
    public void updatePassword(int id,String newPassword);

    public Manager getManagerById(int id);


}
