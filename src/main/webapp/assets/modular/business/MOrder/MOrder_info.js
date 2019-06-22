
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
    var ajax = new $ax(Feng.ctxPath + "/MOrder/MOrder_detail?oNumber=" + Feng.getUrlParam("oNumber"));
    var result = ajax.start();
    form.val('MOrderForm', result.data);

    // 表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/customer/customer_edit", function (data) {
            Feng.success("修改成功！");
            window.location.href = Feng.ctxPath + "/customer";
        }, function (data) {
            Feng.error("修改成功！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();
        return false;
    });

    //删除按钮
    $("#deleteCustomer").click(function () {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/customer/customer_delete", function () {
                Feng.success("删除成功!");
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("cNumber",result.data.cNumber);
            ajax.start();
            window.location.href = Feng.ctxPath + "/customer";
        };
        Feng.confirm("是否删除用户" + result.data.cName + "?", operation);

    });

    $("#backupPage").click(function () {
        window.location.href = Feng.ctxPath + "/MOrder";
    });
    $("#editMOrder").click(function () {
        window.location.href = Feng.ctxPath + '/MOrder/to_MOrder_edit?oNumber=' +result.data.oNumber;
    });

});