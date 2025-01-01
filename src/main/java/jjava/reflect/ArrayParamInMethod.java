package jjava.reflect;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ArrayParamInMethod {
    public   void print(String[] strs) {
	  System.out.println(Arrays.toString(strs));
    }
    public void myfun(Object[] args){
	  System.out.println("公共方法："+Arrays.toString(args));
    }
    private void myfun2(Object[] args){
	  System.out.println("私有方法："+Arrays.toString(args));
    }

    /**
     * 执行指定类的带参方法
     * @param ClassName 相对路径类名
     * @param MethodName 方法名
     * @param args 数组Object[]
     * @param privacy 是否私有方法
     * @throws Exception
     */
    public static void refrectMethod(String ClassName,String MethodName,Object[] args,boolean privacy)throws Exception{
	  Class<?> myclass = Class.forName(ClassName);
	  Method myMethod;
	  if(privacy){//私有方法
		myMethod = myclass.getDeclaredMethod(MethodName,args.getClass());
		myMethod.setAccessible(true);
	  }else{//公共方法
		myMethod =  myclass.getMethod(MethodName,args.getClass());
	  }
	  Object obj = myclass.newInstance();
	  myMethod.invoke(obj,(Object)args);//数组参数要强转为Object类型
    }

    public static void main(String[] args) throws Exception{
	  try {
//	      Class[] paramType = String[].class.getClasses();
//		System.out.println(paramType);
	      String[] strs = {"1","2"};
//		System.out.println(strs.getClass());
		Method method = ArrayParamInMethod.class.getMethod("print",String[].class);
		method.invoke(new ArrayParamInMethod(),(Object) strs);
	  } catch (Exception e) {
	      e.printStackTrace();
	  }
//	  refrectMethod("jjava.reflect.ArrayParamInMethod","myfun",new Object[]{"jhjhf",12,2.2},false);
//	  refrectMethod("jjava.reflect.ArrayParamInMethod","myfun2",new Object[]{"adf",23,2.3},true);
    }
}
