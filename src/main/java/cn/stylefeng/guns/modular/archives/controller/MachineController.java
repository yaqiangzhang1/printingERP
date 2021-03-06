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

import cn.stylefeng.guns.config.properties.GunsProperties;
import cn.stylefeng.guns.core.common.annotion.Permission;
import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.modular.archives.entity.Machine;
import cn.stylefeng.guns.modular.archives.entity.Materiel;
import cn.stylefeng.guns.modular.archives.service.MachineService;
import cn.stylefeng.guns.modular.archives.service.MaterielService;
import cn.stylefeng.guns.modular.archives.warpper.MaterielWrapper;
import cn.stylefeng.guns.modular.system.service.DictService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;
import java.util.Map;

/**
 * 设备档案控制器
 *
 * @author fengshuonan
 * @Date 2017年1月11日 下午1:08:17
 */
@Controller
@RequestMapping("/machine")
public class MachineController extends BaseController {

    private static String PREFIX = "/modular/archives/machine/";

    @Autowired
    private GunsProperties gunsProperties;

    @Autowired
    private MachineService machineService;
    @Autowired
    private DictService dictService;

    /**
     * 跳转到查看设备档案列表的页面
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:43
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "machine.html";
    }


    /**
     * 查询设备列表
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:43
     */
    @RequestMapping("/list")
    @Permission
    @ResponseBody
    public Object list(@RequestParam(required = false) String searchType,@RequestParam(required = false) String search) {
        Page<Map<String, Object>> machine = machineService.selectMachine(searchType,search);
        Page wrapped = new MaterielWrapper(machine).wrap();
        return LayuiPageFactory.createPageInfo(wrapped);
    }


    /**
     * 跳转到增加设备的页面
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:43
     */
    @RequestMapping("/machine_add")
    public String addView() {
        return PREFIX + "machine_add.html";
    }

    /**
     * 添加物料档案
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:44
     */
    @RequestMapping("/add")
    //@BussinessLog(value = "添加客户档案", key = "", dict = CustomerDict.class)
    @Permission
    @ResponseBody
    public ResponseData add(Machine machine) {
        Calendar calendar = Calendar.getInstance();
        String createTime = calendar.getTimeInMillis()+"";
        machine.setStatus("ENABLE");
        machine.setMcNumber("SB-"+createTime.substring(createTime.length()-8,createTime.length()));
        System.out.println(machine.toString());
        this.machineService.addCustomer(machine);
        return SUCCESS_TIP;
    }


    /**
     * 跳转到编辑设备页面
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:43
     */
    @RequestMapping("/to_machine_edit")
    public String materielEdit() {
        return PREFIX + "machine_edit.html";
    }

    /**
     * 跳转到设备详情页面
     *
     * @author zls
     * @Date
     */
    @RequestMapping("/to_machine_info")
    public String materielInfo() {
        return PREFIX + "machine_info.html";
    }

    /**
     * 获取设备详情
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:43
     */
    @RequestMapping("/machine_detail")
    @ResponseBody
    public ResponseData getmachine(@RequestParam String mcNumber) {
        return ResponseData.success(machineService.getBymcNumber(mcNumber));
    }


    /**
     * 修改物料档案
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:44
     */
    @RequestMapping("/machine_edit")
    //@BussinessLog(value = "修改管理员", key = "account", dict = UserDict.class)
    @ResponseBody
    public ResponseData edit(Machine machine) {
       this.machineService.updateById(machine);
        return SUCCESS_TIP;
    }

    /**
     * 删除设备档案
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:44
     */
    @RequestMapping("/machine_delete")
    //@BussinessLog(value = "删除管理员", key = "userId", dict = UserDict.class)
    //@Permission
    @ResponseBody
    public ResponseData delete(Machine machine) {
        machine.setStatus("DELETED");
        this.machineService.updateById(machine);
        return SUCCESS_TIP;
    }

}
