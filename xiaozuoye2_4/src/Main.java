import java.io.*;
import java.util.Scanner;
//xcopy C:\Users\86182\OneDrive\Desktop\ChatRoom C:\Users\86182\OneDrive\Desktop\test
public class Main {
    public static void main(String[] args) {
        System.out.println("xcopy dir1 dir2表示把dir1下面的所有子文件夹及文件都复制到dir2下面，dir2可以不存在");

        Scanner sc = new Scanner(System.in);
        String[] dir = sc.nextLine().split(" ");
       File source =new File(dir[1]) ;
        File target =new File(dir[2]) ;

        if (!source.exists() || !source.isDirectory()) {
            System.out.println("错误：源目录不存在或不是一个目录");
            return;
        }

        if (!target.exists()) {
            target.mkdirs();
        }

        copyDir(source, target);
        System.out.println("复制完成：" + source.getPath() + " -> " + target.getPath());
    }
//遍历 source 目录下的所有文件和子目录。
//
//如果是目录，就创建同名子目录并递归复制。
//
//如果是文件，就调用 copyFile 进行复制。
    public static void copyDir(File source, File target) {
        File[] files = source.listFiles();
        if (files == null) return;

        for (File file : files) {
            File newFile = new File(target, file.getName());
            if (file.isDirectory()) {
                newFile.mkdirs(); // 创建对应子目录
                copyDir(file, newFile); // 递归复制
            } else {
                copyFile(file, newFile); // 文件直接复制
            }
        }
    }

    public static void copyFile(File sourceFile, File targetFile) {
        try (
                FileInputStream in = new FileInputStream(sourceFile);
                FileOutputStream out = new FileOutputStream(targetFile)
        ) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (IOException e) {
            System.out.println("复制文件出错：" + sourceFile.getPath());
        }
    }
}
