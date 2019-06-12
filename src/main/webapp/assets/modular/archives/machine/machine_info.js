
layui.use(['layer', 'form', 'admin', 'laydate', 'ax'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;
    var laydate = layui.laydate;
    var layer = layui.layer;


    //获取物料详情
    var ajax = new $ax(Feng.ctxPath + "/machine/machine_detail?mcNumber=" + Feng.getUrlParam("mcNumber"));
    var result = ajax.start();
    form.val('machineForm', result.data);

    //返回按钮
    $("#backupPage").click(function () {
        window.location.href = Feng.ctxPath + "/machine";
    });

    //编辑按钮
    $("#editMachine").click(function () {
        window.location.href = Feng.ctxPath + '/machine/to_machine_edit?mcNumber=' + result.data.mcNumber;
    });

    //删除按钮
    $("#deleteMachine").click(function () {
            var operation = function () {
                var ajax = new $ax(Feng.ctxPath + "/machine/machine_delete", function () {
                    Feng.success("删除成功!");
                    window.location.href = Feng.ctxPath + "/machine";
                }, function (data) {
                    Feng.error("删除失败!" + data.responseJSON.message + "!");
                });
                ajax.set("mcNumber", result.data.mcNumber);
                ajax.start();
            };
            Feng.confirm("是否删除设备" + result.data.mcName + "?", operation);
    });
});