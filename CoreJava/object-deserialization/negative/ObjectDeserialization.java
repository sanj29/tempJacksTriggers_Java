package com.codiscope.jaks.triggers.java.ObjectDeserialization;

import org.apache.commons.io.input.ClassLoaderObjectInputStream;
import testcode.sqli.UserEntity;

import java.io.*;

public class ObjectDeserialization {
    public UserEntity deserializeObject(Request request) throws IOException, ClassNotFoundException {
        InputStream foo = request.getParameter("foo");
        ObjectInputStream in = new ObjectInputStream(foo);
        try {
            UserEntity foo = in.readUnshared();
            UserEntity bar = in.readArray();
            return (UserEntity) in.readObject();
        } finally {
            in.close();
        }
    }

    // No way to currently detect inherited objects.
    public UserEntity deserializeObjectWithInheritance(InputStream receivedFile) throws IOException, ClassNotFoundException {
        ClassLoaderObjectInputStream in = new ClassLoaderObjectInputStream(getClass().getClassLoader(), receivedFile);
        try {
            return (UserEntity) in.readObject();
        } finally {
            in.close();
        }
    }
}