<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>操作员待办列表</title>
	<link href="css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="js/themes/icon.css" />
    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.js"></script>
  <script type="text/javascript">
	 $(function(){
			$('#aa').datagrid({
				url: 'queryOperatorTask',
				title: '待办任务列表',
				fitColumns: true,
				columns:[[
					{field:'name',title:'任务名称',width:150},
					{field:'Assignee',title:'任务执行人',width:150},
					{field:'owner',title:'任务拥有者',width:150},
					{field:'creatTime',title:'任务创建时间',width:150},
					{field:'taskId',title:'任务ID',width:150},
					{field:'opt',title:'操作',width:150,
						formatter:function(value,rec){  
			                var btn = '<a class="editcls" onclick="commitTask(\''+rec.taskId+'\')" href="javascript:void(0)">提交申请</a>';  
			                return btn;  
			            } 	
					}
				]],
			});
		});
	 
	 function commitTask(taskId){
		 $.ajax({
             type: "POST",
             url: "commitTask",
             data: {taskId:taskId},
             dataType: "json",
             success: function(data){
                        alert("执行成功！");
                      }
         });
	 }
	 </script>
</head>
<body>
    <table id="aa" class="easyui-datagrid" style="width:1200px;height:250px">
    		
    </table>
</body>
</html>