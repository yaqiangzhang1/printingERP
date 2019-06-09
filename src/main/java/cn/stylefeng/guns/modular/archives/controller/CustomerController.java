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

import cn.hutool.core.collection.CollectionUtil;
import cn.stylefeng.guns.config.properties.GunsProperties;
import cn.stylefeng.guns.core.common.annotion.BussinessLog;
import cn.stylefeng.guns.core.common.annotion.Permission;
import cn.stylefeng.guns.core.common.constant.Const;
import cn.stylefeng.guns.core.common.constant.dictmap.CustomerDict;
import cn.stylefeng.guns.core.common.constant.dictmap.UserDict;
import cn.stylefeng.guns.core.common.constant.factory.ConstantFactory;
import cn.stylefeng.guns.core.common.constant.state.ManagerStatus;
import cn.stylefeng.guns.core.common.exception.BizExceptionEnum;
import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import cn.stylefeng.guns.core.shiro.ShiroKit;
import cn.stylefeng.guns.modular.archives.entity.Customer;
import cn.stylefeng.guns.modular.archives.service.CustomerService;
import cn.stylefeng.guns.modular.archives.warpper.CustomerWrapper;
import cn.stylefeng.guns.modular.system.entity.User;
import cn.stylefeng.guns.modular.system.factory.UserFactory;
import cn.stylefeng.guns.modular.system.model.UserDto;
import cn.stylefeng.guns.modular.system.service.DictService;
import cn.stylefeng.guns.modular.system.service.UserService;
import cn.stylefeng.guns.modular.system.warpper.UserWrapper;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.datascope.DataScope;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.RequestEmptyException;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 客户档案控制器
 *
 * @author fengshuonan
 * @Date 2017年1月11日 下午1:08:17
 */
@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController {

    private static String PREFIX = "/modular/archives/customer/";

    @Autowired
    private GunsProperties gunsProperties;

    @Autowired
    private CustomerService customerService;
    @Autowired
    private DictService dictService;

    /**
     * 跳转到查看客户档案列表的页面
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:43
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "customer.html";
    }

    /**
     * 跳转到查看管理员列表的页面
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:43
     */
    @RequestMapping("/customer_add")
    public String addView(Model model) {
        model.addAttribute("Nature",dictService.getDictByTypeName("C_Nature"));
        model.addAttribute("Trade",dictService.getDictByTypeName("C_Trade"));
        model.addAttribute("Source",dictService.getDictByTypeName("C_Source"));
        model.addAttribute("Type",dictService.getDictByTypeName("C_Type"));
        model.addAttribute("Region",dictService.getDictByTypeName("C_Region"));
        return PREFIX + "customer_add.html";
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
//    /**
//     * 跳转到编辑管理员页面
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:43
//     */
//    @Permission
//    @RequestMapping("/user_edit")
//    public String userEdit(@RequestParam Long userId) {
//        if (ToolUtil.isEmpty(userId)) {
//            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
//        }
//        User user = this.userService.getById(userId);
//        LogObjectHolder.me().set(user);
//        return PREFIX + "customer_edit.html";
//    }
//
//    /**
//     * 获取用户详情
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:43
//     */
//    @RequestMapping("/getUserInfo")
//    @ResponseBody
//    public Object getUserInfo(@RequestParam Long userId) {
//        if (ToolUtil.isEmpty(userId)) {
//            throw new RequestEmptyException();
//        }
//
//        this.userService.assertAuth(userId);
//        User user = this.userService.getById(userId);
//        Map<String, Object> map = UserFactory.removeUnSafeFields(user);
//
//        HashMap<Object, Object> hashMap = CollectionUtil.newHashMap();
//        hashMap.putAll(map);
//        hashMap.put("roleName", ConstantFactory.me().getRoleName(user.getRoleId()));
//        hashMap.put("deptName", ConstantFactory.me().getDeptName(user.getDeptId()));
//
//        return ResponseData.success(hashMap);
//    }
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
     * 查询管理员列表
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:43
     */
    @RequestMapping("/list")
    @Permission
    @ResponseBody
    public Object list(@RequestParam(required = false) String searchType,@RequestParam(required = false) String search) {
        Page<Map<String, Object>> customers = customerService.selectCustomer(searchType,search);
        Page wrapped = new CustomerWrapper(customers).wrap();
        return LayuiPageFactory.createPageInfo(wrapped);
    }

    /**
     * 添加客户档案
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:44
     */
    @RequestMapping("/add")
    @BussinessLog(value = "添加客户档案", key = "", dict = CustomerDict.class)
    @Permission
    @ResponseBody
    public ResponseData add(Customer customer) {
        Calendar calendar = Calendar.getInstance();
        String createTime = calendar.getTimeInMillis()+"";
        customer.setcNumber("KH-"+createTime.substring(createTime.length()-8,createTime.length()));
        System.out.println(customer.toString());
        this.customerService.addCustomer(customer);
        return SUCCESS_TIP;
    }
//
//    /**
//     * 修改管理员
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:44
//     */
//    @RequestMapping("/edit")
//    @BussinessLog(value = "修改管理员", key = "account", dict = UserDict.class)
//    @ResponseBody
//    public ResponseData edit(@Valid UserDto user, BindingResult result) {
//        if (result.hasErrors()) {
//            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
//        }
//        this.userService.editUser(user);
//        return SUCCESS_TIP;
//    }
//
//    /**
//     * 删除管理员（逻辑删除）
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:44
//     */
//    @RequestMapping("/delete")
//    @BussinessLog(value = "删除管理员", key = "userId", dict = UserDict.class)
//    @Permission
//    @ResponseBody
//    public ResponseData delete(@RequestParam Long userId) {
//        if (ToolUtil.isEmpty(userId)) {
//            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
//        }
//        this.userService.deleteUser(userId);
//        return SUCCESS_TIP;
//    }
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
