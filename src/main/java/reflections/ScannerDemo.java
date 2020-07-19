package reflections;

import reflections.annotation.Action;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: yuweixiong
 * @Date: 2020/7/14 0:36
 * @Description:
 */
public class ScannerDemo {
    List<String> clzList = new ArrayList<>();

    public List<String> scanPackages(String packageName) {
        //获取指定包的完整路径
        String packagesUrl = this.getClass().getClassLoader().getResource("" + packageName.replaceAll("\\.", "/")).getFile();
        File scanFile = new File(packagesUrl);
        String[] filenameList = scanFile.list();

        for (String filename : filenameList) {
            File file = new File(scanFile, filename);
            if (file.isDirectory()) {
                scanPackages(packageName + "." + filename);
            } else {
                if (filename.indexOf(".class") > 0)
                    clzList.add(packageName + "." + filename.replace(".class", ""));
            }
        }

        return clzList;
    }

    public <A extends Annotation> Set<Class<?>> scanAnnotationClasses(String packageName, Class<A> annotationClass,
                                                                      boolean isRecursive) {
        Set<Class<?>> classSet = new HashSet<>();

        //获取指定包的完整路径
        String packagesUrl = this.getClass().getClassLoader().getResource("" + packageName.replaceAll("\\.", "/")).getFile();
        File scanFile = new File(packagesUrl);
        String[] filenameList = scanFile.list();

        String pathName = this.getClass().getCanonicalName();

        for (String filename : filenameList) {
            System.out.println("ScannerDemo filename: " + filename);

            File file = new File(scanFile, filename);
            if (file.isDirectory() && isRecursive) {
                scanAnnotationClasses(packageName + "." + filename, annotationClass, true);
            } else {
                if (filename.indexOf(".class") > 0) {
                    String entityName = filename.replace(".class", "");
                    int pos = pathName.lastIndexOf(".");
                    String removeSuffixName = pathName.substring(0, pos);
                    String trueName = removeSuffixName + "." + entityName;
                    try {
                        Class clazz = Class.forName(trueName);
                        Annotation annotations = clazz.getAnnotation(Action.class);
                        if (annotations != null) {
                            classSet.add(clazz);
                        }
                        System.out.println("classSet size: " + classSet.size());
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return classSet;
    }

    public <A extends Annotation> Set<Class<?>> scanAnnotationClasses(String packageName, Class<A> annotationClass) {
        Set<Class<?>> classSet = new HashSet<Class<?>>();

        /**
         * 获取指定包的完整路径
         */
        String packagesUrl = this.getClass().getClassLoader().getResource("" + packageName.replaceAll("\\.", "/")).getFile();
        System.out.println("packagesUrl: " + packagesUrl);
        File scanFile = new File(packagesUrl);
        String[] filenameList = scanFile.list();

        /**
         * 获取完整包名
         */
        String pathName = this.getClass().getCanonicalName();
        String packagePath = pathName.substring(0, pathName.lastIndexOf("."));
        System.out.println("packagePath: " + packagePath);

        for (String filename : filenameList) {
            System.out.println("ScannerDemo filename: " + filename);

            File file = new File(scanFile, filename);
            if (file.isDirectory()) {
                continue;
            } else {
                if (filename.indexOf(".class") > 0) {
                    String entityName = packagePath + "." + filename.replace(".class", "");
                    try {
                        Class clazz = Class.forName(entityName);
                        Annotation annotations = clazz.getAnnotation(annotationClass);
                        if (annotations != null) {
                            classSet.add(clazz);
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return classSet;
    }
}
