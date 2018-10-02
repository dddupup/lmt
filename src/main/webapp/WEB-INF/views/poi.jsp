<%@ page import="Pojo.Poi" %><%--
  Created by IntelliJ IDEA.
  User: shaohao
  Date: 2018/9/30
  Time: 下午9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<html>
<script>
    function check() {
        var device=document.forms["mf"]["device"].value;
        var ipc = document.forms["mf"]["ipc"].value;
        var num = document.forms["mf"]["num"].value;
        var protocol=document.forms["mf"]["protocol"].value;
        alert(protocol);

        var devicecheck=new RegExp("[~!/@#$%^&*()\\_=+\\|[{}];:\'\",<.>/?]");
        var ipcheck=new RegExp("^(1\d{2}|2[0-4]\d|25[0-5]|[1-9]\d|[1-9])(\.(1\d{2}|2[0-4]\d|25[0-5]|[1-9]\d|\d)){3}$");
        var numcheck=new RegExp("^\d+$");
        println(numcheck.test(num));
        if(device.replace(/\s+/g,"")==""){
            alert("请输入设备型号");
            return false;
        }
        if(devicecheck.test(device)==false){
            alert("请输入正确的设备型号");
        }
        if(ipc.replace(/\s+/g,"")==""){
            alert("IP不能为空");
        }
        if(ipcheck.test(ipc)==false){
            alert("请输入正确的IP");
        }
        if(num.replace(/\s+/g,"")==null){
            alert("请输入通道数");
        }
        if(numcheck.test(num)==false){
            alert("请输入正确的通道号");
        }
        if(protocol.test("")){
            alert("请选择协议");
        }


    }
</script>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Test</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/hik/download" name="mf"  method="post" onsubmit="check()">
        设备型号：<input type="text" name="device"/> <br><br>
        IP通道地址：<input type="text" name="ipc"/> <br><br>
        通道数：<input type="text" name="num"/> <br><br>
        协议：<select id="protocol" name="protocol" >
                <option value="">请选择...</option>
                <option value="CUSTOM 1">CUSTOM 1</option>
                <option value="CUSTOM 2">CUSTOM 2</option>
                <option value="CUSTOM 3">CUSTOM 3</option>
                <option value="CUSTOM 4">CUSTOM 4</option>
                <option value="CUSTOM 5">CUSTOM 5</option>
                <option value="CUSTOM 6">CUSTOM 6</option>
                <option value="CUSTOM 7">CUSTOM 7</option>
                <option value="CUSTOM 8">CUSTOM 8</option>
                <option value="CUSTOM 9">CUSTOM 9</option>
                <option value="CUSTOM 10">CUSTOM 10</option>
              </select>
        <br><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
