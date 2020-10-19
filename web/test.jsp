<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title> testaa啊啊啊 </title>
    <meta name="Generator" content="EditPlus">
    <meta name="Author" content="">
    <meta name="Keywords" content="">
    <meta name="Description" content="">
    <script src="static/js/jQuery v1.10.2.js"></script>
    <style>
        .shadow {
            width: 100%;
            height: 100%;
            position: absolute;
            left: 0;
            top: 0;
            z-index: 998;
            background-color: #000;
            opacity: 0.4;
            display: none;
        }

        .addBox {
        / / 其他属性 z-index: 999;
        }
    </style>
</head>

<body>
<%--<form id="form" name="form">
    <table border="0" width="100%" height="100%">
        <tr>
            <td align=center>
                <p><font id="context">正在登录，检查环境.......</font></p>
                <p>
                    <input type="text" name="chart" size="46" style="font-family:Arial; font-weight:bolder; color:gray;background-color:white; padding:0px; border-style:none;">
                    <br>
                    <input type="text" name="percent" size=46 style="font-family:Arial; color:gray; text-align:center; border-width:medium; border-style:none;">
                    <script>var bar = 0;
                    var line = "||" ;
                    var amount ="||" ;
                    count() ;
                    function count(){
                        bar= bar+2 ;
                        amount =amount + line;
                        document.form.chart.value=amount ;
                        document.form.percent.value=bar+"%";
                        if (bar<99)
                        {setTimeout("count()",100);}
                        else
                        {window.location = "http://www.baidu.com/";}
                    }

                    </script>
                </p>
            </td>
        </tr>
    </table>
</form>--%>
<!--调出子窗口按钮-->
<button class="add" onclick="addClick();">新增</button>
<!--子窗口-->
<div id="addBox" class="addBox">

    <button>X</button>
</div>
<!--遮罩层-->
<div class="shadow">
    <a href="javascript:;" onclick="jQuery('.addBox').hide();jQuery('.shadow').hide();" class="close">×  </a>
</div>
<script>
    function addClick(){
        $(".shadow").css({'display':'block'});
        $('.addBox').show();
        return 0;
    }
</script>
</body>

</html>