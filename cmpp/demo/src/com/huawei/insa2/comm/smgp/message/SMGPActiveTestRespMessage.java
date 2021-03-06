// FrontEnd Plus GUI for JAD
// DeCompiled : SMGPActiveTestRespMessage.class

package com.huawei.insa2.comm.smgp.message;

import com.huawei.insa2.comm.smgp.SMGPConstant;
import com.huawei.insa2.util.TypeConvert;

// Referenced classes of package com.huawei.insa2.comm.smgp.message:
//            SMGPMessage

public class SMGPActiveTestRespMessage extends SMGPMessage
{

    public SMGPActiveTestRespMessage()
        throws IllegalArgumentException
    {
        int len = 12;
        buf = new byte[len];
        TypeConvert.int2byte(len, buf, 0);
        TypeConvert.int2byte(0x80000004, buf, 4);
    }

    public SMGPActiveTestRespMessage(byte buf[])
        throws IllegalArgumentException
    {
        super.buf = new byte[4];
        if(buf.length != 4)
        {
            throw new IllegalArgumentException(SMGPConstant.SMC_MESSAGE_ERROR);
        } else
        {
            System.arraycopy(buf, 0, super.buf, 0, 4);
            sequence_Id = TypeConvert.byte2int(super.buf, 0);
            return;
        }
    }

    public String toString()
    {
        StringBuffer strBuf = new StringBuffer(100);
        strBuf.append("SMGPActiveTestRespMessage: ");
        strBuf.append("Sequence_Id=".concat(String.valueOf(String.valueOf(getSequenceId()))));
        return strBuf.toString();
    }

    public int getRequestId()
    {
        return 0x80000004;
    }
}
