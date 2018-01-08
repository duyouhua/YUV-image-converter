package yuvimageconverter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class BMP {

    byte[] buffer_array;

    // BMP Header
    private final byte[] id = {0x42, 0x4D};
    private int fileSize = 0;
    private final short spec1 = 0;
    private final short spec2 = 0;
    private final int offset = 54;

    // DIB Header
    private final int biSize = 40;
    private final int biWidth;
    private final int biHeight;
    private final short biPlanes = 0;
    private short biBitCount = 32;
    private int biCompression, biSizeImage, biXPelsPerMeter, biYPelsPerMeter, biClrUsed, biClrImportant;

    // bitmap data
    private final int[] data;

    public BMP(int width, int height, short pixelBits, int[] pixels) {
        biWidth = width;
        biHeight = height;
        biBitCount = pixelBits;
        data = pixels;
        fileSize = width * height * pixelBits / 8 + offset;
    }

    public int getFileSize() {
        return fileSize;
    }

    private byte[] getFile() {
        ByteBuffer buffer = ByteBuffer.allocate(fileSize);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        buffer.put(id);
        buffer.putInt(fileSize);
        buffer.putShort(spec1);
        buffer.putShort(spec2);
        buffer.putInt(offset);
        buffer.putInt(biSize);
        buffer.putInt(biWidth);
        buffer.putInt(-1 * biHeight);
        buffer.putShort(biPlanes);
        buffer.putShort(biBitCount);
        buffer.putInt(biCompression);
        buffer.putInt(biSizeImage);
        buffer.putInt(biXPelsPerMeter);
        buffer.putInt(biYPelsPerMeter);
        buffer.putInt(biClrUsed);
        buffer.putInt(biClrImportant);

        for (int i = 0; i < data.length; i++) {
            buffer.putInt(data[i]);
        }
        buffer_array = buffer.array();

        return buffer_array;

    }

    public byte[] returnByteArr() {

        return getFile();
    }

    public void saveBMP(String fileName) {
        FileOutputStream out;
        try {
            out = new FileOutputStream(fileName);
            out.write(getFile());
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
