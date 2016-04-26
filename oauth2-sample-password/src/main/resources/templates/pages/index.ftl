<!DOCTYPE html>
<html>
<head>
<#include '/layout/header.ftl'>
</head>
<body>
<h1>teamup sample</h1>

<input type="text" class="ipt_login" id=login-email placeholder="이메일 주소" />
<input type="password" class="ipt_login ipt_pw" id="login-password" placeholder="비밀번호" />
<input type="button" id="btn-login" value="로그인">

<h2>token</h2>
<div id="at">
</div>

<a id="go" target="_blank" >내정보 확인</a>


<script src="/static/js/jquery.min.js"></script>

<script>
    var auth = {
        init : function() {
            $("#login-password").keypress(function(key) {
                if (key.keyCode == 13) {
                    auth.login();
                }
            });

            $("#btn-login").click(function() {
                auth.login();
            });
        },

        login : function() {
            var email = $("#login-email").val().trim();
            if (!email) {
                alert("이메일을 입력해주세요");
                return;
            }

            var password = $("#login-password").val().trim();
            if (!password) {
                alert("비밀번호를 입력해주세요");
                return;
            }

            var user = {};
            user.email = email;
            user.password = password;

            $.ajax({
                url : "/signin",
                type : "POST",
                data : JSON.stringify(user),
                contentType : "application/json; charset=utf-8",
                dataType : "json",
                success : auth.loginResult
            });

        },

        loginResult : function(result) {
            $("#at").text(result.access_token);
            $("#go").attr("href", "https://auth.tmup.com/v1/user?token=" + result.access_token);
        }
    };

    auth.init();

</script>



</body>
</html>