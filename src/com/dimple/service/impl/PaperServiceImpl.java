package com.dimple.service.impl;

import com.dimple.dao.PaperDao;
import com.dimple.entity.Paper;
import com.dimple.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dimple on 2018/6/1/19:14
 */
@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    PaperDao paperDao;

    @Override
    public List<Paper> getPaperAll() {
        List<Paper> paperAll = paperDao.getPaperAll();
        return paperAll;
    }

    @Override
    public void deletePaper(Paper paper) {
        if (paper != null && paper.getId() != 0) {
            paperDao.deletePaperById(paper.getId());
        }
    }

    @Override
    public void updatePaper(Paper paper) {
        if (paper != null && paper.getId() != 0 && paper.getName() != null && !"".equals(paper.getName())) {
            paperDao.updatePaper(paper);
        }
    }
}
