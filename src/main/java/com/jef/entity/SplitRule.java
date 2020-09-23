package com.jef.entity;

import com.jef.common.context.SpringContextHolder;
import com.jef.dao.ISplitTableRuleDao;
import com.jef.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jef
 * @date 2020/8/20
 */
public class SplitRule {


    public static SplitTableRuleVo getSplitTableRuleVo(String ecID, String tableName){
        //将shardingjdbc跟分页插件进行区分开
        if(StringUtils.isEmpty(ecID) || StringUtils.isEmpty(tableName)){
            return null;
        }
        ISplitTableRuleDao splitTableRuleDao = SpringContextHolder.getBean(ISplitTableRuleDao.class);
        List<SplitTableRuleVo> list =  splitTableRuleDao.getSplitTableRuleVo();
        for(SplitTableRuleVo splitTableRuleVo : list){
            if((splitTableRuleVo.getEcID() + "_" + splitTableRuleVo.getTableName()).equals((ecID + "_" + tableName))){
                return splitTableRuleVo;
            }
        }
        return null;
    }

    public static List<SplitTableRuleVo> getSplitSql(String ecID,List<String> tableNameList){
        if(StringUtils.isEmpty(ecID) || (tableNameList == null || tableNameList.size() <= 0)){
            return null;
        }
        ISplitTableRuleDao splitTableRuleDao = SpringContextHolder.getBean(ISplitTableRuleDao.class);
        return splitTableRuleDao.getTableByECID(ecID,tableNameList);
    }

    /**
     * 提供给shardingsphere的分页规则查询方法
     * @param logicTableName
     * @param shardingValue
     * @return
     */
    public static String getTableNameByLogicTable(String logicTableName,String shardingValue){
        if(StringUtils.isEmpty(logicTableName) || StringUtils.isEmpty(shardingValue)){
            return null;
        }
        ISplitTableRuleDao splitTableRuleDao = SpringContextHolder.getBean(ISplitTableRuleDao.class);
        Map paramMap = new HashMap();
        paramMap.put("isECID","0");
        List<SplitTableRuleVo> list =  splitTableRuleDao.getSplitTableRuleVoList(paramMap);
        for(SplitTableRuleVo splitTableRuleVo : list){
            if((splitTableRuleVo.getEcID() + "_" + splitTableRuleVo.getTableName()).equals((shardingValue + "_" + logicTableName))){
                if(splitTableRuleVo.getActualTable()!=null&&splitTableRuleVo.getActualTable().trim().length()>0){
                    return splitTableRuleVo.getActualTable();
                }else{
                    return logicTableName+"_"+shardingValue;
                }
            }
        }
        return logicTableName;
    }

}