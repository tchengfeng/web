package java.sigar.sample.service.sigar.impl;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

/**
 * Created by BinZ on 2016/8/22.
 */
class MemoryUtils{
    private Sigar sigar = new Sigar();

    private static volatile MemoryUtils memoryUtils = null;

    private MemoryUtils() {
    }

    public static MemoryUtils getInstance() {
        if (null == memoryUtils) {
            synchronized (MemoryUtils.class) {
                if (null == memoryUtils) {
                    memoryUtils = new MemoryUtils();
                }
            }
        }
        return memoryUtils;
    }

    /**
     * 获取总的内存使用百分比
     *
     * @return null表示获取失败
     * @throws SigarException jar包操作获取内存异常
     */
    public Double getTotalMemUsedPercent() throws SigarException {
        Double result = null;
        if (null != sigar) {
            Mem mem = sigar.getMem();
            if (null != mem) {
                result = mem.getUsedPercent();
            }
        }
        return result;
    }
}
