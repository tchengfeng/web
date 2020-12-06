package java.sigar.sample;

import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import com.tech.sigar.service.sigar.impl.OSSigarServiceImpl;

import com.tech.sigar.service.jdk.impl.OSJDKServiceImpl;

import java.net.UnknownHostException;

/**
 * Created by tongchengfeng on 2016/10/25.
 */
public class SigarMain {

    public static final void main(String[] args){
        String str = System.getProperty("java.library.path");
        System.out.println(str);
        try {
            System.out.println("cpuUsage:" + OSSigarServiceImpl.getInstance().getTotalCPUUsage());
            System.out.println("disUsage:" + OSSigarServiceImpl.getInstance().getDiskUsage());
            System.out.println("totalMem:" + OSSigarServiceImpl.getInstance().getTotalMemUsedPercent());
            System.out.println("ips:" + OSJDKServiceImpl.getInstance().getAllIpAddress());

            Sigar sigar = new Sigar();
            System.out.println(sigar.getNetInterfaceConfig().getAddress());

        } catch (SigarException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

