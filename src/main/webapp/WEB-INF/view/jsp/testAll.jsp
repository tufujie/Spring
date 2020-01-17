<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../layout/header.jsp"%>
<body>
<form>
    <table>
        <tr>
            <td>运行业务</td>
            <td>
                <select id="fBusinessType" style="width: 300px">
                    <option value="1">生成合同数据</option>
                    <option value="2">运营中心数据</option>
                    <option value="3">租赁运营数据</option>
                    <option value="4">文件查询</option>
                    <option value="5">轻分析接口测试</option>
                    <option value="6">深业版本将运营中心数据存入mongodb</option>
                    <option value="7">标准版本数据存入mongodb</option>
                    <option value="8">标准版本mongodb数据更新</option>
                    <option value="9">标准版本mongodb数据更新</option>
                    <option value="10">标准版本mongodb生成</option>
                    <option value="11">测试轻DATA</option>
                    <option value="12">根据ID生成billType</option>
                    <option value="13">信用中心生成信用明细</option>
                    <option value="14">续签押金自动转</option>
                    <option value="15">查看合同收费明细</option>
                    <option value="16">新增客户</option>
                    <option value="17">开放平台】基础资料类-项目列表接口</option>
                    <option value="18">【开放平台】基础资料类-房源详情接口</option>
                    <option value="19">【开放平台】基础资料类-根据条件获取房源接口</option>
                    <option value="20">【开放平台】合同导入</option>
                    <option value="21">同步国资委数据</option>
                    <option value="22">同步项目数据接口</option>
                    <option value="23">每月应收租金统计表</option>
                </select>
            </td>
        </tr>

        <tr>
            <td>中文</td>
            <td><input id="fChinese" name="fChinese" value="租赁合同" style="width: 1500px"></td>
        </tr>
        <tr>
            <td>fId</td>
            <td><input id="fId" name="fId" value="1dada2421412dsadaga" style="width: 1500px"></td>
        </tr>
        <tr>
            <td>id1Key</td>
            <td><input id="fIdKey" name="fIdKey" value="type" style="width: 1500px"></td>
        </tr>
        <tr>
            <td>id1Value</td>
            <td><input id="fIdValue" name="fIdValue" value="1" style="width: 1500px"></td>
        </tr>
        <tr>
            <td>id2Key</td>
            <td><input id="fId2Key" name="fId2Key" value="orgID" style="width: 1500px"></td>
        </tr>
        <tr>
            <td>id2Value</td>
            <td><input id="fId2Value" name="fId2Value" value="20160410012345678901234567891101" style="width: 1500px"></td>
        </tr>
        <tr>
            <td>id3Key</td>
            <td><input id="fId3Key" name="fId3Key" value="year" style="width: 1500px"></td>
        </tr>
        <tr>
            <td>id3Value</td>
            <td><input id="fId3Value" name="fId3Value" value="2018" style="width: 1500px"></td>
        </tr>
        <tr>
            <td>id4Key</td>
            <td><input id="fId4Key" name="fId4Key" value="catalog" style="width: 1500px"></td>
        </tr>
        <tr>
            <td>id4Value</td>
            <td><input id="fId4Value" name="fId4Value" value="1" style="width: 1500px"></td>
        </tr>
        <tr>
            <td>id5Key</td>
            <td><input id="fId5Key" name="fId5Key" value="runType" style="width: 1500px"></td>
        </tr>

        <tr>
            <td>id4Value</td>
            <td><input id="fId5Value" name="fId5Value" value="1" style="width: 1500px"></td>
        </tr>
        <tr>
            <td>url</td>
            <td><input id="fUrl" name="fUrl" value="http://wy.re.com/tests/testAll" style="width: 1500px"></td>
        </tr>
        <tr>
            <td><input type="button" value="POST1" onclick="Post(1)" style="width: 100px; height: 50px;"></td>
        </tr>
        <tr>
            <td><input type="button" value="POST2" onclick="Post(2)" style="width: 100px; height: 50px;"></td>
        </tr>
        <tr>
            <td><input type="button" value="POST3" onclick="Post(3)" style="width: 100px; height: 50px;"></td>
        </tr>
        <tr>
            <td><input type="button" value="POST4" onclick="Post(4)" style="width: 100px; height: 50px;"></td>
        </tr>
        <%--<tr>
            <td><input type="button" value="POST下载导出文件" onclick="Post(5)" style="width: 200px; height: 50px;"></td>
        </tr>
        <tr>
            <td><input type="button" value="同步运营中心数据" onclick="Post(6)" style="width: 200px; height: 50px;"></td>
        </tr>--%>
        <tr>
            <td><input type="button" value="西保获取收费明细" onclick="Post(7)" style="width: 200px; height: 50px;"></td>
        </tr>
        <tr>
            <td><input type="button" value="西保合同保存" onclick="Post(8)" style="width: 200px; height: 50px;"></td>
        </tr>
        <tr>
            <td><input type="button" value="西保获取合同文本" onclick="Post(9)" style="width: 200px; height: 50px;"></td>
        </tr>
        <tr>
            <td><span>返回结果</span></td>
        </tr>
        <tr>
            <td colspan="4" rowspan="12">
                <textarea class="textarea textarea-percent" id="returnResult"></textarea>
            </td>
        </tr>
    </table>
</form>
<script type="text/javascript" src="/js/testAll.js"></script>
</body>