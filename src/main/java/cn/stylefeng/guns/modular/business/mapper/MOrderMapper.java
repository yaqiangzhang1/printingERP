package cn.stylefeng.guns.modular.business.mapper;

import cn.stylefeng.guns.modular.business.entity.MOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 * 订单信息 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
public interface MOrderMapper extends BaseMapper<MOrder> {

    /**
     * 根据条件查询客户档案列表
     */
    Page<Map<String, Object>> selectMOrder(@Param("page") Page page,  @Param("searchType") String searchType, @Param("search") String search);

//    /**
//     * 通过客户名称获取客户
//     */
//    Customer getBycName(@Param("cName") String cName);


}
