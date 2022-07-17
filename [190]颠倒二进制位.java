public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int l1 = 0x55555555;
        int l2 = 0x33333333;
        int l3 = 0x0f0f0f0f;
        int l4 = 0x00ff00ff;
        int l5 = 0x0000ffff;
        n = (n&l1)<<1|(n>>>1)&l1;
        n = (n&l2)<<2|(n>>>2)&l2;
        n = (n&l3)<<4|(n>>>4)&l3;
        n = (n&l4)<<8|(n>>>8)&l4;
        n = (n&l5)<<16|(n>>>16)&l5;
        return n;
    }
}