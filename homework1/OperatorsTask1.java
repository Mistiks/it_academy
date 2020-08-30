package homeworks.homework1;

public class OperatorsTask1 {
    public static void main(String[] args) {
        int firstOperand = 42;
        int secondOperand = 15;
        int thirdOperand = -42;
        int fourthOperand = -15;

        System.out.println("First NOT: " + ~firstOperand); // 42 - 00101010; result - 11010101 (-43)
        System.out.println("Second NOT: " + ~secondOperand); // 15 - 00001111; result - 11110000 (-16)
        System.out.println("Third NOT: " + ~thirdOperand); // -42 - 11010110; result - 00101001 (41)
        System.out.println("Fourth NOT: " + ~fourthOperand); // -15 - 11110001; result - 00001110 (14)
        System.out.println("First AND Second: " + (firstOperand & secondOperand)); // 00101010 & 00001111 = 00001010 (10)
        System.out.println("Third AND Fourth: " + (thirdOperand & fourthOperand)); // 11010110 & 11110001 = 11010000 (-48)
        System.out.println("First &= Second: " + (firstOperand &= secondOperand)); // 00101010 &= 00001111 = 00001010 (10)

        firstOperand = 42;

        System.out.println("Third &= Fourth: " + (thirdOperand &= fourthOperand)); // 11010110 &= 11110001 = 11010000 (-48)

        thirdOperand = -42;

        System.out.println("First OR Second: " + (firstOperand | secondOperand)); // 00101010 | 00001111 = 00101111 (47)
        System.out.println("Third OR Fourth: " + (thirdOperand | fourthOperand)); // 11010110 | 11110001 = 11110111 (-9)
        System.out.println("First |= Second: " + (firstOperand |= secondOperand)); // 00101010 |= 00001111 = 00101111 (47)

        firstOperand = 42;

        System.out.println("Third |= Fourth: " + (thirdOperand |= fourthOperand)); // 11010110 |= 11110001 = 11110111 (-9)

        thirdOperand = -42;

        System.out.println("First ^ Second: " + (firstOperand ^ secondOperand)); // 00101010 ^ 00001111 = 00100101 (37)
        System.out.println("Third ^ Fourth: " + (thirdOperand ^ fourthOperand)); // 11010110 ^ 11110001 = 00100111 (39)
        System.out.println("First ^= Second: " + (firstOperand ^= secondOperand)); // 00101010 ^= 00001111 = 00100101 (37)
        System.out.println("Third ^= Fourth: " + (thirdOperand ^= fourthOperand)); // 11010110 ^= 11110001 = 00100111 (39)

        firstOperand = 42;
        thirdOperand = -42;

        System.out.println("First arithmetic shift: " + (firstOperand >> 2)); // 00101010 >> 2 = 00001010 (10)
        System.out.println("Second arithmetic shift: " + (secondOperand >> 1)); // 00001111 >> 1 = 00000111 (7)
        System.out.println("Third arithmetic shift: " + (thirdOperand >> 3)); // 11010110 >> 3 = 11111010 (-6)
        System.out.println("Fourth arithmetic shift: " + (fourthOperand >> 4)); // 11110001 >> 4 = 11111111 (-1)
        System.out.println("First arithmetic shift with assignment: " + (firstOperand >>= 2)); // 00101010 >>= 2 = 00001010 (10)
        System.out.println("Second arithmetic shift with assignment: " + (secondOperand >>= 1)); // 00001111 >>= 2 = 00000111 (7)
        System.out.println("Third arithmetic shift with assignment: " + (thirdOperand >>= 3)); // 11010110 >>= 3 = 11111010 (-6)
        System.out.println("Fourth arithmetic shift with assignment: " + (fourthOperand >>= 4)); // 11110001 >>= 4 = 11111111 (-1)

        firstOperand = 42;
        secondOperand = 15;
        thirdOperand = -42;
        fourthOperand = -15;

        System.out.println("First logical shift: " + (firstOperand >>> 3)); // 00101010 >>> 3 = 00000101 (5)
        System.out.println("Second logical shift: " + (secondOperand >>> 2)); // 00001111 >>> 2 = 00000011 (3)
        System.out.println("Third logical shift: " + (thirdOperand >>> 24)); // 11010110 >>> 24 = 11111111 (255)
        System.out.println("Fourth logical shift: " + (fourthOperand >>> 31)); // 11110001 >>> 31 = 00000001 (1)
        System.out.println("First logical shift with assignment: " + (firstOperand >>>= 1)); // 00101010 >>>= 1 = 00010101 (21)
        System.out.println("Second logical shift with assignment: " + (secondOperand >>>= 3)); // 00001111 >>>= 3 = 00000001 (1)
        System.out.println("Third logical shift with assignment: " + (thirdOperand >>>= 28)); // 11010110 >>>= 28 = 00001111 (15)
        System.out.println("Fourth logical shift with assignment: " + (fourthOperand >>>= 30)); // 11110001 >>>= 30 = 00000011 (3)

        firstOperand = 42;
        secondOperand = 15;
        thirdOperand = -42;
        fourthOperand = -15;

        System.out.println("First left shift: " + (firstOperand << 3)); // 00101010 << 3 = 101010000 (336)
        System.out.println("Second left shift: " + (secondOperand << 4)); // 00001111 << 4 = 11110000 (240)
        System.out.println("Third left shift: " + (thirdOperand << 8)); // 11010110 << 8 = 1101011000000000 (-10752)
        System.out.println("Fourth left shift: " + (fourthOperand << 31)); // 11110001 << 31 = 10000000000000000000000000000000 (-2147483648) Привет, предел int
        System.out.println("First left shift with assignment: " + (firstOperand <<= 2)); // 00101010 <<= 2 = 10101000 (168)
        System.out.println("Second left shift with assignment: " + (secondOperand <<= 3)); // 00001111 <<= 3 = 01111000 (120)
        System.out.println("Third left shift with assignment: " + (thirdOperand <<= 1)); // 11010110 <<= 1 = 110101100 (-84)
        System.out.println("Fourth left shift with assignment: " + (fourthOperand <<= 5)); // 11110001 <<= 5 = 1111000100000 (-480)
    }
}