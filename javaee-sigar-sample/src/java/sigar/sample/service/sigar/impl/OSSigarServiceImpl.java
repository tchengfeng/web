package java.sigar.sample.service.sigar.impl;

import org.hyperic.sigar.SigarException;

import com.tech.sigar.service.sigar.IOSSigarService;

import java.util.List;
import java.util.Map;

/**
 * Created by BinZ on 2016/8/23.
 */
public class OSSigarServiceImpl implements IOSSigarService {

    private static volatile IOSSigarService osService = null;

    public static IOSSigarService getInstance() {
        if (null == osService) {
            synchronized (OSSigarServiceImpl.class) {
                if (null == osService) {
                    osService = new OSSigarServiceImpl();
                }
            }
        }
        return osService;
    }

    @Override
    public List<Double> getTotalCPUUsage() throws SigarException {
        return CPUUtils.getInstance().getTotalCPUUsage();
    }

    @Override
    public Map<String, Object> getDiskUsage() throws SigarException {
        return DiskUtils.getInstance().getDiskUsage();
    }

    @Override
    public Double getTotalMemUsedPercent() throws SigarException {
        return MemoryUtils.getInstance().getTotalMemUsedPercent();
    }
}
