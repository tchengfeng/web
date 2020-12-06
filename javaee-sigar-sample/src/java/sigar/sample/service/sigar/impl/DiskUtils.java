package java.sigar.sample.service.sigar.impl;

import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import com.tech.sigar.common.Constants;

import java.util.HashMap;
import java.util.Map;

import org.hyperic.sigar.OperatingSystem;

/**
 * Created by BinZ on 2016/8/22.
 */
class DiskUtils{
    private Sigar sigar = new Sigar();

    private static volatile DiskUtils diskUtils = null;

    private DiskUtils() {
    }

    public static DiskUtils getInstance() {
        if (null == diskUtils) {
            synchronized (DiskUtils.class) {
                if (null == diskUtils) {
                    diskUtils = new DiskUtils();
                }
            }
        }
        return diskUtils;
    }

    /**
     * 获取硬盘使用情况
     *
     * @return map key:allUsePercent表示总的硬盘使用率，maxDirName表示最大硬盘使用率的盘符，maxUsePercent表示最大硬盘使用率
     * @throws SigarException 操作cpu异常
     */
    public Map<String, Object> getDiskUsage() throws SigarException {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if (null != sigar) {
            FileSystem[] fileSystems = sigar.getFileSystemList();
            OperatingSystem.getInstance().getCpuEndian();
            if (null != fileSystems) {
                FileSystem fileSystem = null;
                String maxDirName = null;
                double maxUsePercent = 0.00D;
                double total = 0;
                double used = 0;
                for (int i = 0; i < fileSystems.length; i++) {
                    fileSystem = fileSystems[i];
                    if (null != fileSystem && Constants.SIGAR_FILE_SYSTEM_TYPE_LOCAL_DISK == fileSystem.getType()) {
                        FileSystemUsage fsu = sigar.getFileSystemUsage(fileSystem.getDirName());
                        if (null != fsu) {
                            total += fsu.getTotal();
                            used += fsu.getUsed();
                            if (maxUsePercent < fsu.getUsePercent()) {
                                maxUsePercent = fsu.getUsePercent();
                                maxDirName = fileSystem.getDirName();
                            }
                        }
                    }
                }
                if (used > 0) {
                    resultMap.put("allUsePercent", used / total);
                    resultMap.put("maxDirName", maxDirName);
                    resultMap.put("maxUsePercent", maxUsePercent);
                }
            }
        }
        return resultMap;
    }
}
