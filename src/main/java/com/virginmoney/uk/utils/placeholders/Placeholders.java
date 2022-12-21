package com.virginmoney.uk.utils.placeholders;

import java.util.Map;

public interface Placeholders<T, K, V> {
    Map<K, V> getPlaceholders(T t);
}
