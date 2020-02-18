package com.jef.service.impl;

import com.jef.dao.IFoundationDao;
import com.jef.dao.IFoundationEntryDao;
import com.jef.entity.Foundation;
import com.jef.entity.FoundationEntry;
import com.jef.service.IFoundationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Jef
 * @date 2019/7/6
 */
@Service(value = "foundationService")
public class IFoundationServiceImpl implements IFoundationService {
    @Autowired
    private IFoundationDao foundationDao;
    @Autowired
    private IFoundationEntryDao foundationEntryDao;

    @Override
    public void insert(Foundation foundation) {
        foundationDao.insert(foundation);
    }

    @Override
    public List<Foundation> getByParams(Map<String, Object> requestParams) {
        return foundationDao.getByParams(requestParams);
    }

    @Override
    public void insertEntry(FoundationEntry foundationEntry) {
        foundationEntryDao.insert(foundationEntry);
    }

    @Override
    public List<FoundationEntry> getEntryByParams(Map<String, Object> requestParams) {
        return foundationEntryDao.getByParams(requestParams);
    }

    @Override
    public Foundation getByCode(String code) {
        return foundationDao.selectByPrimaryKey(code);
    }
}