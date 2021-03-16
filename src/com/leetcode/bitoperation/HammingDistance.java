/**HammingDistance.java
 * com.leetcode.bitoperation
 * TODO
 * LC461.�������롣��������int32�����������������Ϊ��ͬ��λ�����ܺ͡�
 * ����һѭ��λ�ƺ����ʱ��ռ䶼�ǳ�����
 * ������ͨ��x=x&(x-1)��ÿ��ȥ�����λ��1���ȷ���һ�����������
 * @author liar
 * 2021��3��16�� ����5:23:02
 * @version 1.0
 */
package com.leetcode.bitoperation;


public class HammingDistance {
	public int hammingDistance(int x, int y) {
        int all = x ^ y;
        //���֮����ͬΪ0������Ϊ1��ֻ��Ҫͳ��1����������
        int result = 0;
        for(int i = 0; i < 32;i++){
            if((all & 1) == 1)
                result++;
            all = all >> 1;
        }

        return result;
    }
}
