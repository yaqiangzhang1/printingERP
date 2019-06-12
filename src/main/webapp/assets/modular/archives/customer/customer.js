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
    var customer = {
        tableId: "customerTable",    //表格id
    };

    /**
     * 初始化表格的列
     */
    customer.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'cNumber', sort: true, title: '客户编码'},
            {field: 'cName', sort: true, title: '客户名称'},
            {field: 'contacts', sort: true, title: '联系人'},
            {field: 'phone', sort: true, title: '联系电话'},
            {field: 'cTrade', sort: true, title: '所属行业'},
            {field: 'cNature', sort: true, title: '客户性质'},
            {field: 'cSource', sort: true, title: '客户来源'},
            {field: 'cType', sort: true, title: '客户类型'},
            {field: 'cRegion', sort: true, title: '地区'},
            {field: 'salesman', sort: true, title: '业务员'},
            {field: 'address', sort: true, title: '地址'},
            {field: 'discount', sort: true, title: '报价折扣'},
            {field: 'remarks', sort: true, title: '备注'}
            // {fixed: 'right', title:'操作', toolbar: '#tableBar', width:150}
        ]];
    };

    /**
     * 点击查询按钮
     */
    customer.search = function () {
        var queryData = {};
        queryData['searchType'] = $("#searchType").val();
        queryData['search'] = $("#search").val();
        table.reload(customer.tableId, {where: queryData});
    };

    /**
     * 弹出添加对话框
     */
    customer.openAddcustomer = function () {
        window.location.href = Feng.ctxPath + '/customer/customer_add';
    };

    /**
     * 弹出客户详情对话框
     */
    customer.openInfocustomer = function (data) {
        window.location.href = Feng.ctxPath + '/customer/customer_info?cNumber=' + data.cNumber;
    };

    /**
     * 点击编辑
     *
     * @param data 点击按钮时候的行数据
     */
    customer.onEditCustomer = function (data) {
        window.location.href = Feng.ctxPath + '/customer/to_customer_edit?cNumber=' + data.cNumber;
    };
    /**
     * 导出excel按钮
     */
    customer.exportExcel = function () {
        var checkRows = table.checkStatus(customer.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + customer.tableId,
        url: Feng.ctxPath + '/customer/list',
        page: true,
        height: "full-98",
        cellMinWidth: 100,
        cols: customer.initColumn()
    });


    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        customer.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        customer.openAddcustomer();
    });

    // 导出excel
    $('#btnExp').click(function () {
        customer.exportExcel();
    });

    //监听行单击事件（单击事件为：rowDouble）
    table.on('rowDouble('+customer.tableId+')', function(obj){
        var data = obj.data;
        customer.openInfocustomer(data);
    });

});
