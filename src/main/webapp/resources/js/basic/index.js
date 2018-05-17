/**
 * 登录请求
 */
function login() {
    var name = $.trim($( "#name" ).val());
    var password = $.trim($( "#password" ).val());
    if (!name) {
        alert( "请输入用户名" );
        return false;
    }
    if (!password) {
        alert( "请输入密码" );
        return false;
    }
    // 表单提交
    $("#form_login").attr("action", "login.do");
    $("#form_login").submit();

    //ajax 提交方法
    /*  var data = $("#form_login").serializeArray();
    $.ajax({
        type: 'post',
        url: 'login.do',
        data: data,
        success: function () {
        }
    });*/
}

/**
 * MD5加密，现在使用后台代码进行加密，暂时不用这个
 */
function md5Encode() {
    var password = $( "#password" ).val();
    var pwd = $.md5(password);
    $( "#pwd" ).val(pwd);
    // 这里前端加密和后端加密不一样，统一用其中一种，暂时使用后端加密
    console.log("前端密码加密的结果=" + pwd);
}
