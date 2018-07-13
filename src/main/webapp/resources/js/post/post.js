/**
 * 注册请求
 */
function Post(type) {
    var name = $.trim($( "#userName" ).val());
    var password = $.trim($( "#userPassword" ).val());
    var phone = $.trim($( "#phone" ).val());
    if (name == "") {
        alert( "请输入用户名" );
        return false;
    }
    if (password == "") {
        alert( "请输入密码" );
        return false;
    }
    if (phone == "") {
        alert( "请输入手机号" );
        return false;
    }

    var url;
    if (type == 1) {
        url = "/postAll/postOne";
        var user = {};
        user.name = name;
        user.password = password;
        user.phone = phone;
        $.post(url,
            user,
            function(result) {
                console.log("here");
            }
        );
    } else if (type == 2) {
        url = "/postAll/postTwo";
        $.post(url,
            {
                name: name,
                password: password,
                phone: phone
            },
            function(result) {
                console.log("here");
            }
        );
    } else if (type == 3) {
        url = "/postAll/postThree";
        $.post(url,
            {
                name: name,
                password: password,
                phone: phone
            },
            function(result) {
                console.log("here");
            }
        );
    }


}