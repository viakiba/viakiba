package com.tdvm.tool;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

import com.tdvm.base.UpdateConst;
import com.tdvm.base.UpdateException;
import com.tdvm.bean.PageInfo;


public class HelpFunctions {

	private static Logger log4j = LoggerFactory.getLogger(HelpFunctions.class);

	/**
	 * 固定日期格式
	 */
	private static final String FIX_DATE_FORMAT = "yyyyMMddHHmmss";

	/**
	 * 动�?日期格式默认�?
	 */
	private static final String DYNAMIC_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private static final SimpleDateFormat fix = new SimpleDateFormat(FIX_DATE_FORMAT);

	private static SimpleDateFormat dynamic = new SimpleDateFormat(DYNAMIC_DATE_FORMAT);

	/**
	 * 判断字符串是否为空�?
	 * 
	 * @param str
	 *            字符�?
	 * @return 布尔�?
	 */
	public static final boolean isEmpty(String str) {

		if (str == null || str.length() == 0) {
			return true;
		}
		String tmp = str.trim().toLowerCase();

		if (tmp.length() == 0 || tmp.equals("null")) {

			tmp = null;
			return true;
		}
		tmp = null;

		return false;
	}

	/**
	 * 判断字符串是否为空�?
	 * 
	 * @param str
	 *            字符�?
	 * @return 布尔�?
	 */
	public static final boolean isEmpty(StringBuilder str) {

		if (str == null || str.length() == 0) {
			return true;
		}
		String tmp = str.toString().trim().toLowerCase();

		if (tmp.length() == 0 || tmp.equals("null")) {

			tmp = null;
			return true;
		}
		tmp = null;

		return false;
	}

	/**
	 * 判断数组是否为空�?
	 * 
	 * @param arr
	 * @return
	 */
	public static final boolean isEmpty(Object[] arr) {

		if (arr == null || arr.length == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断列表是否为空�?
	 * 
	 * @param arr
	 * @return
	 */
	public static final boolean isEmpty(List<?> list) {

		if (list == null || list.size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断映射是否为空�?
	 * 
	 * @param arr
	 * @return
	 */
	public static final boolean isEmpty(Map<?, ?> map) {

		if (map == null || map.size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 返回当前时间的字符串表示形式，格式：yyyyMMddHHmmss
	 * 
	 * @return
	 */
	public static String getCurrentDateString() {

		return fix.format(new Date());
	}

	/**
	 * 获取指定�?dateFormat 格式的当前时间的字符串表示形式�?
	 * 
	 * @param dateFormat
	 * @return
	 */
	public static String getCurrentDateString(String dateFormat) {

		String date = null;

		if (isEmpty(dateFormat)) {
			return null;
		}
		try {
			dynamic = new SimpleDateFormat(dateFormat);
		} catch (IllegalArgumentException e) {
			log4j.error("警告！日期格式无效" + dateFormat);
			return null;
		}
		try {
			date = dynamic.format(new Date());
		} catch (IllegalArgumentException e) {
			log4j.error("警告！日期格式无效" + dateFormat);
			return null;
		}

		return date;
	}

	/**
	 * 判断当前系统是否 Windows 操作系统�?
	 * 
	 * @return 布尔�?
	 */
	public static final boolean isWindows() {
		return System.getProperty("os.name").indexOf("Windows") >= 0;
	}

	/**
	 * 判断当前系统是否 Linux 操作系统�?
	 * 
	 * @return 布尔�?
	 */
	public static final boolean isLinux() {
		return System.getProperty("os.name").indexOf("Linux") >= 0;
	}

	/**
	 * 将字符转换为整型数字�?
	 * 
	 * @param value
	 *            字符型整型数�?
	 * @param defaultValue
	 *            转换失败后采用的默认�?
	 * @return
	 */
	public static final int getInt(String value, int defaultValue) {

		try {
			return Integer.valueOf(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * �?��目标URL地址是否可用，限�?秒�?
	 * 
	 * @param urlAddress
	 *            目标地址
	 * @return 布尔�?
	 */
	public static final boolean ping(String urlAddress) {

		URL url = null;
		HttpURLConnection urlConnect = null;
		try {
			url = new URL(urlAddress);
			urlConnect = (HttpURLConnection) url.openConnection();
			urlConnect.setConnectTimeout(3000);
			urlConnect.connect();

			int code = urlConnect.getResponseCode();
			if (code == 200) {
				return true;
			}

		} catch (Exception e) {

		} finally {
			try {
				if (urlConnect != null) {
					urlConnect.disconnect();
				}
				urlConnect = null;
				url = null;
			} catch (Exception e2) {
			}
		}

		return false;
	}

	/**
	 * 去除全部空白字符�?
	 * 
	 * @param str
	 * @return
	 */
	public static final String cutWhiteSpace(String str) {

		if (isEmpty(str)) {
			return null;
		}
		StringBuilder newStr = new StringBuilder();

		for (char c : str.toCharArray()) {
			if (Character.isWhitespace(c)) {
				continue;
			} else {
				newStr.append(c);
			}
		}
		return newStr.toString();
	}

	/**
	 * 压缩数据
	 * 
	 * @param sourceData
	 *            要压缩的字节数组
	 * @return 压缩过的字节数组
	 */
	public static byte[] compressData(byte[] sourceData) {
		if (sourceData == null || sourceData.length <= 0) {
			return null;
		}
		ByteArrayOutputStream bos = null;
		java.util.zip.GZIPOutputStream gzos = null;
		try {
			bos = new ByteArrayOutputStream();
			gzos = new GZIPOutputStream(bos);
			gzos.write(sourceData);
			gzos.close();
		} catch (IOException ex) {
			log4j.error("压缩失败" + ex.getMessage());
			return null;
		}
		return bos.toByteArray();
	}

	/**
	 * 解压缩数�?
	 * 
	 * @param compressData
	 *            解压缩的字节数组
	 * @return 解压后的字节数组
	 */
	public static byte[] unCompressData(byte[] compressData) {
		if (compressData == null || compressData.length <= 0) {
			return null;
		}
		ByteArrayInputStream bis = null;
		ByteArrayOutputStream bos = null;
		java.util.zip.GZIPInputStream gzis = null;
		try {
			bis = new ByteArrayInputStream(compressData);
			bos = new ByteArrayOutputStream();
			gzis = new java.util.zip.GZIPInputStream(bis);
			byte[] tbyte = new byte[1024];
			int flag = -1;
			while ((flag = gzis.read(tbyte, 0, tbyte.length)) != -1) {
				bos.write(tbyte, 0, flag);
			}
		}

		catch (Exception ex) {
			log4j.error("解压失败" + ex.getMessage());
			return null;
		} finally {
			try {
				bis.close();
				gzis.close();
			} catch (IOException ex) {
			}
		}
		return bos.toByteArray();
	}

	/**
	 * 将整数转换为4字节数组�?
	 * 
	 * @param num
	 * @return
	 */
	public static byte[] intToBytes4(int num) {
		byte[] b = new byte[4];
		for (int i = 0; i < 4; i++) {
			b[i] = (byte) (num >> (24 - i * 8));
		}
		return b;
	}

	/**
	 * 将长度为4的字节数组转换为整数�?
	 * 
	 * @param b
	 * @return
	 */
	public static int bytes4ToInt(byte[] b) {
		int mask = 0xff;
		int temp = 0;
		int res = 0;
		for (int i = 0; i < 4; i++) {
			res <<= 8;
			temp = b[i] & mask;
			res |= temp;
		}
		return res;
	}

	/**
	 * 获取字符串MD5
	 * @param str
	 * @return
	 */
	public static String getStringMD5(String str) {

		return DigestUtils.md5DigestAsHex(str.getBytes());
	}

	public static String getID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 比较两个版本
	 * 
	 * @param pver
	 *            前版本号
	 * @param cver
	 *            后版本号
	 * @return 0 代表后版本小于前版本�?代表两版本相等，2代表后版本大于前版本 9 版本号格式错�?
	 * @throws UpdateException 
	 */
	public static int compareVer(String pver, String cver) throws UpdateException {
		try {
			String[] pvarr = pver.split("\\.");
			String[] cvarr = cver.split("\\.");
			int len = cvarr.length > pvarr.length ? pvarr.length : cvarr.length;

			for (int i = 0; i < len; i++) {
				if (Long.parseLong(cvarr[i]) < Long.parseLong(pvarr[i])) {
					return 0;
				} else if (Long.parseLong(cvarr[i]) > Long.parseLong(pvarr[i])) {
					return 2;
				}
			}
			if (cvarr.length > pvarr.length) {
				for (int j = pvarr.length; j < cvarr.length; j++) {
					if (Long.parseLong(cvarr[j]) > 0) {
						return 2;
					}
				}
			} else if (cvarr.length < pvarr.length) {
				for (int j = cvarr.length; j < pvarr.length; j++) {
					if (Long.parseLong(pvarr[j]) > 0) {
						return 0;
					}
				}
			}
		} catch (Exception e) {
			log4j.error("比较版本号出错[" + pver + "][" + cver + "]");
			throw new UpdateException("比较版本号出错");
		}
		return 1;

	}

	/**
	 * 版本号规则验�?
	 * 支持版本号X.X.X_base|X.X.X_alpha|X.X.X_beta|X.X.X_RC|X.X.X_release|X.X.X_rX|X.X.X_aX|X.X.X_bX
	 * 
	 * @param version
	 * @return
	 */
	public static boolean checkVersionInfo(String version) throws UpdateException{
		boolean flag = false;

		return flag;
	}

	public static String getMD5(File file) throws Exception {

		String res = "";
		FileInputStream tempfile = null;
		try {

			tempfile = new FileInputStream(file);
			res = org.apache.commons.codec.digest.DigestUtils.md5Hex(tempfile);

		} catch (Exception e) {
			log4j.error("获取文件MD5值出错：" + e.getMessage(), e);
			throw new Exception("获取文件MD5值出错：" + e.getMessage());

		} finally {
			if (tempfile != null) {
				try {
					tempfile.close();
				} catch (Exception e) {
					log4j.error("关闭文件流出�?" + e.getMessage());
				}
			}
		}
		return res;
	}

	/**
	 * 生成随机�?
	 * @return
	 */
	public static String getFileRandomId() {
		return System.currentTimeMillis() + "" + (int) (Math.random() * 10000);
	}

	public static String getStringNotNull(String str) {
		if (isEmpty(str)) {
			return "";
		}
		return str;
	}

	public static String dateToStr(Date date) {
		String result = "";
		try {

			result = dynamic.format(date);

		} catch (Exception e) {
			log4j.error("日期类型转为字符串出�?" + e.getMessage());
		}
		return result;
	}

	/**
	 * 将字符串转换为yyyy-MM-dd HH:mm:ss格式日期
	 * @param str
	 * @return
	 */
	public static Date strTodate(String str) {

		try {
			return dynamic.parse(str);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 对一个文件数组按照最后修改时间进行排序，�?��修改时间新的排在后面
	 * 
	 * @param files
	 * @return
	 * @throws AppException
	 */
	public static List<File> FileSort(File[] files) throws Exception {

		List<File> list = new ArrayList<File>();
		try {
			for (File file : files) {
				list.add(file);
			}
			if (list.size() > 0) {
				ComparatorFileModifyTime cfmt = new ComparatorFileModifyTime();
				Collections.sort(list, cfmt);
			}
		} catch (Exception e) {
			throw new Exception("对文件进行排序时出错" + e.getMessage());
		}
		return list;
	}

	/**
	 * 计算页数
	 * @param pageSize
	 * @param pageCount
	 * @return
	 */
	public static Integer getPage(Integer pageSize, Integer pageCount) {

		Integer page = 0;

		if (pageCount != 0) {

			page = pageCount / pageSize;
			if (pageCount % pageSize > 0) {
				page++;
			}
		}

		return page;
	}

	public static void initPageInfoStartEnd(PageInfo pageInfo) {

		Integer page = pageInfo.getCurrPage();
		Integer length = pageInfo.getLength();
//		if (page != 1) {
			pageInfo.setStartPage(((page - 1) * pageInfo.getPageSize()));
			pageInfo.setEndPage(page * pageInfo.getPageSize());
			pageInfo.setPageSize(length);
//		}

	}

	public static byte[] FormatNoZipSendData(String str) {
		if (str == null) {
			return null;
		}
		byte[] tbyte = getUTF8Bytes(str);
		byte[] binlen = new byte[tbyte.length + 2];

		binlen[0] = (byte) (tbyte.length >> 8);
		binlen[1] = (byte) tbyte.length;

		System.arraycopy(tbyte, 0, binlen, 2, tbyte.length);
		return binlen;
	}

	public static byte[] getUTF8Bytes(String s) {
		try {
			return s.getBytes(UpdateConst.UTF8);
		} catch (UnsupportedEncodingException e) {
			log4j.error("编码错误" + e.getMessage());
		}
		return null;
	}

	public static byte[] IntToBytes4(int num) {
		byte[] b = new byte[4];
		for (int i = 0; i < 4; i++) {
			b[i] = (byte) (num >> (24 - i * 8));
		}
		return b;
	}

	public static int byte2int(byte byHi, byte byLo) {
		return (byHi & 0xFF) << 8 | (byLo & 0xFF);
	}

	public static int searchString(String[] arr, String val) {

		if (arr == null || val == null) {
			return -1;
		}
		for (int x = 0; x < arr.length; x++) {
			if (arr[x] == null) {
				continue;
			}
			if (arr[x].equalsIgnoreCase(val)) {
				return x;
			}
		}
		return -1;
	}

	/**
	 * 适用于上G大的文件
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String getFileMD5String(String path) {
		String res = "";
		FileInputStream in = null;
		try {

			in = new FileInputStream(new File(path));
			res = org.apache.commons.codec.digest.DigestUtils.md5Hex(in);
		} catch (IOException e) {
			log4j.error("获取MD5值失败：" + e.getMessage());
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					log4j.error("关闭文件流出�?" + e.getMessage());
				}
			}
		}
		return res;
	}
	
	
	/**
	 * 版本号规则验�?p>
	 * 支持版本�?X.X.X_base|X.X.X_alpha|X.X.X_beta|X.X.X_RC|X.X.X_release|X.X.X_rX|X.X.X_aX|X.X.X_bX|VXXX.XXX
	 * 
	 * @param version
	 * @param pversion
	 * @return version大于pversion或两者中任何�?��不符合版本号标准时，返回true
	 */
	public static boolean compareVersionInfo(String version, String pversion) {

		boolean flag = false;

		if (version.equals(pversion)) {
			return false;
		}

		int i = 0;
		try {
			i = compareVer(checkVersion(pversion), checkVersion(version));
		} catch (UpdateException e) {
			log4j.error(e.getMessage(),e);
		}

		if (i == 2 || i == 9) {
			flag = true;
		}

		return flag;

	}
	
	/**
	 * 对版本号按版本号标准进行处理
	 * @param version
	 * @return
	 */
	public static String checkVersion(String version) {

		log4j.debug("版本号处理前:" + version);
		try {
			version = version.toLowerCase();
			if (version.endsWith("_base") || version.endsWith("_alpha") || version.endsWith("_beta")
					|| version.endsWith("_rc") || version.endsWith("_release")) {
				version = version.replace("_base", "").replace("_alpha", "").replace("_beta", "").replace("_rc", "")
						.replace("_release", "");
			}

			version = version.replace("_r", ".").replace("_a", ".").replace("_b", ".").replace("v", "");

		} catch (Exception e) {
			log4j.error("处理版本号错误[" + version + "]:" + e.getMessage());
		}
		log4j.debug("版本号处理后:" + version);

		return version;

	}
	
	/**
	 * �?��版本号是否为数字和英文点的格�?
	 * @param version
	 * @return
	 */
	public static boolean checkVersionInt(String version) {

		log4j.debug("待检测版本号:" + version);
		boolean flag = false;
		try {
			String[] strs = version.split("\\.");

			for (String string : strs) {

				Long.valueOf(string);
			}

			flag = true;
		} catch (Exception e) {
			log4j.error("版本号验证没通过:" + version);
		}

		return flag;
	}
	

}
