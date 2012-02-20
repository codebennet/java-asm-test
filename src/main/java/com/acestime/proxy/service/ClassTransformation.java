package com.acestime.proxy.service;


import com.acestime.proxy.utils.ByteCodeClassLoader;

public abstract class ClassTransformation {

    private ByteCodeClassLoader byteCodeClassLoader = new ByteCodeClassLoader();

    public abstract <T> Class<T> execute(Class<T> clazz) throws Exception;

    @SuppressWarnings("unchecked")
    public <T> Class<T> getClassFromBytes(Class<T> clazz, byte[] bytes) {
//        ByteCodeClassLoader byteCodeClassLoader = new ByteCodeClassLoader();
        return byteCodeClassLoader.defineClass(clazz.getName(), bytes);
    }
}
