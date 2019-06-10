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
import cn.stylefeng.guns.core.common.annotion.BussinessLog;
import cn.stylefeng.guns.core.common.annotion.Permission;
import cn.stylefeng.guns.core.common.constant.dictmap.CustomerDict;
import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.modular.archives.entity.Customer;
import cn.stylefeng.guns.modular.archives.entity.Materiel;
import cn.stylefeng.guns.modular.archives.service.CustomerService;
import cn.stylefeng.guns.modular.archives.service.MaterielService;
import cn.stylefeng.guns.modular.archives.warpper.CustomerWrapper;
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
 * 物料档案控制器
 *
 * @author fengshuonan
 * @Date 2017年1月11日 下午1:08:17
 */
@Controller
@RequestMapping("/materiel")
public class MaterielController extends BaseController {

    private static String PREFIX = "/modular/archives/materiel/";

    @Autowired
    private GunsProperties gunsProperties;

    @Autowired
    private MaterielService materielService;
    @Autowired
    private DictService dictService;

    /**
     * 跳转到查看物料档案列表的页面
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:43
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "materiel.html";
    }

    /**
     * 跳转到增加物料的页面
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:43
     */
    @RequestMapping("/materiel_add")
    public String addView(Model model) {
        model.addAttribute("Unit",dictService.getDictByTypeName("Unit"));
        model.addAttribute("M_Type",dictService.getDictByTypeName("M_Type"));
        return PREFIX + "materiel_add.html";
    }

//    /**
//     * 跳转到角色分配页面
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:43
//     */
//    @Permission
//    @RequestMapping("/role_assign")
//    public String roleAssign(@RequestParam Long userId, Model model) {
//        if (ToolUtil.isEmpty(userId)) {
//            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
//        }
//        model.addAttribute("userId", userId);
//        return PREFIX + "user_roleassign.html";
//    }
//
    /**
     * 跳转到编辑物料页面
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:43
     */
    @RequestMapping("/to_materiel_edit")
    public String materielEdit(Model model) {
        model.addAttribute("Unit",dictService.getDictByTypeName("Unit"));
        model.addAttribute("M_Type",dictService.getDictByTypeName("M_Type"));
        return PREFIX + "materiel_edit.html";
    }

    /**
     * 获取物料详情
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:43
     */
    @RequestMapping("/materiel_detail")
    @ResponseBody
    public ResponseData getmateriel(@RequestParam String mNumber) {
        return ResponseData.success(materielService.getByNumber(mNumber));
    }
//
//    /**
//     * 修改当前用户的密码
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:43
//     */
//    @RequestMapping("/changePwd")
//    @ResponseBody
//    public Object changePwd(@RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword) {
//        if (ToolUtil.isOneEmpty(oldPassword, newPassword)) {
//            throw new RequestEmptyException();
//        }
//        this.userService.changePwd(oldPassword, newPassword);
//        return SUCCESS_TIP;
//    }
//
    /**
     * 查询物料列表
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:43
     */
    @RequestMapping("/list")
    @Permission
    @ResponseBody
    public Object list(@RequestParam(required = false) String searchType,@RequestParam(required = false) String search) {
        Page<Map<String, Object>> materiel = materielService.selectMateriel(searchType,search);
        Page wrapped = new MaterielWrapper(materiel).wrap();
        return LayuiPageFactory.createPageInfo(wrapped);
    }

    /**
     * 添加物料档案
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:44
     */
    @RequestMapping("/add")
//    @BussinessLog(value = "添加客户档案", key = "", dict = CustomerDict.class)
    @Permission
    @ResponseBody
    public ResponseData add(Materiel materiel) {
        Calendar calendar = Calendar.getInstance();
        String createTime = calendar.getTimeInMillis()+"";
        materiel.setStatus("ENABLE");
        materiel.setmNumber("WL-"+createTime.substring(createTime.length()-8,createTime.length()));
        System.out.println(materiel.toString());
        this.materielService.addCustomer(materiel);
        return SUCCESS_TIP;
    }

    /**
     * 修改物料档案
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:44
     */
    @RequestMapping("/materiel_edit")
    //@BussinessLog(value = "修改管理员", key = "account", dict = UserDict.class)
    @ResponseBody
    public ResponseData edit(Materiel materiel) {
       this.materielService.updateById(materiel);
        return SUCCESS_TIP;
    }

    /**
     * 删除物料档案
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:44
     */
    @RequestMapping("/materiel_delete")
    //@BussinessLog(value = "删除管理员", key = "userId", dict = UserDict.class)
    //@Permission
    @ResponseBody
    public ResponseData delete(Materiel materiel) {
        System.out.println(materiel);
        materiel.setStatus("DELETED");
        this.materielService.updateById(materiel);
        return SUCCESS_TIP;
    }
//
//    /**
//     * 查看管理员详情
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:44
//     */
//    @RequestMapping("/view/{userId}")
//    @ResponseBody
//    public User view(@PathVariable Long userId) {
//        if (ToolUtil.isEmpty(userId)) {
//            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
//        }
//        this.userService.assertAuth(userId);
//        return this.userService.getById(userId);
//    }
//
//    /**
//     * 重置管理员的密码
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:44
//     */
//    @RequestMapping("/reset")
//    @BussinessLog(value = "重置管理员密码", key = "userId", dict = UserDict.class)
//    //@Permission(Const.ADMIN_NAME)
//    @ResponseBody
//    public ResponseData reset(@RequestParam Long userId) {
//        if (ToolUtil.isEmpty(userId)) {
//            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
//        }
//        this.userService.assertAuth(userId);
//        User user = this.userService.getById(userId);
//        user.setSalt(ShiroKit.getRandomSalt(5));
//        user.setPassword(ShiroKit.md5(Const.DEFAULT_PWD, user.getSalt()));
//        this.userService.updateById(user);
//        return SUCCESS_TIP;
//    }
//
//    /**
//     * 冻结用户
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:44
//     */
//    @RequestMapping("/freeze")
//    @BussinessLog(value = "冻结用户", key = "userId", dict = UserDict.class)
//    //@Permission(Const.ADMIN_NAME)
//    @ResponseBody
//    public ResponseData freeze(@RequestParam Long userId) {
//        if (ToolUtil.isEmpty(userId)) {
//            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
//        }
//        //不能冻结超级管理员
//        if (userId.equals(Const.ADMIN_ID)) {
//            throw new ServiceException(BizExceptionEnum.CANT_FREEZE_ADMIN);
//        }
//        this.userService.assertAuth(userId);
//        this.userService.setStatus(userId, ManagerStatus.FREEZED.getCode());
//        return SUCCESS_TIP;
//    }
//
//    /**
//     * 解除冻结用户
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:44
//     */
//    @RequestMapping("/unfreeze")
//    @BussinessLog(value = "解除冻结用户", key = "userId", dict = UserDict.class)
//    //@Permission(Const.ADMIN_NAME)
//    @ResponseBody
//    public ResponseData unfreeze(@RequestParam Long userId) {
//        if (ToolUtil.isEmpty(userId)) {
//            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
//        }
//        this.userService.assertAuth(userId);
//        this.userService.setStatus(userId, ManagerStatus.OK.getCode());
//        return SUCCESS_TIP;
//    }
//
//    /**
//     * 分配角色
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:44
//     */
//    @RequestMapping("/setRole")
//    @BussinessLog(value = "分配角色", key = "userId,roleIds", dict = UserDict.class)
//    //@Permission(Const.ADMIN_NAME)
//    @ResponseBody
//    public ResponseData setRole(@RequestParam("userId") Long userId, @RequestParam("roleIds") String roleIds) {
//        if (ToolUtil.isOneEmpty(userId, roleIds)) {
//            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
//        }
//        //不能修改超级管理员
//        if (userId.equals(Const.ADMIN_ID)) {
//            throw new ServiceException(BizExceptionEnum.CANT_CHANGE_ADMIN);
//        }
//        this.userService.assertAuth(userId);
//        this.userService.setRoles(userId, roleIds);
//        return SUCCESS_TIP;
//    }
//
//    /**
//     * 上传图片
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:44
//     */
//    @RequestMapping(method = RequestMethod.POST, path = "/upload")
//    @ResponseBody
//    public String upload(@RequestPart("file") MultipartFile picture) {
//
//        String pictureName = UUID.randomUUID().toString() + "." + ToolUtil.getFileSuffix(picture.getOriginalFilename());
//        try {
//            String fileSavePath = gunsProperties.getFileUploadPath();
//            picture.transferTo(new File(fileSavePath + pictureName));
//        } catch (Exception e) {
//            throw new ServiceException(BizExceptionEnum.UPLOAD_ERROR);
//        }
//        return pictureName;
//    }
}
