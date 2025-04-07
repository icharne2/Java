package PAYPALISHIRING;

public class Convertion {
    public String convert(String s, int nRows) {
        if (nRows <= 1)
            return s;

        int len = s.length();
        StringBuilder[] str = new StringBuilder[nRows];

        for (int i = 0; i < nRows; ++i) {
            str[i] = new StringBuilder();
        }

        int row = 0, step = 1;
        for (int i = 0; i < len; ++i) {
            str[row].append(s.charAt(i));

            if (row == 0)
                step = 1;
            else if (row == nRows - 1)
                step = -1;

            row += step;
        }

        StringBuilder result = new StringBuilder();
        for (int j = 0; j < nRows; ++j) {
            result.append(str[j]);
        }

        return result.toString();
    }
}
