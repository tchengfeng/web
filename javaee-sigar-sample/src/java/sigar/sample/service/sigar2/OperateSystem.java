package java.sigar.sample.service.sigar2;

import java.net.InetAddress;

import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Who;

/**
 * Created by tongchengfeng on 2016/10/25.
 */
public class OperateSystem {
	
	public void operSysFunc() throws SigarException{
		
		// 获取Sigar实例
		Sigar sigar = new Sigar();
		
		String hostname = "abc";
		try {
			hostname = InetAddress.getLocalHost().getHostName();
		} catch (Exception exc) {
			try {
				hostname = sigar.getNetInfo().getHostName();
			} catch (SigarException e) {
				hostname = "localhost.unknown";
			} finally {
				sigar.close();
			}
		}
		
		System.out.println("OS Host name = " + hostname);
		
		// 取当前操作系统的信息
		OperatingSystem OS = OperatingSystem.getInstance();
		
		// 操作系统内核类型如： 386、486、586等x86
		System.out.println("OS.getArch() = " + OS.getArch());
		System.out.println("OS.getCpuEndian() = " + OS.getCpuEndian());
		System.out.println("OS.getDataModel() = " + OS.getDataModel());
		
		// 系统描述
		System.out.println("OS.getDescription() = " + OS.getDescription());
		System.out.println("OS.getMachine() = " + OS.getMachine());
		
		// 操作系统类型
		System.out.println("OS.getName() = " + OS.getName());
		System.out.println("OS.getPatchLevel() = " + OS.getPatchLevel());
		
		// 操作系统的卖主
		System.out.println("OS.getVendor() = " + OS.getVendor());
		
		// 卖主名称
		System.out.println("OS.getVendorCodeName() = " + OS.getVendorCodeName());
		
		// 操作系统名称
		System.out.println("OS.getVendorName() = " + OS.getVendorName());
		
		// 操作系统卖主类型
		System.out.println("OS.getVendorVersion() = " + OS.getVendorVersion());
		
		// 操作系统的版本号
		System.out.println("OS.getVersion() = " + OS.getVersion());

		// 取当前系统进程表中的用户信息
		Who[] who = sigar.getWhoList();
		if (who != null && who.length > 0) {
			for (int i = 0; i < who.length; i++) {
				System.out.println("\n~~~~~~~~~" + String.valueOf(i) + "~~~~~~~~~");
				Who _who = who[i];
				System.out.println("getDevice() = " + _who.getDevice());
				System.out.println("getHost() = " + _who.getHost());
				System.out.println("getTime() = " + _who.getTime());
				
				// 当前系统进程表中的用户名
				System.out.println("getUser() = " + _who.getUser());
			}
		}
	}
	
}
