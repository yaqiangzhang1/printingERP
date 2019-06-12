
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
    form.val('materielForm', result.data);

    //返回按钮
    $("#backupPage").click(function () {
        window.location.href = Feng.ctxPath + "/materiel";
    });
    //编辑按钮
    $("#editMateriel").click(function () {
        window.location.href = Feng.ctxPath + '/materiel/to_materiel_edit?mNumber=' + result.data.mNumber
    });
    //删除按钮
    $("#deleteMateriel").click(function () {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/materiel/materiel_delete", function () {
                Feng.success("删除成功!");
                window.location.href = Feng.ctxPath + "/materiel";
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("mNumber", result.data.mNumber);
            ajax.start();
        };
        Feng.confirm("是否删除物料" + result.data.mName + "?", operation);
    });
});