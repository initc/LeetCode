package com.jie;

public class BuyAndSellStockWithColldown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete as many
	 * transactions as you like (ie, buy one and sell one share of the stock
	 * multiple times) with the following restrictions:
	 * 
	 * You may not engage in multiple transactions at the same time (ie, you
	 * must sell the stock before you buy again). After you sell your stock, you
	 * cannot buy stock on next day. (ie, cooldown 1 day)
	 * 
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int len = prices.length;
		// ���������¼ӵ�й�Ʊ���������
		// ������ʾ��i��ӵ�й�Ʊ������
		// ����������Ʊ ˵��֮ǰû��ӵ�й�Ʊ
		// 1:���������С˵�������ǲ�ӵ�й�Ʊ�� ����Ϊcooldown
		// 2: ������ܲ�ȥ�� ������������Ѿ������Ʊ��
		int[] buy = new int[len];
		// ���������ʾû��ӵ�й�Ʊ������
		// ��Ϊ��ӵ�й�Ʊ�Ļ� �����ֵ����
		// ��һ�ֵ���
		// 1������ѹ�Ʊ���� ��Ϊ���ǽ���Ҫȥ����Ʊ ��������֮ǰ������˹�Ʊ��
		// ��������ӵ�еĹ�Ʊ���� ��������
		// 2:����ʲô�¶�û���� ֻ�Ǻ�����һ��
		int[] sell = new int[len];
		buy[0] = -prices[0];
		// ��һ��������Ʊ�Ļ� ���ǳԿ��� ��һ����������
		for (int i = 1; i < len; i++) {
			sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
			if (i < 2) {
				buy[i] = Math.max(buy[i - 1], -prices[i]);
			} else
				buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
		}

		return sell[len - 1];
	}

}
