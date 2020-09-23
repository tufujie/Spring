package com.jef.dao;

import com.jef.entity.SplitTableRuleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ISplitTableRuleDao {
    /**
     * 获取分摊表名
     * @return
     */
    List<SplitTableRuleVo> getSplitTableRuleVo();
    /**
     * 获取分摊表名
     * @return
     */
    List<SplitTableRuleVo> getSplitTableRuleVoList(Map map);

    List<SplitTableRuleVo> getTableByECID(@Param("ecID") String ecID, @Param("tableNameList") List<String> tableNameList);

}
