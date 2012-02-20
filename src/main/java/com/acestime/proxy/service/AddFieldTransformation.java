package com.acestime.proxy.service;


import com.acestime.proxy.asm.field.AddFieldAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.FieldNode;

public class AddFieldTransformation extends ClassTransformation{

    private FieldNode fieldNode;

    public AddFieldTransformation(FieldNode fieldNode) {
        this.fieldNode = fieldNode;
    }

    @Override
    public <T> Class<T> execute(Class<T> clazz) throws Exception {

        String className = clazz.getName();
        String classAsPath = className.replace('.', '/') + ".class";

        ClassReader cr = new ClassReader(clazz.getClassLoader().getResourceAsStream(classAsPath));
        ClassWriter cw = new ClassWriter(cr, 0);

        AddFieldAdapter cv = new AddFieldAdapter(cw, fieldNode.access, fieldNode.name, fieldNode.desc);
        cr.accept(cv, 0);

        return getClassFromBytes(clazz, cw.toByteArray());
    }
}
