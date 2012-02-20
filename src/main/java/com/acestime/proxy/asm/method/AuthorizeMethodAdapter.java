package com.acestime.proxy.asm.method;


import org.objectweb.asm.MethodVisitor;
import static org.objectweb.asm.Opcodes.*;

public class AuthorizeMethodAdapter extends MethodVisitor {

    public AuthorizeMethodAdapter(MethodVisitor mv) {
        super(ASM4, mv);
    }

    @Override
    public void visitCode() {
        super.visitCode();
        mv.visitInsn(ICONST_1);
        mv.visitVarInsn(ISTORE, 1);
    }
}
