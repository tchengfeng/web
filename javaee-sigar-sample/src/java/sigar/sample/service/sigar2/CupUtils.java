package java.sigar.sample.service.sigar2;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

/**
 * Created by tongchengfeng on 2016/10/25.
 */
public class CupUtils {

	public void cupFunc() throws SigarException {

		// 获取Sigar实例
		Sigar sigar = new Sigar();

		// CPU数量（单位：个）
		int cpuLength = sigar.getCpuInfoList().length;
		System.out.println(cpuLength);

		// CPU的总量（单位：HZ）及CPU的相关信息
		CpuInfo infos[] = sigar.getCpuInfoList();
		for (int i = 0; i < infos.length; i++) {// 不管是单块CPU还是多CPU都适用
			CpuInfo info = infos[i];
			System.out.println("mhz=" + info.getMhz());// CPU的总量MHz
			System.out.println("vendor=" + info.getVendor());// 获得CPU的卖主，如：Intel
			System.out.println("model=" + info.getModel());// 获得CPU的类别，如：Celeron
			System.out.println("cache size=" + info.getCacheSize());// 缓冲存储器数量
		}

		/** CPU的用户使用量、系统使用剩余量、总的剩余量、总的使用占用量等（单位：100%） **/
		// 方式一，主要是针对一块CPU的情况
		CpuPerc cpu;
		try {
			cpu = sigar.getCpuPerc();
			System.out.println(cpu);
		} catch (SigarException e) {
			e.printStackTrace();
		}

		// 方式二，不管是单块CPU还是多CPU都适用
		CpuPerc cpuList[] = null;
		try {
			cpuList = sigar.getCpuPercList();
		} catch (SigarException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < cpuList.length; i++) {
			System.out.println(cpuList[i]);
		}

	}

}
