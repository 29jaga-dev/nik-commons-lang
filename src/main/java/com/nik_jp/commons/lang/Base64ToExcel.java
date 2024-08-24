package com.nik_jp.commons.lang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class Base64ToExcel {

	public static void main(String[] args) {
		// Base64でエンコードされたファイルのパス
		String encodedFilePath = "encoded_data.txt";
		// 復元されたExcelファイルを保存するパス
		String outputFilePath = "restored_example.xlsx";
		try {
			// エンコードされたテキストファイルを読み込む
			FileInputStream fileInputStream = new FileInputStream(new File(encodedFilePath));
			byte[] encodedBytes = new byte[(int) new File(encodedFilePath).length()];
			fileInputStream.read(encodedBytes);
			fileInputStream.close();

			// Base64デコード
			byte[] decodedBytes = Base64.getDecoder().decode(new String(encodedBytes));

			// デコードされたデータをExcelファイルとして保存
			FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath);
			fileOutputStream.write(decodedBytes);
			fileOutputStream.close();

			System.out.println("Base64から復元されたExcelファイルが " + outputFilePath + " に保存されました。");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
