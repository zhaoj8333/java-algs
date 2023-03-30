package com.algs;

public interface ISerializable {

    String serialize();

    Object deserialize(String data);

}
