layui.use(['table', 'admin', 'ax', 'ztree'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var $ZTree = layui.ztree;

    /**
     * 系统管理--系统编码
     */
    var syscode = {
        tableId: "syscodeTable",
        condition: {
            codeId: ""
        }
    };

    /**
     * 初始化表格的列
     */
    syscode.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'codeId', hide: true, sort: true, title: 'id'},
            {field: 'pName',  sort: true, title: '编码种类'},
            {field: 'simpleName', sort: true, title: '编码名称'},
            {align: 'center', toolbar: '#tableBar', title: '操作', minWidth: 200}
        ]];
    };

    /**
     * 点击查询按钮
     */
    syscode.search = function () {
        var queryData = {};
        queryData['condition'] = $("#name").val();
        queryData['codeId'] = syscode.condition.codeId;
        table.reload(syscode.tableId, {where: queryData});
    };

    /**
     * 选择部门时
     */
    syscode.onClicksyscode = function (e, treeId, treeNode) {
        syscode.condition.codeId = treeNode.id;
        syscode.search();
    };

    /**
     * 弹出添加
     */
    syscode.openAddsyscode = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '添加系统编码',
            content: Feng.ctxPath + '/syscode/syscode_add',
            end: function () {
                admin.getTempData('formOk') && table.reload(syscode.tableId);
            }
        });
    };

    /**
     * 导出excel按钮
     */
    syscode.exportExcel = function () {
        var checkRows = table.checkStatus(syscode.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    /**
     * 点击编辑部门
     *
     * @param data 点击按钮时候的行数据
     */
    syscode.onEditsyscode = function (data) {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '修改系统编码',
            content: Feng.ctxPath + '/syscode/syscode_update?codeId=' + data.codeId,
            end: function () {
                admin.getTempData('formOk') && table.reload(syscode.tableId);
            }
        });
    };

    /**
     * 点击删除部门
     *
     * @param data 点击按钮时候的行数据
     */
    syscode.onDeletesyscode = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/syscode/delete", function () {
                Feng.success("删除成功!");
                table.reload(syscode.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("codeId", data.codeId);
            ajax.start();
        };
        Feng.confirm("是否删除部门 " + data.simpleName + "?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + syscode.tableId,
        url: Feng.ctxPath + '/syscode/list',
        page: true,
        height: "full-98",
        cellMinWidth: 100,
        cols: syscode.initColumn()
    });

    //初始化左侧部门树
    var ztree = new $ZTree("syscodeTree", "/syscode/tree");
    ztree.bindOnClick(syscode.onClicksyscode);
    ztree.init();

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        syscode.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        syscode.openAddsyscode();
    });

    // 导出excel
    $('#btnExp').click(function () {
        syscode.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + syscode.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            syscode.onEditsyscode(data);
        } else if (layEvent === 'delete') {
            syscode.onDeletesyscode(data);
        }
    });
});
