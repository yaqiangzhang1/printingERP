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
    var materiel = {
        tableId: "materielTable",    //表格id
        condition: {

        }
    };

    /**
     * 初始化表格的列
     */
    materiel.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'mNumber', sort: true, title: '物料编码'},
            {field: 'mName', sort: true, title: '物料名称'},
            {field: 'mBrand', sort: true, title: '品牌'},
            {field: 'mType', sort: true, title: '物料种类'},
            {field: 'unit', sort: true, title: '单位'},
            {field: 'specifications', sort: true, title: '规格'},
            {field: 'remarks', sort: true, title: '备注'},
            // {field: 'status', sort: true, templet: '#statusTpl', title: '状态'},
            {align: 'center', toolbar: '#tableBar', title: '操作', minWidth: 280}
        ]];
    };

    // /**
    //  * 选择部门时
    //  */
    // MgrUser.onClickDept = function (e, treeId, treeNode) {
    //     MgrUser.condition.deptId = treeNode.id;
    //     MgrUser.search();
    // };

    /**
     * 点击查询按钮
     */
    materiel.search = function () {
        var queryData = {};
        queryData['searchType'] = $("#searchType").val();
        queryData['search'] = $("#search").val();
        table.reload(materiel.tableId, {where: queryData});
    };

    /**
     * 弹出添加用户对话框
     */
    // customer.openAddUser = function () {
    //     admin.putTempData('formOk', false);
    //     // var index = top.layui.admin.open({
    //     //     type: 2,
    //     //     title: '增加客户档案',
    //     //     content: Feng.ctxPath + '/customer/customer_add',
    //     //     end: function () {
    //     //         admin.getTempData('formOk') && table.reload(customer.tableId);
    //     //     }
    //     // });
    //     // layer.full(index);
    //     var index = layer.open({
    //         type: 2,
    //         title: '增加客户档案',
    //         content: Feng.ctxPath + '/customer/customer_add',
    //         end: function () {
    //             admin.getTempData('formOk') && table.reload(customer.tableId);
    //         }
    //     });
    //     layer.full(index);
    // };
    /**
     * 弹出添加对话框
     */
    materiel.openAddmateriel = function () {
        window.location.href = Feng.ctxPath + '/materiel/materiel_add';
    };
    /**
     * 导出excel按钮
     */
    materiel.exportExcel = function () {
        var checkRows = table.checkStatus(materiel.tableId);
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
    materiel.onEditmateriel = function (data) {
        console.log(data)
        console.log(data.mNumber)
        window.location.href = Feng.ctxPath + '/materiel/to_materiel_edit?mNumber=' + data.mNumber
    };

    /**
     * 点击删除用户按钮
     *
     * @param data 点击按钮时候的行数据
     */
    materiel.onDeletemateriel = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/materiel/materiel_delete", function () {
                table.reload(materiel.tableId);
                Feng.success("删除成功!");
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("mNumber", data.mNumber);
            ajax.start();
        };
        Feng.confirm("是否删除物料" + data.mName + "?", operation);
    };

    // /**
    //  * 分配角色
    //  *
    //  * @param data 点击按钮时候的行数据
    //  */
    // MgrUser.roleAssign = function (data) {
    //     layer.open({
    //         type: 2,
    //         title: '角色分配',
    //         area: ['300px', '400px'],
    //         content: Feng.ctxPath + '/mgr/role_assign?userId=' + data.userId,
    //         end: function () {
    //             table.reload(MgrUser.tableId);
    //         }
    //     });
    // };
    //
    // /**
    //  * 重置密码
    //  *
    //  * @param data 点击按钮时候的行数据
    //  */
    // MgrUser.resetPassword = function (data) {
    //     Feng.confirm("是否重置密码为111111 ?", function () {
    //         var ajax = new $ax(Feng.ctxPath + "/mgr/reset", function (data) {
    //             Feng.success("重置密码成功!");
    //         }, function (data) {
    //             Feng.error("重置密码失败!");
    //         });
    //         ajax.set("userId", data.userId);
    //         ajax.start();
    //     });
    // };
    //
    // /**
    //  * 修改用户状态
    //  *
    //  * @param userId 用户id
    //  * @param checked 是否选中（true,false），选中就是解锁用户，未选中就是锁定用户
    //  */
    // MgrUser.changeUserStatus = function (userId, checked) {
    //     if (checked) {
    //         var ajax = new $ax(Feng.ctxPath + "/mgr/unfreeze", function (data) {
    //             Feng.success("解除冻结成功!");
    //         }, function (data) {
    //             Feng.error("解除冻结失败!");
    //             table.reload(MgrUser.tableId);
    //         });
    //         ajax.set("userId", userId);
    //         ajax.start();
    //     } else {
    //         var ajax = new $ax(Feng.ctxPath + "/mgr/freeze", function (data) {
    //             Feng.success("冻结成功!");
    //         }, function (data) {
    //             Feng.error("冻结失败!" + data.responseJSON.message + "!");
    //             table.reload(MgrUser.tableId);
    //         });
    //         ajax.set("userId", userId);
    //         ajax.start();
    //     }
    // };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + materiel.tableId,
        url: Feng.ctxPath + '/materiel/list',
        page: true,
        height: "full-98",
        cellMinWidth: 100,
        cols: materiel.initColumn()
    });

    // //渲染时间选择框
    // laydate.render({
    //     elem: '#timeLimit',
    //     range: true,
    //     max: Feng.currentDate()
    // });

    // //初始化左侧部门树
    // var ztree = new $ZTree("deptTree", "/dept/tree");
    // ztree.bindOnClick(MgrUser.onClickDept);
    // ztree.init();

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        materiel.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        materiel.openAddmateriel();
    });

    // 导出excel
    $('#btnExp').click(function () {
        btnSearch.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + materiel.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;
        if (layEvent === 'edit') {
            materiel.onEditmateriel(data);
        } else if (layEvent === 'delete') {
            materiel.onDeletemateriel(data);
        }
    });

    // // 修改user状态
    // form.on('switch(status)', function (obj) {
    //
    //     var userId = obj.elem.value;
    //     var checked = obj.elem.checked ? true : false;
    //
    //     MgrUser.changeUserStatus(userId, checked);
    // });

});
