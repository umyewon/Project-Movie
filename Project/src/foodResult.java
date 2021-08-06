package com.kh.project.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.kh.project.view.foodPanel1;
import com.kh.project.view.foodPanel2;
import com.kh.project.view.foodPanel3;

public class foodResult implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String menu = "";

		int num1 = foodPanel1.getSpinner1();
		int num2 = foodPanel1.getSpinner2();
		int num3 = foodPanel1.getSpinner3();
		int num4 = foodPanel2.getSpinner1();
		int num5 = foodPanel2.getSpinner2();
		int num6 = foodPanel2.getSpinner3();
		int num7 = foodPanel3.getSpinner1();
		int num8 = foodPanel3.getSpinner2();
		int num9 = foodPanel3.getSpinner3();
		
		if(num1 > 0)
			menu += "기본 팝콘" + num1 + "개 ";
		if(num2 > 0)
			menu += "캬라멜 팝콘" + num2 + "개 ";
		if(num3 > 0)
			menu += "치즈 팝콘" + num3 + "개 ";
		if(num4 > 0)
			menu += "나초" + num4 + "개 ";
		if(num5 > 0)
			menu += "감자칩" + num5 + "개 ";
		if(num6 > 0)
			menu += "프레첼" + num6 + "개 ";
		if(num7 > 0)
			menu += "콜라" + num7 + "개 ";
		if(num8 > 0)
			menu += "사이다" + num8 + "개 ";
		if(num9 > 0)
			menu += "환타" + num9 + "개 ";
		
		if(menu == "")
		{
			int result = JOptionPane.showConfirmDialog(null, "아무것도 구매하지 않으시겠습니까?","확인 창",JOptionPane.YES_NO_OPTION);
			
			if(result == 0)
			{
				JOptionPane.showMessageDialog(null,  "음식 구매 안함", "구매 완료",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(result == 1)
			{
				JOptionPane.showMessageDialog(null,  "음식 구매 취소", "구매 취소",JOptionPane.ERROR_MESSAGE);
			}
		}
		else
		{
			menu+=" 구매하시겠습니까?";
			int result = JOptionPane.showConfirmDialog(null, menu,"확인 창",JOptionPane.YES_NO_OPTION);
			
			if(result == 0)
			{
				JOptionPane.showMessageDialog(null,  "음식 구매 완료", "구매 완료",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(result == 1)
			{
				JOptionPane.showMessageDialog(null,  "음식 구매 취소", "구매 취소",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
