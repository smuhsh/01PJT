package com.model2.mvc.framework;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class RequestMapping {
	
	private static RequestMapping requestMapping;
	private Map<String, Action> map;
	private Properties properties;  //properties 에서 actionmapping.properties 에 있는 정보를 파싱해서 갖고있다. path name(무슨무슨DO)을 주면 준다. action을 준다.
	
	private RequestMapping(String resources) { //인사부장 함부로 못 만들게 private 로 1개만 생성한다.
		map = new HashMap<String, Action>(); //자바API java.util properties hierarchy 보면 map 은 Map<Object,Object> key,value 으로 받는다.
		//제네릭이 오브젝트 관리하는데 그걸 확장해서 String 만 관리한다. properties는 키,밸류값을 String으로 추상화캡슐화해서 관리한다. 그 파일만 주면 파싱해서 관리한다.
		InputStream in = null;
		try{
			in = getClass().getClassLoader().getResourceAsStream(resources);
			//in = new FileInputStream(resources); //이렇게 해도 똑같다 근데 에러뜨네..?
			//getClass 가서 getResourceAsStream 도 있다는걸 확인하라는 취지임
			
			properties = new Properties(); //InputStream 을 만들어서 아까 그 actionmapping.properties 안에 있는것을 load()메소드를 발생해서 가지고 있으라는 뜻이다.
			properties.load(in);//InputStream 에서 키,밸류를 파싱해서 갖고있다.
		}catch(Exception ex){
			System.out.println(ex);
			throw new RuntimeException("actionmapping.properties 파일 로딩 실패 :"  + ex);
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
		if(action == null){ //properties 에서 actionmapping.properties 에 있는 정보를 파싱해서 갖고있다. path name(무슨무슨DO)을 주면 준다. action을 준다.
			String className = properties.getProperty(path);
			System.out.println("prop : " + properties);
			System.out.println("path : " + path);			
			System.out.println("className : " + className);
			className = className.trim(); //trim api 는 앞뒤 공백을 자르는 것이다. 
			try{//String을 쓰려면 인스턴스를 생성해야한다. jdbc할 때 oracle.jdbc.driver.oracledriver 하면 인스턴스 생성해줬다.
				Class c = Class.forName(className); // Class.forName은 jdbc에서 했었다. 인스턴스를 생성해줬다. Class.forName 으로 인스턴스생성하면 api를 읽어보면 인스턴스를 직접 생성해야한다.
				Object obj = c.newInstance(); //인스턴스를 생성해서(객체생성) map에 집어넣는다. 처음에 request할 때 map에 객체가 추가되고 액션만들고 metadata에 들어가면 안만들었으니까 또 가져온다.
				if(obj instanceof Action){ //instanceof (핸드폰 비교하는 과제)
					map.put(path, (Action)obj);
					action = (Action)obj;
				}else{
					throw new ClassCastException("Class형변환시 오류 발생  ");
				}
			}catch(Exception ex){
				System.out.println(ex);
				throw new RuntimeException("Action정보를 구하는 도중 오류 발생 : " + ex);
			}
		}
		return action;
	}
}