package com.jef.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Jef
 * @date 2020/8/27
 */
public class SplitTableRuleVo implements Serializable {

    private static final long serialVersionUID = -5617497144502291969L;
    private String id;

    //分表表名
    private String tableName;

    //是否分表 0否 1是
    private int isEcID;

    //创建时间
    private Date createTime;

    //企业ID
    private String ecID;

    //数据库名称（格式：数据库A. 或者 空字符串）
    private String dataBaseName;

    //分表后缀
    private String sufEcName;

    //多张分表
    private String[] tableNameArr;

    //实际表名
    private String actualTable;


    public SplitTableRuleVo(){}

    public SplitTableRuleVo(String tableName,int isEcID,String ecID,String sufEcName,String dataBaseName){
        this.tableName = tableName;
        this.isEcID = isEcID;
        this.ecID = ecID;
        this.dataBaseName = dataBaseName;
        this.sufEcName = sufEcName;
    }


    public SplitTableRuleVo(String ecID,String[] tableNameArr){
        this.ecID = ecID;
        this.tableNameArr = tableNameArr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getIsEcID() {
        return isEcID;
    }

    public void setIsEcID(int isEcID) {
        this.isEcID = isEcID;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEcID() {
        return ecID;
    }

    public void setEcID(String ecID) {
        this.ecID = ecID;
    }

    public String getSufEcName() {
        return sufEcName;
    }

    public void setSufEcName(String sufEcName) {
        this.sufEcName = sufEcName;
    }

    public String[] getTableNameArr() {
        return tableNameArr;
    }

    public void setTableNameArr(String[] tableNameArr) {
        this.tableNameArr = tableNameArr;
    }

    public String getDataBaseName() {
        return dataBaseName;
    }

    public void setDataBaseName(String dataBaseName) {
        this.dataBaseName = dataBaseName;
    }

    public String getActualTable() {
        return actualTable;
    }

    public void setActualTable(String actualTable) {
        this.actualTable = actualTable;
    }
}