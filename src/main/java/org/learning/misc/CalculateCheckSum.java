package org.learning.misc;

import java.util.zip.CRC32;

public class CalculateCheckSum {

    public static void main(String[] args) {
        String url = "https://www.example.com/page?param=value";

        long checksum = calculateChecksum(url);
        System.out.println("Checksum for URL: " + checksum);
    }

    private static long calculateChecksum(String data) {
        CRC32 crc32 = new CRC32();
        crc32.update(data.getBytes());
        return crc32.getValue();
    }
}
