package healenium;

public class LongestCommonSubsequence {

    int lcs(char ch1[], char ch2[], int lengthS1, int lenghtS2) {

        if(lengthS1 == 0 || lenghtS2 == 0)
            return 0;
        if (ch1[lengthS1-1] == ch2[lenghtS2-1])
            return 1 + lcs(ch1, ch2, lengthS1-1, lenghtS2-1);
        else
            return max(lcs(ch1, ch2, lengthS1-1, lenghtS2), lcs(ch1, ch2, lengthS1, lenghtS2-1));

    }

    int max(int a, int b)
    {
        return (a >b) ? a : b;
    }

    public static void main(String[] args) {

        LongestCommonSubsequence l = new LongestCommonSubsequence();
        String s1 = "abcdefghi";
        String s2 = "cbeha";

        char ch1[] = s1.toCharArray();
        char ch2[] = s2.toCharArray();

        int lenghtS1 = ch1.length;
        int lenghthS2 = ch2.length;

        System.out.println("length of subsequence is = " + " " + l.lcs(ch1,ch2,lenghtS1, lenghthS2));
    }
}
