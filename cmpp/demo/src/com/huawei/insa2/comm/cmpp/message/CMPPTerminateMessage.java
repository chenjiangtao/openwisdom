// FrontEnd Plus GUI for JAD
// DeCompiled : CMPPTerminateMessage.class

package com.huawei.insa2.comm.cmpp.message;

import com.huawei.insa2.comm.cmpp.CMPPConstant;
import com.huawei.insa2.util.TypeConvert;

// Referenced classes of package com.huawei.insa2.comm.cmpp.message:
//            CMPPMessage

public class CMPPTerminateMessage extends CMPPMessage
{

    public CMPPTerminateMessage()
    {
        int len = 12;
        buf = new byte[len];
        TypeConvert.int2byte(len, buf, 0);
        TypeConvert.int2byte(2, buf, 4);
    }

    public CMPPTerminateMessage(byte buf[])
        throws IllegalArgumentException
    {
        super.buf = new byte[4];
        if(buf.length != 4)
        {
            throw new IllegalArgumentException(CMPPConstant.SMC_MESSAGE_ERROR);
        } else
        {
            System.arraycopy(buf, 0, super.buf, 0, 4);
            sequence_Id = TypeConvert.byte2int(super.buf, 0);
            return;
        }
    }

    public String toString()
    {
        String tmpStr = "CMPP_Terminate: ";
        tmpStr = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(tmpStr)))).append("Sequence_Id=").append(getSequenceId())));
        return tmpStr;
    }

    public int getCommandId()
    {
        return 2;
    }
}