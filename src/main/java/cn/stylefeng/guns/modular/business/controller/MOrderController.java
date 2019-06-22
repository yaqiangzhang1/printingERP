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
package cn.stylefeng.guns.modular.business.controller;

import cn.stylefeng.guns.core.common.annotion.Permission;
import cn.stylefeng.guns.modular.business.entity.Cost;
import cn.stylefeng.guns.modular.business.service.MOrderService;
import cn.stylefeng.guns.modular.business.warpper.MOrderWrapper;
import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.modular.system.entity.Dict;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 订单管理控制器
 *
 * @author fengshuonan
 * @Date 2017年1月11日 下午1:08:17
 */
@Controller
@RequestMapping("/MOrder")
public class MOrderController extends BaseController {

    private static String PREFIX = "/modular/business/MOrder/";
    @Autowired
    private MOrderService mOrderService;
    @Autowired
    private DictService dictService;


    /**
     * 跳转到查看订单列表的页面
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:43
     */
    @RequestMapping("")
    public String index() {

        return PREFIX + "MOrder.html";
    }

    /**
     * 查询订单列表
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:43
     */
    @RequestMapping("/list")
    @Permission
    @ResponseBody
    public Object list(@RequestParam(required = false) String searchType,@RequestParam(required = false) String search) {
        Page<Map<String, Object>> mOrder = mOrderService.selectMOrder(searchType,search);
//        Page<Map<String, Object>> mOrder = mOrderService.selectrMOrder(searchType,search);
        Page wrapped = new MOrderWrapper(mOrder).wrap();
        return LayuiPageFactory.createPageInfo(wrapped);
    }


    /**
     * 跳转到增加订单的页面
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:43
     */
    @RequestMapping("/MOrder_add")
    public String addView(Model model) {
        model.addAttribute("Nature",dictService.getDictByTypeName("C_Nature"));
        model.addAttribute("Trade",dictService.getDictByTypeName("C_Trade"));
        model.addAttribute("Source",dictService.getDictByTypeName("C_Source"));
        model.addAttribute("Type",dictService.getDictByTypeName("C_Type"));
        model.addAttribute("Region",dictService.getDictByTypeName("C_Region"));
        return PREFIX + "MOrder_add.html";
    }

    /**
     * 跳转到客户详情的页面
     *
     * @author zls
     * @Date
     */
    @RequestMapping("/MOrder_info")
    public String infoView(@RequestParam(required = false) String oNumber,Model model) {
//        model.addAttribute("Nature",dictService.getDictByTypeName("C_Nature"));
//        model.addAttribute("Trade",dictService.getDictByTypeName("C_Trade"));
//        model.addAttribute("Source",dictService.getDictByTypeName("C_Source"));
//        model.addAttribute("Type",dictService.getDictByTypeName("C_Type"));
          List<Cost> listcost = mOrderService.getCostByoNumber(oNumber);
          List list = new ArrayList<>();
          //model.addAttribute("size",dictService.getDictByTypeName("Cost").size()/9+1);
          for(int i=0;i<listcost.size()/9+1;i++){
              List list1 = new ArrayList<>();
              for(int j=i*9;j<i*9+9;j++){
                  if(j==listcost.size()){
                      break;
                  }
                  list1.add(listcost.get(j));
              }
              list.add(list1);
          }
          model.addAttribute("cost",list);
          return PREFIX + "MOrder_info.html";
    }

    /**
     * 获取订单详情
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:43
     */
    @RequestMapping("/MOrder_detail")
    @ResponseBody
    public ResponseData getcustomer(@RequestParam String oNumber) {
        return ResponseData.success(mOrderService.selectMOrderByoNumber(oNumber));
    }
//    /**
//     * 跳转到增加客户档案的页面
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:43
//     */
//    @RequestMapping("/customer_add")
//    public String addView(Model model) {
//        model.addAttribute("Nature",dictService.getDictByTypeName("C_Nature"));
//        model.addAttribute("Trade",dictService.getDictByTypeName("C_Trade"));
//        model.addAttribute("Source",dictService.getDictByTypeName("C_Source"));
//        model.addAttribute("Type",dictService.getDictByTypeName("C_Type"));
//        model.addAttribute("Region",dictService.getDictByTypeName("C_Region"));
//        return PREFIX + "MOrder_add.html";
//    }
//
//    /**
//     * 跳转到客户详情的页面
//     *
//     * @author zls
//     * @Date
//     */
//    @RequestMapping("/customer_info")
//    public String infoView(Model model) {
//        model.addAttribute("Nature",dictService.getDictByTypeName("C_Nature"));
//        model.addAttribute("Trade",dictService.getDictByTypeName("C_Trade"));
//        model.addAttribute("Source",dictService.getDictByTypeName("C_Source"));
//        model.addAttribute("Type",dictService.getDictByTypeName("C_Type"));
//        model.addAttribute("Region",dictService.getDictByTypeName("C_Region"));
//        return PREFIX + "MOrder_info.html";
//    }
//
//
//    /**
//     * 添加客户档案
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:44
//     */
//    @RequestMapping("/add")
//    @BussinessLog(value = "添加客户档案", key = "", dict = CustomerDict.class)
//    @Permission
//    @ResponseBody
//    public ResponseData add(Customer customer) {
//        Calendar calendar = Calendar.getInstance();
//        String createTime = calendar.getTimeInMillis()+"";
//        customer.setStatus("ENABLE");
//        customer.setcNumber("KH-"+createTime.substring(createTime.length()-8,createTime.length()));
//        System.out.println(customer.toString());
//        this.customerService.addCustomer(customer);
//        return SUCCESS_TIP;
//    }
//
//
//    /**
//     * 跳转到编辑客户档案页面
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:43
//     */
//    //@Permission
//    @RequestMapping("/to_customer_edit")
//    public String customerEdit(Model model) {
//        model.addAttribute("Nature",dictService.getDictByTypeName("C_Nature"));
//        model.addAttribute("Trade",dictService.getDictByTypeName("C_Trade"));
//        model.addAttribute("Source",dictService.getDictByTypeName("C_Source"));
//        model.addAttribute("Type",dictService.getDictByTypeName("C_Type"));
//        model.addAttribute("Region",dictService.getDictByTypeName("C_Region"));
//        return PREFIX + "MOrder_edit.html";
//    }
//    /**
//     * 获取客户详情
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:43
//     */
//    @RequestMapping("/customer_detail")
//    @ResponseBody
//    public ResponseData getcustomer(@RequestParam String cNumber) {
//        return ResponseData.success(customerService.getById(cNumber));
//    }
//
//    /**
//     * 修改客户档案
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:44
//     */
//    @RequestMapping("/customer_edit")
//    //@BussinessLog(value = "修改管理员", key = "account", dict = UserDict.class)
//    @ResponseBody
//    public ResponseData edit(Customer customer) {
//        this.customerService.updateById(customer);
//        return SUCCESS_TIP;
//    }
//    /**
//     * 删除设备档案
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:44
//     */
//    @RequestMapping("/customer_delete")
//    //@BussinessLog(value = "删除管理员", key = "userId", dict = UserDict.class)
//    //@Permission
//    @ResponseBody
//    public ResponseData delete(Customer customer) {
//        customer.setStatus("DELETED");
//        this.customerService.updateById(customer);
//        return SUCCESS_TIP;
//    }
}
