package cn.stylefeng.guns.modular.archives.service;

import cn.stylefeng.guns.core.common.exception.BizExceptionEnum;
import cn.stylefeng.guns.core.common.node.TreeviewNode;
import cn.stylefeng.guns.core.common.node.ZTreeNode;
import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.modular.archives.entity.SysCode;
import cn.stylefeng.guns.modular.archives.mapper.SysCodeMapper;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统编码表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
@Service
public class SysCodeService extends ServiceImpl<SysCodeMapper, SysCode> {

    @Resource
    private cn.stylefeng.guns.modular.archives.mapper.SysCodeMapper SysCodeMapper;

    /**
     * 新增系统编码
     *
     * @author fengshuonan
     * @Date 2018/12/23 5:00 PM
     */
    @Transactional(rollbackFor = Exception.class)
    public void addSysCode(SysCode sysCode) {

        if (ToolUtil.isOneEmpty(sysCode, sysCode.getSimpleName(), sysCode.getPid())) {
            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
        }

        //完善pids,根据pid拿到pid的pids
        //this.SysCodeSetPids(SysCode);
        System.out.println(sysCode.toString());
        this.save(sysCode);
    }

    /**
     * 修改系统编码
     *
     * @author fengshuonan
     * @Date 2018/12/23 5:00 PM
     */
    @Transactional(rollbackFor = Exception.class)
    public void editSysCode(SysCode SysCode) {
        System.out.println(SysCode.toString());
        if (ToolUtil.isOneEmpty(SysCode)) {
            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
        }

        //完善pids,根据pid拿到pid的pids
        //this.SysCodeSetPids(SysCode);

        this.updateById(SysCode);
    }

    /**
     * 删除部门
     *
     * @author fengshuonan
     * @Date 2018/12/23 5:16 PM
     */
    @Transactional
    public void deleteSysCode(Long SysCodeId) {
        SysCode SysCode = SysCodeMapper.selectById(SysCodeId);

        //根据like查询删除所有级联的部门
        List<SysCode> subSysCodes = SysCodeMapper.likePids(SysCode.getCodeId());

        for (SysCode temp : subSysCodes) {
            this.removeById(temp.getCodeId());
        }

        this.removeById(SysCode.getCodeId());
    }

    /**
     * 获取ztree的节点列表
     *
     * @author fengshuonan
     * @Date 2018/12/23 5:16 PM
     */
    public List<ZTreeNode> tree() {
        return this.baseMapper.tree();
    }

    /**
     * 获取ztree的节点列表
     *
     * @author fengshuonan
     * @Date 2018/12/23 5:16 PM
     */
    public List<TreeviewNode> treeviewNodes() {
        return this.baseMapper.treeviewNodes();
    }

    /**
     * 获取所有部门列表
     *
     * @author fengshuonan
     * @Date 2018/12/23 5:16 PM
     */
    public Page<Map<String, Object>> list(String condition, Long SysCodeId) {
        Page page = LayuiPageFactory.defaultPage();
        return this.baseMapper.list(page, condition, SysCodeId);
    }

    /**
     * 设置部门的父级ids
     *
     * @author fengshuonan
     * @Date 2018/12/23 4:58 PM
     */
//    private void SysCodeSetPids(SysCode SysCode) {
//        if (ToolUtil.isEmpty(SysCode.getPid()) || SysCode.getPid().equals(0L)) {
//            SysCode.setPid(0L);
//            SysCode.setPids("[0],");
//        } else {
//            Long pid = SysCode.getPid();
//            SysCode temp = this.getById(pid);
//            String pids = temp.getPids();
//            SysCode.setPid(pid);
//            SysCode.setPids(pids + "[" + pid + "],");
//        }
//    }
}
