/**
 * Copyright 2018-2020 stylefeng & fengshuonan (https://gitee.com/stylefeng)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.stylefeng.guns.modular.archives.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.stylefeng.guns.core.common.annotion.BussinessLog;
import cn.stylefeng.guns.core.common.annotion.Permission;
import cn.stylefeng.guns.core.common.constant.dictmap.SysCodeDict;
import cn.stylefeng.guns.core.common.constant.factory.ConstantFactory;
import cn.stylefeng.guns.core.common.node.TreeviewNode;
import cn.stylefeng.guns.core.common.node.ZTreeNode;
import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import cn.stylefeng.guns.modular.archives.entity.SysCode;
import cn.stylefeng.guns.modular.archives.model.SysCodeDto;
import cn.stylefeng.guns.modular.archives.service.SysCodeService;
import cn.stylefeng.guns.modular.archives.warpper.SysCodeTreeWrapper;
import cn.stylefeng.guns.modular.archives.warpper.SysCodeWrapper;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.core.treebuild.DefaultTreeBuildFactory;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.RequestEmptyException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 系统编码控制器
 *
 * @author fengshuonan
 * @Date 2017年2月17日20:27:22
 */
@Controller
@RequestMapping("syscode")
public class SysCodeController extends BaseController {

    private String PREFIX = "/modular/archives/syscode/";

    @Autowired
    private SysCodeService syscodeService;

    /**
     * 跳转到系统编码管理首页
     *
     * @author fengshuonan
     * @Date 2018/12/23 4:56 PM
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "syscode.html";
    }

    /**
     * 跳转到添加系统编码
     *
     * @author fengshuonan
     * @Date 2018/12/23 4:56 PM
     */
    @RequestMapping("syscode_add")
    public String syscodeAdd() {
        return PREFIX + "syscode_add.html";
    }

    /**
     * 跳转到修改系统编码
     *
     * @author fengshuonan
     * @Date 2018/12/23 4:56 PM
     */
    @Permission
    @RequestMapping("syscode_update")
    public String syscodeUpdate(@RequestParam("codeId") Long codeId) {
        if (ToolUtil.isEmpty(codeId)) {
            throw new RequestEmptyException();
        }
        //缓存系统编码修改前详细信息
        SysCode syscode = syscodeService.getById(codeId);
        LogObjectHolder.me().set(syscode);
        System.out.println(syscode.toString());
        return PREFIX + "syscode_edit.html";
    }

    /**
     * 获取系统编码的tree列表，ztree格式
     *
     * @author fengshuonan
     * @Date 2018/12/23 4:56 PM
     */
    @RequestMapping(value = "/tree")
    @ResponseBody
    public List<ZTreeNode> tree() {
        List<ZTreeNode> tree = this.syscodeService.tree();
        tree.add(ZTreeNode.createParent());
        return tree;
    }

    /**
     * 获取系统编码的tree列表，treeview格式
     *
     * @author fengshuonan
     * @Date 2018/12/23 4:57 PM
     */
    @RequestMapping(value = "/treeview")
    @ResponseBody
    public List<TreeviewNode> treeview() {
        List<TreeviewNode> treeviewNodes = this.syscodeService.treeviewNodes();

        //构建树
        DefaultTreeBuildFactory<TreeviewNode> factory = new DefaultTreeBuildFactory<>();
        factory.setRootParentId("0");
        List<TreeviewNode> results = factory.doTreeBuild(treeviewNodes);

        //把子节点为空的设为null
        SysCodeTreeWrapper.clearNull(results);

        return results;
    }

    /**
     * 新增系统编码
     *
     * @author fengshuonan
     * @Date 2018/12/23 4:57 PM
     */
    @BussinessLog(value = "添加系统编码", key = "simpleName", dict = SysCodeDict.class)
    @RequestMapping(value = "/add")
    @Permission
    @ResponseBody
    public ResponseData add(SysCode syscode) {
        this.syscodeService.addSysCode(syscode);
        return SUCCESS_TIP;
    }

    /**
     * 获取所有系统编码列表
     *
     * @author fengshuonan
     * @Date 2018/12/23 4:57 PM
     */
    @RequestMapping(value = "/list")
    @Permission
    @ResponseBody
    public Object list(@RequestParam(value = "condition", required = false) String condition,
                       @RequestParam(value = "codeId", required = false) Long codeId) {
        if("null1".equals(codeId+"1")){
            codeId = 0L;
        }
        Page<Map<String, Object>> list = this.syscodeService.list(condition, codeId);
        Page<Map<String, Object>> wrap = new SysCodeWrapper(list).wrap();
        return LayuiPageFactory.createPageInfo(wrap);
    }

    /**
     * 系统编码详情
     *
     * @author fengshuonan
     * @Date 2018/12/23 4:57 PM
     */
    @RequestMapping(value = "/detail/{codeId}")
    @Permission
    @ResponseBody
    public Object detail(@PathVariable("codeId") Long codeId) {
        System.out.println(codeId+"---------------------------");
        SysCode syscode = syscodeService.getById(codeId);
        System.out.println(syscode.toString()+"-----------------------------------------------------");
        SysCodeDto syscodeDto = new SysCodeDto();
        BeanUtil.copyProperties(syscode, syscodeDto);
        syscodeDto.setPName(ConstantFactory.me().getSimpleName(syscodeDto.getPid()));
        return syscodeDto;
    }

    /**
     * 修改系统编码
     *
     * @author fengshuonan
     * @Date 2018/12/23 4:57 PM
     */
    @BussinessLog(value = "修改系统编码", key = "simpleName", dict = SysCodeDict.class)
    @RequestMapping(value = "/update")
    @Permission
    @ResponseBody
    public ResponseData update(SysCode syscode) {
        syscodeService.editSysCode(syscode);
        return SUCCESS_TIP;
    }

    /**
     * 删除系统编码
     *
     * @author fengshuonan
     * @Date 2018/12/23 4:57 PM
     */
    @BussinessLog(value = "删除系统编码", key = "syscodeId", dict = SysCodeDict.class)
    @RequestMapping(value = "/delete")
    @Permission
    @ResponseBody
    public ResponseData delete(@RequestParam Long syscodeId) {

        //缓存被删除的系统编码名称
        LogObjectHolder.me().set(ConstantFactory.me().getSimpleName(syscodeId));

        syscodeService.deleteSysCode(syscodeId);

        return SUCCESS_TIP;
    }

}
