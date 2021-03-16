/**HammingDistance.java
 * com.leetcode.bitoperation
 * TODO
 * LC461.汉明距离。给出两个int32数，求出两个数比特为不同的位数的总和。
 * 方法一循环位移和异或，时间空间都是常数；
 * 方法二通过x=x&(x-1)，每次去掉最低位的1，比方法一有相对提升。
 * @author liar
 * 2021年3月16日 下午5:23:02
 * @version 1.0
 */
package com.leetcode.bitoperation;


public class HammingDistance {
	public int hammingDistance(int x, int y) {
        int all = x ^ y;
        //异或之后，相同为0，相异为1，只需要统计1的数量即可
        int result = 0;
        for(int i = 0; i < 32;i++){
            if((all & 1) == 1)
                result++;
            all = all >> 1;
        }

        return result;
    }
}
