<!DOCTYPE html>
<html>
<head>
<#include '/layout/header.ftl'>
</head>
<body>
<h1>teamup sample</h1>

access token:${token.access_token?if_exists} <br/>
expires_in:${token.expires_in?if_exists} <br/>

<a href="https://auth.tmup.com/v1/user?token=${token.access_token?if_exists}" target="_blank" >내정보 확인하러 가기</a>

</body>
</html>