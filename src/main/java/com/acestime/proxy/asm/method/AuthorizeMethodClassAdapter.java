package com.acestime.proxy.asm.method;


import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.ASM4;

public class AuthorizeMethodClassAdapter extends ClassVisitor {

    private static final String NAME = "authorize";

    public AuthorizeMethodClassAdapter(ClassVisitor cv) {
        super(ASM4, cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv;
        mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (mv != null && name.equals(NAME)) {
            mv = new AuthorizeMethodAdapter(mv);
        }
        return mv;
    }
}
