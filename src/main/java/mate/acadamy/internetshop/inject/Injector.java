package mate.acadamy.internetshop.inject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mate.acadamy.internetshop.dao.lib.Dao;
import mate.acadamy.internetshop.inject.lib.Inject;
import mate.acadamy.internetshop.service.lib.Service;

public class Injector {

    private static final Map<String, Injector> INJECTORS = new HashMap<>();
    private static final Map<Class<?>, Object> INSTANCE_OF_CLASSES = new HashMap<>();
    private static final List<Class<?>> CLASSES = new ArrayList<>();

    private Injector(String mainPackageName) {
        try {
            CLASSES.addAll(getClasses(mainPackageName));
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Can't get information about all classes", e);
        }
    }

    public static Injector getInstance(String mainPackageName) {
        if (INJECTORS.containsKey(mainPackageName)) {
            return INJECTORS.get(mainPackageName);
        }
        Injector injector = new Injector(mainPackageName);
        INJECTORS.put(mainPackageName, injector);
        return injector;
    }

    public static Object getInstance(Class<?> certainInterface) {
        Object newInstanceOfClass = null;
        Class<?> clazz = findClassExtendingInterface(certainInterface);
        Object instanceOfCurrentClass = createInstance(clazz);
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (isFieldInitialized(field, instanceOfCurrentClass)) {
                continue;
            }
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                Object classToInject = getInstance(field.getType());
                newInstanceOfClass = getNewInstance(clazz);
                setValueToField(field, newInstanceOfClass, classToInject);
            } else {
                throw new RuntimeException("Class " + field.getName() + " in class "
                        + clazz.getName() + " hasn't annotation Inject");
            }
        }
        if (newInstanceOfClass == null) {
            return getNewInstance(clazz);
        }
        return newInstanceOfClass;
    }

    private static Class<?> findClassExtendingInterface(Class<?> certainInterface) {
        for (Class<?> clazz : CLASSES) {
            Class<?>[] interfaces = clazz.getInterfaces();
            for (Class<?> singleInterface : interfaces) {
                if (singleInterface.equals(certainInterface)
                        && (clazz.isAnnotationPresent(Service.class)
                        || clazz.isAnnotationPresent(Dao.class))) {
                    return clazz;
                }
            }
        }
        throw new RuntimeException("Can't find class which implemented "
                + certainInterface.getName()
                + "interface and has valid annotation (Dao or Service)");
    }

    private static Object getNewInstance(Class<?> certainClass) {
        if (INSTANCE_OF_CLASSES.containsKey(certainClass)) {
            return INSTANCE_OF_CLASSES.get(certainClass);
        }
        Object newInstance = createInstance(certainClass);
        INSTANCE_OF_CLASSES.put(certainClass, newInstance);
        return newInstance;
    }

    private static boolean isFieldInitialized(Field field, Object instance) {
        field.setAccessible(true);
        try {
            return field.get(instance) != null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Can't get access to field");
        }
    }

    private static Object createInstance(Class<?> clazz) {
        Object newInstance;
        try {
            Constructor<?> classConstructor = clazz.getConstructor();
            newInstance = classConstructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Can't create object of the class", e);
        }
        return newInstance;
    }

    private static void setValueToField(Field field, Object instanceOfClass, Object classToInject) {
        try {
            field.setAccessible(true);
            field.set(instanceOfClass, classToInject);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Can't set value to field ", e);
        }
    }

    private static List<Class<?>> getClasses(String packageName)
            throws IOException, ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            throw new RuntimeException("Class loader is null");
        }
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class<?>> classes = new ArrayList<>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes;
    }

    private static List<Class<?>> findClasses(File directory, String packageName)
            throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    if (file.getName().contains(".")) {
                        throw new RuntimeException("File name shouldn't consist point.");
                    }
                    classes.addAll(findClasses(file, packageName + "."
                            + file.getName()));
                } else if (file.getName().endsWith(".class")) {
                    classes.add(Class.forName(packageName + '.'
                            + file.getName().substring(0, file.getName().length() - 6)));
                }
            }
        }
        return classes;
    }
}

