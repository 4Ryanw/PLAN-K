<%--
  Created by IntelliJ IDEA.
  User: 4Ryanw
  Date: 2020/8/31
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>凯计划</title>
    <script src="static/js/jQuery v1.10.2.js"></script>
    <style>
        #t1{
            color: red;
        }
        #t2{
            color: green;
        }
        #t3{
            color: blue;
        }

        #bar-warp{
            width:500px;
            height:30px;
            border:1px solid green;
        }
        #bar{
            width:0px;
            height:30px;
            background:green;
        }
    </style>
      <link rel="stylesheet" href="static/css/style.css">
  </head>
  <body>
  <div style="width: 100%;text-align: center;">
  <img src="static/img/logo.png" style="width:300px;margin:auto;">
  </div>
 <%--<div style="margin: auto;width:50%;padding: 2rem">

     <form action="Upload" enctype="multipart/form-data" method="post" onsubmit="return checksubmit()">
         <div style="margin-left:15%;width: 60%;float: left">
             <input style="width: 100%;height: 2.5rem;padding: .5rem;border-bottom-left-radius: 15px;border-top-left-radius: 15px;outline: none;" readonly="true" class="showFileName">
         </div>

         <a href="javascript:;" class="file">选择文件
             <input style="margin-left: 10rem;" type="file" name="pic">
         </a>

         <div class="breathe-div"><input style="background:none;
	outline:none;
	border:none;font-size: 20px;line-height: 50px;cursor: pointer;font-family: 幼圆;font-weight: 500"  type="submit" value="冲"></div>
     </form>




 </div>--%>




  <div id="bar-warp">
      <div id="bar"></div>

  </div><span id="precent"></span><br/>
  <input type="file" name="pic" onchange="upfile();"/>


  </body>
  <div class="footer">
  <span >Copyright &copy; 2020.ZhengKai All rights reserved. <a href="https://www.joyoung.com/" target="_blank" title="">凯集团有限公司</a> </span>
  </div>
<script>

    var fileflag = false;
    $(".file").on("change","input[type='file']",function(){
        var filePath=$(this).val();
        if(filePath.length<=0){
            return false;
        }
        if(filePath.indexOf("xls")!=-1 ){
            var arr=filePath.split('\\');
            var fileName=arr[arr.length-1];
            $(".showFileName").val(fileName);
            fileflag = true;
        }else{
            $(".showFileName").val("");
            alert("睁大狗眼看看你选的文件是不是xls格式？");
            fileflag = false;
            return false
        }
    })
    function checksubmit(){
        if(!fileflag){
            alert("你文件都没选你冲你妈的骨灰盒？")
            return false;
        }else{
            return true;
        }
    }
</script>


  <script type="text/javascript">
      function upfile(){
          var pic=document.getElementsByTagName('input')[0].files[0];
          debugger;
          var fd=new FormData();
          var xhr=new XMLHttpRequest();
          //xhr.open('post','01.php',true);

          xhr.onreadystatechange=function (){
              //readystate为4表示请求已完成并就绪
              if(this.readyState==4){
                  document.getElementById('precent').innerHTML=this.responseText;
                  //在进度条下方插入百分比
              }
          }

          xhr.upload.onprogress=function (ev){
              //如果ev.lengthComputable为true就可以开始计算上传进度
              //上传进度 = 100* ev.loaded/ev.total
              if(ev.lengthComputable){
                  var precent=100 * ev.loaded/ev.total;
                  console.log(precent);
                  //更改进度条，及百分比
                  document.getElementById('bar').style.width=precent+'%';
                  document.getElementById('precent').innerHTML=Math.floor(precent)+'%';
              }
          }
          fd.append('pic',pic);

          xhr.send(fd);

      }
  </script>
</html>
