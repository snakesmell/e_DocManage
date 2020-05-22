<%@page import="com.doc.a.Common"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>文件查阅平台</title>
  <link rel="stylesheet" href="<%=basePath%>Static/css/layui.css">
  <link rel="stylesheet" href="<%=basePath%>Static/css/layer.css">
  <script src="<%=basePath%>Static/js/jquery-3.4.1.min.js"></script>
  <script src="<%=basePath%>Static/js/hm.js"></script>
  <script src="<%=basePath%>Static/js/layer.js"></script>
  <style type="text/css">
  
  </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header" style="background-color:#1E90FF;border-bottom-color: white;border-bottom-width: 2px;border-bottom-style: solid;">
    <div class="layui-logo">
    	<label style="font-size: 26px;color: white;cursor: pointer;" onclick="pageBegin()">文件查阅平台</label>
    </div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <!-- <li class="layui-nav-item"><a onclick="pageRoot()" href="javascript:;">文件名称搜索</a></li>
      <li class="layui-nav-item"><input placeholder="请输入文件名称..."  id="pageRoot"></li>
      <li class="layui-nav-item"><a onclick="pageRoot2()" href="javascript:;">查询文件内容</a></li>
      <li class="layui-nav-item"><input placeholder="请输入搜索内容..."  id="pageRoot2"></li> -->
      <!-- <li class="layui-nav-item"><a href=""></a></li> -->
      <li class="layui-nav-item"><a onclick="page()" href="javascript:;">磁盘目录查询</a></li>
      <li class="layui-nav-item">
      <select  id="pageUrl">
      	<!-- <option value="c:/">c</option>
      	<option value="d:/">d</option>
      	<option value="e:/">e</option>
      	<option value="f:/">f</option>
      	<option value="g:/">g</option>
      	<option value="h:/">h</option>
      	<option value="i:/">i</option> -->
      </select>
      <!-- <input placeholder="路径_例 c:/" value="c:/" id="pageUrl"></li> -->
     <!--  <li class="layui-nav-item">
        <a href="javascript:;">文档查找</a>
        <dl class="layui-nav-child">
          <dd><a href="">搜索</a><input placeholder="路径_例 c:/" value="c:/" id="pageUrl"></dd>
          <dd><a href="">消息管理</a></dd>
        </dl>
      </li> -->
    </ul> 
    <ul class="layui-nav layui-layout-right">
    <li class="layui-nav-item">
    </li>
     <!-- 暂时用不到20200418  
     <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
         	 贤心
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li> 
                 暂时用不到20200418-->
      <!-- <li class="layui-nav-item"><a id="lucenceUpdate"  href="javascript:;"></a></li> -->
    <%--   <li class="layui-nav-item"><a href="<%=basePath%>/begin">退出</a></li> --%>
    </ul>
  </div>
  <!-- layui-bg-black -->
  <div class="layui-side " style="background-color:#1E90FF;">
    <div class="layui-side-scroll">
      <ul id ="roadPanel"  class="layui-nav layui-nav-tree layui-inline" style="margin-right: 10px;background-color:#1E90FF;" lay-filter="demo">
		  <!-- <li class="layui-nav-item ">
		    <a href="javascript:;">一级</a>
		    <dl class="layui-nav-child">
		      <dd>
		      	<a href="javascript:;">二级</a>
					<dl class="layui-nav-child layui-cite-2">
                    	<dd><a href="javascript:;"> <cite>三级菜单</cite></a></dd>
                	</dl>		      
			  </dd>
		      <dd><a href="javascript:;">二级</a></dd>
		    </dl>
		  </li> -->
		  <!-- <li class="layui-nav-item">
		    <a href="javascript:;">解决方案</a>
		    <dl class="layui-nav-child">
		      <dd><a href="">移动模块</a></dd>
		      <dd><a href="">电商平台</a></dd>
		      <dd><a href="">移动模块</a></dd>
		      <dd><a href="">后台模版</a></dd>
		      <dd><a href="">电商平台</a></dd>
		    </dl>
		  </li> -->
		  <!-- <li class="layui-nav-item"><a href="">云市场</a></li> -->
		  <!-- <li class="layui-nav-item"><a href="">社区</a></li> -->
	 </ul>
      
      
    </div>
  </div>
  <div class="layui-body" style="background-color: #F5F5F5;">
    <!-- 内容主体区域 -->
    <span class="layui-breadcrumb" l id="nav1" >
		  <a href="/" id="tab1">首页</a>
		</span>
    <div style="padding: 15px;" >
	    
    	<div style="width: 100%;height: 100%;" id="mainBody">
    		<div></div>
    	</div>
    </div>
  </div>
  <div class="layui-footer" >
 
  <input type="file" id="excel">
  <button onclick="uploadCheck()" >上传文件</button>
  &nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="text" id="mkdir" placeholder="输入文件夹名称...">
  <button onclick="fileOper('create')" >创建文件夹</button>

  <a style="float: right;" id="lucenceUpdate"  href="javascript:;"></a>
  <!--  <div class="layui-row">
    <div class="layui-col-xs6">
      12
    </div>
    <div class="layui-col-xs6">
    	<ul class="layui-nav" lay-filter="">
		  <li class="layui-nav-item">
			<input type="text" placeholder="搜索..." autocomplete="off" class="layui-input layui-input-search" layadmin-event="serach" lay-action="template/search/keywords=">
		  </li>
		  <li class="layui-nav-item layui-this">
		  	<button type="button" class="layui-btn">按钮一</button>
		  </li>
    	</ul>
    </div>
  </div> -->
    <!-- 底部固定区域 -->
    <!-- <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item">
		<input type="text" placeholder="搜索..." autocomplete="off" class="layui-input layui-input-search" layadmin-event="serach" lay-action="template/search/keywords=">
	  </li>
      <li class="layui-nav-item"><a href="">查找</a></li>
    </ul> -->
    
  </div>
</div>
<script src="<%=basePath%>Static/js/layui.all.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<!-- <script>
layui.use('element', function(){
  var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
  
  //监听导航点击
  element.on('nav(demo)', function(elem){
    //console.log(elem)
    layer.msg(elem.text());
  });
});
</script> -->
</body>
<script type="text/javascript">
$(document).ready(function(){
	pageBegin();//左侧菜单
	queryCP();//查询盘符
});
var sp=null;
var fileUploadPath="";
//索引更新时间
<%-- setInterval(function(){$("#lucenceUpdate").html("<%=request.getServletContext().getAttribute(Common.application)%>");},3000); --%>
function changcolor(lab){
	$(".leftA").css("background-color","#1E90FF");
	$(lab).css("background-color","	#6495ED");
}
//left root panel
function pageBegin(){
	 $.ajax({
         url:"<%=basePath%>/page",
         type:"GET",
         //data:{ url: $("#pageUrl").val()},
         contentType :"application/x-www-form-urlencoded; charset=utf-8",
         success:function(data){
  			$("#roadPanel").html(data);
         }
	});
}
//1 lucence query
function pageRoot(){
	if($("#pageRoot").val().trim()==""){
		return;
	}
	 $.ajax({
        url:"<%=basePath%>/pageRoot",
        type:"POST",
        data:{ key: $("#pageRoot").val()},
        contentType :"application/x-www-form-urlencoded; charset=utf-8",
        success:function(data){
 			$("#mainBody").html(data);
        }
	});
}
//2 lucence query2
function pageRoot2(){
	if($("#pageRoot2").val().trim()==""){
		return;
	}
	 $.ajax({
        url:"<%=basePath%>/pageRoot",
        type:"GET",
        data:{ key: $("#pageRoot2").val()},
        contentType :"application/x-www-form-urlencoded; charset=utf-8",
        success:function(data){
 			$("#mainBody").html(data);
        }
	});
}
//3 left panel
function page(url){
	if($("#pageUrl").val().trim()==""){
		return;
	}
	 $.ajax({
         url:"<%=basePath%>/page",
         type:"POST",
         data:{ url: $("#pageUrl").val()},
         contentType :"application/x-www-form-urlencoded; charset=utf-8",
         success:function(data){
  			$("#roadPanel").html(data);
         }
	});
}
//盘符
function queryCP(){
	 $.ajax({
        url:"<%=basePath%>/query",
        type:"GET",
        //data:{ url: url},
        contentType :"application/x-www-form-urlencoded; charset=utf-8",
        success:function(data){
 			$("#pageUrl").html(data);
        }
	});

	//setTab(url);
}

//right panel
function query(url,name){
	 fileUploadPath=url;
	 $.ajax({
         url:"<%=basePath%>/query",
         type:"POST",
         data:{ url: url},
         contentType :"application/x-www-form-urlencoded; charset=utf-8",
         success:function(data){
  			$("#mainBody").html(data);
         }
	});

	setTab(url);
}
//导航条
function setTab(url){
	var tab="<span class=\"layui-badge-dot layui-bg-blue\"></span>";
	sp=url.split("/");
	//console.log(sp);
	for(var i=1;i<sp.length;i++){
		if(i==sp.length-1){
			tab+="<a style=\"font-size: 16px;\" onclick='getTab("+i+")' href='javascript:;'>"+sp[i]+"</a>"
		}else{
			tab+="<a style=\"font-size: 16px;\" onclick='getTab("+i+")' href='javascript:;'>"+sp[i]+"&nbsp;/&nbsp;</a>"
		}
	}
	$("#nav1").html(tab);
	  /* <a href="/" id="tab1">首页</a>
	  <a href="/demo/">演示</a>
	  <a><cite>导航元素</cite></a> */
}

function getTab(i){
	//console.log(i);
	//console.log(sp);
	var url=sp[0];
	for(var j=1;j<=i;j++){
		url+="/";
		url+=sp[j];
	}
	//console.log(url);
	query(url);
}
//下载
function download(url){
	//console.log(url);
	 //var formm=function(){
	        var form=$("<form>");//定义一个form表单
	        form.attr("style","display:none");
	        form.attr("target","");
	        form.attr("method","post");
	        form.attr("action","<%=basePath%>/download");
	        var input1=$("<input>");
	        input1.attr("type","hidden");
	        input1.attr("name","url");
	        input1.attr("value",url);
	        var input2=$("<input>");
	        input2.attr("type","hidden");
	        input2.attr("name","flag");
	        input2.attr("value",0);
	        $("body").append(form);//将表单放置在web中
	        form.append(input1);
	        form.append(input2);
	        form.submit();//表单提交
	   // }
}
//判断是否是图片
function judgeImg(url){
	//var url="d://用户目录/我的图片/2019-12-19-13-46-13-196-1384_format_f.JPEG";
	var ext=url.split(".");
	var ext_end=ext[ext.length-1].toLowerCase();
	//console.log(ext_end);
	var pattern="bmp,jpg,png,gif,jpeg,png";
	var z=pattern.indexOf(ext_end,0);
	//console.log(z);
	if(z!=-1){
		return true;
		//console.log("success");
	}else{
		return false;
		//console.log("error");
	}
}
//判断是否PDF
function judgePdf(url){
	//var url="d://用户目录/我的图片/2019-12-19-13-46-13-196-1384_format_f.JPEG";
	var ext=url.split(".");
	var ext_end=ext[ext.length-1].toLowerCase();
	//console.log(ext_end);
	var pattern="pdf";
	var z=pattern.indexOf(ext_end,0);
	//console.log(z);
	if(z!=-1){
		return true;
		//console.log("success");
	}else{
		return false;
		//console.log("error");
	}
}
//查看
function queryload(url){
	//PDF文件查看
	if(judgePdf(url)){
		window.open("<%=basePath%>/Show/pdf.jsp?url="+url,"_blank","toolbar=no, location=yes, directories=no, status=no, menubar=yes, scrollbars=yes, resizable=no, copyhistory=yes, width=800, height=800");
		return;
		<%-- $("#mainBody").html("<embed :src='<%=basePath%>/pdfShow?url='"+url+"' type='application/pdf' width='100%' height='100%'>"); --%>
	}
	//判断是否是图片
	if(judgeImg(url)){
		layer.open({
		    type: 1 //此处以iframe举例
		    ,title: '图片浏览'
		    ,area: ['500px', '400px']
		    ,shade: 0
		    ,maxmin: true
		    ,offset: [ //为了演示，随机坐标
		      ($(window).height()/2)
		      ,($(window).width()/2)
		    ] 
		    ,content: "<img id=\"npcImg\" width=\"100%\" height=\"100%\"/>  "
		    ,btn: ['全部关闭'] //只是为了演示
		    ,yes: function(){
		   /*    $(that).click(); 
		    }
		    ,btn2: function(){ */
		      layer.closeAll();
		    }
		    ,zIndex: layer.zIndex //重点1
		    ,success: function(layero){
		      layer.setTop(layero); //重点2
		      $('#npcImg').attr('src','<%=basePath%>/download?url='+url);  
		    }
		  });
		return;
	 }
	if(!judgeImg(url)){
		 layer.open({
			    type: 2 //此处以iframe举例
			    ,title: '文档内容'
			    ,area: ['500px', '400px']
			    ,shade: 0
			    ,maxmin: true
			    ,offset: [ //为了演示，随机坐标
			      ($(window).height()/2)
			      ,($(window).width()/2)
			    ] 
			    ,content: '<%=basePath%>/show?url='+url
			    ,btn: ['全部关闭'] //只是为了演示
			    ,yes: function(){
			     /*  $(that).click(); 
			    }
			    ,btn2: function(){ */
			      layer.closeAll();
			    }
			    ,zIndex: layer.zIndex //重点1
			    ,success: function(layero){
			      layer.setTop(layero); //重点2
			    }
			  }); 
		 return;
	 }
}

//文件删除
function fileDelete(url){
	layer.confirm('确定要删除吗？', {
	  btn: ['确定','取消'] 
	}, function(){
		$.ajax({
	        url:"<%=basePath%>/fileUpload",
	        type:"GET",
	        data:{ url:url,oper:'delete'},
	        contentType :"application/x-www-form-urlencoded; charset=utf-8",
	        success:function(data){
	 			//console.log(data);
	 			if(data==0){//操作失败
	 				layer.msg("操作失败");
	 			}
				if(data==1){//操作成功
					query(fileUploadPath);
					layer.msg("操作成功");
	 			}
	        }
		});
	}, function(){});
	 
}

//文件夹创建
function fileOper(){
	layer.confirm('确定要创建吗？', {
		  btn: ['确定','取消'] 
		}, function(){
		 var dirname=$("#mkdir").val();//文件夹名称
		 if(fileUploadPath==""||dirname==null||dirname==""){//空值判断
		    	return;
		 }
		 $.ajax({
	        url:"<%=basePath%>/fileUpload",
	        type:"GET",
	        data:{ url:fileUploadPath+"/"+dirname,oper:'create'},
	        contentType :"application/x-www-form-urlencoded; charset=utf-8",
	        success:function(data){
	 			//console.log(data);
	 			if(data==0){//操作失败
	 				layer.msg("创建失败");
	 			}
				if(data==1){//操作成功
					query(fileUploadPath);
					layer.msg("创建成功");
	 			}
	        }
		});
	}, function(){});
}

/* 文件上传 */
function uploadCheck(){
	layer.confirm('确定要上传吗？', {
		  btn: ['确定','取消'] 
		}, function(){
		    var formdata = new FormData();
		    var fileObj = $('#excel').get(0);
		    if(fileUploadPath==""||fileObj==null){//空值判断
		    	return;
		    }
		    formdata.append("file", fileObj.files[0]);
		    formdata.append("filePath", fileUploadPath);
		    $.ajax({
		        url: "<%=basePath%>/fileUpload",
		        type: 'post',
		        data: formdata,
		        cache: false,
		        contentType: false,
		        processData: false,
		        //dataType: "json",
		        success: function (data) {
		        	//console.log(data);
		        	if(data==1){//上传成功
		        		query(fileUploadPath);
		        		layer.msg('上传成功');
		        	}
		        	if(data==0){//上传成功
		        		layer.msg('上传失败！');
		        	}
		        	if(data==2){//上传成功
		        		layer.msg('失败,文件已存在！');
		        	}
		        }
		    });    
	}, function(){});
}
</script>
</html>
