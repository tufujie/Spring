package com.jef.service;

import com.jef.entity.Foundation;
import com.jef.entity.FoundationEntry;

import java.util.List;
import java.util.Map;

/**
 * @author Jef
 * @date 2019/7/6
 */
public interface IFoundationService {


    /**
     * 新增
     * @param foundation
     */
    void insert(Foundation foundation);

    /**
     * 获取所有的基金
     * @return
     */
    List<Foundation> getByParams(Map<String, Object> requestParams);
    /**
     * 新增
     * @param foundationEntry
     */
    void insertEntry(FoundationEntry foundationEntry);

    /**
     * 获取所有的基金
     * @return
     */
    List<FoundationEntry> getEntryByParams(Map<String, Object> requestParams);

    /**
     * 根据编码获取基金
     * @return
     */
    Foundation getByCode(String code);
}