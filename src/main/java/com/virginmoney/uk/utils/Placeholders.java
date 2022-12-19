package com.virginmoney.uk.utils;

import java.util.List;
import java.util.Map;

public interface Placeholders<T, K, V> {
    Map<K, V> getPlaceholders(T t);
}
