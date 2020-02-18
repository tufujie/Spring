/**
 * 单个添加
 */
function addInfo() {
    var code = $.trim($( "#code" ).val()),
        name = $.trim($( "#name" ).val()),
        url = "/foundation/addInfo";
    if (code == "") {
        alert( "请输入基金编码" );
        return false;
    }
    if (name == "") {
        alert( "请输入基金名称" );
        return false;
    }

    var foundation = {};
    foundation.name = name;
    foundation.code = code;
    $.post(url,
        foundation,
        function(result) {
            alert("操作成功");
            location.reload();
            console.log("here");
        }
    );
}

/**
 * 添加分录
 */
function addInfoEntry() {
    var createDate,
        year = $.trim($("select[name='YYYY']").val()),
        month = $.trim($("select[name='MM']").val()),
        day = $.trim($("select[name='DD']").val()),
        unitPrice = $.trim($( "#unitPrice" ).val()),
        url = "/foundation/addInfoEntry";
    if (year == "") {
        alert( "请选择年份" );
        return false;
    }
    if (month == "") {
        alert( "请选择月份" );
        return false;
    }
    if (day == "") {
        alert( "请选择日" );
        return false;
    }
    if (unitPrice == "") {
        alert( "请输入单位净值" );
        return false;
    }
    createDate = year + "-" + month + "-" + day;
    var foundationEntry = {};
    foundationEntry.code = code;
    foundationEntry.createDate = createDate;
    foundationEntry.unitPrice = unitPrice;
    $.post(url,
        foundationEntry,
        function(result) {
            alert("操作成功");
            location.reload();
            console.log("here");
        }
    );
}

/**
 * 批量插入
 */
function batchAddInfo() {
    url = "/foundation/addInfoEntry";
    $('table tbody tr').each(function() {
        var $tr = $(this), $td = $tr.find('td');
        var foundationEntry = {};
        foundationEntry.code = code;
        foundationEntry.createDate = $td[0].textContent;
        foundationEntry.unitPrice = $td[1].textContent;
        $.post(url,
            foundationEntry,
            function(result) {
            }
        );
    });
    alert("操作成功");
}



