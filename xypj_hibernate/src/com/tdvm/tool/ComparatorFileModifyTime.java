package com.tdvm.tool;

import java.io.File;
import java.util.Comparator;

/**
 * 文件比较器，比较文件的最后修改时�?
 *
 */
public class ComparatorFileModifyTime implements Comparator<File> {

	public int compare(File o1, File o2) {
		Long l = o2.lastModified();
		return l.compareTo(o1.lastModified());
	}

}
