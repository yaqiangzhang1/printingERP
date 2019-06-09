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
package cn.stylefeng.guns.core.common.constant.dictmap;

import cn.stylefeng.guns.core.common.constant.dictmap.base.AbstractDictMap;

/**
 * 客户的字典
 *
 * @author fengshuonan
 * @date 2017-05-06 15:01
 */
public class CustomerDict extends AbstractDictMap {

    @Override
    public void init() {
        put("cNumber", "客户编号");
        put("cName", "客户名称");
        put("cTrade", "所属行业");
        put("cNature", "客户性质");
        put("cSource", "客户来源");
        put("cType", "客户类型");
        put("cRegion", "地区");
        put("salesman", "业务员");
        put("address", "地址");
        put("discount", "报价折扣");
        put("remarks", "备注");
        put("contacts", "联系人");
        put("phone", "联系电话");
    }

    @Override
    protected void initBeWrapped() {
//        putFieldWrapperMethodName("sex", "getSexName");
//        putFieldWrapperMethodName("deptId", "getDeptName");
//        putFieldWrapperMethodName("roleId", "getSingleRoleName");
//        putFieldWrapperMethodName("userId", "getUserAccountById");
//        putFieldWrapperMethodName("roleIds", "getRoleName");
    }
}
