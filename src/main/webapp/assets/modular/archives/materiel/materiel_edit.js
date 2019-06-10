
layui.use(['layer', 'form', 'admin', 'laydate', 'ax'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;
    var laydate = layui.laydate;
    var layer = layui.layer;


    //获取物料详情
    var ajax = new $ax(Feng.ctxPath + "/materiel/materiel_detail?mNumber=" + Feng.getUrlParam("mNumber"));
    var result = ajax.start();
    console.log(result.data)
    form.val('materielForm', result.data);




    // 表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/materiel/materiel_edit", function (data) {
            Feng.success("修改成功！");
            window.location.href = Feng.ctxPath + "/materiel";
        }, function (data) {
            Feng.error("修改成功！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();
        return false;
    });

    //返回按钮
    $("#backupPage").click(function () {
        window.location.href = Feng.ctxPath + "/materiel";
    });
});