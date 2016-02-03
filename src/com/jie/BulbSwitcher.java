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
	/*解答：

	我们知道，每当灯泡会改变状态，也就是 toggle 时，是因为它出现在了某个数的整数倍上。

	对于第1个灯泡：1*1，会改变1次状态，即 off -》on

	对于第2个灯泡：1*2，2*1，会改变2次状态，即 off -》on -》off

	对于第3个灯泡：1*3，3*1，会改变2次状态，即 off -》on -》off

	对于第4个灯泡：1*4，2*2，4*1，会改变3次状态，即 off -》on -》off -》on

	……

	会发现，每当我找到一个数的整数倍，总会找到对称的一个整数倍，例如 1*2，就肯定会有一个 2*1。唯一的例外出现在平方数上，例如 4 = 2*2，只有一次整数倍。

	每次作为偶数次整数倍，最终的灯泡都会还原为 off；只有作为奇数次整数倍，最终的灯泡都会 on。*/
	
	/*
	 * 以上方法非常的聪明    我们可以这么来理解   对于n个灯泡    一开的状态是off   
	 * 在第一次时把所有都打开   即把所有的1循环都打开   
	 * 第二次时时吧所有第二个都关闭   即对所有为2的循环都toggle下 
	 * 第三次即对第三个toggle下
	 * 所以我们得出    初始状态为off  对于任意位置上的m(m<=n)它所在意的是<=m次之前的toggle  对于之后不可能
	 * 会去toggle it 所以我们的问题就变成了对于一个位置上为m的灯  在1-m次循环后他的状态是什么样的
	 * 如果他被toggle偶数次即为off（初始状态）否则为on 
	 * 所以我们要知道   在那几次循环中他被toggle了 并且知道其的次数    
	 * 所以我们需要把这个数因式分解   非平方数有偶数个（成对出现）  
	 * 所以题目就变成了 <=m的平方数的多少  即sqrt(m)
	 * 
	 * 
	 */
	public static int bulbSwitch(int n) {
		 return (int)Math.sqrt(n);  

	}

}
