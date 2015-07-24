package com.utils.test;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class Util {
	public static byte[] intToByteArray(int i, int len) {
		byte[] result = new byte[len];
		for(int j=0; j< len; j++){
			result[j] = (byte)((i>>(len-1-j)*8) & 0xFF);
		}
		return result;
	}
	
	public static byte[] arraycat(byte[] buf1, byte[] buf2) {
		byte[] bufret = null;
		int len1 = 0;
		int len2 = 0;
		if (buf1 != null)
			len1 = buf1.length;
		if (buf2 != null)
			len2 = buf2.length;
		if (len1 + len2 > 0)
			bufret = new byte[len1 + len2];
		if (len1 > 0)
			System.arraycopy(buf1, 0, bufret, 0, len1);
		if (len2 > 0)
			System.arraycopy(buf2, 0, bufret, len1, len2);
		return bufret;
	}
	
	public static byte[] InputStreamTOByte(DataInputStream in) throws IOException {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		int count = -1;

		byte[] s = new byte[4];
		count = in.read(s, 0, 4);
		int i = 0;
		i += ((s[0] & 0xff) << 24);
		i += ((s[1] & 0xff) << 16);
		i += ((s[2] & 0xff) << 8);
		i += ((s[3] & 0xff));

		byte[] s1 = new byte[12];
		in.read(s1, 0, 12);
		byte[] data = new byte[4096];
		count = in.read(data, 0, i - 16);
		outStream.write(data, 0, count);
		data = null;

		return outStream.toByteArray();

	}

}
