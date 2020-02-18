package com.jef.dao;

import com.jef.entity.FoundationEntry;
import java.util.List;
import java.util.Map;

/**
 * 基金DAO层
 * @author Jef
 * @create 2018/5/15 19:18
 */
public interface IFoundationEntryDao {
    /**
     * 新增基金分录信息
     * @param foundationEntry
     * @return
     */
    boolean insert(FoundationEntry foundationEntry);

    /**
     * 根据条件基金
     * @param requestParams
     * @return
     */
    List<FoundationEntry> getByParams(Map<String, Object> requestParams);

}
