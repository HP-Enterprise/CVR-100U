package com.cvr.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



/**
 * Created by shuzihao on 2016/8/4.
 */
@RestController
@RequestMapping("/api")
public class TextController {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public ObjectResult text(){
        CVR100DemoView cvr100DemoView = new CVR100DemoView();
        UserInfo userInfo = new UserInfo();
        try{
            //1.打开端口   串口  或者 USB（USB1001） 1成功，2失败，3动态库加载失败
            int str = cvr100DemoView.CVR_InitComm(1001);
            if(str == 1) {
                //1.卡认证    1成功，2寻卡失败，3选卡失败，0初始化失败
                int aun = cvr100DemoView.CVR_Authenticate ();
                if(aun == 1) {
                    //1.读卡    1成功，0错误，99异常
                    int readCard = cvr100DemoView.CVR_Read_Content (4);
                    if(readCard == 1) {
                        //姓名
                        if (cvr100DemoView.GetPeopleName() == 1){userInfo.setName(cvr100DemoView.strTmp.trim());}

                        //性别
                        if (cvr100DemoView.GetPeopleSex() == 1){userInfo.setGender(cvr100DemoView.strTmp.trim());}

                        //民族
                        if (cvr100DemoView.GetPeopleNation() == 1){userInfo.setNation(cvr100DemoView.strTmp.trim());}

                        //出生日期
                        if (cvr100DemoView.GetPeopleBirthday() == 1){userInfo.setBirthday(cvr100DemoView.strTmp.trim());}

                        //地址
                        if (cvr100DemoView.GetPeopleAddress() == 1){userInfo.setAddress(cvr100DemoView.strTmp.trim());}

                        //获取身份证
                        if(cvr100DemoView.GetPeopleIDCode() == 1)
                        {userInfo.setIdCode(cvr100DemoView.strTmp.trim());}

                        //发证机关
                        if (cvr100DemoView.GetDepartment() == 1){userInfo.setDepartment(cvr100DemoView.strTmp.trim());}

                        //开始日期
                        if (cvr100DemoView.GetStartDate() == 1){userInfo.setStartDate(cvr100DemoView.strTmp.trim());}

                        //结束日期
                        if (cvr100DemoView.GetEndDate() == 1){userInfo.setEndDate(cvr100DemoView.strTmp.trim());}

                        //安全模块号码
                        if (cvr100DemoView.CVR_GetSAMID() == 1){userInfo.setsAMID(cvr100DemoView.strTmp.trim());}

                        //关闭连接
                        cvr100DemoView.CVR_CloseComm();
                    }else {
                        return new ObjectResult("false","读卡失败");
                    }
                }else  if(aun == 2){
                    return new ObjectResult("false","寻卡失败");
                }else  if(aun == 3){
                    return new ObjectResult("false","选卡失败");
                }else{
                    return new ObjectResult("false","初始化失败");
                }
            }else if (str == 2){
                return new ObjectResult("false","端口打开失败");
            }else {
                return new ObjectResult("false","动态库加载失败");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return new ObjectResult("true",userInfo);

    }
}
