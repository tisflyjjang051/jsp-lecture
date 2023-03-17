package com.bunny.model;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {
	private static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			String resource = "com/bunny/mybatis/config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// 싱글턴 패턴 (하나만 생성해서 쓰기)
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
}
