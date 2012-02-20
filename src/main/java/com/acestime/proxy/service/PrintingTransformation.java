package com.acestime.proxy.service;


import com.acestime.proxy.asm.ClassPrinter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

public class PrintingTransformation extends ClassTransformation{

    @Override
    public <T> Class<T> execute(Class<T> clazz) throws Exception {

        String className = clazz.getName();
        String classAsPath = className.replace('.', '/') + ".class";

        ClassVisitor cv = new ClassPrinter();
        ClassReader cr = new ClassReader(clazz.getClassLoader().getResourceAsStream(classAsPath));
        cr.accept(cv, 0);

        return null;
    }
}
