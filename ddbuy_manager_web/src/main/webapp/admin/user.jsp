<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
	<script src="js/jquery-1.8.3.js"></script>
	<!--jquery.easyui.min.js包含了easyUI中的所有插件-->
	<script src="js/jquery.easyui.min.js"></script>

	<script type="text/javascript">
        $(function () {
            $("#dg").datagrid({
                url:"/admin/getUser", //服务器请求（后台控制器的实现请求:），前台需要总条数，行数据
                pagination:true,     //开启分页
                pageList:[3,5,8,10], //分页设置
                pageSize:8,          //每页大小（行数）
                toolbar:"#ToolBar",  //工具栏,toorbar 注意全部小写
                fitColumns:true,    //表格和页面自适应（列/宽度）
                // singleSelect:true,
                columns:[[
                    {field:'ck',checkbox:true},  //设置复选框
                    {field:'id',title:'用户编号',width:100,align:"center"},
                    {field:'name',title:'姓名',width:100,align:"center"},
                    {field:'telephone',title:'电话',width:100,align:"center"},
                    {field:'age',title:'年龄',width:100,align:"center"},
                    {field:'isadmin',title:'用户类别',width:100,align:"center"},
                    {field:'opt',title:'操作',width:100,align:"center",
                        formatter: function(value,row,index){  // 字段的值，此行数据，行索引
                            // return "<a href='delType?id="+row.id+"'>删除</a>";
                            return "<a href='javascript:delSingle("+row.id+")'>删除</a> ||<a href='javascript:showHouse("+row.id+")'>查看房屋列表</a>";
                        }
                    }
                ]]
            })
        })
        //点击"添加"弹出添加对话框
        function Add() {
            $("#AddDialog").dialog("open").dialog("setTitle","添加用户");
        }
        //点击“取消”关闭添加的对话框
        function CloseDialog() {
            $("#AddDialog").dialog("close");
        }
        
        //添加
		function SaveDialog() {
			$('#addForm').form('submit',{
			    url:"/admin/addUser",
				success:function (data) {
					var obj=$.parseJSON(data);
					if (obj.result>0){
					    $("#AddDialog").dialog("close");
						$("#dg").datagrid('reload');
						$.messager.alert("提示框","添加成功！");
					} else {
                        $.messager.alert("提示框","系统维护中！");
					}
                }
			});
        }
	</script>

        </head>
<body>
<div id="ToolBar">
	<div style="height: 40px;">
		<a href="javascript:Add()" class="easyui-linkbutton"
		   iconCls="icon-add" plain="true">添加</a> <a
			href="javascript:ModifyBySelect()" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true">修改</a> <a
			href="javascript:DeleteByFruitName()" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true">删除</a>
	</div>
</div>

<div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
	 style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
	<form id="addForm" method="post">
		<table>
			<tr>
				<td>姓    名:</td>
				<td><input type="text" name="name" id="n" /></td>
			</tr>
			<tr>
				<td>电    话:</td>
				<td><input type="text" name="telephone" id="t" /></td>
			</tr>
			<tr>
				<td>年    龄:</td>
				<td><input type="text" name="age" id="a" /></td>
			</tr>
			<tr>
				<td>用户类别:</td>
				<td><input type="text" name="isadmin" id="adm" /></td>
			</tr>
		</table>

	</form>
</div>

<div id="AddDialogButtons">
	<a href="javascript:SaveDialog()" class="easyui-linkbutton"
	   iconCls="icon-ok">保存</a>
	<a href="javascript:CloseDialog()" class="easyui-linkbutton"
	   iconCls="icon-cancel">取消</a>
</div>

 	<table id="dg"></table>

	<script type="text/javascript" src="./js/MyEasyUICRUD.js"></script>
</body>
</html>