package com.ap.bankApplication.Configure;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.MySQL57Dialect;

import com.ap.bankApplication.model.Account;

public class HbUtil {

	
	private static SessionFactory sf ;
	
	public static SessionFactory getSessionFactory()
	{
		Map<String,String> map = new HashMap<String,String>();
		
		map.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
		map.put(Environment.URL, "jdbc:mysql://localHost:3306/bankapplication");
		map.put(Environment.USER, "root");
		map.put(Environment.PASS,"root");
		
		
		map.put(Environment.DIALECT,"org.hibernate.dialect.MySQL57Dialect");
		map.put(Environment.HBM2DDL_AUTO,"update");
		map.put(Environment.SHOW_SQL, "false");
		map.put(Environment.FORMAT_SQL,"false");
		
		
		StandardServiceRegistry rg = new StandardServiceRegistryBuilder().applySettings(map).build();
		
		MetadataSources mds = new MetadataSources(rg);
		
		mds.addAnnotatedClass(Account.class);
		
		Metadata md = mds.getMetadataBuilder().build();
		
		 sf = md.getSessionFactoryBuilder().build();
		
		 return sf;
		
	}
	
	
	
}
