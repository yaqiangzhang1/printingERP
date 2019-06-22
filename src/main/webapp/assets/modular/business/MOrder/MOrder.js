layui.use(['layer', 'form', 'table', 'ztree', 'laydate', 'admin', 'ax'], function () {
    var layer = layui.layer;
    var form = layui.form;
    var table = layui.table;
    var $ZTree = layui.ztree;
    var $ax = layui.ax;
    var laydate = layui.laydate;
    var admin = layui.admin;

    /**
     * 订单管理
     */
    var MOrder = {
        tableId: "MOrderTable",    //表格id
    };

    /**
     * 初始化表格的列
     */
    MOrder.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'oNumber', sort: true, title: '单据编号'},
            {field: 'oType', sort: true, title: '订单类型'},
            {field: 'oStstus', sort: true, title: '订单状态'},
            {field: 'salesman', sort: true, title: '业务员'},
            {field: 'cName', sort: true, title: '客户名称'},
            {field: 'pName', sort: true, title: '产品名称'},
            {field: 'pNumber', sort: true, title: '产品开数'},
            {field: 'pSize', sort: true, title: '产品尺寸'},
            {field: 'oQuantity', sort: true, title: '订货数量'},
            {field: 'unit', sort: true, title: '单位'},
            {field: 'cONumber', sort: true, title: '客户订单号'},
            {field: 'ordertime', sort: true, title: '下单日期'},
            {field: 'remarks', sort: true, title: '备注'}
            // {fixed: 'right', title:'操作', toolbar: '#tableBar', width:150}
        ]];
    };

    /**
     * 点击查询按钮
     */
    MOrder.search = function () {
        var queryData = {};
        queryData['searchType'] = $("#searchType").val();
        queryData['search'] = $("#search").val();
        table.reload(MOrder.tableId, {where: queryData});
    };

    /**
     * 弹出添加对话框
     */
    MOrder.openAddcustomer = function () {
        window.location.href = Feng.ctxPath + '/MOrder/MOrder_add';
    };

    /**
     * 弹出客户详情对话框
     */
    MOrder.openInfoMOrder = function (data) {
        window.location.href = Feng.ctxPath + '/MOrder/MOrder_info?oNumber=' + data.oNumber;
    };

    // /**
    //  * 点击编辑
    //  *
    //  * @param data 点击按钮时候的行数据
    //  */
    // customer.onEditCustomer = function (data) {
    //     window.location.href = Feng.ctxPath + '/customer/to_customer_edit?cNumber=' + data.cNumber;
    // };
    /**
     * 导出excel按钮
     */
    MOrder.exportExcel = function () {
        var checkRows = table.checkStatus(MOrder.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + MOrder.tableId,
        url: Feng.ctxPath + '/MOrder/list',
        page: true,
        height: "full-98",
        cellMinWidth: 100,
        cols: MOrder.initColumn()
    });


    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        MOrder.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        MOrder.openAddMOrder();
    });

    // 导出excel
    $('#btnExp').click(function () {
        MOrder.exportExcel();
    });

    //监听行单击事件（单击事件为：rowDouble）
    table.on('rowDouble('+MOrder.tableId+')', function(obj){
        var data = obj.data;
        MOrder.openInfoMOrder(data);
    });

});
