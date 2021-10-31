<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/resources/commons/basejs.jsp" %>
</head>
<body>
    <div style="width: 400px;padding-top: 10px;">
        <form id="form_submit" class="layui-form">
            <div class="layui-form-item">
                <label class="layui-form-label">商品名称</label>
                <div class="layui-input-inline">
                    <input type="text" name="name" lay-verify="required" placeholder="请输入商品名称" class="layui-input" value="">
                </div>
                <label class="layui-form-label">店铺名称</label>
                <div class="layui-input-inline">
                    <input type="text" name="writer" lay-verify="required" placeholder="请输入店铺名称" class="layui-input" value="">
                </div>
                <label class="layui-form-label">商品描述</label>
                <div class="layui-input-inline">
                    <input type="text" name="des" lay-verify="required" placeholder="请输入商品简介" class="layui-input" value="">
                </div>
                <label class="layui-form-label">图片</label>
                <div class="layui-input-inline" style="position: relative">
                    <button type="button" class="layui-btn layui-btn-normal" id="image-upload-show">
                        <i class="layui-icon layui-icon-upload"></i>上传图片
                    </button>
                    <div class="image-upload-show"></div>
                </div>
                <label class="layui-form-label">价格</label>
                <div class="layui-input-inline">
                    <input type="text" name="price" lay-verify="required|number" placeholder="请输入价格" class="layui-input" value="">
                </div>

            </div>
            <div class="layui-form-item" style="display: none">
                <button type="button" lay-submit lay-filter="btn_form_submit" id="btn_form_submit" class="layui-btn layui-btn-lg"></button>
            </div>
        </form>
    </div>
</body>
<script>
    var modleName = "${ctxPath}/goods";
    //用layui加载数据
    function onLayuiInit() {
        bindUpload("image-upload-show","coverImage");
        //绑定监听表单提交事件
        bindSubmit(modleName,'add','btn_form_submit','form_submit');
    }
</script>
</html>














