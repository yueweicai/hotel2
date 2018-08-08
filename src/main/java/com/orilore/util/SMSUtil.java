package com.orilore.util;
import java.util.HashMap;
import java.util.Map;

import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.sms.SmsClient;
import com.baidubce.services.sms.SmsClientConfiguration;
import com.baidubce.services.sms.model.SendMessageV2Request;
import com.baidubce.services.sms.model.SendMessageV2Response;

public class SMSUtil {

    public static void main(String[] args) {
        // 相关参数定义
        String endPoint = "http://sms.bj.baidubce.com"; // SMS服务域名，可根据环境选择具体域名
        String accessKeyId = "u23487324298ewuroiew";  // 发送账号安全认证的Access Key ID
        String secretAccessKy = "8273dsjhfkjdshf78327jkj"; // 发送账号安全认证的Secret Access Key

        // ak、sk等config
        SmsClientConfiguration config = new SmsClientConfiguration();
        config.setCredentials(
        		new DefaultBceCredentials(accessKeyId, secretAccessKy));
        config.setEndpoint(endPoint);

        // 实例化发送客户端
        SmsClient smsClient = new SmsClient(config);

        // 定义请求参数
        String invokeId = "dkw86m01T-26Nv9-H5Z3"; // 发送使用签名的调用ID
        String phoneNumber = "13800138000"; // 要发送的手机号码(只能填写一个手机号)
        String templateCode = "smsTpl:0000000000000000000000"; // 本次发送使用的模板Code
      
        Map<String, String> vars =
                new HashMap<String, String>(); // 若模板内容为：您的验证码是${code},在${time}分钟内输入有效
        vars.put("code", "986082");
        vars.put("time", "30");

        //实例化请求对象
        SendMessageV2Request request = new SendMessageV2Request();
        request.withInvokeId(invokeId)
                .withPhoneNumber(phoneNumber)
                .withTemplateCode(templateCode)
                .withContentVar(vars);

        // 发送请求
        SendMessageV2Response response = smsClient.sendMessage(request);

        // 解析请求响应 response.isSuccess()为true 表示成功
        if (response != null && response.isSuccess()) {
            //  submit success
        } else {
            // fail
        }
    }
}