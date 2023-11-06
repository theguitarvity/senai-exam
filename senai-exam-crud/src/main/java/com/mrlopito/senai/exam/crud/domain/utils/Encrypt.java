package com.mrlopito.senai.exam.crud.domain.utils;

public interface Encrypt {
    String hash(String plain);
    String encode(CharSequence cs);
}