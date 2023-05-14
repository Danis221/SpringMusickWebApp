<!DOCTYPE html>
<#include "base.ftl">
<html lang="en">
<head>
    <meta charset="UTF-8">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <#macro title>Update profile</#macro>
    <link rel="stylesheet" href="../css/updateUser.css">
    <script defer src="../js/validatorForAuth.js"></script>
</head>

<body>
<#macro content>


    <form action="updateProfile" method="post" id="form">
        <p style="color:red"><#if error??>${error}<br></#if></p>
        <p style="color:red" id="errorMessage" hidden></p>

        Firstname:
        <input id="firstname" type="text" name="firstname"/>
        <br>

        Lastname:
        <input id="lastname" type="text" name="lastname"/>
        <br>

        Password:
        <input id="password" type="password" name="password"/>
        <br>
        <input class="button" type="submit" value="Update">
    </form>
</#macro>

</body>
</html>