layui.use(['layer', 'form', 'table', 'ztree', 'laydate', 'admin', 'ax'], function () {
    var layer = layui.layer;
    var form = layui.form;
    var table = layui.table;
    var $ZTree = layui.ztree;
    var $ax = layui.ax;
    var laydate = layui.laydate;
    var admin = layui.admin;

    /**
     * 基础档案--客户档案
     */
    var machine = {
        tableId: "machineTable",    //表格id
        condition: {

        }
    };

    /**
     * 初始化表格的列
     */
    machine.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'mcNumber', sort: true, title: '设备编码'},
            {field: 'mcName', sort: true, title: '设备名称'},
            {field: 'mcModel', sort: true, title: '规格型号'},
            {field: 'mcAddress', sort: true, title: '生产地址'},
            {field: 'factorydate', sort: true, title: '出厂日期'},
            {field: 'factorynumber', sort: true, title: '出厂编号'},
            {field: 'useyear', sort: true, title: '使用年限'},
            {field: 'cycle', sort: true, title: '保养周期'},
            {field: 'telephone', sort: true, title: '售后电话'},
            {field: 'remarks', sort: true, title: '备注'},
            {fixed: 'right', title:'操作', toolbar: '#tableBar', width:150}
        ]];
    };

    /**
     * 点击查询按钮
     */
    machine.search = function () {
        var queryData = {};
        queryData['searchType'] = $("#searchType").val();
        queryData['search'] = $("#search").val();
        table.reload(machine.tableId, {where: queryData});
    };

    /**
     * 弹出添加对话框
     */
    machine.openAddmachine = function () {
        window.location.href = Feng.ctxPath + '/machine/machine_add';
    };
    /**
     * 导出excel按钮
     */
    machine.exportExcel = function () {
        var checkRows = table.checkStatus(machine.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    /**
     * 点击编辑
     *
     * @param data 点击按钮时候的行数据
     */
    machine.onEditmachine = function (data) {
        window.location.href = Feng.ctxPath + '/machine/to_machine_edit?mcNumber=' + data.mcNumber
    };

    /**
     * 点击删除用户按钮
     *
     * @param data 点击按钮时候的行数据
     */
    machine.onDeletemachine = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/machine/machine_delete", function () {
                table.reload(machine.tableId);
                Feng.success("删除成功!");
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("mcNumber", data.mcNumber);
            ajax.start();
        };
        Feng.confirm("是否删除设备" + data.mcName + "?", operation);
    };


    // 渲染表格
    var tableResult = table.render({
        elem: '#' + machine.tableId,
        url: Feng.ctxPath + '/machine/list',
        page: true,
        height: "full-98",
        cellMinWidth: 100,
        cols: machine.initColumn()
    });

    //渲染时间选择框
    laydate.render({
        elem: '#timeLimit',
        range: true,
        max: Feng.currentDate()
    });


    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        machine.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        machine.openAddmachine();
    });

    // 导出excel
    $('#btnExp').click(function () {
        btnSearch.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + machine.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;
        if (layEvent === 'edit') {
            machine.onEditmachine(data);
        } else if (layEvent === 'delete') {
            machine.onDeletemachine(data);
        }
    });


});
