package com.hufei.framework.parse;

import com.hufei.framework.util.XmlBean;

import java.io.InputStream;

/**
 * <p>  </p>
 * @author hufei
 * @date 2022/7/17 19:23
*/
public class ParseXml extends ParseFile{
    @Override
    public void load(InputStream is) throws Exception {
        System.out.println("加载XML文件");
        XmlBean.load(is);
    }
}
