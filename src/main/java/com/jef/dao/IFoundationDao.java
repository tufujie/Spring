package com.jef.dao;

import com.jef.entity.Foundation;
import java.util.List;
import java.util.Map;

/**
 * 基金DAO层
 * @author Jef
 * @create 2018/5/15 19:18
 */
public interface IFoundationDao {
    /**
     * 新增基金信息
     * @param foundation
     * @return
     */
    boolean insert(Foundation foundation);

    /**
     * 根据ID查询基金信息
     * @param code 基金编码
     * @return
     */
    Foundation selectByPrimaryKey(String code);

    /**
     * 根据条件基金
     * @param requestParams
     * @return
     */
    List<Foundation> getByParams(Map<String, Object> requestParams);

}
