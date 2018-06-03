package com.dimple.dao;

import com.dimple.entity.Paper;

import java.util.List;

/**
 * Created by Dimple on 2018/6/1/18:57
 */
public interface PaperDao {

    public List<Paper> getPaperAll();

    public void deletePaperById(int id);

    public void updatePaper(Paper paper);

    public void add(Paper paper);

    public Paper getPaperById(int id);
}
