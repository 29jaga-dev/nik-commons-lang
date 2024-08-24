package com.nik_jp.commons.lang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class ExcelToBase64 {
	public static void main(String[] args) {
		// Excelファイルのパス
		String filePath = "example.xlsx";
		// エンコードされたファイルを保存するパス
		String encodedFilePath = "encoded_data.txt";

		try {
			// Excelファイルをバイナリとして読み込む
			System.out.println(new File(filePath).getAbsolutePath());
			FileInputStream fileInputStream = new FileInputStream(new File(filePath));
			byte[] fileBytes = new byte[(int) new File(filePath).length()];
			fileInputStream.read(fileBytes);
			fileInputStream.close();

			// バイナリデータをBase64エンコード
			String encodedData = Base64.getEncoder().encodeToString(fileBytes);

			// エンコードされたデータをテキストファイルに保存
			FileOutputStream fileOutputStream = new FileOutputStream(encodedFilePath);
			fileOutputStream.write(encodedData.getBytes());
			fileOutputStream.close();

			System.out.println("ExcelファイルがBase64にエンコードされ、" + encodedFilePath + " に保存されました。");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
