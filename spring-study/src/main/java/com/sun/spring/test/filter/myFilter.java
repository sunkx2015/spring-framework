package com.sun.spring.test.filter;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Set;

/**
 * 测试在扫描路径下需要排除的bean,返回true,spring则不会放到容器
 */
public class myFilter implements TypeFilter {
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
		String str = metadataReader.getClassMetadata().getClassName();
		System.out.println(str);
		return str.toLowerCase().contains("badbean");
	}
	@PostConstruct
	public void init(){
		System.out.println("=============filter scan=============");
	}
}
