/*
 * CVR100DemoView.java
 */
package com.cvr.test;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xvolks.jnative.JNative;
import org.xvolks.jnative.Type;
import org.xvolks.jnative.exceptions.NativeException;
import org.xvolks.jnative.pointers.Pointer;
import org.xvolks.jnative.pointers.memory.MemoryBlockFactory;




/**
 * The application's main frame.
 */
public class CVR100DemoView {

    String strTmp = "";
    int len = 0;
    int ret = 0;


    /**
     * 初始化连接
     * @param Port
     * @return
     * @throws NativeException
     * @throws IllegalAccessException
     * @throws UnsupportedEncodingException
     */
    public  int CVR_InitComm(int Port) throws NativeException, IllegalAccessException, UnsupportedEncodingException
    {
        JNative n = null;
        try
        {
            n = new JNative("Termb.dll", "CVR_InitComm");
            n.setRetVal(Type.INT); // 指定返回参数的类型
            n.setParameter(0, Port);
            n.invoke(); // 调用方法
            return Integer.parseInt(n.getRetVal());
        }
        finally
        {

        }
    }

    /**
     * 卡认证
     * @return
     * @throws NativeException
     * @throws IllegalAccessException
     */
    public  int CVR_Authenticate() throws NativeException, IllegalAccessException
    {
        JNative n = null;
        try
        {
            n = new JNative("Termb.dll", "CVR_Authenticate");
            n.setRetVal(Type.INT); // 指定返回参数的类型
            n.invoke(); // 调用方法
            return Integer.parseInt(n.getRetVal());
        }
        finally
        {

        }
    }

    /**
     * 读卡操作
     * @param Active
     * @return
     * @throws NativeException
     * @throws IllegalAccessException
     */
    public  int CVR_Read_Content(int Active) throws NativeException, IllegalAccessException
    {
        JNative n = null;
        try
        {
            n = new JNative("Termb.dll", "CVR_Read_Content");
            n.setRetVal(Type.INT); // 指定返回参数的类型
            n.setParameter(0, Active);
            n.invoke(); // 调用方法
            return Integer.parseInt(n.getRetVal());
        }
        finally
        {

        }
    }

    /**
     * 关闭连接
     * @return
     * @throws NativeException
     * @throws IllegalAccessException
     */
    public  int CVR_CloseComm() throws NativeException,IllegalAccessException
    {
        JNative n = null;
        try
        {
            n = new JNative("Termb.dll", "CVR_CloseComm");
            n.setRetVal(Type.INT); // 指定返回参数的类型
            n.invoke(); // 调用方法
            return Integer.parseInt(n.getRetVal());
        }
        finally
        {

        }
    }

    /**
     * 获取姓名
     * @return
     * @throws NativeException
     * @throws IllegalAccessException
     */
    public  int GetPeopleName() throws NativeException, IllegalAccessException
    {
        JNative n = null;
        try
        {
            n = new JNative("Termb.dll", "GetPeopleName");
            n.setRetVal(Type.INT); // 指定返回参数的类型
            Pointer a = new Pointer(MemoryBlockFactory.createMemoryBlock(4*10));
            Pointer b = new Pointer(MemoryBlockFactory.createMemoryBlock(4*30));
            n.setParameter(0,b);
            n.setParameter(1,a);
            n.invoke();
            byte[] by = new byte[120];
            by = b.getMemory();
            try
            {
                strTmp = new String(by,"gb2312");
            }
            catch (UnsupportedEncodingException ex)
            {
                Logger.getLogger(CVR100DemoView.class.getName()).log(Level.SEVERE, null, ex);
            }

            byte[] bt = new byte[40];
            bt = a.getMemory();
            len = a.getAsInt(0);
            a.dispose();
            b.dispose();
            return Integer.parseInt(n.getRetVal());
        }
        finally
        {

        }
    }

    /**
     * 获取性别
     * @return
     * @throws NativeException
     * @throws IllegalAccessException
     */
    public  int GetPeopleSex() throws NativeException, IllegalAccessException
    {
        JNative n = null;
        try
        {
            n = new JNative("Termb.dll", "GetPeopleSex");
            n.setRetVal(Type.INT); // 指定返回参数的类型
            Pointer a = new Pointer(MemoryBlockFactory.createMemoryBlock(4*10));
            Pointer b = new Pointer(MemoryBlockFactory.createMemoryBlock(4*30));
            n.setParameter(0,b);
            n.setParameter(1,a);
            n.invoke();
            byte[] by = new byte[120];
            by = b.getMemory();
            try
            {
                strTmp = new String(by,"gb2312");
            }
            catch (UnsupportedEncodingException ex)
            {
                Logger.getLogger(CVR100DemoView.class.getName()).log(Level.SEVERE, null, ex);
            }
            len = a.getAsInt(0);
            a.dispose();
            b.dispose();
            return Integer.parseInt(n.getRetVal());
        }
        finally
        {

        }
    }

    /**
     * 获取民族
     */
    public int GetPeopleNation()throws NativeException, IllegalAccessException{
        JNative n = null;
        try
        {
            n = new JNative("Termb.dll", "GetPeopleNation");
            n.setRetVal(Type.INT); // 指定返回参数的类型
            Pointer a = new Pointer(MemoryBlockFactory.createMemoryBlock(4*10));
            Pointer b = new Pointer(MemoryBlockFactory.createMemoryBlock(4*30));
            n.setParameter(0,b);
            n.setParameter(1,a);
            n.invoke();
            byte[] by = new byte[120];
            by = b.getMemory();
            try
            {
                strTmp = new String(by,"gb2312");
            }
            catch (UnsupportedEncodingException ex)
            {
                Logger.getLogger(CVR100DemoView.class.getName()).log(Level.SEVERE, null, ex);
            }

            len = a.getAsInt(0);

            a.dispose();
            b.dispose();
            return Integer.parseInt(n.getRetVal());
        }
        finally
        {

        }
    }

    /**
     * 获取生日
     * @return
     * @throws NativeException
     * @throws IllegalAccessException
     */
    public int GetPeopleBirthday()throws NativeException, IllegalAccessException{
        JNative n = null;
        try
        {
            n = new JNative("Termb.dll", "GetPeopleBirthday");
            n.setRetVal(Type.INT); // 指定返回参数的类型
            Pointer a = new Pointer(MemoryBlockFactory.createMemoryBlock(4*10));
            Pointer b = new Pointer(MemoryBlockFactory.createMemoryBlock(4*30));
            n.setParameter(0,b);
            n.setParameter(1,a);
            n.invoke();
            byte[] by = new byte[120];
            by = b.getMemory();
            try
            {
                strTmp = new String(by,"gb2312");
            }
            catch (UnsupportedEncodingException ex)
            {
                Logger.getLogger(CVR100DemoView.class.getName()).log(Level.SEVERE, null, ex);
            }

            len = a.getAsInt(0);

            a.dispose();
            b.dispose();
            return Integer.parseInt(n.getRetVal());
        }
        finally
        {

        }
    }

    /**
     * 获取地址
     * @return
     * @throws NativeException
     * @throws IllegalAccessException
     */
    public  int GetPeopleAddress() throws NativeException, IllegalAccessException
    {
        JNative n = null;
        try
        {
            n = new JNative("Termb.dll", "GetPeopleAddress");
            n.setRetVal(Type.INT); // 指定返回参数的类型
            Pointer a = new Pointer(MemoryBlockFactory.createMemoryBlock(4*10));
            Pointer b = new Pointer(MemoryBlockFactory.createMemoryBlock(4*30));
            n.setParameter(0,b);
            n.setParameter(1,a);
            n.invoke();
            byte[] by = new byte[120];
            by = b.getMemory();
            try
            {
                strTmp = new String(by,"gb2312");
            }
            catch (UnsupportedEncodingException ex)
            {
                Logger.getLogger(CVR100DemoView.class.getName()).log(Level.SEVERE, null, ex);
            }

            len = a.getAsInt(0);

            a.dispose();
            b.dispose();
            return Integer.parseInt(n.getRetVal());
        }
        finally
        {

        }
    }

    /**
     * 获取身份证号
     * @return
     * @throws NativeException
     * @throws IllegalAccessException
     */
    public  int GetPeopleIDCode() throws NativeException, IllegalAccessException
    {
        JNative n = null;
        try
        {
            n = new JNative("Termb.dll", "GetPeopleIDCode");
            n.setRetVal(Type.INT); // 指定返回参数的类型
            Pointer a = new Pointer(MemoryBlockFactory.createMemoryBlock(4*10));
            Pointer b = new Pointer(MemoryBlockFactory.createMemoryBlock(4*30));
            n.setParameter(0,b);
            n.setParameter(1,a);
            n.invoke();
            byte[] by = new byte[120];
            by = b.getMemory();
            try
            {
                strTmp = new String(by,"gb2312");
            }
            catch (UnsupportedEncodingException ex)
            {
                Logger.getLogger(CVR100DemoView.class.getName()).log(Level.SEVERE, null, ex);
            }

            len = a.getAsInt(0);

            a.dispose();
            b.dispose();
            return Integer.parseInt(n.getRetVal());
        }
        finally
        {

        }
    }

    /**
     * 获取发证机关信息
     * @return
     * @throws NativeException
     * @throws IllegalAccessException
     */
    public int GetDepartment() throws NativeException, IllegalAccessException
    {
        JNative n = null;
        try
        {
            n = new JNative("Termb.dll", "GetDepartment");
            n.setRetVal(Type.INT); // 指定返回参数的类型
            Pointer a = new Pointer(MemoryBlockFactory.createMemoryBlock(4*10));
            Pointer b = new Pointer(MemoryBlockFactory.createMemoryBlock(4*30));
            n.setParameter(0,b);
            n.setParameter(1,a);
            n.invoke();
            byte[] by = new byte[120];
            by = b.getMemory();
            try
            {
                strTmp = new String(by,"gb2312");
            }
            catch (UnsupportedEncodingException ex)
            {
                Logger.getLogger(CVR100DemoView.class.getName()).log(Level.SEVERE, null, ex);
            }

            len = a.getAsInt(0);

            a.dispose();
            b.dispose();
            return Integer.parseInt(n.getRetVal());
        }
        finally
        {

        }
    }

    /**
     * 获取有效开始日期
     * @return
     * @throws NativeException
     * @throws IllegalAccessException
     */
    public int GetStartDate() throws NativeException, IllegalAccessException
    {
        JNative n = null;
        try
        {
            n = new JNative("Termb.dll", "GetStartDate");
            n.setRetVal(Type.INT); // 指定返回参数的类型
            Pointer a = new Pointer(MemoryBlockFactory.createMemoryBlock(4*10));
            Pointer b = new Pointer(MemoryBlockFactory.createMemoryBlock(4*30));
            n.setParameter(0,b);
            n.setParameter(1,a);
            n.invoke();
            byte[] by = new byte[120];
            by = b.getMemory();
            try
            {
                strTmp = new String(by,"gb2312");
            }
            catch (UnsupportedEncodingException ex)
            {
                Logger.getLogger(CVR100DemoView.class.getName()).log(Level.SEVERE, null, ex);
            }

            len = a.getAsInt(0);

            a.dispose();
            b.dispose();
            return Integer.parseInt(n.getRetVal());
        }
        finally
        {

        }
    }

    /**
     * 获取有效结束期
     * @return
     * @throws NativeException
     * @throws IllegalAccessException
     */
    public int GetEndDate() throws NativeException, IllegalAccessException
    {
        JNative n = null;
        try
        {
            n = new JNative("Termb.dll", "GetEndDate");
            n.setRetVal(Type.INT); // 指定返回参数的类型
            Pointer a = new Pointer(MemoryBlockFactory.createMemoryBlock(4*10));
            Pointer b = new Pointer(MemoryBlockFactory.createMemoryBlock(4*30));
            n.setParameter(0,b);
            n.setParameter(1,a);
            n.invoke();
            byte[] by = new byte[120];
            by = b.getMemory();
            try
            {
                strTmp = new String(by,"gb2312");
            }
            catch (UnsupportedEncodingException ex)
            {
                Logger.getLogger(CVR100DemoView.class.getName()).log(Level.SEVERE, null, ex);
            }

            len = a.getAsInt(0);

            a.dispose();
            b.dispose();
            return Integer.parseInt(n.getRetVal());
        }
        finally
        {

        }
    }

    /**
     * 获取安全模块号码
     * @return
     * @throws NativeException
     * @throws IllegalAccessException
     */
    public int CVR_GetSAMID() throws NativeException, IllegalAccessException
    {
        JNative n = null;
        try
        {
            n = new JNative("Termb.dll", "CVR_GetSAMID");
            n.setRetVal(Type.INT); // 指定返回参数的类型
            Pointer a = new Pointer(MemoryBlockFactory.createMemoryBlock(4*10));
            Pointer b = new Pointer(MemoryBlockFactory.createMemoryBlock(4*30));
            n.setParameter(0,b);
            n.setParameter(1,a);
            n.invoke();
            byte[] by = new byte[120];
            by = b.getMemory();
            try
            {
                strTmp = new String(by,"gb2312");
            }
            catch (UnsupportedEncodingException ex)
            {
                Logger.getLogger(CVR100DemoView.class.getName()).log(Level.SEVERE, null, ex);
            }

            len = a.getAsInt(0);

            a.dispose();
            b.dispose();
            return Integer.parseInt(n.getRetVal());
        }
        finally
        {

        }
    }
}
