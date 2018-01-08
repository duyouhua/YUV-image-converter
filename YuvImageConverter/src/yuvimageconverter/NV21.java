package yuvimageconverter;

public class NV21 {

    public static byte[] returnByteArray(byte[] yuv, int width, int height, int rowStep) {
        byte byteVal[] = new byte[width * height];

        int i = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                byteVal[i] = yuv[y * rowStep + x];
                i++;
            }
        }
        return byteVal;

    }
  public static int[] yuv2rgbA(byte[] yuv, int width, int height, int rowStep) {

        int rowImageSize = rowStep * height;
        int outputImageSize = width * height;
        int[] rgb = new int[outputImageSize];

        int Y, Cb = 0, Cr = 0, index = 0;
        int R, G, B;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Y = yuv[y * rowStep + x];
                if (Y < 0) {
                    Y += 255;
                }

                if ((x & 1) == 0) {
                    Cr = yuv[(y >> 1) * (rowStep) + x + rowImageSize];
                    Cb = yuv[(y >> 1) * (rowStep) + x + rowImageSize + 1];

                    if (Cb < 0) {
                        Cb += 127;
                    } else {
                        Cb -= 128;
                    }
                    if (Cr < 0) {
                        Cr += 127;
                    } else {
                        Cr -= 128;
                    }
                }

                R = Y + Cr + (Cr >> 2) + (Cr >> 3) + (Cr >> 5);
                G = Y - (Cb >> 2) + (Cb >> 4) + (Cb >> 5) - (Cr >> 1) + (Cr >> 3) + (Cr >> 4) + (Cr >> 5);
                B = Y + Cb + (Cb >> 1) + (Cb >> 2) + (Cb >> 6);

                if (R < 0) {
                    R = 0;
                } else if (R > 255) {
                    R = 255;
                }
                if (G < 0) {
                    G = 0;
                } else if (G > 255) {
                    G = 255;
                }
                if (B < 0) {
                    B = 0;
                } else if (B > 255) {
                    B = 255;
                }

                rgb[index++] = 0xff000000 + (R << 16) + (G << 8) + B;
            }
        }

        return rgb;
    }
    public static int[] yuv2rgb(byte[] yuv, int width, int height, int rowStep) {

        int rowImageSize = rowStep * height;
        int outputImageSize = width * height;
        int[] rgb = new int[outputImageSize];

        int Y, Cb = 0, Cr = 0, index = 0;
        int R, G, B;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Y = yuv[y * rowStep + x];
                if (Y < 0) {
                    Y += 255;
                }

                if ((x & 1) == 0) {
                    Cr = yuv[(y >> 1) * (rowStep) + x + rowImageSize];
                    Cb = yuv[(y >> 1) * (rowStep) + x + rowImageSize + 1];

                    if (Cb < 0) {
                        Cb += 127;
                    } else {
                        Cb -= 128;
                    }
                    if (Cr < 0) {
                        Cr += 127;
                    } else {
                        Cr -= 128;
                    }
                }

                R = Y + Cr + (Cr >> 2) + (Cr >> 3) + (Cr >> 5);
                G = Y - (Cb >> 2) + (Cb >> 4) + (Cb >> 5) - (Cr >> 1) + (Cr >> 3) + (Cr >> 4) + (Cr >> 5);
                B = Y + Cb + (Cb >> 1) + (Cb >> 2) + (Cb >> 6);

                if (R < 0) {
                    R = 0;
                } else if (R > 255) {
                    R = 255;
                }
                if (G < 0) {
                    G = 0;
                } else if (G > 255) {
                    G = 255;
                }
                if (B < 0) {
                    B = 0;
                } else if (B > 255) {
                    B = 255;
                }

                rgb[index++] = 0xff000000 + (R << 16) + (G << 8) + B;
            }
        }

        return rgb;
    }

}
