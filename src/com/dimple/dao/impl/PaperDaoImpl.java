package com.dimple.dao.impl;

import com.dimple.dao.PaperDao;
import com.dimple.entity.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Dimple on 2018/6/1/18:57
 */
@Repository
@Transactional
public class PaperDaoImpl implements PaperDao {
    @Autowired
    HibernateTemplate hibernateTemplate;

    /**
     * 获取全部的paper
     * @return 全部的paper
     */
    @Override
    public List<Paper> getPaperAll() {
        Paper paper = new Paper();
        List<Paper> byExample = hibernateTemplate.findByExample(paper);
        return byExample;
    }

    /**
     * 根据ID删除试卷
     * @param id
     */
    @Override
    public void deletePaperById(int id) {
        Paper paper = hibernateTemplate.get(Paper.class, id);
        hibernateTemplate.delete(paper);
    }

    /**
     * 修改试卷的名称
     * @param paper
     */
    @Override
    public void updatePaper(Paper paper) {
        Paper paperDB = hibernateTemplate.get(Paper.class, paper.getId());
        paperDB.setName(paper.getName());
        hibernateTemplate.update(paperDB);
    }


}
