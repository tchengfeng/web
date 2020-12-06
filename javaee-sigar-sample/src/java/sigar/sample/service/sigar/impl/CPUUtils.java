package java.sigar.sample.service.sigar.impl;

import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BinZ on 2016/8/22.
 */
class CPUUtils{
    private Sigar sigar = new Sigar();

    private static volatile CPUUtils cpuUtils = null;

    private CPUUtils() {
    }

    public static CPUUtils getInstance() {
        if (null == cpuUtils) {
            synchronized (CPUUtils.class) {
                if (null == cpuUtils) {
                    cpuUtils = new CPUUtils();
                }
            }
        }
        return cpuUtils;
    }

    /**
     * 获取总的CPU使用量
     *
     * @return 如果isEmpty表示没有获取到任一CPU信息，List中的Double对象为null表示没有获取到该CPU的使用率
     * @throws SigarException 操作cpu异常
     */
    public List<Double> getTotalCPUUsage() throws SigarException {
        List<Double> resultLt = new ArrayList<Double>();
        if (null != sigar) {
            CpuPerc[] infoArray = sigar.getCpuPercList();
            if (null != infoArray && 0 < infoArray.length) {
                for (int i = 0; i < infoArray.length; i++) {
                    CpuPerc cpuPerc = infoArray[i];
                    if (null != cpuPerc) {
                        resultLt.add(cpuPerc.getCombined());
                    } else {
                        resultLt.add(null);
                    }
                }
            }
        }
        return resultLt;
    }
}
