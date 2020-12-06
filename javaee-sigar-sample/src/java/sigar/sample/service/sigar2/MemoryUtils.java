package java.sigar.sample.service.sigar2;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;

public class MemoryUtils {

	public void memFunc() throws SigarException {

		// 获取Sigar实例
		Sigar sigar = new Sigar();

		// 物理内存信息
		Mem mem = sigar.getMem();
		// 内存总量
		System.out.println("Total = " + mem.getTotal() / 1024L / 1024 + "M av");
		// 当前内存使用量
		System.out.println("Used = " + mem.getUsed() / 1024L / 1024 + "M used");
		// 当前内存剩余量
		System.out.println("Free = " + mem.getFree() / 1024L / 1024 + "M free");

		// 系统页面文件交换区信息
		Swap swap = sigar.getSwap();
		// 交换区总量
		System.out.println("Total = " + swap.getTotal() / 1024L + "K av");
		// 当前交换区使用量
		System.out.println("Used = " + swap.getUsed() / 1024L + "K used");
		// 当前交换区剩余量
		System.out.println("Free = " + swap.getFree() / 1024L + "K free");

	}

}
