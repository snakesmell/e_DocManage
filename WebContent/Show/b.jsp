<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <title>table模块快速使用</title>
<link rel="stylesheet" href="<%=basePath%>Static/css/layui.css" media="all">
<link rel="stylesheet" href="<%=basePath%>Static/css/common.css" media="all">
<style type="text/css" id="LAY_layadmin_theme">.layui-side-scroll,.layui-bg-black,.layui-nav-left{background-color:#3A3D49 !important;}.layui-side-scroll .layui-logo{background-color:#2F9688 !important;}.layui-header{background-color:#fff !important;}.layui-body .layui-header a, .layui-body .layui-header a cite{color:#333 !important;}.layui-header .layui-nav .layui-nav-more{border-top-color:#333 !important;}.layui-nav-tree .layui-nav-child dd.layui-this, .layui-nav-tree .layui-nav-child dd.layui-this a, .layui-nav-tree .layui-this, .layui-nav-tree .layui-this>a, .layui-nav-tree .layui-this>a:hover{background-color: #5FB878; !important;}.layui-body .layui-header .layui-layout-right .layui-nav-child a{color:#333 !important;}</style><link id="layuicss-layer" rel="stylesheet" href="./layer.css" media="all"></head>
<body>
<div id="LAY_WRAP">
  <div id="LAY_app" class="layui-side layui-bg-black" style="width: 230px;">
      <div class="layui-side-scroll">
          <div class="layui-logo" lay-href=""> <span>layuiAdmin Pro</span> </div>
          <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
          <ul class="layui-nav layui-nav-left layui-nav-tree" lay-filter="layui-nav-left">
              <li class="layui-nav-item">
                  <a class="" href="javascript:;"><i class="layui-icon layui-icon-face-smile"></i> <cite>导航1</cite><span class="layui-nav-more"></span></a>
                  <dl class="layui-nav-child">
                      <dd>
                        <a class="" href="javascript:;"> <cite>二级菜单</cite><span class="layui-nav-more"></span></a>
                        <dl class="layui-nav-child layui-cite-2">
                        	<dd><a href="javascript:;"> <cite>三级菜单</cite></a></dd>
                            <dd><a href="javascript:;"> <cite>三级菜单</cite></a></dd>
                            <dd><a href="javascript:;"> <cite>三级菜单</cite></a></dd>
                            <dd><a href="javascript:;"> <cite>三级菜单</cite></a></dd>
                            <dd><a href="javascript:;"> <cite>三级菜单</cite></a></dd>
                            <dd><a href="javascript:;"> <cite>三级菜单</cite></a></dd>
                            <dd><a href="javascript:;"> <cite>三级菜单</cite></a></dd>
                            <dd><a href="javascript:;"> <cite>三级菜单</cite></a></dd>
                            <dd><a href="javascript:;"> <cite>三级菜单</cite></a></dd>
                            <dd><a href="javascript:;"> <cite>三级菜单</cite></a></dd>
                            <dd><a href="javascript:;"> <cite>三级菜单</cite></a></dd>
                            <dd><a href="javascript:;"> <cite>三级菜单</cite></a></dd>
                            <dd><a href="javascript:;"> <cite>三级菜单</cite></a></dd>
                            <dd><a href="javascript:;"> <cite>三级菜单</cite></a></dd>
                            <dd><a href="javascript:;"> <cite>三级菜单</cite></a></dd>
                            <dd><a href="javascript:;"> <cite>三级菜单</cite></a></dd>
                            <dd><a href="javascript:;"> <cite>三级菜单</cite></a></dd>
                            <dd><a href="javascript:;"> <cite>三级菜单</cite></a></dd>
                        </dl>
                        
                      </dd>
                      <dd><a href="javascript:;"><i class="fa fa-clipboard fa-lg"></i> <cite>简单模拟</cite></a></dd>
                      <dd><a href="javascript:;"><i class="fa fa-file-text fa-lg"></i> <cite>测试</cite></a></dd>
                  </dl>
              </li>
              <li class="layui-nav-item">
                  <a href="javascript:;"><i class="layui-icon layui-icon-face-smile"></i> <cite>导航2</cite><span class="layui-nav-more"></span></a>
                  <dl class="layui-nav-child">
                      <dd><a href="javascript:;"> <cite>测试</cite></a></dd>
                      <dd><a href="javascript:;"> <cite>测试</cite></a></dd>
                  </dl>
              </li>
          <span class="layui-nav-bar" style="top: 67.5px; height: 0px; opacity: 0;"></span></ul>
      </div>
  </div>  

  <!--主体-->
  <div class="layui-body" id="LAY_app_body" style="left: 230px;">
    <div class="layui-header">
          <!-- 头部区域 -->
          <ul class="layui-nav layui-layout-left" lay-filter="layadmin-layout-left">
            <li class="layui-nav-item layadmin-flexible" lay-unselect="">
              <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
                <i class="layui-icon layui-icon-shrink-right layui-icon-spread-right" id="LAY_app_flexible"></i>
              </a>
            </li>
            <li class="layui-nav-item" lay-unselect="">
              <a href="javascript:;" layadmin-event="refresh" title="刷新">
                <i class="layui-icon layui-icon-refresh-3"></i>
              </a>
            </li>
            <li class="layui-nav-item layui-hide-xs" lay-unselect="">
              <input type="text" placeholder="搜索..." autocomplete="off" class="layui-input layui-input-search" layadmin-event="serach" lay-action="template/search/keywords="> 
            </li>
        <span class="layui-nav-bar" style="left: 142px; top: 45px; width: 0px; opacity: 0;"></span></ul>
        <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">
            <li class="layui-nav-item layui-hide-xs" lay-unselect="">
              <a href="javascript:;" layadmin-event="theme">
                <i class="layui-icon layui-icon-theme"></i>
              </a>
            </li>
            <li class="layui-nav-item" lay-unselect=""> 
              <a href="javascript:;"> <span>Choutest</span> <span class="layui-nav-more"></span></a> 
              <dl class="layui-nav-child"> 
                  <dd><a lay-href="set/user/info">基本资料</a></dd>
                  <dd><a lay-href="set/user/password">修改密码</a></dd> 
                  <hr> 
                  <dd layadmin-event="logout" style="text-align: center;"><a>退出</a></dd> 
              </dl> 
            </li>
        <span class="layui-nav-bar"></span></ul>
      </div>
    <div class="layui-fluid">
      <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
          <div class="layui-card">
            <div style="font-size:20px;color:red" class="layui-card-header">layui学习交流群请加入（701180681）</div>
            <div class="layui-card-body">
              
              <br>小圆点：
              
              <span class="layui-badge-dot"></span>
              <span class="layui-badge-dot layui-bg-orange"></span>
              <span class="layui-badge-dot layui-bg-green"></span>
              <span class="layui-badge-dot layui-bg-cyan"></span>
              <span class="layui-badge-dot layui-bg-blue"></span>
              <span class="layui-badge-dot layui-bg-black"></span>
              <span class="layui-badge-dot layui-bg-gray"></span>
              
              <br><br>常规弧形徽章：
              
              <span class="layui-badge">6</span>
              <span class="layui-badge">99</span>
              <span class="layui-badge">61728</span>
              <span class="layui-badge">赤</span>
              <span class="layui-badge layui-bg-orange">橙</span>
              <span class="layui-badge layui-bg-green">绿</span>
              <span class="layui-badge layui-bg-cyan">青</span>
              <span class="layui-badge layui-bg-blue">蓝</span>
              <span class="layui-badge layui-bg-black">黑</span>
              <span class="layui-badge layui-bg-gray">灰</span>
              
              <br><br>边框徽章：
              
              <span class="layui-badge-rim">6</span>
              <span class="layui-badge-rim">Hot</span>
              
              <br><br>
            
            </div>
          </div>
        </div>
        <div class="layui-col-md12">
          <div class="layui-card">
            <div class="layui-card-header">与其它元素的搭配</div>
            <div class="layui-card-body">
              
              <br>
              
              <button class="layui-btn">查看消息<span class="layui-badge layui-bg-gray">1</span></button>
              <button class="layui-btn">动态<span class="layui-badge-dot layui-bg-orange"></span></button>
               
              <br><br>
               
              <ul class="layui-nav" style="text-align:right;">
                <li class="layui-nav-item">
                  <a href="https://www.17sucai.com/preview/994717/2018-11-06/%E7%AE%80%E5%8D%95%E6%A8%A1%E6%8B%9F%E5%8D%95%E9%A1%B5%E9%9D%A22.45/index.html">控制台<span class="layui-badge">9</span></a>
                </li>
                <li class="layui-nav-item">
                  <a href="https://www.17sucai.com/preview/994717/2018-11-06/%E7%AE%80%E5%8D%95%E6%A8%A1%E6%8B%9F%E5%8D%95%E9%A1%B5%E9%9D%A22.45/index.html">个人中心<span class="layui-badge-dot"></span></a>
                </li>
              <span class="layui-nav-bar" style="width: 0px; left: 0px; opacity: 0;"></span></ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!--用于选色效果-->
<div id="setbgcolor" style="display:none">
  <div class="layui-layer-shade" id="setbgcolorshade" style="z-index: 19891016; background-color: rgb(0, 0, 0); opacity: 0.3;"></div>
  <div class="layui-layer-color">
      <div class="layui-layer-content">
        <div class="layui-card-header"> 配色方案 </div>
        <div class="layui-card-body layadmin-setTheme">
          <ul class="layadmin-setTheme-color" id="ChangeColor">
              <li layadmin-event="setTheme" data-index="0" data-alias="default" title="default">
                  <div class="layadmin-setTheme-header">
                  </div>
                  <div class="layadmin-setTheme-side" style="background-color: #20222A;">
                      <div class="layadmin-setTheme-logo">
                      </div>
                  </div>
              </li>
              <li layadmin-event="setTheme" data-index="1" data-alias="dark-blue" title="dark-blue">
                  <div class="layadmin-setTheme-header">
                  </div>
                  <div class="layadmin-setTheme-side" style="background-color: #03152A;">
                      <div class="layadmin-setTheme-logo">
                      </div>
                  </div>
              </li>
              <li layadmin-event="setTheme" data-index="2" data-alias="coffee" title="coffee">
                  <div class="layadmin-setTheme-header">
                  </div>
                  <div class="layadmin-setTheme-side" style="background-color: #2E241B;">
                      <div class="layadmin-setTheme-logo">
                      </div>
                  </div>
              </li>
              <li layadmin-event="setTheme" data-index="3" data-alias="purple-red" title="purple-red">
                  <div class="layadmin-setTheme-header">
                  </div>
                  <div class="layadmin-setTheme-side" style="background-color: #50314F;">
                      <div class="layadmin-setTheme-logo">
                      </div>
                  </div>
              </li>
              <li layadmin-event="setTheme" data-index="4" data-alias="ocean" title="ocean">
                  <div class="layadmin-setTheme-header">
                  </div>
                  <div class="layadmin-setTheme-side" style="background-color: #344058;">
                      <div class="layadmin-setTheme-logo" style="background-color: #1E9FFF;">
                      </div>
                  </div>
              </li>
              <li layadmin-event="setTheme" data-index="5" data-alias="green" title="green" class="layui-this">
                  <div class="layadmin-setTheme-header">
                  </div>
                  <div class="layadmin-setTheme-side" style="background-color: #3A3D49;">
                      <div class="layadmin-setTheme-logo" style="background-color: #2F9688;">
                      </div>
                  </div>
              </li>
              <li layadmin-event="setTheme" data-index="6" data-alias="red" title="red">
                  <div class="layadmin-setTheme-header">
                  </div>
                  <div class="layadmin-setTheme-side" style="background-color: #20222A;">
                      <div class="layadmin-setTheme-logo" style="background-color: #F78400;">
                      </div>
                  </div>
              </li>
              <li layadmin-event="setTheme" data-index="7" data-alias="fashion-red" title="fashion-red">
                  <div class="layadmin-setTheme-header">
                  </div>
                  <div class="layadmin-setTheme-side" style="background-color: #28333E;">
                      <div class="layadmin-setTheme-logo" style="background-color: #AA3130;">
                      </div>
                  </div>
              </li>
              <li layadmin-event="setTheme" data-index="8" data-alias="classic-black" title="classic-black">
                  <div class="layadmin-setTheme-header">
                  </div>
                  <div class="layadmin-setTheme-side" style="background-color: #24262F;">
                      <div class="layadmin-setTheme-logo" style="background-color: #3A3D49;">
                      </div>
                  </div>
              </li>
              <li layadmin-event="setTheme" data-index="9" data-alias="green-header" title="green-header">
                  <div class="layadmin-setTheme-header" style="background-color: #2F9688;">
                  </div>
                  <div class="layadmin-setTheme-side">
                      <div class="layadmin-setTheme-logo" style="background-color: #226A62;">
                      </div>
                  </div>
              </li>
              <li layadmin-event="setTheme" data-index="10" data-alias="ocean-header" title="ocean-header">
                  <div class="layadmin-setTheme-header" style="background-color: #1E9FFF;">
                  </div>
                  <div class="layadmin-setTheme-side" style="background-color: #344058;">
                      <div class="layadmin-setTheme-logo" style="background-color: #0085E8;">
                      </div>
                  </div>
              </li>
              <li layadmin-event="setTheme" data-index="11" data-alias="classic-black-header" title="classic-black-header">
                  <div class="layadmin-setTheme-header" style="background-color: #393D49;">
                  </div>
                  <div class="layadmin-setTheme-side">
                      <div class="layadmin-setTheme-logo">
                      </div>
                  </div>
              </li>
              <li layadmin-event="setTheme" data-index="12" data-alias="purple-red-header" title="purple-red-header">
                  <div class="layadmin-setTheme-header" style="background-color: #50314F;">
                  </div>
                  <div class="layadmin-setTheme-side" style="background-color: #50314F;">
                      <div class="layadmin-setTheme-logo" style="background-color: #50314F;">
                      </div>
                  </div>
              </li>
              <li layadmin-event="setTheme" data-index="13" data-alias="fashion-red-header" title="fashion-red-header">
                  <div class="layadmin-setTheme-header" style="background-color: #AA3130;">
                  </div>
                  <div class="layadmin-setTheme-side" style="background-color: #28333E;">
                      <div class="layadmin-setTheme-logo" style="background-color: #28333E;">
                      </div>
                  </div>
              </li>
              <li layadmin-event="setTheme" data-index="14" data-alias="green-header" title="green-header">
                  <div class="layadmin-setTheme-header" style="background-color: #009688;">
                  </div>
                  <div class="layadmin-setTheme-side" style="background-color: #28333E;">
                      <div class="layadmin-setTheme-logo" style="background-color: #009688;">
                      </div>
                  </div>
              </li>
          </ul>
        </div>
        </div>   
      </div>
    </div>

<!--辅助作用一般用于手机遮罩层-->
<div class="layui-layer-shade" id="mobilenav" onclick="clearmobilenav()" style="z-index: 998; background-color: rgb(0, 0, 0); opacity: 0.3;display:none"></div>

<script type="text/javascript" src="<%=basePath%>Static/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>Static/js/layui.all.js"></script>
<script type="text/javascript" src="<%=basePath%>Static/js/common.js"></script>
</body>
</html>