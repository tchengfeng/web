
package java.sigar.sample.service.sigar;

import org.hyperic.sigar.SigarException;

import java.util.List;
import java.util.Map;

/**
 * Created by BinZ on 2016/8/23.
 */
public interface IOSSigarService {

    /**
     * 获取所有cpu的使用率
     *
     * @return 当前系统的所有cpu使用率
     * @throws SigarException 操作异常
     */
    List<Double> getTotalCPUUsage() throws SigarException;

    /**
     * 获取硬盘使用情况
     *
     * @return map key:allUsePercent表示总的硬盘使用率，maxDirName表示最大硬盘使用率的盘符，maxUsePercent表示最大硬盘使用率
     * @throws SigarException 操作cpu异常
     */
    Map<String, Object> getDiskUsage() throws SigarException;

    /**
     * 获取总的内存使用百分比
     *
     * @return null表示获取失败
     * @throws SigarException jar包操作获取内存异常
     */
    Double getTotalMemUsedPercent() throws SigarException;
}
