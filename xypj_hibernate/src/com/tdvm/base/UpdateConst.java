package com.tdvm.base;


public interface UpdateConst {

	/**
	 * 系统配置文件路径
	 */
	public static final String CONFIG_XML_PATH = "/WEB-INF/classes/config.xml";

	/**
	 * 页面上下文路�?
	 */
	public static final String VIEW_PATH = "path";
	/**
	 * 日期格式 ：yyyyMM
	 */
	public static final String DATE_FORMAT_YYYYMM = "yyyyMM";
	/**
	 * 日期格式 ：yyyyMMdd
	 */
	public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
	/**
	 * 日期格式 :yyyyMMddHHmmss
	 */
	public static final String DATE_FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	/**
	 * 日期格式 : yyyy-MM-dd HH:mm:ss
	 */
	public static final String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 日期格式 : yyyy-MM-dd 
	 */
	public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

	/**
	 * 请求返回结果 成功
	 */
	public static final String RESULT_BEAN_STATE_PASS = "1";

	/**
	 * 请求返回结果	失败
	 */
	public static final String RESULT_BEAN_STATE_FAIL = "0";

	/**
	 * 系统主页�?
	 */
	public static final String SERVER_MAIN_PAGE = "main/main";

	/**
	 * 登录过滤器免验证后缀
	 */
	public static final String[] NO_LOGIN_EXT = new String[] { ".png", ".jpg", ".css", ".js", ".ftl", ".gif","checkversion.do", "getnewdownloadurl.do", "filedownload.do", "checkserverstate.do","httpupdate.do","iupdateserver","uploadfile.do","createfile.do" };

	public static final String ROOT_URI = "/xypj_hibernate/";
	/**
	 * 登录URL，用于判断是打开登录页面
	 */
	public static final String LOGIN_URI = "/xypj_hibernate/Login/index.do";
	/**
	 * 登录URL,用于未登录时重定�?
	 */
	public static final String LOGIN_URL = "/Login/index.do";

	/**
	 * 登录验证URL，用于跳过session验证
	 */
	public static final String LOGIN_CHECK_URL = "/xypj_hibernate/Login/checkUserInfo.do";
	/**
	 * session中存储的用户信息key
	 */
	public static final String SESSION_USER_NAME = "updateUserSessionInfo";

	/**
	 * 删除标志 删除
	 */
	public static final String DICT_DELETE_YES = "0";

	/**
	 * 删除标志 未删�?
	 */
	public static final String DICT_DELETE_NO = "1";

	/**
	 * 用户类型 管理�?
	 */
	public static final String DICT_USERINFO_TYPE_ADMIN = "0";

	/**
	 * 用户类型 第三方用�?
	 */
	public static final String DICT_USERINF_TYPE_OTHER = "1";

	/**
	 * 系统版本�?
	 */
	public static final String SYSTEM_VERSION = "system_version";

	/**
	 * 系统根路径存储名�?
	 */
	public static final String SYSTEM_ROOT_PATH = "webapp.root";

	/**
	 * 系统用户默认密码
	 */
	public static final String SYSTEM_DEFAULT_PASSWORD = "96e79218965eb72c92a549dd5a330112";

	/**
	 * UTF-8编码
	 */
	public static final String UTF8 = "UTF-8";
	
	/**
	 * 文本
	 */
	public static final String TEXT = "text";
	
	/**
	 * �?
	 */
	public static final String STREAM="stream";
}
