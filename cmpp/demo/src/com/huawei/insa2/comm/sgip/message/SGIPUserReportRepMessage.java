// FrontEnd Plus GUI for JAD
// DeCompiled : SGIPUserReportRepMessage.class

package com.huawei.insa2.comm.sgip.message;

import com.huawei.insa2.comm.sgip.SGIPConstant;
import com.huawei.insa2.util.TypeConvert;

// Referenced classes of package com.huawei.insa2.comm.sgip.message:
//            SGIPMessage

public class SGIPUserReportRepMessage extends SGIPMessage
{

    private String outStr;

    public SGIPUserReportRepMessage(int result)
        throws IllegalArgumentException
    {
        if(result < 0 || result > 255)
        {
            throw new IllegalArgumentException(String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(SGIPConstant.USERREPORT_REPINPUT_ERROR)))).append(":result").append(SGIPConstant.INT_SCOPE_ERROR))));
        } else
        {
            int len = 29;
            buf = new byte[len];
            TypeConvert.int2byte(len, buf, 0);
            TypeConvert.int2byte(0x80000011, buf, 4);
            buf[20] = (byte)result;
            outStr = ",result=".concat(String.valueOf(String.valueOf(result)));
            return;
        }
    }

    public String toString()
    {
        String tmpStr = "SGIP_USERREPORT_REP: ";
        tmpStr = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(tmpStr)))).append("Sequence_Id=").append(getSequenceId())));
        tmpStr = String.valueOf(tmpStr) + String.valueOf(outStr);
        return tmpStr;
    }

    public int getCommandId()
    {
        return 0x80000011;
    }
}
