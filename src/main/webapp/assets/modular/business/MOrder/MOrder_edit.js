
layui.use(['layer', 'form', 'admin', 'laydate', 'ax'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;
    var laydate = layui.laydate;
    var layer = layui.layer;

    // 让当前iframe弹层高度适应
    admin.iframeAuto();

    //获取用户信息
    var ajax = new $ax(Feng.ctxPath + "/customer/customer_detail?cNumber=" + Feng.getUrlParam("cNumber"));
    var result = ajax.start();
    form.val('customerForm', result.data);


    // 表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/customer/customer_edit", function (data) {
            Feng.success("修改成功！");
            window.location.href = Feng.ctxPath + '/customer/customer_info?cNumber=' + result.data.cNumber;
        }, function (data) {
            Feng.error("修改成功！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();
        return false;
    });

    $("#backPage").click(function () {
        window.location.href = Feng.ctxPath + '/customer/customer_info?cNumber=' + result.data.cNumber;
    });

});