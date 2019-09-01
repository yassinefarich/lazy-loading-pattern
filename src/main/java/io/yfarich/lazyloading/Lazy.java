package io.yfarich.lazyloading;

import java.util.function.Supplier;

public class Lazy<T> {

  private Supplier<T> valueSupplier;

  private Lazy(Supplier<T> valueSupplier) {
    this.valueSupplier = valueSupplier;
  }

  public static <T> Lazy<T> of(Supplier<T> valueSupplier) {
    return new Lazy<>(valueSupplier);
  }

  public T getValue() {
    return valueSupplier.get();
  }

}
