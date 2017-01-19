<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head id="Head1">
    <title>差错处理平台</title>
    <link href="css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="js/themes/icon.css" />
    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.js"></script>

	<script type="text/javascript" src='js/outlook2.js'> </script>

    <script type="text/javascript">
	 var _menus = {"menus":[
						{"menuid":"1","icon":"icon-sys","menuname":"操作员",
							"menus":[{"menuname":"操作员代办事项","icon":"icon-nav","url":"operatorTodo.jsp"},
									{"menuname":"操作员已办事项","icon":"icon-add","url":"demo.html"}
								]
						},
						{"menuid":"1","icon":"icon-sys","menuname":"审核员",
							"menus":[{"menuname":"审核员代办事项","icon":"icon-nav","url":"demo2.html"},
									{"menuname":"审核员已办事项","icon":"icon-add","url":"demo3.html"}
								]
						}
				]};
	 
	 $(function(){
			$('#tt').datagrid({
				url: 'queryTask',
				title: '任务列表',
				fitColumns: true,
				columns:[[
					{field:'name',title:'任务名称',width:150},
					{field:'key',title:'任务key',width:150},
					{field:'id',title:'任务id',width:150},
					{field:'opt',title:'操作',width:150,
						formatter:function(value,rec){  
			                var btn = '<a class="editcls" onclick="runTask(\''+rec.key+'\')" href="javascript:void(0)">执行</a>';  
			                return btn;  
			            } 	
					}
				]],
			});
		});
	    
	    function runTask(taskKey){  
	    	$.ajax({
	             type: "POST",
	             url: "runTask",
	             data: {taskKey:taskKey},
	             dataType: "json",
	             success: function(data){
	                        alert("执行成功！");
	                      }
	         });
	    }  
    </script>

</head>
<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
<noscript>
<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
    <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
</div></noscript>
    <div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
        background: url(images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
        <span style="float:right; padding-right:20px;" class="head"></span>
        <span style="padding-left:10px; font-size: 16px; "><img src="images/blocks.gif" width="20" height="20" align="absmiddle"> 联通支付公司差错处理平台</span>
    </div>
    <div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
        <div class="footer">联通支付公司</div>
    </div>
    <div region="west" split="true" title="导航菜单" style="width:180px;" id="west">
	<div class="easyui-accordion" fit="true" border="false">
		<!--  导航内容 -->
				
			</div>

    </div>
    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<div title="欢迎使用" style="padding:20px;overflow:hidden;" id="home">
				
			<h1>欢迎使用差错处理平台,请开始以下任务</h1>
    <table id="tt" class="easyui-datagrid" style="width:600px;height:250px">
    		
    </table>
			</div>
		</div>
    </div>
	<div id="mm" class="easyui-menu" style="width:150px;">
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-exit">退出</div>
	</div>
</body>
</html>
