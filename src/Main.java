package src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length < 3)
            return;

        final LeetEncrypter encrypter = new CaesarEncrypter(args[1].getBytes());

        switch (args[0]) {
            case "-e":
                for (int f = 2; f < args.length; f++)
                    save(String.format("%s.lenc", snipExtension(args[f])), encrypter.encrypt(open(args[f])));
                return;
            case "-d":
                for (int f = 2; f < args.length; f++)
                    save(String.format("%s.ldec", snipExtension(args[f])), encrypter.decrypt(open(args[f])));
                return;
        }
    }

    public static String snipExtension(String filename) {
        return filename.substring(0, filename.lastIndexOf('.'));
    }

    public static byte[] open(String filename) {
        final File file = new File(filename);

        if (!file.exists()) {
            System.out.printf("It seems like %s does not exist.%n", filename);
            return new byte[0];
        }

        try (final FileInputStream fileInputStream = new FileInputStream(file)) {
            return fileInputStream.readAllBytes();
        }
        catch (IOException e) {
            System.out.printf("The FileInputStream failed to open for %s.%n", filename);
            return new byte[0];
        }
    }

    public static void save(String filename, byte[] data) {
        final File file = new File(filename);

        if (!file.exists())
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.printf("Unable to create the file %s.%n", filename);
                return;
            }
        
        try (final FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(data);
        }
        catch (IOException e) {
            System.out.printf("The FileOutputStream failed to open for %s.%n", filename);
        }
    }
}