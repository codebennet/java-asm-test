package com.acestime.proxy.service;


import com.acestime.proxy.asm.method.AuthorizeMethodClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.PrintWriter;
import java.io.StringWriter;

public class MethodTransformation extends ClassTransformation{


    @Override
    public <T> Class<T> execute(Class<T> clazz) throws Exception {

        String className = clazz.getName();
        String classAsPath = className.replace('.', '/') + ".class";

        ClassReader cr = new ClassReader(clazz.getClassLoader().getResourceAsStream(classAsPath));
        ClassWriter cw = new ClassWriter(cr, 0);

        /*StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        TraceClassVisitor traceClassVisitor = new TraceClassVisitor(cw, new ASMifier(), printWriter);

        AuthorizeMethodClassAdapter cv = new AuthorizeMethodClassAdapter(traceClassVisitor);*/

        AuthorizeMethodClassAdapter cv = new AuthorizeMethodClassAdapter(cw);
        cr.accept(cv, 0);

//        System.out.println("Class contents: " + stringWriter.toString());

        return getClassFromBytes(clazz, cw.toByteArray());
    }
}
