package com.jie;

public class BulbSwitcher {

	public static void main(String[] args) {
		

	}

	/*
	 * There are n bulbs that are initially off. You first turn on all the
	 * bulbs. Then, you turn off every second bulb. On the third round, you
	 * toggle every third bulb (turning on if it's off or turning off if it's
	 * on). For the nth round, you only toggle the last bulb. Find how many
	 * bulbs are on after n rounds.
	 * 
	 * Example:
	 * 
	 * Given n = 3.
	 * 
	 * At first, the three bulbs are [off, off, off]. After first round,
	 * thethree bulbs are [on, on, on]. After second round, the three bulbs
	 * are[on, off, on]. After third round, the three bulbs are [on, off, off].
	 * 
	 * So you should return 1, because there is only one bulb is on.
	 */
	/*���

	����֪����ÿ�����ݻ�ı�״̬��Ҳ���� toggle ʱ������Ϊ����������ĳ�������������ϡ�

	���ڵ�1�����ݣ�1*1����ı�1��״̬���� off -��on

	���ڵ�2�����ݣ�1*2��2*1����ı�2��״̬���� off -��on -��off

	���ڵ�3�����ݣ�1*3��3*1����ı�2��״̬���� off -��on -��off

	���ڵ�4�����ݣ�1*4��2*2��4*1����ı�3��״̬���� off -��on -��off -��on

	����

	�ᷢ�֣�ÿ�����ҵ�һ���������������ܻ��ҵ��ԳƵ�һ�������������� 1*2���Ϳ϶�����һ�� 2*1��Ψһ�����������ƽ�����ϣ����� 4 = 2*2��ֻ��һ����������

	ÿ����Ϊż���������������յĵ��ݶ��ỹԭΪ off��ֻ����Ϊ�����������������յĵ��ݶ��� on��*/
	
	/*
	 * ���Ϸ����ǳ��Ĵ���    ���ǿ�����ô�����   ����n������    һ����״̬��off   
	 * �ڵ�һ��ʱ�����ж���   �������е�1ѭ������   
	 * �ڶ���ʱʱ�����еڶ������ر�   ��������Ϊ2��ѭ����toggle�� 
	 * �����μ��Ե�����toggle��
	 * �������ǵó�    ��ʼ״̬Ϊoff  ��������λ���ϵ�m(m<=n)�����������<=m��֮ǰ��toggle  ����֮�󲻿���
	 * ��ȥtoggle it �������ǵ�����ͱ���˶���һ��λ����Ϊm�ĵ�  ��1-m��ѭ��������״̬��ʲô����
	 * �������toggleż���μ�Ϊoff����ʼ״̬������Ϊon 
	 * ��������Ҫ֪��   ���Ǽ���ѭ��������toggle�� ����֪����Ĵ���    
	 * ����������Ҫ���������ʽ�ֽ�   ��ƽ������ż�������ɶԳ��֣�  
	 * ������Ŀ�ͱ���� <=m��ƽ�����Ķ���  ��sqrt(m)
	 * 
	 * 
	 */
	public static int bulbSwitch(int n) {
		 return (int)Math.sqrt(n);  

	}

}
