package com.utils.test;

import java.io.*;

public class IntToByte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i = 65535;
		byte[] b = intToByteArray3(i, 4);
		for (byte bb : b) {
			System.out.print(bb + " ");
		}

		try {
			byte[] c = intToByteArray2(i);
			for (byte bb : c) {
				System.out.print(bb + " ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static byte[] intToByteArray1(int i) {
		byte[] result = new byte[4];
		result[0] = (byte) ((i >> 24) & 0xFF);
		result[1] = (byte) ((i >> 16) & 0xFF);
		result[2] = (byte) ((i >> 8) & 0xFF);
		result[3] = (byte) (i & 0xFF);
		return result;
	}

	public static byte[] intToByteArray2(int i) throws Exception {
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(buf);
		out.writeInt(i);
		byte[] b = buf.toByteArray();
		out.close();
		buf.close();
		return b;
	}

	public static byte[] intToByteArray3(int i, int len) {
		byte[] result = new byte[len];
		for (int j = 0; j < len; j++) {
			result[j] = (byte) ((i >> (len - 1 - j) * 8) & 0xFF);
		}
		return result;
	}

}
