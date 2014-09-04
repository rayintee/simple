package com.nutz.simple.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.nutz.lang.Streams;

public class CoolHtmlParser {
	public static String DOC_CAT_BLANK = "1"; // 填空题
	public static String DOC_CAT_YESNO = "2"; // 判断题
	public static String DOC_CAT_MUTI_CHOISE = "3"; // 选择题
	public static String DOC_CAT_CORRECT = "4"; // 改错题
	public static String DOC_CAT_CHOOSE_WORDS = "5"; // 选词组词
	public static String DOC_CAT_CONNECT_WORDS = "6"; // 连词成句
	public static String DOC_CAT_MEM_WRITE = "7"; // 默写题
	public static String DOC_CAT_READ_WRITE = "8"; // 临摹题

	public void parse(String htmlPath) {
		File f = getFile(htmlPath);

		if (f == null) {
			try {
				throw new FileNotFoundException(".htm文件不存在");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		// start...
		StringBuffer sb = new StringBuffer("");
		Reader reader = Streams.fileInr(f);
		BufferedReader br = new BufferedReader(reader);
		try {

			/**
			 * 规范： 1. sx (x=1-15表示15种题型) 2. _sx/sx_ (表示*大题* 的起始位置/结束位置) 3. sxx
			 * (xx表示大题下面的小题,如:s1x 表示) 4. _sxx/sxx_ (表示*小题* 的起始位置/结束位置)
			 */
			String str = null;
			String score; // 小题分数
			String total; // 本题总分
			String catalog; // 题目类型
			String placeholder; // 占位符
			while ((str = br.readLine()) != null) {
				sb.append(str + "/n");

				// 读到大题题目
				int _s1 = -1;
				if ((_s1 = str.indexOf("<填空题>")) > 0) {
					int s1_ = str.indexOf("</br>");
					str.subSequence(_s1, s1_);
					Pattern p = Pattern.compile("<(\\d*?)>");
					Matcher mat = p.matcher(str);
					if (mat.find()) {
						score = mat.group(1);
					}
					if (mat.find()) {
						total = mat.group(1);
					}

					// ~~~获取的信息是~~~~
					catalog = DOC_CAT_BLANK;
					placeholder = "${square}";
					continue;
				}

				// 读到小题
				if (StringUtils.isNumeric(str.substring(0, 1))) {

				}

				// 读到bd,保存
				// 读到bp,

				System.out.println(str);
			}

			br.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}

		// end...

	}

	private File getFile(String htmlPath) {
		File f = new File(htmlPath);
		if (f.exists() && f.getName().indexOf(".htm") > 0) {
			return f;
		}
		return null;
	}

	public static void main(String[] args) {
		// new
		// CoolHtmlParser().parse("D:/tools/jee-eclipse-keeper/play/angel-example/doc/transferFile/白板语文题库.htm");
		// String regEx = "<a>([\\s\\S]*?)</a>";
		// String regEx = "<(\\d*?)>";
		// String s = "<填空题>（每题<1>分，共<10>分）<br/>";
		// Pattern pat = Pattern.compile(regEx);
		// Matcher mat = pat.matcher(s);
		// boolean rs = mat.find();
		// System.out.println(mat.group(1));
		// mat.find();
		// System.out.println(mat.group(1));
		String str = "8、临摹练习<临摹题>（每题<1>分，共<10>分）<br/>";
		System.out.println(StringUtils.isNumeric(str.substring(0, 1)));

	}
}
