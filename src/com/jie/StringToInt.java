package com.jie;

public class StringToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(myAtoi("   321"));
		System.out.println(Integer.MAX_VALUE + "   " + Integer.MIN_VALUE);
	}

	public static int myAtoi(String str) {
		long result = 0;
		boolean isNeg = false, isPos = false;
		boolean isErro = false;
		long big = 2147483647;
		big++;
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if (ch > '9' ||ch < '0') {

				if (ch == '-') {
					if (isPos) {
						// ���������� �����������ø��� �������
						return 0;
					}
					// �������������
					if (isNeg)
						return 0;
					isErro = true;
					isNeg = true;
					continue;

				}
				if (ch == '+') {
					if (isNeg) {
						return 0;// �����˸��������������� �������
					}
					// �ɂ����������
					if (isPos)
						return 0;
					isErro = true;
					isPos = true;
					continue;
				}
				if (ch == ' ') {
					if (!isErro)
						continue;
					else
						return 0;
				}
               
				return 0;
			} else {
				index = i;
				break;
			}

		}
		char ch ;
		for (; index < str.length(); index++) {
         ch=str.charAt(index);
			if (ch <= '9' && ch >= '0') {
				long tp = ch - '0';
				result = result * 10 + tp;
				if(isNeg&&result>big){
					result=big;
					break;
				}else 
				if(!isNeg&&result>2147483647){
					
					result=2147483647;
					break;
				}
			}else{
				break;
			}
			
		}
		if (isNeg)
			result = -result;
		return (int) result;
	}
	/*
	 * 1.����ǰ���пո� ��s=�� 123456�� 2.����ǰ�����˲���Ҫ����ڵ��ַ�����������֤�������0 ��s=�� b1234�� ��s=��
	 * ++1233�� , s=�� +-1121�� 3.�����г����˲���Ҫ���ַ��������ַ�ǰ������ ��s=�� 12a12�� �� s=�� 123 123��
	 * 4.����Խ�� �����˷�Χ��-2147483648--2147483647) �������˸����� ���-2147483648
	 * ���������������2147483647 �ڿ���һ��֪ʶ�㣬����ĳ����������2147483647����Ϊ������������һ��
	 */
	public int myAtoi_2(String str) {
        
		long result = 0;
	boolean isNeg = false, isPos = false;
	boolean isErro = false;
	long  big=2147483647;
	big++;
	for (int i = 0; i < str.length(); i++) {

		char ch = str.charAt(i);
		if (ch == '-') {
			if (isPos) {
				// ���������� �����������ø��� �������
				return 0;
			}
			if(isNeg)
				return 0;
			isErro = true;
			isNeg = true;
			continue;
		}
		if (ch == '+') {
			if (isNeg) {
				return 0;// �����˸��������������� �������
			}
			if(isPos)
				return 0;
			isErro = true;
			isPos = true;
			continue;
		}
		if (ch == ' ') {
			if (!isErro)
				continue;
			else
				break;
		}
		if ((ch < '0' || ch > '9')) {
			// ��֮ǰ�����˷Ƿ��ַ�
			if (!isErro) {
				return 0;

			} else {

				break;

			}

		}
		if (ch <= '9' && ch >= '0') {
			isErro = true;
			long tp = ch - '0';
			result = result * 10 + tp;
			if(isNeg&&result>big){
				
				result=big;
				break;
			}
			if(!isNeg&&result>2147483647){
				
				result=2147483647;
				break;
			}
		}

	}
	if (isNeg)
		result = -result;
	return (int) result;


}
}
