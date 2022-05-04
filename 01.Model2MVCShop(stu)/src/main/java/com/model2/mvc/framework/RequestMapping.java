package com.model2.mvc.framework;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class RequestMapping {
	
	private static RequestMapping requestMapping;
	private Map<String, Action> map;
	private Properties properties;  //properties ���� actionmapping.properties �� �ִ� ������ �Ľ��ؼ� �����ִ�. path name(��������DO)�� �ָ� �ش�. action�� �ش�.
	
	private RequestMapping(String resources) { //�λ���� �Ժη� �� ����� private �� 1���� �����Ѵ�.
		map = new HashMap<String, Action>(); //�ڹ�API java.util properties hierarchy ���� map �� Map<Object,Object> key,value ���� �޴´�.
		//���׸��� ������Ʈ �����ϴµ� �װ� Ȯ���ؼ� String �� �����Ѵ�. properties�� Ű,������� String���� �߻�ȭĸ��ȭ�ؼ� �����Ѵ�. �� ���ϸ� �ָ� �Ľ��ؼ� �����Ѵ�.
		InputStream in = null;
		try{
			in = getClass().getClassLoader().getResourceAsStream(resources);
			//in = new FileInputStream(resources); //�̷��� �ص� �Ȱ��� �ٵ� �����߳�..?
			//getClass ���� getResourceAsStream �� �ִٴ°� Ȯ���϶�� ������
			
			properties = new Properties(); //InputStream �� ���� �Ʊ� �� actionmapping.properties �ȿ� �ִ°��� load()�޼ҵ带 �߻��ؼ� ������ ������� ���̴�.
			properties.load(in);//InputStream ���� Ű,����� �Ľ��ؼ� �����ִ�.
		}catch(Exception ex){
			System.out.println(ex);
			throw new RuntimeException("actionmapping.properties ���� �ε� ���� :"  + ex);
		}finally{
			if(in != null){
				try{ in.close(); } catch(Exception ex){}
			}
		}
	}
	
	public synchronized static RequestMapping getInstance(String resources){
		if(requestMapping == null){
			requestMapping = new RequestMapping(resources);
		}
		return requestMapping;
	}
	
	public Action getAction(String path){
		Action action = map.get(path);
		if(action == null){ //properties ���� actionmapping.properties �� �ִ� ������ �Ľ��ؼ� �����ִ�. path name(��������DO)�� �ָ� �ش�. action�� �ش�.
			String className = properties.getProperty(path);
			System.out.println("prop : " + properties);
			System.out.println("path : " + path);			
			System.out.println("className : " + className);
			className = className.trim(); //trim api �� �յ� ������ �ڸ��� ���̴�. 
			try{//String�� ������ �ν��Ͻ��� �����ؾ��Ѵ�. jdbc�� �� oracle.jdbc.driver.oracledriver �ϸ� �ν��Ͻ� ���������.
				Class c = Class.forName(className); // Class.forName�� jdbc���� �߾���. �ν��Ͻ��� ���������. Class.forName ���� �ν��Ͻ������ϸ� api�� �о�� �ν��Ͻ��� ���� �����ؾ��Ѵ�.
				Object obj = c.newInstance(); //�ν��Ͻ��� �����ؼ�(��ü����) map�� ����ִ´�. ó���� request�� �� map�� ��ü�� �߰��ǰ� �׼Ǹ���� metadata�� ���� �ȸ�������ϱ� �� �����´�.
				if(obj instanceof Action){ //instanceof (�ڵ��� ���ϴ� ����)
					map.put(path, (Action)obj);
					action = (Action)obj;
				}else{
					throw new ClassCastException("Class����ȯ�� ���� �߻�  ");
				}
			}catch(Exception ex){
				System.out.println(ex);
				throw new RuntimeException("Action������ ���ϴ� ���� ���� �߻� : " + ex);
			}
		}
		return action;
	}
}