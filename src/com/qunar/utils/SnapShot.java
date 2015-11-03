package com.qunar.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class SnapShot {
	public static void snapshot(TakesScreenshot drivername, String filename)  //此方法为屏幕截图
    {     
        String currentPath = System.getProperty("user.dir"); // 获取当前工作路径
        File scrFile = drivername.getScreenshotAs(OutputType.FILE); //利用 TakesScreenshot接口提供的 getScreenshotAs()方法捕捉屏幕,会将获取到的截图存放到一个临时文件中
        try 
        {
            System.out.println("save snapshot path is:" + currentPath + "/" + filename);
            FileUtils.copyFile(scrFile, new File(currentPath + "\\" + filename));  //将临时文件拷贝到当前工作路径
        } 
        catch (IOException e)
        {
            System.out.println("Can't save screenshot");   //截图失败
            e.printStackTrace();  //打印出异常，与System.out.println(e)类似，但是它还将显示出更深的调用信息
        }
        finally 
        {
            System.out.println("screen shot finished, it's in " + currentPath + " folder");   //截图成功
        }
    }
}
