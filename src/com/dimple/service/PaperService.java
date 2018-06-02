package com.dimple.service;

import com.dimple.entity.Paper;

import java.util.List;

/**
 * Created by Dimple on 2018/6/1/19:14
 */
public interface PaperService {

    public List<Paper> getPaperAll();

    public void deletePaper(Paper paper);

    public void updatePaper(Paper paper);

}
