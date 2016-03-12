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
		// 这个用来记录拥有股票的最大收益
		// 用来表示第i天拥有股票的收益
		// 今天买来股票 说明之前没有拥有股票
		// 1:今天来买过小说明昨天是不拥有股票的 可能为cooldown
		// 2: 今天可能不去买 但是我昨天就已经买过股票了
		int[] buy = new int[len];
		// 这个是来表示没有拥有股票的收益
		// 因为不拥有股票的话 有两种的情况
		// 第一种的是
		// 1：今天把股票卖了 因为我们今天要去卖股票 所以我们之前是买回了股票的
		// 就是昨天拥有的股票收益 今天来卖
		// 2:今天什么事都没有做 只是和昨天一样
		int[] sell = new int[len];
		buy[0] = -prices[0];
		// 第一天买来股票的话 就是吃亏的 是一个负的利益
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
