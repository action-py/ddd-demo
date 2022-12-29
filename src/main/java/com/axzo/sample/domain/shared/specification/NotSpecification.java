package com.axzo.sample.domain.shared.specification;


/**
 * @ClassName
 * @Description
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
public class NotSpecification<T> extends AbstractSpecification<T> {

  private Specification<T> spec1;

  /**
   * Create a new NOT specification based on another spec.
   *
   * @param spec1 Specification instance to not.
   */
  public NotSpecification(final Specification<T> spec1) {
    this.spec1 = spec1;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isSatisfiedBy(final T t) {
    return !spec1.isSatisfiedBy(t);
  }
}
